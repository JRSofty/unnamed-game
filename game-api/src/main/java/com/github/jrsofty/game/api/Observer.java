package com.github.jrsofty.game.api;

public interface Observer {
    void onNotify(Entity entity, ObserverEvent event);
}
