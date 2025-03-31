package models;

import utils.*;

public class Fire extends Emergency {

    public Fire(EmergencyLocation location, SeverityLevel severityLevel, int responseTime) {
        super(EmergencyType.INCENDIO, location, severityLevel, responseTime);
    }
}