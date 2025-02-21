package views;

import java.util.*;
import controller.*;
import images.*;
import models.strategy.*;

public class Main002 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean exit = false;
        // Se crea la instancia
        EmergencyManager manager = EmergencyManager.getInstancia();
        manager.setStrategy(new PrioritizationEmergenciesStrategy());
        // Impresion de imagen de bienvenida
        imagesACCI.Welcome();
        // Se almacenan los suministros diarios
        dailyRequest.Application();
        showMenu.pressEnter(scanner);
        // Menú inicial
        while (!exit) {
            var option = showMenu.menuMain(null);

            // Se valida que la opción sea un número
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
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
                    showMenu.menuResources();
                    showMenu.pressEnter(scanner);
                    break;
                case 4:
                    // Emergencias pendeintes
                    manager.printAllEmergencies();
                    showMenu.pressEnter(scanner);
                    break;
                case 5:
                    // Estadisticas
                    manager.showStatistics();
                    showMenu.pressEnter(scanner);
                    break;
                case 6:
                    // Finalizar jornada
                    break;
                default:
                    // Opción inválida
                    showMenu.serrMenu();
            }
        }
    }
}
