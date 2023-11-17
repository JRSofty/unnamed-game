package com.github.jrsofty.game.api.gds;

import java.util.HashMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
                throw new RuntimeException("Registry already exists");
            }
            final GameDataRegistry registry = new GameDataRegistryImpl();
            registry.setRegistryName(registryName);
            this.registries.put(registryName, registry);
            return registry;
        }

        @Override
        public GameDataRegistry getRegistry(final String registryName) {
            if (!this.registries.containsKey(registryName)) {
                throw new RuntimeException("Registry does not exist");
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
                throw new RuntimeException("Registry does not exist");
            }
            final ObjectMapper mapper = new ObjectMapper();
            final String output = mapper.writeValueAsString(this.registries.get(registryName));
            return output;

        }

    }

    public abstract GameDataRegistry createRegistry(String registryName);

    public abstract GameDataRegistry getRegistry(String registryName);

    public abstract void deleteRegistry(String registryName);

    public abstract String serializeRegistry(String registryName) throws JsonProcessingException;

}
