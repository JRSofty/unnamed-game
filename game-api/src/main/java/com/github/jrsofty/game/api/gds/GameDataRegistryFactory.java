package com.github.jrsofty.game.api.gds;

import java.util.HashMap;

public interface GameDataRegistryFactory {
    GameDataRegistryFactory INSTANCE = new GameDataRegistryFactoryImpl();

    static GameDataRegistryFactory getDefaultFactory() {
        return GameDataRegistryFactory.INSTANCE;
    }

    GameDataRegistry createRegistry(String registryName);

    GameDataRegistry getRegistry(String registryName);

    void deleteRegistry(String registryName);

    class GameDataRegistryFactoryImpl implements GameDataRegistryFactory {
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
