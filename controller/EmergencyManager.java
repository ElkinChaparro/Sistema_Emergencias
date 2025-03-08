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

    // Atributos
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

    // Constructor
    public EmergencyManager() {
        ePriorityQueue = new PriorityQueue<>();
        attendedEmergencies = new ArrayList<>();
        observers = new ArrayList<>();
        numberEmergenciesAtt = 0;
        totalAttentionTime = 0;
    }

    // Getters y Setters
    public void setStrategy(PrioritizationStrategy strategy) {
        EmergencyManager.strategy = strategy;
    }

    public static EmergencyManager getInstancia() {
        if (instancia == null) {
            instancia = new EmergencyManager();
        }
        return instancia;
    }

    // Función para registrar una nueva emergencia
    public void registerEmergencyMenu(Scanner scanner) throws InterruptedException {
        boolean exit = false;

        while (!exit) {
            // Impresion del menu de gravedad
            System.out.println(
                    ConsoleColor.cyanText("|===========================================================|"));
            System.out.println(ConsoleColor.cyanText("|================-")
                    + ConsoleColor.blueText("REGISTRAR NUEVA EMERGENCIA")
                    + ConsoleColor.cyanText("-===============|"));
            var type = selecType();
            var location = selecLocation();
            var severityLevel = selecSeverityLevel();
            // Se crea la nueva emergencia
            Emergency newEmergency = FactoryEmergencies.creatEmergency(type, location, severityLevel,
                    strategy.estimatedTime(location));
            // Se agrega la emergencia a la lista de emergencias
            addEmergency(newEmergency);
            System.out.println(
                    ConsoleColor.cyanText("|===========================================================|"));
            // Barra de carga
            showMenu.printLoadingBar();
            // se agrega el observer y se notifica de la emergencia registrada
            addObserver(observer);
            notifyObservers(newEmergency);
            removeObserver(observer);
            // Se imprime la emergencia registrada
            System.out.println(ConsoleColor.greenText("""
                    |===========================================================|
                    |============-Emergencia registrada exitosamente.-==========|
                    |===========================================================|"""));
            exit = true;
        }
        // Se imprime un mensaje de confirmación
        showMenu.pressEnter(scanner);
    }

    public static EmergencyType selecType() {
        EmergencyType type = null;
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
            type = selecType();
        } // Se captura la excepción en caso de que la opción sea nula
        catch (NullPointerException e) {
            showMenu.serrMenu();
            type = selecType();
        }
        return type;
    }

    public static EmergencyLocation selecLocation() {
        EmergencyLocation location = null;
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
            location = selecLocation();
        } // Se captura la excepción en caso de que la opción sea nula
        catch (NullPointerException e) {
            showMenu.serrMenu();
            location = selecLocation();
        }
        return location;
    }

    public static SeverityLevel selecSeverityLevel() {
        SeverityLevel severityLevel = null;
        // impresion del menu de gravedad
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
            severityLevel = selecSeverityLevel();
        } // Se captura la excepción en caso de que la opción sea nula
        catch (NullPointerException e) {
            showMenu.serrMenu();
            severityLevel = selecSeverityLevel();
        }
        return severityLevel;
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

    // Función para manejar o atender la siguiente emergencia, ordenadas en una
    // "Queue" según su prioridad
    public Emergency handleNextEmergency() {
        Emergency nextEmergency = peekNextEmergency();
        BackgroundEmergencie bEmergencie = new BackgroundEmergencie(nextEmergency);
        if (nextEmergency == null) {
            // Si no hay emergencias pendientes
            System.out
                    .println(ConsoleColor.redText("|===========================================================|"));
            System.out
                    .println(ConsoleColor.redText("|==============-No hay emergencias pendientes-==============|"));
            System.out
                    .println(ConsoleColor.redText("|===========================================================|"));
            showMenu.pressEnter(scanner);
        } else {

            // Si hay emergencias pendientes
            printAllEmergencies();
            // Se imprime el mensaje de confirmación
            System.out
                    .println(ConsoleColor.cyanText("|===========================================================|"));
            System.out
                    .println(ConsoleColor.cyanText(
                            "|====-" + ConsoleColor.blueText("Desea atender la siguiente emergencia? |S| o |N|")
                                    + ConsoleColor.cyanText("-=====|")));
            System.out
                    .println(ConsoleColor.cyanText("|===========================================================|"));
            System.out.print(ConsoleColor.cyanText("|==-"));
            try {
                var option = String.format(scanner.nextLine());
                if (option.equalsIgnoreCase("s")) {
                    // validacion de recursos disponibles para atender la emergencia
                    if (checkResources(nextEmergency)) {
                        nextEmergency = ePriorityQueue.poll(); // Obtiene y elimina la emergencia con mayor prioridad
                        attendedEmergencies.add(nextEmergency);
                        // se llama al metodo para manejar la emergencia como una tarea secundaria
                        bEmergencie.backgroundEmergency();
                        System.out.println(
                                ConsoleColor.cyanText("|===========================================================|"));
                        System.out.println(ConsoleColor.cyanText("|==================-")
                                + ConsoleColor.blueText("Atendiendo emergencia")
                                + ConsoleColor.cyanText("-==================|")
                                + nextEmergency.getDescription());
                        System.out.println(
                                ConsoleColor.cyanText("|===========================================================|"));
                        System.out.println(
                                ConsoleColor.cyanText("|==================-")
                                        + ConsoleColor.blueText("Continúa la ejecución")
                                        + ConsoleColor.cyanText("-==================|"));
                        System.out.println(
                                ConsoleColor.cyanText("|===========================================================|"));
                        numberEmergenciesAtt++;
                        operations(nextEmergency);
                    }
                } else if (option.equalsIgnoreCase("n")) {
                    System.out.println(
                            ConsoleColor.orangeText("|===========================================================|"));
                    System.out.println(
                            ConsoleColor.orangeText("|=================-Emergencia no atendida.-=================|"));
                    System.out.println(
                            ConsoleColor.orangeText("|===========================================================|"));
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out
                        .println(ConsoleColor.redText("|===========================================================|"));
                System.out
                        .println(ConsoleColor.redText("|======-Opción no válida. Por favor, ingrese |S| o |N|-=====|"));
                System.out
                        .println(ConsoleColor.redText("|===========================================================|"));
                handleNextEmergency();
            } catch (NullPointerException e) {
                showMenu.serrMenu();
                handleNextEmergency();
            } catch (Exception e) {
                System.out.println(
                        ConsoleColor.orangeText("|===========================================================|"));
                System.out.println(
                        ConsoleColor.orangeText("|===============-Ocurrió un error inesperado.-==============|"));
                System.out.println(
                        ConsoleColor.orangeText("|===========================================================|"));
            }
        }
        return nextEmergency;
    }

    // obtiene e imprime en consola todas las emergencias pendientes por atender
    public void printAllEmergencies() {
        // copia de la lista principal de "ePriorityQueue" para poder verse en listado
        PriorityQueue<Emergency> copyQueue = new PriorityQueue<>(ePriorityQueue);

        if (copyQueue.isEmpty()) {
            // Si no hay emergencias pendientes
            System.out
                    .println(ConsoleColor.redText("|===========================================================|"));
            System.out
                    .println(ConsoleColor.redText("|==============-No hay emergencias pendientes-==============|"));
            System.out
                    .println(ConsoleColor.redText("|===========================================================|"));
        } else {
            System.out.println(
                    ConsoleColor.cyanText(
                            "|===========================================================|"));
            System.out.println(ConsoleColor.cyanText("|=================-")
                    + ConsoleColor.blueText("EMERGENCIAS PENDIENTES") + ConsoleColor.cyanText("-==================|"));
            System.out.println(
                    ConsoleColor.cyanText(
                            "|===========================================================|"));
            while (!copyQueue.isEmpty()) {
                Emergency emergency = copyQueue.poll();
                System.out.println(ConsoleColor.orangeText("-> ") + emergency);
            }
        }
    }

    // Muestra las estadisticas del dia
    public void showStatistics() {
        System.out.println(
                ConsoleColor.cyanText(
                        "|===========================================================|"));
        System.out.println(ConsoleColor.cyanText("|=================-") + ConsoleColor.blueText("ESTADISTICAS DEL DIA")
                + ConsoleColor.cyanText("-==================|"));
        System.out.println(
                ConsoleColor.cyanText(
                        "|===========================================================|"));
        System.out.println("Emergencias atendidas: " + numberEmergenciesAtt);
        System.out.println("TIEMPO: " + totalAttentionTime);
    }

    public void operations(Emergency nextEmergency) {

        if (nextEmergency.getType() == EmergencyType.ROBO) {
            Policia.executeRobbery(nextEmergency.getLocation(), nextEmergency.getSeverityLevel());
        }
        if (nextEmergency.getType() == EmergencyType.ACCIDENTE_TRANSITO) {
            Ambulancia.executetrafficAccident(nextEmergency.getLocation(), nextEmergency.getSeverityLevel());
        }
        if (nextEmergency.getType() == EmergencyType.INCENDIO) {
            Bomberos.executeFire(nextEmergency.getLocation(), nextEmergency.getSeverityLevel());
        }
    }

    public boolean checkResources(Emergency emergency) {
        // variable booleana para la verificación de si estan los recursos disponibles
        boolean isCheck = false;

        // se hace la verificación
        if (emergency.getType() == EmergencyType.ROBO
                && Policia.isAvailablee(emergency.getLocation(), emergency.getSeverityLevel())) {
            // si "isAvailable" es true, ischeck retorna "true"
            isCheck = true;
        } else if (emergency.getType() == EmergencyType.INCENDIO
                && Bomberos.isAvailablee(emergency.getLocation(), emergency.getSeverityLevel())) {
            isCheck = true;

        } else if (emergency.getType() == EmergencyType.ACCIDENTE_TRANSITO
                && Ambulancia.isAvailablee(emergency.getLocation(), emergency.getSeverityLevel())) {
            isCheck = true;

        }
        return isCheck;
    }

    @Override
    public void addObserver(ObserverEmergencies observerEmergencies) {
        observers.add(observerEmergencies);
    }

    @Override
    public void removeObserver(ObserverEmergencies observerEmergencies) {
        observers.remove(observerEmergencies);
    }

    @Override
    public void notifyObservers(Emergency emergency) {
        for (ObserverEmergencies observerEmergencies : observers) {
            observerEmergencies.update(emergency);
        }
    }

}
