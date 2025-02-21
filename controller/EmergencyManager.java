package controller;

import java.util.*;

import images.*;
import models.*;
import models.factory.*;
import models.observer.*;
import models.services.*;
import models.strategy.*;
import utils.*;

public class EmergencyManager implements SubjectEmergencies {

    private static EmergencyManager instancia;
    private static PrioritizationStrategy strategy;
    private static PriorityQueue<Emergency> ePriorityQueue;
    private List<Emergency> attendedEmergencies;
    private List<ObserverEmergencies> observers;
    static Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    ObserverEmergencies observer = new ConsoleObserver();

    private int numberEmergenciesAtt;
    private int totalAttentionTime;

    public EmergencyManager() {
        ePriorityQueue = new PriorityQueue<>();
        attendedEmergencies = new ArrayList<>();
        observers = new ArrayList<>();
        numberEmergenciesAtt = 0;
        totalAttentionTime = 0;
    }

    public void setStrategy(PrioritizationStrategy strategy) {
        EmergencyManager.strategy = strategy;
    }

    public static EmergencyManager getInstancia() {
        if (instancia == null) {
            instancia = new EmergencyManager();
        }
        return instancia;
    }

    public void registerEmergencyMenu(Scanner scanner) {
        boolean exit = false;
        EmergencyType type = null;
        EmergencyLocation location = null;
        SeverityLevel severityLevel = null;

        while (!exit) {
            // Impresion del menude tipo de emergencia
            var option01 = showMenu.menuType(null);
            // Se valida que la opción sea un número
            try {
                option01 = Integer.parseInt(scanner.nextLine());
                // switch para seleccionar el tipo de emergencia
                switch (option01) {
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
                        throw new NullPointerException();
                }
            } // Se captura la excepción en caso de que la opción no sea un número
            catch (NumberFormatException e) {
                showMenu.serrMenu();
                break;
            } // Se captura la excepción en caso de que la opción sea nula
            catch (NullPointerException e) {
                showMenu.serrMenu();
                break;
            }

            // Impresion del menu de locaciones
            var option02 = showMenu.menuLocation(null);
            // Se valida que la opción sea un número
            try {
                option02 = Integer.parseInt(scanner.nextLine());
                // switch para seleccionar la locacion de la emergencia
                switch (option02) {
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
                        throw new NullPointerException();
                }
            } // Se captura la excepción en caso de que la opción no sea un número
            catch (NumberFormatException e) {
                showMenu.serrMenu();
                break;
            } // Se captura la excepción en caso de que la opción sea nula
            catch (NullPointerException e) {
                showMenu.serrMenu();
                break;
            }

            // Impresion del menu de gravedad
            var option03 = showMenu.menuGravity(null);
            // Se valida que la opción sea un número
            try {
                option03 = Integer.parseInt(scanner.nextLine());
                // switch para seleccionar la gravedad de la emergencia
                switch (option03) {
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
                        throw new NullPointerException();
                }
            } // Se captura la excepción en caso de que la opción no sea un número
            catch (NumberFormatException e) {
                showMenu.serrMenu();
                break;
            } // Se captura la excepción en caso de que la opción sea nula
            catch (NullPointerException e) {
                showMenu.serrMenu();
                break;
            }

            Emergency newEmergency = FactoryEmergencies.creatEmergency(type, location, severityLevel,
                    strategy.estimatedTime(location));
            if (newEmergency == null) {
                System.out.println(ConsoleColor.redText("""
                        |===========================================================|
                        |================-Tipo de emergencia invalido-==============|
                        |===========================================================|"""));
                return;
            }
            // Se agrega la emergencia a la lista de emergencias
            addEmergency(newEmergency);
            // Se imprime la emergencia registrada
            System.out.println(ConsoleColor.greenText("""
                    |===========================================================|
                    |============-Emergencia registrada exitosamente.-==========|
                    |===========================================================|"""));
            // se agrega el observer y se notifica de la emergencia registrada
            addObserver(observer);
            notifyObservers(newEmergency);
            removeObserver(observer);
            // Se imprime un mensaje de confirmación
            showMenu.pressEnter(scanner);
            exit = true;
        }
    }

    // Función para aregar una emergencia nueva
    public static void addEmergency(Emergency emergency) {
        int priority = strategy.prioritize(emergency);
        emergency.setPriority(priority);
        ePriorityQueue.add(emergency);
    }

    // Función para seleccionar una emergencia
    public Emergency peekNextEmergency() {
        return ePriorityQueue.peek(); // Obtiene la emergencia con mayor prioridad
    }

