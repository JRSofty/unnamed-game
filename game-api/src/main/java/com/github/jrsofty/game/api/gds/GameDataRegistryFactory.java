package com.github.jrsofty.game.api.gds;

import java.util.HashMap;

public abstract class GameDataRegistryFactory {
    private static final GameDataRegistryFactory INSTANCE = new GameDataRegistryFactoryImpl();

    public static GameDataRegistryFactory getDefaultFactory() {
        return GameDataRegistryFactory.INSTANCE;
    }

    abstract GameDataRegistry createRegistry(String registryName);

    abstract GameDataRegistry getRegistry(String registryName);

    abstract void deleteRegistry(String registryName);

    static class GameDataRegistryFactoryImpl extends GameDataRegistryFactory {
        private final HashMap<String, GameDataRegistry> registries = new HashMap<>();

        @Override
        public GameDataRegistry createRegistry(final String registryName) {
            if (this.registries.containsKey(registryName)) {
                throw new RuntimeException("Registry already exists");
            }
            this.registries.put(registryName, new GameDataRegistryImpl());
            return this.registries.get(registryName);
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

    }

}
