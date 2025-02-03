package model;

import utils.*;

public class Robbery extends Emergency {

    public Robbery(EmergencyLocation location, SeverityLevel severityLevel, int responseTime) {
        super("Robo", location, severityLevel, responseTime);

    }

}