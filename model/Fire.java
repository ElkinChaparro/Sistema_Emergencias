package model;

import utils.EmergencyLocation;
import utils.SeverityLevel;

public class Fire extends Emergency {

    public Fire (EmergencyLocation location, SeverityLevel severityLevel, int responseTime) {
        super("Incendio", location, severityLevel, responseTime);
    }
}
