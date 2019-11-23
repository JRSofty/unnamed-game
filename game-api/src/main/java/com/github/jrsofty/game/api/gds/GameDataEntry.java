package com.github.jrsofty.game.api.gds;

import java.io.Serializable;

public interface GameDataEntry<T extends Serializable> extends Serializable {

    String getEntryName();

    void setEntryName(String entryName);

    T getEntryData();

    void setEntryData(T entryData);

    String toString(boolean pretty);

}
