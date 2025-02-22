package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import images.ConsoleColor;
import models.Emergency;
import utils.EmergencyLocation;


public class BackgroundEmergencie {

    private static List<BackgroundEmergencie> emergenciesInProcess = new ArrayList<>();
    private final Emergency emergency;
    private long timeStart;
    private int timeDuration;

    public BackgroundEmergencie(Emergency emergency) {
        this.emergency = emergency;
    }

    // Ejecuta un hilo secundario para atender la emergencia y poder seguir usando el programa
    public void backgroundEmergency() {
        BackgroundEmergencie bEmergencies = new BackgroundEmergencie(emergency);
        emergenciesInProcess.add(bEmergencies); // Agregar la emergencia a la lista
        Thread emergencyThread = new Thread(() -> {
            emergency.startAttention();
            bEmergencies.timeStart = System.currentTimeMillis();
            bEmergencies.attendedEmergencie();
            emergency.endAttention();
            System.out.println("\nLa emergencia: " + emergency.getDescription() + " ha sido atendida exitosamente");
            // Transformar de milisegundos a segundos
            long durationMillis = emergency.calculateAttentionTime();
            double durationSeconds = durationMillis / 1000.0;
            System.out.println("La emergencia ha sido atendida en: " + durationSeconds + " segundos");
        });
        emergencyThread.start();

        System.out.println("Continúa la ejecución");
    }

    public void attendedEmergencie() {
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

    public void printProgress() {
        long currentTime = System.currentTimeMillis();
        long lapsedTime = currentTime - timeStart;
        if (timeDuration > 0) {
            double percentageCompleted = ((double) lapsedTime / timeDuration) * 100;
            percentageCompleted = Math.min(percentageCompleted, 100); // Limitar el valor máximo a 100
            System.out.printf(ConsoleColor.blueText("Progreso actual de '%s': %.2f%%\n"), emergency.getType(), percentageCompleted);
            if (percentageCompleted >= 100) {
                synchronized (emergenciesInProcess) {
                    emergenciesInProcess.remove(this);
                }
                System.out.println(ConsoleColor.redText("ESTA EMERGENCIA YA HA SIDO ATENDIDA"));
            }
        } else {
            System.out.println("NO VALIDO");
        }
    }

    public static void printBar() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Seleccione una emergencia para ver el progreso (0 para salir):");
            synchronized (emergenciesInProcess) {
                for (int i = 0; i < emergenciesInProcess.size(); i++) {
                    System.out.printf("%d: %s\n", i + 1, emergenciesInProcess.get(i).emergency.getDescription());
                }
            }
            int opcion = scanner.nextInt();
            if (opcion == 0) {
                break;
            } else if (opcion > 0 && opcion <= emergenciesInProcess.size()) {
                synchronized (emergenciesInProcess) {
                    emergenciesInProcess.get(opcion - 1).printProgress();
                }
            } else {
                System.out.println("Opción no válida.");
            }
        }

    }
}
