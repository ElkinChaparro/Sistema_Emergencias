package model;

import utils.EmergencyLocation;
import utils.SeverityLevel;

public class Robbery extends Emergency{

    public Robbery(EmergencyLocation location, SeverityLevel severityLevel, int responseTime) {
        super("Robo", location, severityLevel, responseTime);
    }

}
