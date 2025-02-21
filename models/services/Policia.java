package models.services;

import utils.*;
import controller.*;

public class Policia {

    public static void executeRobbery(EmergencyLocation location, SeverityLevel severityLevel) {
        int gasoline = dailyRequest.litersOfGasoline.get(0);
        int patrols = dailyRequest.patrols.get(0);
        int ammunition = dailyRequest.ammunition.get(0);
        int police = dailyRequest.police.get(0);
        int operator = 0;

        if (gasoline <= 0 || patrols <= 0 || ammunition <= 0 || police <= 0) {
            System.out.println("No hay recursos disponibles para atender la emergencia");
        } else {
            switch (severityLevel) {
                case BAJO:
                    ammunition -= 20;
                    police -= 2;
                    patrols -= 1;
                    operator = 1;
                    dailyRequest.ammunition.clear();
                    dailyRequest.ammunition.add(ammunition);
                    dailyRequest.police.clear();
                    dailyRequest.police.add(police);
                    dailyRequest.patrols.clear();
                    dailyRequest.patrols.add(patrols);
                    break;
                case MEDIO:
                    ammunition -= 40;
                    police -= 4;
                    patrols -= 2;
                    operator = 2;
                    dailyRequest.ammunition.clear();
                    dailyRequest.ammunition.add(ammunition);
                    dailyRequest.police.clear();
                    dailyRequest.police.add(police);
                    dailyRequest.patrols.clear();
                    dailyRequest.patrols.add(patrols);
                    break;
                case ALTO:
                    ammunition -= 60;
                    police -= 6;
                    patrols -= 3;
                    operator = 3;
                    dailyRequest.ammunition.clear();
                    dailyRequest.ammunition.add(ammunition);
                    dailyRequest.police.clear();
                    dailyRequest.police.add(police);
                    dailyRequest.patrols.clear();
                    dailyRequest.patrols.add(patrols);
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