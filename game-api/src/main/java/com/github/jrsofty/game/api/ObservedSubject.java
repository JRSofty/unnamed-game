package com.github.jrsofty.game.api;

public interface ObservedSubject {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers(Entity entity, ObserverEvent event);
}
