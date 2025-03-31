package models.factory;

import models.*;
import utils.*;
public class FactoryEmergencies {
    public static Emergency creatEmergency(EmergencyType type, EmergencyLocation location, SeverityLevel severityLevel,
            int responseTime) {
        switch (type) {
            case ROBO:
                return new Robbery(location, severityLevel, responseTime);
            case ACCIDENTE_TRANSITO:
                return new TrafficAccident(location, severityLevel, responseTime);
            case INCENDIO:
                return new Fire(location, severityLevel, responseTime);
            default:
                return null;
        }
    }
}
