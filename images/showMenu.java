package images;

import java.util.Scanner;

import controller.dailyRequest;

public class showMenu {

        // Welcome
        public static void Welcome() {
                System.out.println(
                                ConsoleColor.cyanText("|===========================================================|"));
                System.out.println(ConsoleColor.cyanText("|=====-")
                                + ConsoleColor.blueText("BIENVENIDO al SISTEMA DE GESTIÓN DE EMERGENCIAS")
                                + ConsoleColor.cyanText("-=====|"));
                System.out.println(
                                ConsoleColor.cyanText("|===========================================================|"));
                System.out.println(ConsoleColor.cyanText("|-")
                                + ConsoleColor.blueText("Por favor, ingrese la cantidad de suministros")
                                + ConsoleColor.cyanText("             |"));
                System.out.println(
                                ConsoleColor.cyanText("|-") + ConsoleColor.blueText("con los que cuenta el dia de hoy.")
                                                + ConsoleColor.cyanText("                         |"));
        }

        // Menu principal
        public static Integer menuMain(Integer option) {
                System.out.println(
                                ConsoleColor.cyanText("|===========================================================|"));
                System.out.println(ConsoleColor.cyanText("|============-")
                                + ConsoleColor.blueText("SISTEMA DE GESTIÓN DE EMERGENCIAS")
                                + ConsoleColor.cyanText("-============|"));
                System.out.println(
                                ConsoleColor.cyanText("|===========================================================|"));
                System.out.println(ConsoleColor.cyanText("|-")
                                + ConsoleColor.blueText(" 1. Registrar una nueva emergencia                        ")
                                + ConsoleColor.cyanText("|"));
                System.out.println(ConsoleColor.cyanText("|-")
                                + ConsoleColor.blueText(" 2. Atender una emergencia                                ")
                                + ConsoleColor.cyanText("|"));
                System.out.println(ConsoleColor.cyanText("|-")
                                + ConsoleColor.blueText(" 3. Recursos actuales                                     ")
                                + ConsoleColor.cyanText("|"));
                System.out.println(ConsoleColor.cyanText("|-")
                                + ConsoleColor.blueText(" 4. Añadir recursos                                       ")
                                + ConsoleColor.cyanText("|"));
                System.out.println(ConsoleColor.cyanText("|-")
                                + ConsoleColor.blueText(" 5. Emergencias pendientes                                ")
                                + ConsoleColor.cyanText("|"));
                System.out.println(ConsoleColor.cyanText("|-")
                                + ConsoleColor.blueText(" 6. Mostrar estadísticas del día                          ")
                                + ConsoleColor.cyanText("|"));
                System.out.println(ConsoleColor.cyanText("|-")
                                + ConsoleColor.blueText(" 7. Finalizar jornada **                                  ")
                                + ConsoleColor.cyanText("|"));
                System.out.println(
                                ConsoleColor.cyanText("|===========================================================|"));
                System.out.print(ConsoleColor.orangeText("|- Seleccione una opcion: "));
                option = 0;
                return option;
        }

