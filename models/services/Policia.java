package models.services;

import utils.*;
import controller.*;

public class Policia {

    public static void executeRobbery(EmergencyLocation location, SeverityLevel severityLevel) {
        if ((dailyRequest.litersOfGasoline.get(0) == 0) || (dailyRequest.patrols.get(0) == 0)
                || (dailyRequest.ammunition.get(0) == 0) || (dailyRequest.police.get(0) == 0)) {
            System.out.println("No hay recursos disponibles para atender la emergencia");
        } else {
            var operator01 = dailyRequest.litersOfGasoline.get(0);
            var operator02 = dailyRequest.patrols.get(0);
            var operator03 = dailyRequest.ammunition.get(0);
            var operator04 = dailyRequest.police.get(0);
            switch (location) {
                case ZONA_NORTE:
                    operator01 -= 75;
                    operator02 -= 3;
                    dailyRequest.litersOfGasoline.clear();
                    dailyRequest.litersOfGasoline.add(operator01);
                    dailyRequest.patrols.clear();
                    dailyRequest.patrols.add(operator01);
                    break;
                case ZONA_SUR:
                    operator01 -= 75;
                    operator02 -= 3;
                    dailyRequest.litersOfGasoline.clear();
                    dailyRequest.litersOfGasoline.add(operator01);
                    dailyRequest.patrols.clear();
                    dailyRequest.patrols.add(operator01);
                    break;
                case ZONA_CENTRO:
                    operator01 -= 25;
                    operator02 -= 1;
                    dailyRequest.litersOfGasoline.clear();
                    dailyRequest.litersOfGasoline.add(operator01);
                    dailyRequest.patrols.clear();
                    dailyRequest.patrols.add(operator01);
                    break;
                case ZONA_ORIENTE:
                    operator01 -= 50;
                    operator02 -= 2;
                    dailyRequest.litersOfGasoline.clear();
                    dailyRequest.litersOfGasoline.add(operator01);
                    dailyRequest.patrols.clear();
                    dailyRequest.patrols.add(operator01);
                    break;
                case ZONA_OCCIDENTE:
                    operator01 -= 50;
                    operator02 -= 2;
                    dailyRequest.litersOfGasoline.clear();
                    dailyRequest.litersOfGasoline.add(operator01);
                    dailyRequest.patrols.clear();
                    dailyRequest.patrols.add(operator01);
                    break;
            }
            switch (severityLevel) {
                case BAJO:
                    operator03 -= 20;
                    operator04 -= 2;
                    dailyRequest.ammunition.clear();
                    dailyRequest.ammunition.add(operator02);
                    dailyRequest.police.clear();
                    dailyRequest.police.add(operator01);
                    break;
                case MEDIO:
                    operator03 -= 40;
                    operator04 -= 4;
                    dailyRequest.ammunition.clear();
                    dailyRequest.ammunition.add(operator02);
                    dailyRequest.police.clear();
                    dailyRequest.police.add(operator01);
                    break;
                case ALTO:
                    operator03 -= 60;
                    operator04 -= 6;
                    dailyRequest.ammunition.clear();
                    dailyRequest.ammunition.add(operator02);
                    dailyRequest.police.clear();
                    dailyRequest.police.add(operator01);
                    break;
            }
        }
    }
}