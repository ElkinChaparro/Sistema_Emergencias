package controller;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;


import model.Emergency;
import model.strategy.PrioritizationStrategy;

public class EmergencyManager {
    private static EmergencyManager instancia;
    private PrioritizationStrategy strategy;
    private PriorityQueue<Emergency> ePriorityQueue;
    private List<Emergency> attendedEmergencies;
    Random random = new Random();

    private int numberEmergenciesAtt;
    private int totalAttentionTime;

    public EmergencyManager(){
        ePriorityQueue = new PriorityQueue<>();
        attendedEmergencies = new ArrayList<>();
        numberEmergenciesAtt = 0;
        totalAttentionTime = 0;
    }

    public void setStrategy(PrioritizationStrategy strategy){
        this.strategy = strategy;
    }

    public static EmergencyManager getInstancia(){
        if (instancia == null) {
            instancia = new EmergencyManager();
        }
        return instancia;
    }
    // Función para aregar una emergencia nueva
    public void addEmergency(Emergency emergency){
        int priority = strategy.prioritize(emergency);
        emergency.setPriority(priority);
        ePriorityQueue.add(emergency);
    }
    // Función para seleccionar una emergencia
    public Emergency peekNextEmergency(){
        return ePriorityQueue.peek(); // Obtiene la emergencia con mayor prioridad
    }

    //Ejecuta un hilo secundario para atender la emergencia y poder seguir usando el programa
    public void backgroundEmergency(Emergency emergency){
        Thread emergencyThread = new Thread(new Runnable(){

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
    public static void attendedEmergencie(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        }
    //Función para manejar o atender la siguiente emergencia, ordenadas en una "Queue" según su prioridad
    public Emergency handleNextEmergency(){
        Emergency nextEmergency = ePriorityQueue.poll();// Obtiene y elimina la emergencia con mayor prioridad
        if (nextEmergency != null) {
            nextEmergency.startAttention();
            attendedEmergencies.add(nextEmergency);
            // se llama al metodo para manejar la emergencia como una tarea secundaria
            backgroundEmergency(nextEmergency);

            nextEmergency.endAttention();
            System.out.println("Atendiendo emergencia: " + nextEmergency.getDescription());
            numberEmergenciesAtt++;
            totalAttentionTime += nextEmergency.getResponseTime();
        }else{
            System.out.println("No hay emergencias pendientes");
        }
        return nextEmergency;
    }
    //obtiene e imprime en consola todas las emergencias pendientes por atender
    public void printAllEmergencies(){
        //copia de la lista principal de "ePriorityQueue" para poder verse en listado
        PriorityQueue<Emergency> copyQueue = new PriorityQueue<>(ePriorityQueue);
        System.out.println("=== EMERGENCIAS PENDIENTES ===");
        while (!copyQueue.isEmpty()) {
            Emergency emergency = copyQueue.poll();
            System.out.println("-> "+emergency);
        }
    }
    // Muestra las estadisticas del dia
    public void showStatistics(){
        System.out.println("\n === ESTADISTICAS DEL DIA ===");
        System.out.println("Emergencias atendidas: " + numberEmergenciesAtt);
        System.out.println("TIEMPO: " + totalAttentionTime);
    }


}
