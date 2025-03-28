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
                    System.out.println("¿Está seguro de que desea finalizar la jornada? (S/N)");
                    String confirm = scanner.nextLine();
                    if (confirm.equalsIgnoreCase("S")) {
                        System.out.println("Jornada finalizada.");
                        exit = true;
                    } else if (confirm.equalsIgnoreCase("N")) {
                        System.out.println("Jornada no finalizada.");
                    } else {
                        System.out.println("Opción inválida. Por favor, ingrese S o N.");
                    }
                    break;
                default:
                    // Opción inválida
                    showMenu.serrMenu();
            }
        }
    }
}
