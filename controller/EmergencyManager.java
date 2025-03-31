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
    private List<Emergency> emergenciesCompleted;
    private int attentionTimeMinutes;
    private int attentionTimeSeconds;

    static Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    ObserverEmergencies observer = new ConsoleObserver();

    // Constructor
    public EmergencyManager() {
        ePriorityQueue = new PriorityQueue<>();
        attendedEmergencies = new ArrayList<>();
        emergenciesCompleted = new ArrayList<>();
        observers = new ArrayList<>();
        attentionTimeMinutes = 0;
        attentionTimeSeconds = 0;

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
            // Impresion de los menus de emergencias
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

    private static EmergencyType selecType() {
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

    private static EmergencyLocation selecLocation() {
        EmergencyLocation location = null;
        // Impresion del menu de locaciones
        var option02 = showMenu.menuLocation(null);
        // Se valida que la opción sea un número
        try {
            option02 = Integer.parseInt(scanner.nextLine());
        } // Se captura la excepción en caso de que la opción no sea un número
        catch (NumberFormatException e) {
            showMenu.serrMenu();
            location = selecLocation();
        } // Se captura la excepción en caso de que la opción sea nula
        catch (NullPointerException e) {
            showMenu.serrMenu();
            location = selecLocation();
        }
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
        return location;
    }

    private static SeverityLevel selecSeverityLevel() {
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
    private static void addEmergency(Emergency emergency) {
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
                        // Obtiene y elimina la emergencia con mayor prioridad
                        nextEmergency = ePriorityQueue.poll();
                        attendedEmergencies.add(nextEmergency);
                        // se llama al metodo para manejar la emergencia como una tarea secundaria
                        bEmergencie.backgroundEmergency();
                        System.out.println(
                                ConsoleColor.cyanText("|===========================================================|"));
                        System.out.println(ConsoleColor.cyanText("|==================-")
                                + ConsoleColor.blueText("Atendiendo emergencia")
                                + ConsoleColor.cyanText("-==================|"));
                        System.out.println(
                                ConsoleColor.cyanText("|===========================================================|"));
                        System.out.println(nextEmergency.getDescription());
                        System.out.println(
                                ConsoleColor
                                        .greenText("|===========================================================|"));
                        System.out.println(
                                ConsoleColor.greenText("|==================-")
                                        + ConsoleColor.blueText("Continúa la ejecución")
                                        + ConsoleColor.greenText("-==================|"));
                        System.out.println(
                                ConsoleColor
                                        .greenText("|===========================================================|"));
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

    // metodo que actualiza y establece la duracion de la atención
    // de las emergencias en minutos y segundos
    public void updateTotalAttentionTime() {
        for (Emergency emergency : attendedEmergencies) {
            attentionTimeMinutes += emergency.getAttentionDurationMinutes();
            attentionTimeSeconds += emergency.getAttentionDurationSeconds();
        }
    }

    // metodo que agrega la emergencia a "emergenciesCompleted" cuando ya fueron
    // completadas y las elimina
    // de attendedEmergencies
    public void updateEmergencie() {
        synchronized (attendedEmergencies) {
            Iterator<Emergency> iterator = attendedEmergencies.iterator();
            while (iterator.hasNext()) {
                Emergency emergency = iterator.next();
                if (emergency.isAttended()) {
                    // agrega la emergencia a la lista de emergencias completadas
                    emergenciesCompleted.add(emergency);
                    iterator.remove(); // Eliminar el elemento usando el iterador
                }
            }
        }
    }

    // Muestra las estadisticas del dia
    public void showStatistics() {
        // se llama al metodo para establecer la duracion
        updateTotalAttentionTime();
        // se llama el metodo para actualizar las estadisticas
        updateEmergencie();
        // se actualiza el valor de las emergencias ya atendidas
        if (attendedEmergencies.isEmpty() && emergenciesCompleted.isEmpty()) {
            System.out.println(ConsoleColor.redText("|===========================================================|"));
            System.out.println(ConsoleColor.redText("|=================-No hay emergencias atendidas-============|"));
            System.out.println(ConsoleColor.redText("|===========================================================|"));
            return;
        }
        System.out.println(ConsoleColor.cyanText("|===========================================================|"));
        System.out.println(ConsoleColor.cyanText("|==================-")
                + ConsoleColor.blueText("ESTADISTICAS DEL DIA") + ConsoleColor.cyanText("-===================|"));
        System.out.println(ConsoleColor.cyanText("|===========================================================|"));
        System.out.println(ConsoleColor.cyanText("|") + ConsoleColor.blueText("Emergencias atendidas: ")
                + emergenciesCompleted.size());
        System.out.println(ConsoleColor.cyanText("|") + ConsoleColor.blueText("Emergencias en proceso: ")
                + attendedEmergencies.size());
        System.out.println(
                ConsoleColor.cyanText("|") + ConsoleColor.blueText("Emergencias pendientes: ") + ePriorityQueue.size());
        System.out.println(
                ConsoleColor.cyanText("|") + ConsoleColor.blueText("Tiempo total de atencion: ") + attentionTimeMinutes
                        +
                        " hora/s y " + attentionTimeSeconds + " minutos");
        System.out.println(ConsoleColor.cyanText("|") + ConsoleColor.blueText("Tiempo promedio de atención: ")
                + (emergenciesCompleted.size() > 0 ? (attentionTimeMinutes / emergenciesCompleted.size()) : 0)
                + " hora/s");
        System.out.println(ConsoleColor.cyanText("|===========================================================|"));
        System.out.println(ConsoleColor.cyanText("|===================-")
                + ConsoleColor.blueText("RECURSOS RESTANTES") + ConsoleColor.cyanText("-===================|"));
        System.out.println(ConsoleColor.cyanText("|===========================================================|"));
        showMenu.menuResources();
        System.out.println(ConsoleColor.cyanText("|===========================================================|"));
    }

    // Función para realizar las operaciones de la emergencia
    // dependiendo del tipo de emergencia
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

    // Función para verificar si hay recursos disponibles para atender la emergencia
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
