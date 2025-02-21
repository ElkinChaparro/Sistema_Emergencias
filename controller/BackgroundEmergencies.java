package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import models.Emergency;
import utils.EmergencyLocation;


public class BackgroundEmergencies {

    private static List<BackgroundEmergencies> emergenciesInProcess = new ArrayList<>();
    private final Emergency emergency;
    private static Long timeStart;
    private static int timeDuration;

    public BackgroundEmergencies(Emergency emergency) {
        this.emergency = emergency;
    }

    // Ejecuta un hilo secundario para atender la emergencia y poder seguir usando el programa
    public void backgroundEmergency(Emergency nextEmergency) {
        BackgroundEmergencies bEmergencies = new BackgroundEmergencies(nextEmergency);
        emergenciesInProcess.add(bEmergencies); // Agregar la emergencia a la lista
        Thread emergencyThread = new Thread(() -> {
            nextEmergency.startAttention();
            timeStart = System.currentTimeMillis();
            bEmergencies.attendedEmergencie(nextEmergency);
            nextEmergency.endAttention();
            System.out.println("\nLa emergencia: " + nextEmergency.getDescription() + " ha sido atendida exitosamente");
            // Transformar de milisegundos a segundos
            long durationMillis = nextEmergency.calculateAttentionTime();
            double durationSeconds = durationMillis / 1000.0;
            System.out.println("La emergencia ha sido atendida en: " + durationSeconds + " segundos");
        });
        emergencyThread.start();

        System.out.println("Continúa la ejecución");
    }

    public void attendedEmergencie(Emergency emergency) {
        Random random = new Random();
        // Variables locales que almacenan la fórmula para el random del tiempo
        var time1 = random.nextInt((45000 - 30000) + 1) + 30000;
        var time2 = random.nextInt((29000 - 15000) + 1) + 15000;
        var time3 = random.nextInt((10000 - 5000) + 1) + 5000;
        try {
            if (emergency.getLocation().equals(EmergencyLocation.ZONA_SUR)
                    || emergency.getLocation().equals(EmergencyLocation.ZONA_NORTE)) {
                timeDuration = time1;
                Thread.sleep(time1);
            } else if (emergency.getLocation().equals(EmergencyLocation.ZONA_OCCIDENTE)
                    || emergency.getLocation().equals(EmergencyLocation.ZONA_ORIENTE)) {
                timeDuration = time2;
                Thread.sleep(time2);
            } else {
                timeDuration = time3;
                Thread.sleep(time3);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void progressEmergency(Emergency emergency) {
        BackgroundEmergencies bEmergencies = new BackgroundEmergencies(emergency);
        Thread task = new Thread(() -> {
            try {
                Thread.sleep(timeDuration);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        task.start();

        while (task.isAlive()) {
            bEmergencies.printProgress();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("COMPLETADO");
    }

    public void printProgress() {
        long currentTime = System.currentTimeMillis();
        Long lapsedTime = currentTime - timeStart;
        if (timeDuration > 0) {
            double percentageCompleted = ((double) lapsedTime / timeDuration) * 100;
            percentageCompleted = Math.min(percentageCompleted, 100); // Limita el valor maximo del porcentaje a 100
            System.out.printf("Progreso actual: %.2f%%\n", percentageCompleted);
            if (percentageCompleted >= 100) {
                synchronized(emergenciesInProcess){
                    emergenciesInProcess.remove(this);
                }
                System.out.println("ESTA EMERGENCIA YA HA SIDO ATENDIDA");
            }
        } else {
            System.out.println("NO VALIDO");
        }
    }

    public static void printBar() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Seleccione una emergencia para ver el progreso (0 para salir):");
            synchronized(emergenciesInProcess){
                for (int i = 0; i < emergenciesInProcess.size(); i++) {
                    System.out.printf("%d: %s\n", i + 1, emergenciesInProcess.get(i).emergency.getDescription());
                }
            }
            int opcion = scanner.nextInt();
            if (opcion == 0) {
                break;
            } else if (opcion > 0 && opcion <= emergenciesInProcess.size()) {
                emergenciesInProcess.get(opcion - 1).printProgress();
            } else {
                System.out.println("Opción no válida.");
            }
        }

        System.out.println("Programa terminado.");
    }
}
