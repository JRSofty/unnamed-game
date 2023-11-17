package com.github.jrsofty.game.api.gds;

import java.io.Serializable;

public class GameDataEntryObject<T extends Serializable> implements GameDataEntry<T> {

    /**
     *
     */
    private static final long serialVersionUID = 5356471937502619912L;
    private T entryData;

    @Override
    public T getEntryData() {
        return this.entryData;
    }

    @Override
    public void setEntryData(final T entryData) {
        this.entryData = entryData;
    }

}
