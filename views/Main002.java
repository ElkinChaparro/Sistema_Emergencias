package views;

import java.util.*;
import controller.*;
import images.*;
import models.strategy.*;

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
            var option = showMenu.menuMain(null);

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
                    showMenu.menuResources();
                    showMenu.pressEnter(scanner);
                    break;
                case 4:
                    manager.printAllEmergencies();
                    break;
                case 5:
                    manager.showStatistics();
                    showMenu.pressEnter(scanner);
                    break;
                case 6:
                    // Finalizar jornada
                    break;
                default:
                    showMenu.serrMenu();
            }
        }
    }
}
