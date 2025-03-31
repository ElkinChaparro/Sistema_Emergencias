package views;

import java.util.*;
import controller.*;
import images.*;
import models.strategy.*;

public class Main002 {

        static Scanner scanner = new Scanner(System.in);
        static boolean exit = false;

        public static void main(String[] args) throws InterruptedException {
                // Se crea la instancia
                EmergencyManager manager = EmergencyManager.getInstancia();
                manager.setStrategy(new PrioritizationEmergenciesStrategy());
                // Impresion de imagen de bienvenida
                imagesACCI.Welcome();
                showMenu.Welcome();
                // Se almacenan los suministros diarios
                dailyRequest.Application();
                showMenu.pressEnter(scanner);
                while (!exit) {
                        // Se muestra el menú principal
                        var option = showMenu.menuMain(null);
                        // Se valida que la opción sea un número
                        option = getValidOption(scanner, 1, 8);
                        if (option == -1) {
                                continue;
                        }
                        handleMenuOption(option, manager);
                }
        }

        private static void handleMenuOption(int option, EmergencyManager manager) throws InterruptedException {
                switch (option) {
                        case 1 -> manager.registerEmergencyMenu(scanner);
                        case 2 -> manager.handleNextEmergency();
                        case 3 -> dailyRequest.currenResources(scanner);
                        case 4 -> dailyRequest.añadirRecursos();
                        case 5 -> {
                                manager.printAllEmergencies();
                                showMenu.pressEnter(scanner);
                        }
                        case 6 -> BackgroundEmergencie.printBar();
                        case 7 -> {
                                manager.showStatistics();
                                showMenu.pressEnter(scanner);
                        }
                        case 8 -> exit = getConfirm(exit, manager);
                        default -> showMenu.serrMenu();
                }
        }

        private static boolean getConfirm(boolean exit, EmergencyManager manager) throws InterruptedException {
                System.out.println(
                                ConsoleColor.cyanText("|===========================================================|"));
                System.out.println(ConsoleColor.blueText("|-¿Está seguro de que desea finalizar la jornada? (S/N)     ")
                                + ConsoleColor.cyanText("|"));
                System.out.println(
                                ConsoleColor.cyanText("|===========================================================|"));
                System.out.print(ConsoleColor.cyanText("|")
                                + ConsoleColor.blueText("Presione S para confirmar o N para cancelar: "));
                // Se espera la respuesta del usuario
                String confirm = scanner.nextLine();
                if (confirm.equalsIgnoreCase("S")) {
                        // Se finaliza la jornada
                        System.out.println(
                                        ConsoleColor.cyanText(
                                                        "|===========================================================|"));
                        System.out
                                        .println(ConsoleColor.cyanText("|")
                                                        + ConsoleColor.blueText("Finalizando jornada..."));
                        System.out.println(
                                        ConsoleColor.cyanText(
                                                        "|===========================================================|"));
                        System.out.println(ConsoleColor.cyanText("|") + ConsoleColor.blueText("Guardando datos..."));
                        System.out.println(
                                        ConsoleColor.cyanText(
                                                        "|===========================================================|"));
                        // estadisticas finales
                        manager.showStatistics();
                        System.out.println(
                                        ConsoleColor.cyanText(
                                                        "|===========================================================|"));
                        // Se espera 2 segundos
                        Thread.sleep(2000);
                        // Se imprime el mensaje de finalización
                        System.out.println(
                                        ConsoleColor.cyanText(
                                                        "|===========================================================|"));
                        System.out.println(ConsoleColor.cyanText("|")
                                        + ConsoleColor.blueText(
                                                        "Gracias por usar el sistema de gestión de emergencias."));
                        System.out.println(
                                        ConsoleColor.cyanText(
                                                        "|===========================================================|"));
                        System.out.println(ConsoleColor.cyanText("|")
                                        + ConsoleColor.blueText("Esperamos que haya sido de ayuda."));
                        System.out.println(
                                        ConsoleColor.cyanText(
                                                        "|===========================================================|"));
                        System.out.println(ConsoleColor.cyanText("|") + ConsoleColor.blueText("Hasta la próxima."));
                        System.out.println(
                                        ConsoleColor.cyanText(
                                                        "|===========================================================|"));
                        exit = true;
                } else if (confirm.equalsIgnoreCase("N")) {
                        // Se cancela la finalización de la jornada
                        System.out.println(
                                        ConsoleColor.cyanText(
                                                        "|===========================================================|"));
                        System.out.println(ConsoleColor.cyanText("|")
                                        + ConsoleColor.blueText("Cancelando finalización de jornada..."));
                        System.out.println(
                                        ConsoleColor.cyanText(
                                                        "|===========================================================|"));
                } else {
                        // Opción inválida
                        System.out.println(
                                        ConsoleColor.redText(
                                                        "|===========================================================|"));
                        System.out.println(ConsoleColor.redText("|")
                                        + ConsoleColor.redText("Opción inválida. Por favor, ingrese S o N."));
                        System.out.println(
                                        ConsoleColor.redText(
                                                        "|===========================================================|"));
                }
                return exit;
        }

        public static int getValidOption(Scanner scanner, int min, int max) {
                try {
                        int option = Integer.parseInt(scanner.nextLine());
                        if (option >= min && option <= max) {
                                return option;
                        }
                } catch (NumberFormatException e) {
                        System.out.println("Por favor, ingrese un número válido.");
                }
                return -1; // Opción inválida
        }
}