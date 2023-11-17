package com.github.jrsofty.game.api.gds;

import java.util.UUID;

public interface GameDataRegistry {

    void setRegistryName(String registryName);

    String getRegistryName();

    UUID getRegistryId();

    void setRegistryId(UUID id);

    void addEntry(String entryName, GameDataEntry<?> entry);

    GameDataEntry<?> getEntry(String entryName);

    boolean containsEntry(String entryName);

}
