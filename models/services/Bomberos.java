package models.services;

import utils.*;
import controller.*;

public class Bomberos {

    public static void executeFire(EmergencyLocation location, SeverityLevel severityLevel) {
        if ((dailyRequest.litersOfGasoline.get(0) == 0) || (dailyRequest.fireTrucks.get(0) == 0)
                || (dailyRequest.litersOfWater.get(0) == 0) || (dailyRequest.firefighters.get(0) == 0)) {
            System.out.println("No hay recursos disponibles para atender la emergencia");
        } else {
            var operator01 = dailyRequest.litersOfGasoline.get(0);
            var operator02 = dailyRequest.fireTrucks.get(0);
            var operator03 = dailyRequest.litersOfWater.get(0);
            var operator04 = dailyRequest.firefighters.get(0);
            switch (location) {
                case ZONA_NORTE:
                    operator01 -= 75;
                    operator02 -= 3;
                    dailyRequest.litersOfGasoline.clear();
                    dailyRequest.litersOfGasoline.add(operator01);
                    dailyRequest.fireTrucks.clear();
                    dailyRequest.fireTrucks.add(operator01);
                    break;
                case ZONA_SUR:
                    operator01 -= 75;
                    operator02 -= 3;
                    dailyRequest.litersOfGasoline.clear();
                    dailyRequest.litersOfGasoline.add(operator01);
                    dailyRequest.fireTrucks.clear();
                    dailyRequest.fireTrucks.add(operator01);
                    break;
                case ZONA_CENTRO:
                    operator01 -= 25;
                    operator02 -= 1;
                    dailyRequest.litersOfGasoline.clear();
                    dailyRequest.litersOfGasoline.add(operator01);
                    dailyRequest.fireTrucks.clear();
                    dailyRequest.fireTrucks.add(operator01);
                    break;
                case ZONA_ORIENTE:
                    operator01 -= 50;
                    operator02 -= 2;
                    dailyRequest.litersOfGasoline.clear();
                    dailyRequest.litersOfGasoline.add(operator01);
                    dailyRequest.fireTrucks.clear();
                    dailyRequest.fireTrucks.add(operator01);
                    break;
                case ZONA_OCCIDENTE:
                    operator01 -= 50;
                    operator02 -= 2;
                    dailyRequest.litersOfGasoline.clear();
                    dailyRequest.litersOfGasoline.add(operator01);
                    dailyRequest.fireTrucks.clear();
                    dailyRequest.fireTrucks.add(operator01);
                    break;
            }
            switch (severityLevel) {
                case BAJO:
                    operator03 -= 200;
                    operator04 -= 2;
                    dailyRequest.litersOfWater.clear();
                    dailyRequest.litersOfWater.add(operator02);
                    dailyRequest.firefighters.clear();
                    dailyRequest.firefighters.add(operator01);
                    break;
                case MEDIO:
                    operator03 -= 400;
                    operator04 -= 4;
                    dailyRequest.litersOfWater.clear();
                    dailyRequest.litersOfWater.add(operator02);
                    dailyRequest.firefighters.clear();
                    dailyRequest.firefighters.add(operator01);
                    break;
                case ALTO:
                    operator03 -= 600;
                    operator04 -= 6;
                    dailyRequest.litersOfWater.clear();
                    dailyRequest.litersOfWater.add(operator02);
                    dailyRequest.firefighters.clear();
                    dailyRequest.firefighters.add(operator01);
                    break;
            }
        }
    }
}