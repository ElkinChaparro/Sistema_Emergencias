package models.factory;

import models.Emergency;
import models.Fire;
import models.Robbery;
import models.TrafficAccident;
import utils.EmergencyLocation;
import utils.EmergencyType;
import utils.SeverityLevel;

public class FactoryEmergencies {
    public static Emergency creatEmergency(EmergencyType type, EmergencyLocation location, SeverityLevel severityLevel, int responseTime){

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
