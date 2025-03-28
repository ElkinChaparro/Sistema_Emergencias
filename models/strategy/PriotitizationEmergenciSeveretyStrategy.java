package models.strategy;

import models.Emergency;
import utils.EmergencyLocation;

public class PriotitizationEmergenciSeveretyStrategy implements PrioritizationStrategy {

    @Override
    public int prioritize(Emergency emergency) {
        switch (emergency.getSeverityLevel()) {
            case ALTO:
                return 3;
            case MEDIO:
                return 2;
            case BAJO:
                return 1;
            default:
                return 1;
        }
    }
}

    @Override
    public int estimatedTime(EmergencyLocation location) {
        throw new UnsupportedOperationException("Unimplemented method 'estimatedTime'");
    }
}