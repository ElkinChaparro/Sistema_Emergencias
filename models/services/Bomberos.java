package models.services;

import utils.*;
import controller.*;

public class Bomberos {

    public static void executeFire(EmergencyLocation location, SeverityLevel severityLevel) {
        int gasoline = dailyRequest.litersOfGasoline.get(0);
        int fireTrucks = dailyRequest.fireTrucks.get(0);
        int litersOfWater = dailyRequest.litersOfWater.get(0);
        int firefighters = dailyRequest.firefighters.get(0);
        int operator = 0;

        if (gasoline <= 0 || fireTrucks <= 0 || litersOfWater <= 0 || firefighters <= 0) {
            System.out.println("No hay recursos disponibles para atender la emergencia");
        } else {
            switch (severityLevel) {
                case BAJO:
                    litersOfWater -= 200;
                    firefighters -= 2;
                    fireTrucks -= 1;
                    operator = 1;
                    dailyRequest.litersOfWater.clear();
                    dailyRequest.litersOfWater.add(litersOfWater);
                    dailyRequest.firefighters.clear();
                    dailyRequest.firefighters.add(firefighters);
                    dailyRequest.fireTrucks.clear();
                    dailyRequest.fireTrucks.add(fireTrucks);
                    break;
                case MEDIO:
                    litersOfWater -= 400;
                    firefighters -= 4;
                    fireTrucks -= 2;
                    operator = 2;
                    dailyRequest.litersOfWater.clear();
                    dailyRequest.litersOfWater.add(litersOfWater);
                    dailyRequest.firefighters.clear();
                    dailyRequest.firefighters.add(firefighters);
                    dailyRequest.fireTrucks.clear();
                    dailyRequest.fireTrucks.add(fireTrucks);
                    break;
                case ALTO:
                    litersOfWater -= 600;
                    firefighters -= 6;
                    fireTrucks -= 3;
                    operator = 3;
                    dailyRequest.litersOfWater.clear();
                    dailyRequest.litersOfWater.add(litersOfWater);
                    dailyRequest.firefighters.clear();
                    dailyRequest.firefighters.add(firefighters);
                    dailyRequest.fireTrucks.clear();
                    dailyRequest.fireTrucks.add(fireTrucks);
                    break;
            }
            switch (location) {
                case ZONA_NORTE:
                    gasoline -= operator * 75;
                    dailyRequest.litersOfGasoline.clear();
                    dailyRequest.litersOfGasoline.add(gasoline);
                    break;
                case ZONA_SUR:
                    gasoline -= operator * 75;
                    dailyRequest.litersOfGasoline.clear();
                    dailyRequest.litersOfGasoline.add(gasoline);
                    break;
                case ZONA_CENTRO:
                    gasoline -= operator * 25;
                    dailyRequest.litersOfGasoline.clear();
                    dailyRequest.litersOfGasoline.add(gasoline);
                    break;
                case ZONA_ORIENTE:
                    gasoline -= operator * 50;
                    dailyRequest.litersOfGasoline.clear();
                    dailyRequest.litersOfGasoline.add(gasoline);
                    break;
                case ZONA_OCCIDENTE:
                    gasoline -= operator * 50;
                    dailyRequest.litersOfGasoline.clear();
                    dailyRequest.litersOfGasoline.add(gasoline);
                    break;
            }
        }
    }
}