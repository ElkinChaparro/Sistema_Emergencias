package views;

import java.util.*;
import controller.*;
import images.*;
import models.strategy.*;

public class Main002 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        boolean exit = false;
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
            try {
                option = Integer.parseInt(scanner.nextLine());
            } // Se captura la excepción en caso de que la opción no sea un número
            catch (NumberFormatException e) {
                showMenu.serrMenu();
                continue;
            } // Se captura la excepción en caso de que la opción sea nula
            catch (NullPointerException e) {
                showMenu.serrMenu();
                continue;
            }
            switch (option) {
                case 1:
                    // Registrar emergencia
                    manager.registerEmergencyMenu(scanner);
                    break;
                case 2:
                    // Atender una nueva emergencia
                    manager.handleNextEmergency();
                    break;
                case 3:
                    // Ver recursos actuales
                    dailyRequest.currenResources(scanner);
                    break;
                case 4:
                    // Solicitar suministros
                    dailyRequest.añadirRecursos();
                    break;
                case 5:
                    // Emergencias pendeintes
                    manager.printAllEmergencies();
                    showMenu.pressEnter(scanner);
                    break;
                case 6:
                    // Progreso de atencion
                    BackgroundEmergencie.printBar();
                    break;
                case 7:
                    // Estadisticas
                    manager.showStatistics();
                    showMenu.pressEnter(scanner);
                    break;
                case 8:
                    // Finalizar jornada
                    exit = getConfirm(exit, manager);
                    showMenu.credits();
                    break;
                default:
                    // Opción inválida
                    showMenu.serrMenu();
            }
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
}