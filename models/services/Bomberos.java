package models.services;

import utils.*;
import controller.*;
import images.ConsoleColor;

public class Bomberos {
    // variables que almacenan el valor necesitado para tender la emergencia
    static int gasolineRequired = 0;
    static int fireTrucksRequired = 0;
    static int waterRequired = 0;
    static int firefightersRequired = 0;
    static int operator = 0;
    // Variables que traen las cantidades de las listas
    static int gasoline = dailyRequest.litersOfGasoline.get(0);
    static int fireTrucks = dailyRequest.fireTrucks.get(0);
    static int litersOfWater = dailyRequest.litersOfWater.get(0);
    static int firefighters = dailyRequest.firefighters.get(0);

    // metodo que ejecuta la emergencia de incendio, se le pasan los valores de la
    // emergencia y se le asignan los valores requeridos para atender la emergencia
    public static void executeFire(EmergencyLocation location, SeverityLevel severityLevel) {
        establishRequirements(location, severityLevel);
        litersOfWater -= waterRequired;
        firefighters -= firefightersRequired;
        fireTrucks -= fireTrucksRequired;
        gasoline -= gasolineRequired;
        dailyRequest.litersOfWater.clear();
        dailyRequest.litersOfWater.add(litersOfWater);
        dailyRequest.firefighters.clear();
        dailyRequest.firefighters.add(firefighters);
        dailyRequest.fireTrucks.clear();
        dailyRequest.fireTrucks.add(fireTrucks);
        dailyRequest.litersOfGasoline.clear();
        dailyRequest.litersOfGasoline.add(gasoline);
    }

    // metodo que actualiza y establece los valores de los recursos, esto evita un
    // bug al intentar "añadir recursos"
    private static void updateVariables() {
        gasoline = dailyRequest.litersOfGasoline.get(0);
        litersOfWater = dailyRequest.litersOfWater.get(0);
        firefighters = dailyRequest.firefighters.get(0);
        fireTrucks = dailyRequest.fireTrucks.get(0);
    }

    // metodo que establece los valores requeridos para atender la emergencia
    public static void establishRequirements(EmergencyLocation location, SeverityLevel severityLevel) {
        // establecer valores requeridos para "water", "fireTrucks" y "fireFighters"
        switch (severityLevel) {
            case BAJO:
                waterRequired = 200;
                fireTrucksRequired = 1;
                firefightersRequired = 2;
                operator = 1;
                break;
            case MEDIO:
                waterRequired = 400;
                fireTrucksRequired = 2;
                firefightersRequired = 4;
                operator = 2;
                break;
            case ALTO:
                waterRequired = 600;
                fireTrucksRequired = 3;
                firefightersRequired = 6;
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

    // metodo que valida si hay recursos disponibles para atender la emergencia
    public static boolean isAvailablee(EmergencyLocation location, SeverityLevel severityLevel) {
        boolean isAvailable;
        establishRequirements(location, severityLevel);
        updateVariables(); // se actualizan los valores de los recursos antes de ser validados
        if (gasoline < gasolineRequired || fireTrucks < fireTrucksRequired || litersOfWater < waterRequired
                || firefighters < firefightersRequired) {
            System.out
                    .println(ConsoleColor.orangeText("|===========================================================|"));
            System.out
                    .println(ConsoleColor.orangeText("|=-No hay recursos disponibles para atender la emergencia-==|"));
            System.out
                    .println(ConsoleColor.orangeText("|===========================================================|"));
            // se valida cual recurso es el insuficiente para ser mas explicitos con el
            // usuario
            if (gasoline < gasolineRequired) {
                System.out.println(ConsoleColor.orangeText(
                        "|- Gasolina insuficiente: '" + gasoline + "' de '" + gasolineRequired + "' requerida"));
            }
            if (fireTrucks < fireTrucksRequired) {
                System.out.println(ConsoleColor.orangeText(
                        "|- Camiones insuficientes: '" + fireTrucks + "' de '" + fireTrucksRequired + "' requeridos"));
            }
            if (litersOfWater < waterRequired) {
                System.out.println(ConsoleColor.orangeText(
                        "|- Agua insuficiente: '" + litersOfWater + "' de '" + waterRequired + "'  litros requeridos"));
            }
            if (firefighters < firefightersRequired) {
                System.out.println(ConsoleColor.orangeText("|- Bomberos insuficientes: '" + firefighters + "' de '"
                        + firefightersRequired + "' requeridos"));
            }
            System.out
                    .println(ConsoleColor.orangeText("|===========================================================|"));
            isAvailable = false;
        } else {
            isAvailable = true;
        }
        return isAvailable;
    }
}