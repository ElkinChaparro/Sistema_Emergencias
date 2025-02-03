package views;

import java.util.Scanner;

import controller.EmergencyManager;
import model.Emergency;
import model.factory.FactoryEmergencies;
import model.strategy.PrioritizationEmergenciesStrategy;
import utils.EmergencyLocation;
import utils.EmergencyType;
import utils.SeverityLevel;

public class Main002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        EmergencyManager manager = EmergencyManager.getInstancia();

        manager.setStrategy(new PrioritizationEmergenciesStrategy());

        // Menú de prueba
        while (!exit) {
            System.out.println("\n=== SISTEMA DE GESTIÓN DE EMERGENCIAS ===");
            System.out.println("1. Registrar una nueva emergencia");
            System.out.println("2. Atender una emergencia");
            System.out.println("3. Ver emergencias pendientes");
            System.out.println("4. Mostrar estadísticas del día");

            int option = 0;
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opción invalida, intentelo nuevamente.");
                continue;
            }

            switch (option) {
                case 1:
                    registerEmergencyMenu(manager, scanner);
                    break;
                case 2:
                    manager.handleNextEmergency();
                    break;
                case 3:
                    manager.printAllEmergencies();
                    break;
                case 4:
                    manager.showStatistics();
                    break;
                default:
                    break;
            }
        }
        }
        // Menu para registrar la emergencia
        private static void registerEmergencyMenu(EmergencyManager manager, Scanner scanner){
            System.out.println("\n=== REGISTRAR NUEVA EMERGENCIA ===");
            System.out.println("1. Incendio");
            System.out.println("2. Accidente Vehicular");
            System.out.println("3. Robo");
            System.out.print("Seleccione el tipo: ");
            EmergencyType type = null;
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1:
                    type = EmergencyType.INCENDIO;
                    break;
                case 2:
                    type = EmergencyType.ACCIDENTE_TRANSITO;
                    break;
                case 3:
                    type = EmergencyType.ROBO;
                    break;
                default:
                System.out.println("Opción invalida, intentelo nuevamente");
                    break;
            }

            System.out.println("===Seleccione la ubicación de la emergencia===");
            System.out.println("""
                    1. Zona-norte
                    2. Zona-sur
                    3. Zona-centro
                    4. Zona-oriente
                    5. Zona-occidente
                    """);
            System.out.print("Seleccione el tipo: ");
            EmergencyLocation location = null;
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1:
                    location = EmergencyLocation.ZONA_NORTE;
                    break;
                case 2:
                location = EmergencyLocation.ZONA_SUR;
                    break;
                case 3:
                location = EmergencyLocation.ZONA_CENTRO;
                    break;
                case 4:
                location = EmergencyLocation.ZONA_ORIENTE;
                    break;
                case 5:
                location = EmergencyLocation.ZONA_OCCIDENTE;
                    break;
                default:
                System.out.println("Opción invalida intentelo nuevamente");
                    break;
            }

            System.out.println("===Ingrese el nivel de gravedad===");
            System.out.println("""
                1. Bajo
                2. Medio
                3. Alto
                """);
            SeverityLevel severityLevel = null;
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1:
                severityLevel = SeverityLevel.BAJO;
                    break;
                case 2:
                severityLevel = SeverityLevel.MEDIO;
                    break;
                case 3:
                severityLevel = SeverityLevel.ALTO;
                    break;
                default:
                System.out.println("Opción invalida intentelo nuevamente");
                    break;
            }

            Emergency newEmergency = FactoryEmergencies.creatEmergency(type, location, severityLevel, 500);
            if (newEmergency == null) {
                System.out.println("Tipo de emergencia invalido");
                return;
            }

            manager.addEmergency(newEmergency);
            System.out.println("Emergencia registrada:" + newEmergency);

    }



    // codigo de prueba

        /*
        while (true) {
            System.out.println("Presiona 's' para atender la siguiente emergencia, 'n' para salir");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("s")) {
                Emergency nextEmergency = manager.peekNextEmergency();
                if (nextEmergency != null) {
                    System.out.println("Siguiente emergencia con prioridad: " + nextEmergency.getPriority());
                    System.out.println("DATOS: " +nextEmergency.getType()+" "+  nextEmergency.getSeverityLevel() +" "+ nextEmergency.getLocation());

                    System.out.println("Presiona 's' para atender la emergencia, 'n' para no atenderla");
                    input = scanner.nextLine();
                    if (input.equalsIgnoreCase("s")) {
                        manager.handleNextEmergency();
                    }else{
                        System.out.println("SALIENDO...");
                        break;
                    }
                }else{
                    System.out.println("No hay mas emergencias por atender");
                    break;
                }
            }else if (input.equalsIgnoreCase("n")) {
                break;
            }
        }
        scanner.close(); */
}
