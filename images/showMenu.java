package images;

import java.util.Scanner;

import controller.dailyRequest;

public class showMenu {

    public static Integer menuMain(Integer option) {
        System.out.println(ConsoleColor.cyanText("|===========================================================|"));
        System.out.println(ConsoleColor.cyanText("|============-")
                + ConsoleColor.blueText("SISTEMA DE GESTIÓN DE EMERGENCIAS") + ConsoleColor.cyanText("-============|"));
        System.out.println(ConsoleColor.cyanText("|===========================================================|"));
        System.out.println(ConsoleColor.cyanText("|-") + " 1. Registrar una nueva emergencia                        "
                + ConsoleColor.cyanText("|"));
        System.out.println(ConsoleColor.cyanText("|-") + " 2. Atender una emergencia                                "
                + ConsoleColor.cyanText("|"));
        System.out.println(ConsoleColor.cyanText("|-") + " 3. Recursos actuales                                     "
                + ConsoleColor.cyanText("|"));
        System.out.println(ConsoleColor.cyanText("|-") + " 4. Emergencais pendientes                                "
                + ConsoleColor.cyanText("|"));
        System.out.println(ConsoleColor.cyanText("|-") + " 5. Mostrar estadísticas del día                          "
                + ConsoleColor.cyanText("|"));
        System.out.println(ConsoleColor.cyanText("|-") + " 6. Finalizar jornada **                                  "
                + ConsoleColor.cyanText("|"));
        System.out.println(ConsoleColor.cyanText("|===========================================================|"));
        System.out.print(ConsoleColor.orangeText("|- Seleccione una opcion: "));
        option = 0;
        return option;
    }

    public static Integer menuType(Integer option01) {
        System.out.println(ConsoleColor.cyanText("|===========================================================|"));
        System.out.println(ConsoleColor.cyanText("|================-")
                + ConsoleColor.blueText("REGISTRAR NUEVA EMERGENCIA") + ConsoleColor.cyanText("-===============|"));
        System.out.println(ConsoleColor.cyanText("|===========================================================|"));
        System.out.println(ConsoleColor.cyanText("|-") + " 1. Incendio                                              "
                + ConsoleColor.cyanText("|"));
        System.out.println(ConsoleColor.cyanText("|-") + " 2. Accidente Vehicular                                   "
                + ConsoleColor.cyanText("|"));
        System.out.println(ConsoleColor.cyanText("|-") + " 3. Robo                                                  "
                + ConsoleColor.cyanText("|"));
        System.out.println(ConsoleColor.cyanText("|===========================================================|"));
        System.out.print(ConsoleColor.orangeText("|- Seleccione la emergencia: "));
        option01 = 0;
        return option01;
    }

    public static Integer menuLocation(Integer option02) {
        System.out.println(ConsoleColor.cyanText("|===========================================================|"));
        System.out.println(ConsoleColor.cyanText("|-") + " 1. Zona-norte                                            "
                + ConsoleColor.cyanText("|"));
        System.out.println(ConsoleColor.cyanText("|-") + " 2. Zona-sur                                              "
                + ConsoleColor.cyanText("|"));
        System.out.println(ConsoleColor.cyanText("|-") + " 3. Zona-centro                                           "
                + ConsoleColor.cyanText("|"));
        System.out.println(ConsoleColor.cyanText("|-") + " 4. Zona-oriente                                          "
                + ConsoleColor.cyanText("|"));
        System.out.println(ConsoleColor.cyanText("|-") + " 5. Zona-occidente                                        "
                + ConsoleColor.cyanText("|"));
        System.out.println(ConsoleColor.cyanText("|===========================================================|"));
        System.out.print(ConsoleColor.orangeText("|- Seleccione la locacion: "));
        option02 = 0;
        return option02;
    }

    public static Integer menuGravity(Integer option03) {
        System.out.println(ConsoleColor.cyanText("|===========================================================|"));
        System.out.println(ConsoleColor.cyanText("|-") + " 1. Bajo                                                  "
                + ConsoleColor.cyanText("|"));
        System.out.println(ConsoleColor.cyanText("|-") + " 2. Medio                                                 "
                + ConsoleColor.cyanText("|"));
        System.out.println(ConsoleColor.cyanText("|-") + " 3. Alto                                                  "
                + ConsoleColor.cyanText("|"));
        System.out.println(ConsoleColor.cyanText("|===========================================================|"));
        System.out.print(ConsoleColor.orangeText("|- Seleccione el nivel de gravedad: "));
        option03 = 0;
        return option03;
    }

    public static void menuResources() {
        System.out.println(ConsoleColor.cyanText("|===========================================================|"));
        System.out.println(ConsoleColor.cyanText("|====================-") + ConsoleColor.blueText("RECURSOS ACTUALES")
                + ConsoleColor.cyanText("-====================|"));
        System.out.println(ConsoleColor.cyanText("|===========================================================|"));
        System.out.println(ConsoleColor.cyanText("|-") + "Botiquines: " + dailyRequest.firstAidKits.get(0));
        System.out.println(ConsoleColor.cyanText("|-") + "Ambulancias: " + dailyRequest.ambulances.get(0));
        System.out.println(ConsoleColor.cyanText("|-") + "Paramedicos: " + dailyRequest.firstAidKits.get(0));
        System.out.println(ConsoleColor.cyanText("|-") + "Litros de Agua: " + dailyRequest.litersOfWater.get(0));
        System.out.println(ConsoleColor.cyanText("|-") + "Carro de bomberos: " + dailyRequest.fireTrucks.get(0));
        System.out.println(ConsoleColor.cyanText("|-") + "Bomberos: " + dailyRequest.firstAidKits.get(0));
        System.out.println(ConsoleColor.cyanText("|-") + "Municion: " + dailyRequest.ammunition.get(0));
        System.out.println(ConsoleColor.cyanText("|-") + "Patrullas de policia: " + dailyRequest.patrols.get(0));
        System.out.println(ConsoleColor.cyanText("|-") + "Policias: " + dailyRequest.firstAidKits.get(0));
        System.out.println(ConsoleColor.cyanText("|-") + "Litros de Gasolina: " + dailyRequest.litersOfGasoline.get(0));
        System.out.println(ConsoleColor.cyanText("|===========================================================|"));
    }

    public static void serrMenu() {
        System.out.println(ConsoleColor.redText("""
                |===========================================================|
                |==========-Opción invalida, intentelo nuevamente.-=========|
                |===========================================================|"""));
    }

    public static void pressEnter(Scanner scGame) {
        System.out.print(ConsoleColor.orangeText("""
                |===========================================================|
                |==============-Presione Enter para Continuar-==============|
                |===========================================================|"""));
        scGame.nextLine();
    }
}