    // Ejecuta un hilo secundario para atender la emergencia y poder seguir usando
    // el programa
    public void backgroundEmergency(Emergency emergency) {
        Thread emergencyThread = new Thread(new Runnable() {

            @Override
            public void run() {
                emergency.startAttention();
                attendedEmergencie(emergency);
                emergency.endAttention();
                System.out.println("\nLa emergencia: " + emergency.getDescription() + " ha sido atendida exitosamente");
                // transformar de milisegundos a segundos
                long durationMillis = emergency.calculateAttentionTime();
                double durationSeconds = durationMillis / 1000.0;
                System.out.println("La emergencia ha sido atentido en: " + durationSeconds + " segundos");
                totalAttentionTime += durationSeconds;
            }
        });
        emergencyThread.start();
        System.out.println("continua la ejecución");
    }

    // tiempo de ejecucion de la emergencia
    public static void attendedEmergencie(Emergency emergency) {
        Random random = new Random();
        try {
            if (emergency.getLocation().equals(EmergencyLocation.ZONA_SUR)
                    || emergency.getLocation().equals(EmergencyLocation.ZONA_NORTE)) {
                Thread.sleep(random.nextInt((45000 - 30000) + 1) + 30000);
            } else if (emergency.getLocation().equals(EmergencyLocation.ZONA_OCCIDENTE)
                    || (emergency.getLocation().equals(EmergencyLocation.ZONA_ORIENTE))) {
                Thread.sleep(random.nextInt((29000 - 15000) + 1) + 15000);
            } else {
                Thread.sleep(random.nextInt((10000 - 5000) + 1) + 5000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Función para manejar o atender la siguiente emergencia, ordenadas en una
    // "Queue" según su prioridad
    public Emergency handleNextEmergency() {
        Emergency nextEmergency = peekNextEmergency();
        if (nextEmergency == null) {
            System.out.println(ConsoleColor.orangeText("|===========================================================|"));
            System.out.println(ConsoleColor.orangeText("|==============-No hay emergencias pendientes-==============|"));
            System.out.println(ConsoleColor.orangeText("|===========================================================|"));
        } else {
            printAllEmergencies();
            System.out.println("Desea atender la siguiente emergencia? 's' o 'n'");
            String option = scanner.nextLine();
            if (option.equalsIgnoreCase("s")) {
                nextEmergency = ePriorityQueue.poll();// Obtiene y elimina la emergencia con mayor prioridad
                attendedEmergencies.add(nextEmergency);
                // se llama al metodo para manejar la emergencia como una tarea secundaria
                backgroundEmergency(nextEmergency);
                System.out.println("Atendiendo emergencia: " + nextEmergency.getDescription());
                numberEmergenciesAtt++;
                operations(nextEmergency);
            }
        }
        return nextEmergency;
    }

    // obtiene e imprime en consola todas las emergencias pendientes por atender
    public void printAllEmergencies() {
        // copia de la lista principal de "ePriorityQueue" para poder verse en listado
        PriorityQueue<Emergency> copyQueue = new PriorityQueue<>(ePriorityQueue);
        System.out.println("=== EMERGENCIAS PENDIENTES ===");
        while (!copyQueue.isEmpty()) {
            Emergency emergency = copyQueue.poll();
            System.out.println("-> " + emergency);
        }
    }

    // Muestra las estadisticas del dia
    public void showStatistics() {
        System.out.println("\n === ESTADISTICAS DEL DIA ===");
        System.out.println("Emergencias atendidas: " + numberEmergenciesAtt);
        System.out.println("TIEMPO: " + totalAttentionTime);
    }

    public void operations(Emergency nextEmergency) {

        if (nextEmergency.getType() == EmergencyType.ROBO) {
            Policia.executeRobbery(nextEmergency.getLocation(), nextEmergency.getSeverityLevel());
        } else if (nextEmergency.getType() == EmergencyType.ACCIDENTE_TRANSITO) {
            Ambulancia.executetrafficAccident(nextEmergency.getLocation(), nextEmergency.getSeverityLevel());
        } else {
            Bomberos.executeFire(nextEmergency.getLocation(), nextEmergency.getSeverityLevel());
        }
    }

    @Override
    public void addObserver(ObserverEmergencies observerEmergencies) {
        observers.add(observerEmergencies);
    }

    @Override
    public void removeObserver(ObserverEmergencies observerEmergencies) {
        observers.remove(numberEmergenciesAtt);
    }

    @Override
    public void notifyObservers(Emergency emergency) {
        for (ObserverEmergencies observerEmergencies : observers) {
            observerEmergencies.update(emergency);
        }
    }

}
