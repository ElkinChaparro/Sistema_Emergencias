package model.strategy;

import model.Emergency;

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