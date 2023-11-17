package com.github.jrsofty.game.api.gds;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

class GameDataRegistryImpl implements GameDataRegistry {

    private final Map<String, GameDataEntry<?>> internalMap = new LinkedHashMap<>();
    private String registryName = null;
    private UUID id = UUID.randomUUID();

    public GameDataRegistryImpl() {

    }

    @Override
    public String getRegistryName() {
        return this.registryName;
    }

    @Override
    public void setRegistryName(final String registryName) {
        this.registryName = registryName;
    }

    @Override
    public UUID getRegistryId() {
        return this.id;
    }

    @Override
    public void setRegistryId(final UUID id) {
        this.id = id;
    }

    public Map<String, GameDataEntry<?>> getInternalMap() {
        return this.internalMap;
    }

    public void setInternalMap(final Map<String, GameDataEntry<?>> internalMap) {
        this.internalMap.putAll(internalMap);
    }

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
