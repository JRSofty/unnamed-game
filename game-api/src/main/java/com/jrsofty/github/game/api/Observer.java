package com.jrsofty.github.game.api;

public interface Observer {
    void onNotify(Entity entity, ObserverEvent event);
}
