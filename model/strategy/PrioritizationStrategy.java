package model.strategy;

import model.Emergency;
import utils.EmergencyLocation;

public interface PrioritizationStrategy {
    int prioritize(Emergency emergency);

    int estimatedTime(EmergencyLocation location);

}