package model;

import utils.*;

public class TrafficAccident extends Emergency {

    public TrafficAccident(EmergencyLocation location, SeverityLevel severityLevel, int responseTime) {
        super("AccidentedeTransito", location, severityLevel, responseTime);
    }
}
