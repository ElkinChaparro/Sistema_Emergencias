package controller;

import java.util.*;
import images.*;
import models.*;
import utils.*;

public class BackgroundEmergencie {
    static Scanner scanner = new Scanner(System.in);
    private static List<BackgroundEmergencie> emergenciesInProcess = new ArrayList<>();
    public static List<Integer> generalTime = new ArrayList<>();
    private final Emergency emergency;
    private long timeStart;
    private int timeDuration;

    // Constructor de la clase BackgroundEmergencie
    // Se inicializa la emergencia y se agrega a la lista de emergencias en proceso
    // Se inicializa el tiempo de inicio
    public BackgroundEmergencie(Emergency emergency) {
        this.emergency = emergency;
    }

    // Ejecuta un hilo secundario para atender la emergencia y poder seguir usando
    // el programa
    public void backgroundEmergency() {
        BackgroundEmergencie bEmergencies = new BackgroundEmergencie(emergency);
        emergenciesInProcess.add(bEmergencies); // Agregar la emergencia a la lista
        Thread emergencyThread = new Thread(() -> {
            emergency.startAttention();
            bEmergencies.timeStart = System.currentTimeMillis();
            bEmergencies.attendedEmergencie();
            emergency.endAttention();
            System.out.println(
                    ConsoleColor.redText("\n|===========================================================|"));
            System.out.println(
                    ConsoleColor.redText("|-")
                            + ConsoleColor.orangeText(
                                    "La emergencia \n|===========================================================|")
                            + emergency.getDescription()
                            + ConsoleColor.redText("\n|-") + ConsoleColor.orangeText("ha sido atendida exitosamente"));
            // Transformar de milisegundos a segundos para simular horas
            long durationMillis = emergency.calculateAttentionTime();
            int durationSeconds = (int) durationMillis / 1000;
            int durationMinutes = durationSeconds / 60;
            int remainingSeconds = durationSeconds - (durationMinutes * 60);
            // Mostrar el tiempo de atención en horas y minutos
            System.out.println(
                    ConsoleColor.orangeText("|-La emergencia ha sido atendida en: " + durationMinutes + " Horas y "
                            + remainingSeconds + " Minutos"));
            System.out.println(
                    ConsoleColor.redText("|===========================================================|"));
            System.out.println(
                    ConsoleColor.cyanText("|==================-")
                            + ConsoleColor.blueText("Continúa la ejecución")
                            + ConsoleColor.cyanText("-==================|"));
            System.out.println(
                    ConsoleColor.cyanText("|===========================================================|"));
        });
        emergencyThread.start();
    }

    // Método que se encarga de atender la emergencia, se calcula el tiempo de
    // atención dependiendo de la ubicación de la emergencia
    public void attendedEmergencie() {
        Random random = new Random();
        // Variables locales que almacenan la fórmula para el random del tiempo
        var time1 = random.nextInt((450000 - 300000) + 1) + 300000;
        var time2 = random.nextInt((290000 - 150000) + 1) + 150000;
        var time3 = random.nextInt((100000 - 50000) + 1) + 50000;
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

    // Método que se encarga de imprimir el progreso de la emergencia, se calcula el
    // tiempo transcurrido y se muestra el porcentaje de progreso
    public void printProgress() {
        long currentTime = System.currentTimeMillis();
        long lapsedTime = currentTime - timeStart;
        if (timeDuration > 0) {
            double percentageCompleted = ((double) lapsedTime / timeDuration) * 100;
            percentageCompleted = Math.min(percentageCompleted, 100); // Limitar el valor máximo a 100
            System.out.println(
                    ConsoleColor.orangeText("|===========================================================|"));
            System.out.printf(
                    ConsoleColor.orangeText("|-") + ConsoleColor.redText("Progreso actual del '%s': %.2f%%\n"),
                    emergency.getType(),
                    percentageCompleted);
            System.out.println(
                    ConsoleColor.orangeText("|===========================================================|"));
            if (percentageCompleted >= 100) {
                synchronized (emergenciesInProcess) {
                    emergenciesInProcess.remove(this);
                }
                System.out.println(
                        ConsoleColor.greenText("|===========================================================|"));
                System.out.println(
                        ConsoleColor.greenText("|===========-ESTA EMERGENCIA YA HA SIDO ATENDIDA-===========|"));
                System.out.println(
                        ConsoleColor.greenText("|===========================================================|"));
            }
        } else {
            showMenu.serrMenu();
        }
    }

    // Método que se encarga de imprimir el progreso de la emergencia, se calcula el
    // tiempo transcurrido y se muestra el porcentaje de progreso
    public static void printBar() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        if (emergenciesInProcess.isEmpty()) {
            System.out.println(
                    ConsoleColor.orangeText("|===========================================================|"));
            System.out
                    .println(ConsoleColor.orangeText("|===========-NO HAY EMERGENCIAS SIENDO ATENDIDAS-===========|"));
            System.out.println(
                    ConsoleColor.orangeText("|===========================================================|"));
            showMenu.pressEnter(scanner);
        } else {
            while (true) {
                System.out.println(
                        ConsoleColor.cyanText("|===========================================================|"));
                System.out.println(ConsoleColor.cyanText("|-")
                        + ConsoleColor.blueText("Seleccione una emergencia para ver el progreso")
                        + ConsoleColor.cyanText("            |"));
                System.out.println(
                        ConsoleColor.cyanText("|===========================================================|"));
                synchronized (emergenciesInProcess) {
                    for (int i = 0; i < emergenciesInProcess.size(); i++) {
                        System.out.printf(ConsoleColor.cyanText("|-> ") + "%d: %s\n", i + 1,
                                emergenciesInProcess.get(i).emergency.getDescription());
                    }
                }
                System.out.println(
                        ConsoleColor.cyanText("|===========================================================|"));
                System.out.println(ConsoleColor.cyanText("|-") + ConsoleColor.blueText("0 para salir")
                        + ConsoleColor.cyanText("                                              |"));
                System.out.println(
                        ConsoleColor.cyanText("|===========================================================|"));
                System.out.print(ConsoleColor.cyanText("|==-"));
                try {
                    int opcion = scanner.nextInt();
                    if (opcion == 0) {
                        System.out.println(
                                ConsoleColor.cyanText("|===========================================================|"));
                        System.out.println(ConsoleColor.cyanText("|-")
                                + ConsoleColor.blueText("Saliendo del progreso de la emergencia")
                                + ConsoleColor.cyanText("            |"));
                        System.out.println(
                                ConsoleColor.cyanText("|===========================================================|"));
                        break;
                    } else if (opcion > 0 && opcion <= emergenciesInProcess.size()) {
                        synchronized (emergenciesInProcess) {
                            emergenciesInProcess.get(opcion - 1).printProgress();
                        }
                    } else
                        throw new NullPointerException();
                } // Se captura la excepción en caso de que la opción no sea un número
                catch (NumberFormatException e) {
                    showMenu.serrMenu();
                    printBar();
                } // Se captura la excepción en caso de que la opción sea nula
                catch (NullPointerException e) {
                    showMenu.serrMenu();
                    printBar();
                } // Se captura la exepcion en caso de que ocurra un error inesperado
                catch (ExceptionInInitializerError e) {
                    showMenu.serrMenu();
                    printBar();
                }
            }
        }
    }
}
