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
    //Función para manejar o atender la siguiente emergencia, ordenadas en una "Queue" según su prioridad
    public Emergency handleNextEmergency(){
        Emergency nextEmergency = ePriorityQueue.poll();// Obtiene y elimina la emergencia con mayor prioridad
        if (nextEmergency != null) {
            nextEmergency.startAttention();
            attendedEmergencies.add(nextEmergency);
            // try para manejar el tiempo de atención de la emergencia, el tiempo se define con el metodo "random"
            try {
                Thread.sleep(random.nextInt(5000,8000));
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

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
