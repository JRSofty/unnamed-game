package com.github.jrsofty.game.api.gds;

public interface GameDataRegistry {

    void addEntry(String entryName, GameDataEntry<?> entry);

    GameDataEntry<?> getEntry(String entryName);

    boolean containsEntry(String entryName);

}
