package images;

import controller.dailyRequest;
public class showMenu {

    public static Integer menu01(Integer option) {
        System.out.println("|===========================================================|");
        System.out.println("|=============SISTEMA DE GESTIÓN DE EMERGENCIAS=============|");
        System.out.println("|===========================================================|");
        System.out.println("|- 1. Registrar una nueva emergencia                        |");
        System.out.println("|- 2. Atender una emergencia                                |");
        System.out.println("|- 3. Recursos actuales                                     |");
        System.out.println("|- 4. Emergencais pendientes                                |");
        System.out.println("|- 5. Mostrar estadísticas del día                          |");
        System.out.println("|- 6. Finalizar jornada **                                  |");
        System.out.println("|===========================================================|");
        System.out.print("|- Seleccione una opcion: ");
        option = 0;
        return option;
    }

    public static Integer menu02(Integer option) {
        System.out.println("|===========================================================|");
        System.out.println("|=================REGISTRAR NUEVA EMERGENCIA================|");
        System.out.println("|===========================================================|");
        System.out.println("|- 1. Incendio                                              |");
        System.out.println("|- 2. Accidente Vehicular                                   |");
        System.out.println("|- 3. Robo                                                  |");
        System.out.println("|===========================================================|");
        System.out.print("|- Seleccione el tipo: ");
        option = 0;
        return option;
    }

    public static void menu03() {
        System.out.print("""
                |===========================================================|
                |=====================Recursos Actuales=====================|
                """);
        System.out.println("|===========================================================|");
        System.out.println("|-Botiquines: " + dailyRequest.firstAidKits.get(0));
        System.out.println("|-Ambulancias: " + dailyRequest.ambulances.get(0));
        System.out.println("|-Paramedicos: " + dailyRequest.firstAidKits.get(0));
        System.out.println("|-Litros de Agua: " + dailyRequest.litersOfWater.get(0));
        System.out.println("|-Carro de bomberos: " + dailyRequest.fireTrucks.get(0));
        System.out.println("|-Bomberos: " + dailyRequest.firstAidKits.get(0));
        System.out.println("|-Municion: " + dailyRequest.ammunition.get(0));
        System.out.println("|-Patrullas de policia: " + dailyRequest.patrols.get(0));
        System.out.println("|-Policias: " + dailyRequest.firstAidKits.get(0));
        System.out.println("|-Litros de Gasolina: " + dailyRequest.litersOfGasoline.get(0));
        System.out.println("|===========================================================|");
    }

    public static void serrMenu() {
        System.out.println(ConsoleColor.redText("|===========================================================|"));
        System.out.println(ConsoleColor.redText("|==========-Opción invalida, intentelo nuevamente.-=========|"));
        System.out.println(ConsoleColor.redText("|===========================================================|"));
    }

}
