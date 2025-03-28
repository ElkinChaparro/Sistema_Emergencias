package models.observer;

import models.Emergency;

public interface SubjectEmergencies {
    void addObserver(ObserverEmergencies observerEmergencies);

    void removeObserver(ObserverEmergencies observerEmergencies);

    void notifyObservers(Emergency emergency);
}
