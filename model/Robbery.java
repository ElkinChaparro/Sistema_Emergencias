package model;

import utils.EmergencyLocation;
import utils.SeverityLevel;

public class Robbery extends Emergency {

    public Robbery(EmergencyLocation location, SeverityLevel severityLevel, int responseTime) {
        super("Robo", location, severityLevel, responseTime);

        switch (location) {
            case ZONA_NORTE:

                break;
            case ZONA_SUR:

                break;
            case ZONA_CENTRO:

                break;
            case ZONA_ORIENTE:

                break;
            case ZONA_OCCIDENTE:

                break;
        }
        switch (severityLevel) {
            case BAJO:

                break;
            case MEDIO:

                break;
            case ALTO:

                break;
        }
    }

}