        public static Integer añadirRecursos(Integer option) {
                System.out.println(
                                ConsoleColor.cyanText("|===========================================================|"));
                System.out.println(ConsoleColor.cyanText("|-")
                                + " 1. Añadir Botiquines                                     "
                                + ConsoleColor.cyanText("|"));
                System.out.println(ConsoleColor.cyanText("|-")
                                + " 2. Añadir Ambulancias                                    "
                                + ConsoleColor.cyanText("|"));
                System.out.println(ConsoleColor.cyanText("|-")
                                + " 3. Añadir Paramedicos                                    "
                                + ConsoleColor.cyanText("|"));
                System.out.println(ConsoleColor.cyanText("|-")
                                + " 4. Añadir Litros de Agua                                 "
                                + ConsoleColor.cyanText("|"));
                System.out.println(ConsoleColor.cyanText("|-")
                                + " 5. Añadir Carro de bomberos                              "
                                + ConsoleColor.cyanText("|"));
                System.out.println(ConsoleColor.cyanText("|-")
                                + " 6. añadir Bomberos                                       "
                                + ConsoleColor.cyanText("|"));
                System.out.println(ConsoleColor.cyanText("|-")
                                + " 7. añañdir Municion                                      "
                                + ConsoleColor.cyanText("|"));
                System.out.println(ConsoleColor.cyanText("|-")
                                + " 8. Añadir Patrullas de policia                           "
                                + ConsoleColor.cyanText("|"));
                System.out.println(ConsoleColor.cyanText("|-")
                                + " 9. Añadir Policias                                       "
                                + ConsoleColor.cyanText("|"));
                System.out.println(ConsoleColor.cyanText("|-")
                                + " 10. Añadir Litros de Gasolina                            "
                                + ConsoleColor.cyanText("|"));
                System.out.println(
                                ConsoleColor.cyanText("|===========================================================|"));
                System.out.print(ConsoleColor.orangeText("|- Seleccione una opcion: "));
                option = 0;
                return option;
        }

        // Menu de tipo de emergencias
        public static Integer menuType(Integer option01) {
                System.out.println(
                                ConsoleColor.cyanText("|===========================================================|"));
                System.out.println(ConsoleColor.cyanText("|================-")
                                + ConsoleColor.blueText("REGISTRAR NUEVA EMERGENCIA")
                                + ConsoleColor.cyanText("-===============|"));
                System.out.println(
                                ConsoleColor.cyanText("|===========================================================|"));
                System.out.println(ConsoleColor.cyanText("|-")
                                + ConsoleColor.blueText(" 1. Incendio                                              ")
                                + ConsoleColor.cyanText("|"));
                System.out.println(ConsoleColor.cyanText("|-")
                                + ConsoleColor.blueText(" 2. Accidente Vehicular                                   ")
                                + ConsoleColor.cyanText("|"));
                System.out.println(ConsoleColor.cyanText("|-")
                                + ConsoleColor.blueText(" 3. Robo                                                  ")
                                + ConsoleColor.cyanText("|"));
                System.out.println(
                                ConsoleColor.cyanText("|===========================================================|"));
                System.out.print(ConsoleColor.orangeText("|- Seleccione la emergencia: "));
                option01 = 0;
                return option01;
        }

        // Menu de locaciones
        public static Integer menuLocation(Integer option02) {
                System.out.println(
                                ConsoleColor.cyanText("|===========================================================|"));
                System.out.println(ConsoleColor.cyanText("|-")
                                + ConsoleColor.blueText(" 1. Zona-norte                                            ")
                                + ConsoleColor.cyanText("|"));
                System.out.println(ConsoleColor.cyanText("|-")
                                + ConsoleColor.blueText(" 2. Zona-sur                                              ")
                                + ConsoleColor.cyanText("|"));
                System.out.println(ConsoleColor.cyanText("|-")
                                + ConsoleColor.blueText(" 3. Zona-centro                                           ")
                                + ConsoleColor.cyanText("|"));
                System.out.println(ConsoleColor.cyanText("|-")
                                + ConsoleColor.blueText(" 4. Zona-oriente                                          ")
                                + ConsoleColor.cyanText("|"));
                System.out.println(ConsoleColor.cyanText("|-")
                                + ConsoleColor.blueText(" 5. Zona-occidente                                        ")
                                + ConsoleColor.cyanText("|"));
                System.out.println(
                                ConsoleColor.cyanText("|===========================================================|"));
                System.out.print(ConsoleColor.orangeText("|- Seleccione la locacion: "));
                option02 = 0;
                return option02;
        }

