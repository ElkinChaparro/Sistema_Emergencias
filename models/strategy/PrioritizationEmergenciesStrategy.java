package models.strategy;

import models.Emergency;
import utils.EmergencyLocation;

public class PrioritizationEmergenciesStrategy implements PrioritizationStrategy {
    private class MapaUrbano {
        public int calculateDistance(EmergencyLocation location) {
            switch (location) {
                case ZONA_NORTE:
                    return 8;
                case ZONA_SUR:
                    return 10;
                case ZONA_CENTRO:
                    return 2;
                case ZONA_ORIENTE:
                    return 5;
                case ZONA_OCCIDENTE:
                    return 6;
                default:
                    return 10;
            }
        }
    }

    private class SeverityLevel {
        public int calculateSeverety(Emergency emergency) {
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

    private MapaUrbano mapaUrbano = new MapaUrbano();
    private SeverityLevel severety = new SeverityLevel();

    @Override
    public int prioritize(Emergency emergency) {
        int calculateDistance = mapaUrbano.calculateDistance(emergency.getLocation());
        int calculateSeverety = severety.calculateSeverety(emergency);
        return 10 * calculateSeverety - calculateDistance;
    }

    @Override
    public int estimatedTime(EmergencyLocation location) {
        int distanceZona = mapaUrbano.calculateDistance(location);
        if (distanceZona >= 7) {
            return 8;
        } else if (distanceZona <= 4) {
            return 2;
        } else {
            return 5;
        }
    }

}
