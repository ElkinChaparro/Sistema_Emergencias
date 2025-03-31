package models;

import utils.*;

public class Robbery extends Emergency {

    public Robbery(EmergencyLocation location, SeverityLevel severityLevel, int responseTime) {
        super(EmergencyType.ROBO, location, severityLevel, responseTime);
    }
}