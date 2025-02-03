package views;

import java.util.*;

import controller.*;
import model.*;
import model.strategy.*;
import images.*;

public class Main002 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean exit = false;
        EmergencyManager manager = EmergencyManager.getInstancia();
        manager.setStrategy(new PrioritizationEmergenciesStrategy());

        imagesACCI.Welcome();
        dailyRequest.Application();
        scanner.nextLine();
        // Menú de prueba
        while (!exit) {
            var option = showMenu.menu01(null);

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                showMenu.serrMenu();
                continue;
            }

            switch (option) {
                case 1:
                    manager.registerEmergencyMenu(scanner);
                    break;
                case 2:
                    manager.handleNextEmergency();
                    break;
                case 3:
                    // Recursos Actuales
                case 4:
                    manager.printAllEmergencies();
                    break;
                case 5:
                    manager.showStatistics();
                    break;
                case 6:
                    // Finalizar jornada
                    break;
            }
        }
    }

    // Menu para registrar la emergencia

}

// codigo de prueba

/*
 * while (true) {
 * System.out.
 * println("Presiona 's' para atender la siguiente emergencia, 'n' para salir");
 * input = scanner.nextLine();
 *
 * if (input.equalsIgnoreCase("s")) {
 * Emergency nextEmergency = manager.peekNextEmergency();
 * if (nextEmergency != null) {
 * System.out.println("Siguiente emergencia con prioridad: " +
 * nextEmergency.getPriority());
 * System.out.println("DATOS: " +nextEmergency.getType()+" "+
 * nextEmergency.getSeverityLevel() +" "+ nextEmergency.getLocation());
 *
 * System.out.
 * println("Presiona 's' para atender la emergencia, 'n' para no atenderla");
 * input = scanner.nextLine();
 * if (input.equalsIgnoreCase("s")) {
 * manager.handleNextEmergency();
 * }else{
 * System.out.println("SALIENDO...");
 * break;
 * }
 * }else{
 * System.out.println("No hay mas emergencias por atender");
 * break;
 * }
 * }else if (input.equalsIgnoreCase("n")) {
 * break;
 * }
 * }
 * scanner.close();
 */
