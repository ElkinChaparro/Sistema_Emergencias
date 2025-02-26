package models.services;

import utils.*;
import controller.*;
import images.ConsoleColor;

public class Ambulancia {
    //variables que almacenan el valor necesitado para tender la emergencia
    static int gasolineRequired = 0;
    static int firstAidKitsRequired = 0;
    static int paramedicsRequired = 0;
    static int ambulancesRequired = 0;
    static int operator = 0;

    static int gasoline = dailyRequest.litersOfGasoline.get(0);
    static int ambulances = dailyRequest.ambulances.get(0);
    static int firstAidKits = dailyRequest.firstAidKits.get(0);
    static int paramedics = dailyRequest.paramedics.get(0);

    public static void executetrafficAccident(EmergencyLocation location, SeverityLevel severityLevel) {

        establishRequirements(location, severityLevel);

        firstAidKits -= firstAidKitsRequired;
        paramedics -= paramedicsRequired;
        ambulances -= ambulancesRequired;
        gasoline -= gasolineRequired;
        dailyRequest.firstAidKits.clear();
        dailyRequest.firstAidKits.add(firstAidKits);
        dailyRequest.paramedics.clear();
        dailyRequest.paramedics.add(paramedics);
        dailyRequest.ambulances.clear();
        dailyRequest.ambulances.add(ambulances);

        dailyRequest.litersOfGasoline.clear();
        dailyRequest.litersOfGasoline.add(gasoline);
    }

    public static void establishRequirements(EmergencyLocation location, SeverityLevel severityLevel){
        // establecer valores requeridos para "firstAidKits", "paramedics" y "ambulances"
        switch (severityLevel) {
            case BAJO:
                firstAidKitsRequired = 10;
                paramedicsRequired = 2;
                ambulancesRequired = 1;
                operator = 1;
                break;
            case MEDIO:
                firstAidKitsRequired = 20;
                paramedicsRequired = 4;
                ambulancesRequired = 2;
                operator = 2;
                break;
            case ALTO:
                firstAidKitsRequired = 30;
                paramedicsRequired = 6;
                ambulancesRequired = 3;
                operator = 3;
                break;
        }
         // establecer valores requeridos para la gasolina
        switch (location) {
            case ZONA_NORTE:
                gasolineRequired = operator * 75;
                break;
            case ZONA_SUR:
                gasolineRequired = operator * 75;
                break;
            case ZONA_CENTRO:
                gasolineRequired = operator * 25;
                break;
            case ZONA_ORIENTE:
                gasolineRequired = operator * 50;
                break;
            case ZONA_OCCIDENTE:
                gasolineRequired = operator * 50;
                break;
        }
    }


        public static boolean isAvailablee(EmergencyLocation location, SeverityLevel severityLevel){
            boolean isAvailable;
            establishRequirements(location, severityLevel);
            if (gasoline < gasolineRequired || firstAidKits < firstAidKitsRequired || paramedics < paramedicsRequired|| ambulances < ambulancesRequired) {
                System.out.println(ConsoleColor.orangeText("|===========================================================|"));
                System.out.println(ConsoleColor.orangeText("|=-No hay recursos disponibles para atender la emergencia-==|"));
                System.out.println(ConsoleColor.orangeText("|===========================================================|"));
                isAvailable = false;
            }else{
                isAvailable = true;
            }
            return isAvailable;
        }
}