package model;

import utils.EmergencyLocation;
import utils.SeverityLevel;

public class TrafficAccident extends Emergency{

    public TrafficAccident(EmergencyLocation location, SeverityLevel severityLevel, int responseTime) {
        super("AccidentedeTransito", location, severityLevel, responseTime);
    }
}
