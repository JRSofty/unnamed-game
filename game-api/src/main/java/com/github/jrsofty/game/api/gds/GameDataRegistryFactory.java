package com.github.jrsofty.game.api.gds;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jrsofty.game.api.exceptions.RegistryAlreadyExistsException;
import com.github.jrsofty.game.api.exceptions.RegistryNotFoundException;
import com.github.jrsofty.game.api.io.FileWriter;

public abstract class GameDataRegistryFactory {

    private static final GameDataRegistryFactory INSTANCE = new GameDataRegistryFactoryImpl();

    public static GameDataRegistryFactory getDefaultFactory() {
        return GameDataRegistryFactory.INSTANCE;
    }

    public static class GameDataRegistryFactoryImpl extends GameDataRegistryFactory {
        private final HashMap<String, GameDataRegistry> registries = new HashMap<>();

        @Override
        public GameDataRegistry createRegistry(final String registryName) {
            if (this.registries.containsKey(registryName)) {
                throw new RegistryAlreadyExistsException(registryName);
            }
            final GameDataRegistry registry = new GameDataRegistryImpl();
            registry.setRegistryName(registryName);
            this.registries.put(registryName, registry);
            return registry;
        }

        @Override
        public GameDataRegistry getRegistry(final String registryName) {
            if (!this.registries.containsKey(registryName)) {
                throw new RegistryNotFoundException(registryName);
            }
            return this.registries.get(registryName);
        }

        @Override
        public void deleteRegistry(final String registryName) {
            this.registries.remove(registryName);
        }

        @Override
        public String serializeRegistry(final String registryName) throws JsonProcessingException {
            if (!this.registries.containsKey(registryName)) {
                throw new RegistryNotFoundException(registryName);
            }
            final ObjectMapper mapper = new ObjectMapper();
            final String output = mapper.writeValueAsString(this.registries.get(registryName));
            return output;
        }

        @Override
        public GameDataRegistry deserializeAndLoadRegistry(final String registryName, final String content) throws JsonProcessingException {
            if (this.registries.containsKey(registryName)) {
                throw new RegistryAlreadyExistsException(registryName);
            }
            final ObjectMapper mapper = new ObjectMapper();
            final GameDataRegistry registry = mapper.convertValue(content, GameDataRegistryImpl.class);
            this.registries.put(registryName, registry);
            return registry;
        }

        @Override
        public boolean registryExists(final String registryName) {
            return this.registries.containsKey(registryName);
        }

        @Override
        public void storeRegistry(final String registryName, final FileWriter writer) throws IOException {
            final String registryData = this.serializeRegistry(registryName);
            final StringBuilder pathBuilder = new StringBuilder();
            pathBuilder.append(writer.getPath());
            if (!writer.getPath().endsWith(File.pathSeparator)) {
                pathBuilder.append(File.pathSeparator);
            }
            pathBuilder.append(registryName).append(".json");
            writer.writeToFile(pathBuilder.toString(), registryData);

        }

        @Override
        public void storeAllRegistry(final FileWriter writer) throws IOException {
            for (final String registryName : this.registries.keySet()) {
                this.storeRegistry(registryName, writer);
            }
        }

    }

    public abstract GameDataRegistry createRegistry(String registryName);

    public abstract GameDataRegistry getRegistry(String registryName);

    public abstract void deleteRegistry(String registryName);

    public abstract String serializeRegistry(String registryName) throws JsonProcessingException;

    public abstract GameDataRegistry deserializeAndLoadRegistry(String registryName, String content) throws JsonProcessingException;

    public abstract boolean registryExists(String registryName);

    public abstract void storeRegistry(String registryName, FileWriter writer) throws IOException;

    public abstract void storeAllRegistry(FileWriter writer) throws IOException;

}
