package com.github.jrsofty.game.api.gds;

import java.io.Serializable;

public interface GameDataEntry<T extends Serializable> extends Serializable {

    T getEntryData();

    void setEntryData(T entryData);

}
