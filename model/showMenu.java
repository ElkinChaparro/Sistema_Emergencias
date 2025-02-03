package model;

public class showMenu {

    public static Integer menu01(Integer option) {
        System.out.println("\n=== SISTEMA DE GESTIÓN DE EMERGENCIAS ===");
        System.out.println("1. Registrar una nueva emergencia");
        System.out.println("2. Atender una emergencia");
        System.out.println("3. Recursos actuales **");
        System.out.println("4. Emergencais pendientes");
        System.out.println("5. Mostrar estadísticas del día");
        System.out.println("6. Finalizar jornada **");
        option = 0;

        return option;
    }

    public static Integer menu02(Integer option) {
        System.out.println("\n=== REGISTRAR NUEVA EMERGENCIA ===");
        System.out.println("1. Incendio");
        System.out.println("2. Accidente Vehicular");
        System.out.println("3. Robo");
        System.out.print("Seleccione el tipo: ");
        option = 0;
        return option;
    }

    public static void serrMenu(){
        System.out.println("Opción invalida, intentelo nuevamente.");
    }

}
