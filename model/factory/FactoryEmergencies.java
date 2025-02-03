package model.factory;

import model.Emergency;
import model.Fire;
import model.Robbery;
import model.TrafficAccident;
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
