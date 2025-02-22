package models.services;

import utils.*;
import controller.*;
import images.ConsoleColor;

public class Ambulancia {

    public static void executetrafficAccident(EmergencyLocation location, SeverityLevel severityLevel) {
        int gasoline = dailyRequest.litersOfGasoline.get(0);
        int ambulances = dailyRequest.ambulances.get(0);
        int dea = dailyRequest.firstAidKits.get(0);
        int paramedics = dailyRequest.paramedics.get(0);
        int operator = 0;

        if (gasoline <= 0 || ambulances <= 0 || dea <= 0 || paramedics <= 0) {
            System.out
                    .println(ConsoleColor.orangeText("|===========================================================|"));
            System.out
                    .println(ConsoleColor.orangeText("|=-No hay recursos disponibles para atender la emergencia-==|"));
            System.out
                    .println(ConsoleColor.orangeText("|===========================================================|"));
        } else {
            switch (severityLevel) {
                // The following switch statement is repeated in the Policia and Bomberos classes
                case BAJO:
                    dea -= 10;
                    paramedics -= 2;
                    ambulances -= 1;
                    operator = 1;
                    dailyRequest.firstAidKits.clear();
                    dailyRequest.firstAidKits.add(dea);
                    dailyRequest.paramedics.clear();
                    dailyRequest.paramedics.add(paramedics);
                    dailyRequest.ambulances.clear();
                    dailyRequest.ambulances.add(ambulances);
                    break;
                case MEDIO:
                    dea -= 20;
                    paramedics -= 4;
                    ambulances -= 2;
                    operator = 2;
                    dailyRequest.firstAidKits.clear();
                    dailyRequest.firstAidKits.add(dea);
                    dailyRequest.paramedics.clear();
                    dailyRequest.paramedics.add(paramedics);
                    dailyRequest.ambulances.clear();
                    dailyRequest.ambulances.add(ambulances);
                    break;
                case ALTO:
                    dea -= 30;
                    paramedics -= 6;
                    ambulances -= 3;
                    operator = 3;
                    dailyRequest.firstAidKits.clear();
                    dailyRequest.firstAidKits.add(dea);
                    dailyRequest.paramedics.clear();
                    dailyRequest.paramedics.add(paramedics);
                    dailyRequest.ambulances.clear();
                    dailyRequest.ambulances.add(ambulances);
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