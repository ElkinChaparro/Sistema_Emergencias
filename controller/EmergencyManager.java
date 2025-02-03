package controller;

import java.util.*;

import model.factory.*;
import model.strategy.*;
import utils.*;
import model.*;

public class EmergencyManager {

    private static EmergencyManager instancia;
    private static PrioritizationStrategy strategy;
    private static PriorityQueue<Emergency> ePriorityQueue;
    private List<Emergency> attendedEmergencies;
    Random random = new Random();
    static Scanner scanner = new Scanner(System.in);

    private int numberEmergenciesAtt;
    private int totalAttentionTime;

    public EmergencyManager() {
        ePriorityQueue = new PriorityQueue<>();
        attendedEmergencies = new ArrayList<>();
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
        var option = showMenu.menu02(null);
        EmergencyType type = null;

        try {
            option = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            showMenu.serrMenu();
        }

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
        try {
            option = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            showMenu.serrMenu();
        }

        EmergencyLocation location = null;
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
        }

        System.out.println("===Ingrese el nivel de gravedad===");
        System.out.println("""
                1. Bajo
                2. Medio
                3. Alto
                """);
        try {
            option = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            showMenu.serrMenu();
        }

        SeverityLevel severityLevel = null;
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
        }

        Emergency newEmergency = FactoryEmergencies.creatEmergency(type, location, severityLevel, 500);
        if (newEmergency == null) {
            System.out.println("Tipo de emergencia invalido");
            return;
        }

        addEmergency(newEmergency);
        System.out.println("Emergencia registrada:" + newEmergency);
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
                attendedEmergencie();
                System.out.println("La emergencia: " + emergency.getDescription() + " ha sido atendida exitosamente");
            }
        });
        emergencyThread.start();
        System.out.println("continua la ejecución");
    }

    // tiempo de ejecucion de la emergencia
    public static void attendedEmergencie() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Función para manejar o atender la siguiente emergencia, ordenadas en una
    // "Queue" según su prioridad
    public Emergency handleNextEmergency(Robbery robbery) {
        //TODO Crear listadod e todas las emergencias cradas
        Emergency nextEmergency = ePriorityQueue.poll();// Obtiene y elimina la emergencia con mayor prioridad
        //TODO implementar recursos y eliminaciones igualando nextEmergency con las variantes
        if (nextEmergency == robbery) {
            
            nextEmergency.startAttention();
            attendedEmergencies.add(nextEmergency);
            // se llama al metodo para manejar la emergencia como una tarea secundaria
            
            backgroundEmergency(nextEmergency);

            nextEmergency.endAttention();
            System.out.println("Atendiendo emergencia: " + nextEmergency.getDescription());
            numberEmergenciesAtt++;
            totalAttentionTime += nextEmergency.getResponseTime();
        } else {
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

}
