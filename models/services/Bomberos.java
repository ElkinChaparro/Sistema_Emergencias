package models.services;

import utils.*;
import controller.*;

public class Bomberos {

    public static void executeFire(EmergencyLocation location, SeverityLevel severityLevel) {
        switch (location) {
            case ZONA_NORTE:
                var operator01 = dailyRequest.litersOfGasoline.get(0);
                operator01 -= 15;
                dailyRequest.litersOfGasoline.clear();
                dailyRequest.litersOfGasoline.add(operator01);
                break;
            case ZONA_SUR:
                var operator02 = dailyRequest.litersOfGasoline.get(0);
                operator02 -= 15;
                dailyRequest.litersOfGasoline.clear();
                dailyRequest.litersOfGasoline.add(operator02);
                break;
            case ZONA_CENTRO:
                var operator03 = dailyRequest.litersOfGasoline.get(0);
                operator03 -= 15;
                dailyRequest.litersOfGasoline.clear();
                dailyRequest.litersOfGasoline.add(operator03);
                break;
            case ZONA_ORIENTE:
                var operator04 = dailyRequest.litersOfGasoline.get(0);
                operator04 -= 15;
                dailyRequest.litersOfGasoline.clear();
                dailyRequest.litersOfGasoline.add(operator04);
                break;
            case ZONA_OCCIDENTE:
                var operator05 = dailyRequest.litersOfGasoline.get(0);
                operator05 -= 15;
                dailyRequest.litersOfGasoline.clear();
                dailyRequest.litersOfGasoline.add(operator05);
                break;
        }
        switch (severityLevel) {
            case BAJO:
                var operator01 = dailyRequest.patrols.get(0);
                var operator02 = dailyRequest.ammunition.get(0);
                operator01 -= 1;
                operator02 -= 10;
                dailyRequest.patrols.clear();
                dailyRequest.patrols.add(operator01);
                dailyRequest.ammunition.clear();
                dailyRequest.ammunition.add(operator02);
                break;
            case MEDIO:
                var operator03 = dailyRequest.patrols.get(0);
                var operator04 = dailyRequest.ammunition.get(0);
                operator03 -= 2;
                operator04 -= 30;
                dailyRequest.patrols.clear();
                dailyRequest.patrols.add(operator03);
                dailyRequest.ammunition.clear();
                dailyRequest.ammunition.add(operator04);
                break;
            case ALTO:
                var operator05 = dailyRequest.patrols.get(0);
                var operator06 = dailyRequest.ammunition.get(0);
                operator05 -= 3;
                operator06 -= 50;
                dailyRequest.patrols.clear();
                dailyRequest.patrols.add(operator05);
                dailyRequest.ammunition.clear();
                dailyRequest.ammunition.add(operator06);
                break;
        }
    }

}