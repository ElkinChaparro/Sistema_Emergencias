package model;

import utils.*;

public class Fire extends Emergency {

    public Fire(EmergencyLocation location, SeverityLevel severityLevel, int responseTime) {
        super("Incendio", location, severityLevel, responseTime);
    }

}