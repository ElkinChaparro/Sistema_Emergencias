package controller;

import java.util.*;

import images.ConsoleColor;
import images.showMenu;
import model.factory.*;
import model.observer.ConsoleObserver;
import model.observer.ObserverEmergencies;
import model.observer.SubjectEmergencies;
import model.services.Ambulancia;
import model.services.Bomberos;
import model.services.Policia;
import model.strategy.*;
import utils.*;
import model.*;

public class EmergencyManager implements SubjectEmergencies {

    private static EmergencyManager instancia;
    private static PrioritizationStrategy strategy;
    private static PriorityQueue<Emergency> ePriorityQueue;
    private List<Emergency> attendedEmergencies;
    private List<ObserverEmergencies> observers;
    Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
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
        var exit = false;
        var option = showMenu.menu02(null);
        EmergencyType type = null;
        while (!exit) {
        try {
            option = Integer.parseInt(scanner.nextLine());
            switch (option) {

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
                    throw new NullPointerException(ConsoleColor.redText("|======= ERROR: Opción invalida, intentelo nuevamente ======|"));
            }
        } catch (NumberFormatException e) {
            showMenu.serrMenu();
            break;
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
            break;
        }

        // TODO desicion sobre random y estatico
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
        try {
            option = Integer.parseInt(scanner.nextLine());
            switch (option) {
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
                throw new NullPointerException(ConsoleColor.redText("|======= ERROR: Opción invalida, intentelo nuevamente ======|"));
            }
        } catch (NumberFormatException e) {
            showMenu.serrMenu();
            break;
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
            break;
        }


        System.out.println("===Ingrese el nivel de gravedad===");
        System.out.println("""
                1. Bajo
                2. Medio
                3. Alto
                """);
        SeverityLevel severityLevel = null;
        try {
            option = Integer.parseInt(scanner.nextLine());
        switch (option) {
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
            throw new NullPointerException(ConsoleColor.redText("|======= ERROR: Opción invalida, intentelo nuevamente ======|"));
        }
        } catch (NumberFormatException e) {
            showMenu.serrMenu();
            break;
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
            break;
        }


        Emergency newEmergency = FactoryEmergencies.creatEmergency(type, location, severityLevel, strategy.estimatedTime(location));
        if (newEmergency == null) {
            System.out.println("Tipo de emergencia invalido");
            return;
        }

        addEmergency(newEmergency);
        System.out.println(ConsoleColor.greenText("Emergencia registrada exitosamente. "));
        // se agrega el observer y se notifica de la emergencia registrada
        addObserver(observer);
        notifyObservers(newEmergency);
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
            if (emergency.getLocation().equals(EmergencyLocation.ZONA_SUR) || emergency.getLocation().equals(EmergencyLocation.ZONA_NORTE)){
                Thread.sleep(random.nextInt((45000 - 30000)+ 1) + 30000);
            }else if (emergency.getLocation().equals(EmergencyLocation.ZONA_OCCIDENTE)) {
                Thread.sleep(random.nextInt((29000- 15000)+ 1) + 15000);
            }else{
                Thread.sleep(random.nextInt((10000 - 5000)+ 1) + 5000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Función para manejar o atender la siguiente emergencia, ordenadas en una
    // "Queue" según su prioridad
    public Emergency handleNextEmergency(Robbery robbery, TrafficAccident trafficAccident, Fire fire) {
        // TODO Crear listadod e todas las emergencias cradas
        printAllEmergencies();
        Emergency nextEmergency = peekNextEmergency();
        // TODO implementar recursos y eliminaciones igualando nextEmergency con las
        // variantes
            if (nextEmergency == robbery) {
                Policia.executeRobbery(nextEmergency.getLocation(), nextEmergency.getSeverityLevel());
            } else if (nextEmergency == trafficAccident) {
                Ambulancia.executetrafficAccident(nextEmergency.getLocation(), nextEmergency.getSeverityLevel());
            }
            else if (nextEmergency == fire) {
                Bomberos.executeFire(nextEmergency.getLocation(), nextEmergency.getSeverityLevel());
            }
        if (nextEmergency != null) {
            System.out.println("Desea atender la siguiente emergencia? 's' o 'n'");
            String option = scanner.nextLine();
            if (option.equalsIgnoreCase("s")) {
                nextEmergency = ePriorityQueue.poll();// Obtiene y elimina la emergencia con mayor prioridad
                attendedEmergencies.add(nextEmergency);
                // se llama al metodo para manejar la emergencia como una tarea secundaria
                backgroundEmergency(nextEmergency);

                System.out.println("Atendiendo emergencia: " + nextEmergency.getDescription());
                numberEmergenciesAtt++;
                //totalAttentionTime += nextEmergency.getResponseTime();
            }
        }else{
            System.out.println("No hay emergencias pendientes");
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
        for(ObserverEmergencies observerEmergencies : observers){
            observerEmergencies.update(emergency);
        }
    }

}
