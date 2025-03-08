package models.services;

import utils.*;
import controller.*;
import images.ConsoleColor;

public class Policia {
    //variables que almacenan el valor necesitado para tender la emergencia
    static int gasolineRequired = 0;
    static int ammunitionRequired = 0;
    static int policeRequired = 0;
    static int patrolsRequired = 0;
    static int operator = 0;
    //Variables que traen las cantidades de las listas
    static int gasoline = dailyRequest.litersOfGasoline.get(0);
    static int patrols = dailyRequest.patrols.get(0);
    static int ammunition = dailyRequest.ammunition.get(0);
    static int police = dailyRequest.police.get(0);

    public static void executeRobbery(EmergencyLocation location, SeverityLevel severityLevel) {
        establishRequirements(location, severityLevel);
        ammunition -= ammunitionRequired;
        police -= policeRequired;
        patrols -= patrolsRequired;
        gasoline -= gasolineRequired;
        dailyRequest.ammunition.clear();
        dailyRequest.ammunition.add(ammunition);
        dailyRequest.police.clear();
        dailyRequest.police.add(police);
        dailyRequest.patrols.clear();
        dailyRequest.patrols.add(patrols);
        dailyRequest.litersOfGasoline.clear();
        dailyRequest.litersOfGasoline.add(gasoline);
    }

    // metodo que actualiza y establece los valores de los recursos, esto evita un bug al intentar "añadir recursos"
    private static void updateVariables() {
        gasoline = dailyRequest.litersOfGasoline.get(0);
        ammunition = dailyRequest.ammunition.get(0);
        police = dailyRequest.police.get(0);
        patrols = dailyRequest.patrols.get(0);
    }


    public static void establishRequirements(EmergencyLocation location, SeverityLevel severityLevel){
        // establecer valores requeridos para "ammunition", "police" y "patrols"
        switch (severityLevel) {
            case BAJO:
                ammunitionRequired = 20;
                policeRequired = 2;
                patrolsRequired = 1;
                operator = 1;
                break;
            case MEDIO:
                ammunitionRequired = 40;
                policeRequired = 4;
                patrolsRequired= 2;
                operator = 2;
                break;
            case ALTO:
                ammunitionRequired = 60;
                policeRequired = 6;
                patrolsRequired = 3;
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
            updateVariables(); // se actualizan los valores de los recursos antes de ser validados
            if (gasoline < gasolineRequired || ammunition < ammunitionRequired || police< policeRequired|| patrols < patrolsRequired) {
                System.out.println(ConsoleColor.orangeText("|===========================================================|"));
                System.out.println(ConsoleColor.orangeText("|=-No hay recursos disponibles para atender la emergencia-==|"));
                System.out.println(ConsoleColor.orangeText("|===========================================================|"));
                // se valida cual recurso es el insuficiente para ser mas explicitos con el usuario
                if (gasoline < gasolineRequired) {
                    System.out.println(ConsoleColor.orangeText("|- Gasolina insuficiente: '" + gasoline + "' de '" + gasolineRequired + "' requerida"));
                }
                if (ammunition < ammunitionRequired) {
                    System.out.println(ConsoleColor.orangeText("|- Munición insuficiente: '" + ammunition + "' de '" + ammunitionRequired + "' requeridas"));
                }
                if (police < policeRequired) {
                    System.out.println(ConsoleColor.orangeText("|- Policías insuficientes: '" + police + "' de '" + policeRequired + "' requeridos"));
                }
                if (patrols < patrolsRequired) {
                    System.out.println(ConsoleColor.orangeText("|- Patrullas insuficientes: '" + patrols + "' de '" + patrolsRequired + "' requeridas"));
                }
                System.out.println(ConsoleColor.orangeText("|===========================================================|"));
                isAvailable = false;
            }else{
                isAvailable = true;
            }
            return isAvailable;
        }
}