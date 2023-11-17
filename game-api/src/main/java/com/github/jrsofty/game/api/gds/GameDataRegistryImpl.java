package com.github.jrsofty.game.api.gds;

import java.util.LinkedHashMap;

class GameDataRegistryImpl implements GameDataRegistry {

    private final LinkedHashMap<String, GameDataEntry<?>> internalMap = new LinkedHashMap<>();

    @Override
    public void addEntry(final String entryName, final GameDataEntry<?> entry) {
        this.internalMap.put(entryName, entry);
    }

    @Override
    public GameDataEntry<?> getEntry(final String entryName) {
        return this.internalMap.get(entryName);
    }

    @Override
    public boolean containsEntry(final String entryName) {
        return this.internalMap.containsKey(entryName);
    }

}