        // Menu de gravedad
        public static Integer menuGravity(Integer option03) {
                System.out.println(
                                ConsoleColor.cyanText("|===========================================================|"));
                System.out.println(ConsoleColor.cyanText("|-")
                                + ConsoleColor.blueText(" 1. Bajo                                                  ")
                                + ConsoleColor.cyanText("|"));
                System.out.println(ConsoleColor.cyanText("|-")
                                + ConsoleColor.blueText(" 2. Medio                                                 "));
                System.out.println(ConsoleColor.cyanText("|-")
                                + ConsoleColor.blueText(" 3. Alto                                                  ")
                                + ConsoleColor.cyanText("|"));
                System.out.println(
                                ConsoleColor.cyanText("|===========================================================|"));
                System.out.print(ConsoleColor.orangeText("|- Seleccione el nivel de gravedad: "));
                option03 = 0;
                return option03;
        }

        // Menu de recursos
        public static void menuResources() {
                System.out.println(
                                ConsoleColor.cyanText("|===========================================================|"));
                System.out.println(ConsoleColor.cyanText("|====================-")
                                + ConsoleColor.blueText("RECURSOS ACTUALES")
                                + ConsoleColor.cyanText("-====================|"));
                System.out.println(
                                ConsoleColor.cyanText("|===========================================================|"));
                System.out.println(ConsoleColor.cyanText("|-") + ConsoleColor.blueText("Botiquines: ")
                                + dailyRequest.firstAidKits.get(0));
                System.out.println(ConsoleColor.cyanText("|-") + ConsoleColor.blueText("Ambulancias: ")
                                + dailyRequest.ambulances.get(0));
                System.out.println(ConsoleColor.cyanText("|-") + ConsoleColor.blueText("Paramedicos: ")
                                + dailyRequest.firstAidKits.get(0));
                System.out.println(
                                ConsoleColor.cyanText("|-") + ConsoleColor.blueText("Litros de Agua: ")
                                                + dailyRequest.litersOfWater.get(0));
                System.out.println(
                                ConsoleColor.cyanText("|-") + ConsoleColor.blueText("Carro de bomberos: ")
                                                + dailyRequest.fireTrucks.get(0));
                System.out.println(ConsoleColor.cyanText("|-") + ConsoleColor.blueText("Bomberos: ")
                                + dailyRequest.firstAidKits.get(0));
                System.out.println(ConsoleColor.cyanText("|-") + ConsoleColor.blueText("Municion: ")
                                + dailyRequest.ammunition.get(0));
                System.out.println(
                                ConsoleColor.cyanText("|-") + ConsoleColor.blueText("Patrullas de policia: ")
                                                + dailyRequest.patrols.get(0));
                System.out.println(ConsoleColor.cyanText("|-") + ConsoleColor.blueText("Policias: ")
                                + dailyRequest.firstAidKits.get(0));
                System.out.println(ConsoleColor.cyanText("|-") + ConsoleColor.blueText("Litros de Gasolina: ")
                                + dailyRequest.litersOfGasoline.get(0));
                System.out.println(
                                ConsoleColor.cyanText("|===========================================================|"));
        }

        // Mensaje de error
        public static void serrMenu() {
                System.out.println(ConsoleColor.redText("""
                                |===========================================================|
                                |==========-Opción invalida, intentelo nuevamente.-=========|
                                |===========================================================|"""));
        }

        // Pausador
        public static void pressEnter(Scanner scGame) {
                System.out.print(ConsoleColor.orangeText("""
                                |===========================================================|
                                |==============-Presione Enter para Continuar-==============|
                                |===========================================================|"""));
                scGame.nextLine();
        }

        public static void printLoadingBar() throws InterruptedException {
                int total = 53;
                for (int i = 0; i <= total; i++) {
                        // Calcula el porcentaje
                        int porcentaje = (i * 100) / total;
                        // Genera la barra de carga
                        StringBuilder barra = new StringBuilder("[");
                        for (int j = 0; j < total; j++) {
                                if (j < i) {
                                        barra.append("=");
                                } else {
                                        barra.append(" ");
                                }
                        }
                        barra.append("] ").append(porcentaje).append("%");
                        // Imprime la barra de carga
                        System.out.print(ConsoleColor.orangeText("\r" + barra.toString()));
                        // Simula un trabajo en progreso
                        Thread.sleep(50);
                }
                System.out.println(" ");
        }
}
