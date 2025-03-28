package models;

import utils.*;

public class TrafficAccident extends Emergency {

    public TrafficAccident(EmergencyLocation location, SeverityLevel severityLevel, int responseTime) {
        super(EmergencyType.ACCIDENTE_TRANSITO, location, severityLevel, responseTime);
    }
}
