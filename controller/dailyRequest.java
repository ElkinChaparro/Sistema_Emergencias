package controller;

import java.util.*;

import images.ConsoleColor;
import images.showMenu;

public class dailyRequest {
        static Scanner scGame = new Scanner(System.in);
        // Se crean las listas para almacenar los suministros diarios
        public static List<Integer> firstAidKits = new ArrayList<>();
        public static List<Integer> ambulances = new ArrayList<>();
        public static List<Integer> paramedics = new ArrayList<>();
        public static List<Integer> litersOfWater = new ArrayList<>();
        public static List<Integer> fireTrucks = new ArrayList<>();
        public static List<Integer> firefighters = new ArrayList<>();
        public static List<Integer> ammunition = new ArrayList<>();
        public static List<Integer> patrols = new ArrayList<>();
        public static List<Integer> police = new ArrayList<>();
        public static List<Integer> litersOfGasoline = new ArrayList<>();

        public static void Application() throws InterruptedException {
                // Se solicitan los suministros diarios
                iniciarListas();
                solfirstAidKits();
                solambulances();
                solparamedics();
                solLitersOfWater();
                solfireTrucks();
                solfirefighters();
                solammunition();
                solpatrols();
                solpolice();
                sollitersOfGasoline();
                System.out.println(
                                ConsoleColor.cyanText(
                                                "|===========================================================|"));
                showMenu.printLoadingBar();
                System.out.println(ConsoleColor.greenText("""
                                |===========================================================|
                                |==========-Suministros registrados correctamente-==========|
                                |===========================================================|"""));
        }

        public static void iniciarListas() {
                int operator = 0;
                // Se inician las listas para poder añadir recursos
                firstAidKits.add(operator);
                ambulances.add(operator);
                paramedics.add(operator);
                litersOfWater.add(operator);
                fireTrucks.add(operator);
                firefighters.add(operator);
                ammunition.add(operator);
                patrols.add(operator);
                police.add(operator);
                litersOfGasoline.add(operator);
        }

        public static void añadirRecursos() {
                showMenu.añadirRecursos(null);
                try {
                        var option = Integer.parseInt(scGame.nextLine());
                        switch (option) {
                                case 1:
                                        solfirstAidKits();
                                        break;
                                case 2:
                                        solambulances();
                                        break;
                                case 3:
                                        solparamedics();
                                        break;
                                case 4:
                                        solLitersOfWater();
                                        break;
                                case 5:
                                        solfireTrucks();
                                        break;
                                case 6:
                                        solfirefighters();
                                        break;
                                case 7:
                                        solammunition();
                                        break;
                                case 8:
                                        solpatrols();
                                        break;
                                case 9:
                                        solpolice();
                                        break;
                                case 10:
                                        sollitersOfGasoline();
                                        break;
                                default:
                                        break;
                        }
                } catch (NumberFormatException e) {
                        showMenu.serrMenu();
                        añadirRecursos();
                } catch (NullPointerException e) {
                        showMenu.serrMenu();
                        añadirRecursos();
                } catch (Exception e) {
                        showMenu.serrMenu();
                        añadirRecursos();
                }
        }

        public static void solfirstAidKits() {
                var operator = firstAidKits.get(0);
                if (firstAidKits.get(0) == 0) {
                        System.out.println(
                                        ConsoleColor.cyanText(
                                                        "|===========================================================|"));
                        System.out.println(ConsoleColor.cyanText("|-")
                                        + ConsoleColor.redText(
                                                        "Nota:" + ConsoleColor.blueText(
                                                                        " El promedio minimo de botiquines solicitados        |\n|-por dia es de 40"))
                                        + ConsoleColor.cyanText("                                          |"));
                        System.out.println(
                                        ConsoleColor.cyanText(
                                                        "|===========================================================|"));
                } else {
                        System.out.println(
                                        ConsoleColor.cyanText(
                                                        "|===========================================================|"));
                        System.out.println(ConsoleColor.cyanText("|-")
                                        + ConsoleColor.redText(
                                                        "Nota: " + ConsoleColor.blueText(
                                                                        "La cantidad de botiquines actuales es de: "))
                                        + firstAidKits.get(0));
                }
                System.out.println(
                                ConsoleColor.cyanText("|===========================================================|"));
                System.out.println(ConsoleColor.cyanText("|-")
                                + ConsoleColor.blueText("Ingrese la cantidad de botiquines de primeros auxilios")
                                + ConsoleColor.cyanText("    |"));
                System.out.print(ConsoleColor.cyanText("|==-"));
                try {
                        int option = Integer.parseInt(scGame.nextLine());
                        int result = operator + option;
                        firstAidKits.clear();
                        firstAidKits.add(result);
                } catch (NumberFormatException e) {
                        showMenu.serrMenu();
                        solfirstAidKits();
                } catch (NullPointerException e) {
                        showMenu.serrMenu();
                        solfirstAidKits();
                }
        }

        private static void solambulances() {
                var operator = ambulances.get(0);
                if (ambulances.get(0) == 0) {
                        System.out.println(
                                        ConsoleColor.cyanText(
                                                        "|===========================================================|"));
                        System.out.println(ConsoleColor.cyanText("|-")
                                        + ConsoleColor.redText(
                                                        "Nota:" + ConsoleColor.blueText(
                                                                        " El promedio minimo de ambulancias solicitadas       |\n|-por dia es de 10"))
                                        + ConsoleColor.cyanText("                                          |"));
                        System.out.println(
                                        ConsoleColor.cyanText(
                                                        "|===========================================================|"));
                } else {
                        System.out.println(
                                        ConsoleColor.cyanText(
                                                        "|===========================================================|"));
                        System.out.println(ConsoleColor.cyanText("|-")
                                        + ConsoleColor.redText(
                                                        "Nota: " + ConsoleColor.blueText(
                                                                        "La cantidad de ambulancias actual es:"))
                                        + ambulances.get(0));
                }
                System.out.println(
                                ConsoleColor.cyanText("|===========================================================|"));
                System.out.println(ConsoleColor.cyanText("|-")
                                + ConsoleColor.blueText("Ingrese la cantidad de ambulancias")
                                + ConsoleColor.cyanText("                        |"));
                System.out.print(ConsoleColor.cyanText("|==-"));
                try {
                        int option = Integer.parseInt(scGame.nextLine());
                        int result = operator + option;
                        ambulances.clear();
                        ambulances.add(result);
                } catch (NumberFormatException e) {
                        showMenu.serrMenu();
                        solambulances();
                } catch (NullPointerException e) {
                        showMenu.serrMenu();
                        solambulances();
                }
        }

        private static void solparamedics() {
                var operator = paramedics.get(0);
                if (paramedics.get(0) == 0) {
                        System.out.println(
                                        ConsoleColor.cyanText(
                                                        "|===========================================================|"));
                        System.out.println(ConsoleColor.cyanText("|-")
                                        + ConsoleColor.redText(
                                                        "Nota:" + ConsoleColor.blueText(
                                                                        " El promedio minimo de paramedicos solicitados       |\n|-por dia es de 20"))
                                        + ConsoleColor.cyanText("                                          |"));
                        System.out.println(
                                        ConsoleColor.cyanText(
                                                        "|===========================================================|"));
                } else {
                        System.out.println(
                                        ConsoleColor.cyanText(
                                                        "|===========================================================|"));
                        System.out.println(ConsoleColor.cyanText("|-")
                                        + ConsoleColor.redText(
                                                        "Nota: " + ConsoleColor
                                                                        .blueText("La cantidad de paramedicos actual es: "))
                                        + paramedics.get(0));
                }
                System.out.println(
                                ConsoleColor.cyanText("|===========================================================|"));
                System.out.println(ConsoleColor.cyanText("|-")
                                + ConsoleColor.blueText("Ingrese la cantidad de paramedicos")
                                + ConsoleColor.cyanText("                        |"));
                System.out.print(ConsoleColor.cyanText("|==-"));
                try {
                        var option = Integer.parseInt(scGame.nextLine());
                        var result = operator + option;
                        paramedics.clear();
                        paramedics.add(result);
                } catch (NumberFormatException e) {
                        showMenu.serrMenu();
                        solparamedics();
                } catch (NullPointerException e) {
                        showMenu.serrMenu();
                        solparamedics();
                }
        }

        private static void solLitersOfWater() {
                var operator = litersOfWater.get(0);
                if (litersOfWater.get(0) == 0) {
                        System.out.println(
                                        ConsoleColor.cyanText(
                                                        "|===========================================================|"));
                        System.out.println(ConsoleColor.cyanText("|-")
                                        + ConsoleColor.redText(
                                                        "Nota:" + ConsoleColor.blueText(
                                                                        " El promedio minimo de litros de agua solicitados    |\n|-por dia es de 6000"))
                                        + ConsoleColor.cyanText("                                        |"));
                        System.out.println(
                                        ConsoleColor.cyanText(
                                                        "|===========================================================|"));
                } else {
                        System.out.println(
                                        ConsoleColor.cyanText(
                                                        "|===========================================================|"));
                        System.out.println(ConsoleColor.cyanText("|-")
                                        + ConsoleColor.redText(
                                                        "Nota: " + ConsoleColor.blueText(
                                                                        "La cantidad de litros de agua actual es: "))
                                        + litersOfWater.get(0));
                }
                System.out.println(
                                ConsoleColor.cyanText("|===========================================================|"));
                System.out.println(ConsoleColor.cyanText("|-")
                                + ConsoleColor.blueText("Ingrese la cantidad de litros de agua")
                                + ConsoleColor.cyanText("                     |"));
                System.out.print(ConsoleColor.cyanText("|==-"));
                try {
                        var option = Integer.parseInt(scGame.nextLine());
                        var result = operator + option;
                        litersOfWater.clear();
                        litersOfWater.add(result);
                } catch (NumberFormatException e) {
                        showMenu.serrMenu();
                        solLitersOfWater();
                } catch (NullPointerException e) {
                        showMenu.serrMenu();
                        solLitersOfWater();
                }
        }

        private static void solfireTrucks() {
                var operator = fireTrucks.get(0);
                if (fireTrucks.get(0) == 0) {
                        System.out.println(
                                        ConsoleColor.cyanText(
                                                        "|===========================================================|"));
                        System.out.println(ConsoleColor.cyanText("|-")
                                        + ConsoleColor.redText(
                                                        "Nota:" + ConsoleColor.blueText(
                                                                        " El promedio minimo de carros de bomberos solicitados|\n|-por dia es de 10"))
                                        + ConsoleColor.cyanText("                                          |"));
                        System.out.println(
                                        ConsoleColor.cyanText(
                                                        "|===========================================================|"));
                } else {
                        System.out.println(
                                        ConsoleColor.cyanText(
                                                        "|===========================================================|"));
                        System.out.println(ConsoleColor.cyanText("|-")
                                        + ConsoleColor.redText(
                                                        "Nota: " + ConsoleColor.blueText(
                                                                        "La cantidad de carros de bomberos actual es: "))
                                        + fireTrucks.get(0));
                }
                System.out.println(
                                ConsoleColor.cyanText("|===========================================================|"));
                System.out.println(ConsoleColor.cyanText("|-")
                                + ConsoleColor.blueText("Ingrese la cantidad de carros de bomberos")
                                + ConsoleColor.cyanText("                 |"));
                System.out.print(ConsoleColor.cyanText("|==-"));
                try {
                        var option = Integer.parseInt(scGame.nextLine());
                        var result = operator + option;
                        fireTrucks.clear();
                        fireTrucks.add(result);
                } catch (NumberFormatException e) {
                        showMenu.serrMenu();
                        solfireTrucks();
                } catch (NullPointerException e) {
                        showMenu.serrMenu();
                        solfireTrucks();
                }
        }

        private static void solfirefighters() {
                var operator = firefighters.get(0);
                if (firefighters.get(0) == 0) {
                        System.out.println(
                                        ConsoleColor.cyanText(
                                                        "|===========================================================|"));
                        System.out.println(ConsoleColor.cyanText("|-")
                                        + ConsoleColor.redText(
                                                        "Nota:" + ConsoleColor.blueText(
                                                                        " El promedio minimo de bomberos solicitados          |\n|-por dia es de 20"))
                                        + ConsoleColor.cyanText("                                          |"));
                        System.out.println(
                                        ConsoleColor.cyanText(
                                                        "|===========================================================|"));
                } else {
                        System.out.println(
                                        ConsoleColor.cyanText(
                                                        "|===========================================================|"));
                        System.out.println(ConsoleColor.cyanText("|-")
                                        + ConsoleColor.redText(
                                                        "Nota: " + ConsoleColor.blueText(
                                                                        "La cantidad de bomberos actual es: "))
                                        + firefighters.get(0));
                }
                System.out.println(
                                ConsoleColor.cyanText("|===========================================================|"));
                System.out.println(ConsoleColor.cyanText("|-")
                                + ConsoleColor.blueText("Ingrese la cantidad de bomberos")
                                + ConsoleColor.cyanText("                           |"));
                System.out.print(ConsoleColor.cyanText("|==-"));
                try {
                        var option = Integer.parseInt(scGame.nextLine());
                        var result = operator + option;
                        firefighters.clear();
                        firefighters.add(result);
                } catch (NumberFormatException e) {
                        showMenu.serrMenu();
                        solfirefighters();
                } catch (NullPointerException e) {
                        showMenu.serrMenu();
                        solfirefighters();
                }
        }

        private static void solammunition() {
                var operator = ammunition.get(0);
                if (ammunition.get(0) == 0) {
                        System.out.println(
                                        ConsoleColor.cyanText(
                                                        "|===========================================================|"));
                        System.out.println(ConsoleColor.cyanText("|-")
                                        + ConsoleColor.redText(
                                                        "Nota:" + ConsoleColor.blueText(
                                                                        " El promedio minimo de municiones solicitadas        |\n|-por dia es de 1000"))
                                        + ConsoleColor.cyanText("                                        |"));
                        System.out.println(
                                        ConsoleColor.cyanText(
                                                        "|===========================================================|"));
                } else {
                        System.out.println(
                                        ConsoleColor.cyanText(
                                                        "|===========================================================|"));
                        System.out.println(ConsoleColor.cyanText("|-")
                                        + ConsoleColor.redText(
                                                        "Nota: " + ConsoleColor.blueText(
                                                                        "La cantidad de municiones actual es: "))
                                        + ammunition.get(0));
                }
                System.out.println(
                                ConsoleColor.cyanText("|===========================================================|"));
                System.out.println(ConsoleColor.cyanText("|-")
                                + ConsoleColor.blueText("Ingrese la cantidad de municiones")
                                + ConsoleColor.cyanText("                         |"));
                System.out.print(ConsoleColor.cyanText("|==-"));
                try {
                        var option = Integer.parseInt(scGame.nextLine());
                        var result = operator + option;
                        ammunition.clear();
                        ammunition.add(result);
                } catch (NumberFormatException e) {
                        showMenu.serrMenu();
                        solammunition();
                } catch (NullPointerException e) {
                        showMenu.serrMenu();
                        solammunition();
                }
        }

        private static void solpatrols() {
                var operator = patrols.get(0);
                if (patrols.get(0) == 0) {
                        System.out.println(
                                        ConsoleColor.cyanText(
                                                        "|===========================================================|"));
                        System.out.println(ConsoleColor.cyanText("|-")
                                        + ConsoleColor.redText(
                                                        "Nota:" + ConsoleColor.blueText(
                                                                        " El promedio minimo de patrullas solicitadas         |\n|-por dia es de 10"))
                                        + ConsoleColor.cyanText("                                          |"));
                        System.out.println(
                                        ConsoleColor.cyanText(
                                                        "|===========================================================|"));
                } else {
                        System.out.println(
                                        ConsoleColor.cyanText(
                                                        "|===========================================================|"));
                        System.out.println(ConsoleColor.cyanText("|-")
                                        + ConsoleColor.redText(
                                                        "Nota: " + ConsoleColor.blueText(
                                                                        "La cantidad de patrullas actual es: "))
                                        + patrols.get(0));
                }
                System.out.println(
                                ConsoleColor.cyanText("|===========================================================|"));
                System.out.println(ConsoleColor.cyanText("|-")
                                + ConsoleColor.blueText("Ingrese la cantidad de patrullas")
                                + ConsoleColor.cyanText("                          |"));
                System.out.print(ConsoleColor.cyanText("|==-"));
                try {
                        var option = Integer.parseInt(scGame.nextLine());
                        var result = operator + option;
                        patrols.clear();
                        patrols.add(result);
                } catch (NumberFormatException e) {
                        showMenu.serrMenu();
                        solpatrols();
                } catch (NullPointerException e) {
                        showMenu.serrMenu();
                        solpatrols();
                }
        }

        private static void solpolice() {
                var operator = police.get(0);
                if (police.get(0) == 0) {
                        System.out.println(
                                        ConsoleColor.cyanText(
                                                        "|===========================================================|"));
                        System.out.println(ConsoleColor.cyanText("|-")
                                        + ConsoleColor.redText(
                                                        "Nota:" + ConsoleColor.blueText(
                                                                        " El promedio minimo de policias solicitados          |\n|-por dia es de 20"))
                                        + ConsoleColor.cyanText("                                          |"));
                        System.out.println(
                                        ConsoleColor.cyanText(
                                                        "|===========================================================|"));
                } else {
                        System.out.println(
                                        ConsoleColor.cyanText(
                                                        "|===========================================================|"));
                        System.out.println(ConsoleColor.cyanText("|-")
                                        + ConsoleColor.redText(
                                                        "Nota: " + ConsoleColor.blueText(
                                                                        "La cantidad de policias actual es: "))
                                        + police.get(0));
                }
                System.out.println(
                                ConsoleColor.cyanText("|===========================================================|"));
                System.out.println(ConsoleColor.cyanText("|-")
                                + ConsoleColor.blueText("Ingrese la cantidad de policias")
                                + ConsoleColor.cyanText("                           |"));
                System.out.print(ConsoleColor.cyanText("|==-"));
                try {
                        var option = Integer.parseInt(scGame.nextLine());
                        var result = operator + option;
                        police.clear();
                        police.add(result);
                } catch (NumberFormatException e) {
                        showMenu.serrMenu();
                        solpolice();
                } catch (NullPointerException e) {
                        showMenu.serrMenu();
                        solpolice();
                }
        }

        private static void sollitersOfGasoline() {
                var operator = litersOfGasoline.get(0);
                if (litersOfGasoline.get(0) == 0) {
                        System.out.println(
                                        ConsoleColor.cyanText(
                                                        "|===========================================================|"));
                        System.out.println(ConsoleColor.cyanText("|-")
                                        + ConsoleColor.redText(
                                                        "Nota:" + ConsoleColor.blueText(
                                                                        " El promedio minimo de Gal de gasolina solicitados   |\n|-por dia es de 15000"))
                                        + ConsoleColor.cyanText("                                       |"));
                        System.out.println(
                                        ConsoleColor.cyanText(
                                                        "|===========================================================|"));
                } else {
                        System.out.println(
                                        ConsoleColor.cyanText(
                                                        "|===========================================================|"));
                        System.out.println(ConsoleColor.cyanText("|-")
                                        + ConsoleColor.redText("Nota: " + ConsoleColor
                                                        .blueText("La cantidad de galones de gasolina actual es: "))
                                        + litersOfGasoline.get(0));
                }
                System.out.println(
                                ConsoleColor.cyanText("|===========================================================|"));
                System.out.println(ConsoleColor.cyanText("|-")
                                + ConsoleColor.blueText("Ingrese la cantidad de galones de gasolina")
                                + ConsoleColor.cyanText("                |"));
                System.out.print(ConsoleColor.cyanText("|==-"));
                try {
                        var option = Integer.parseInt(scGame.nextLine());
                        var result = operator + option;
                        litersOfGasoline.clear();
                        litersOfGasoline.add(result);
                } catch (NumberFormatException e) {
                        showMenu.serrMenu();
                        sollitersOfGasoline();
                } catch (NullPointerException e) {
                        showMenu.serrMenu();
                        sollitersOfGasoline();
                }
        }

        public static void currenResources(Scanner scanner) throws InterruptedException {
                System.out.println(
                                ConsoleColor.cyanText("|===========================================================|"));
                System.out.println(ConsoleColor.cyanText("|====================-")
                                + ConsoleColor.blueText("RECURSOS ACTUALES")
                                + ConsoleColor.cyanText("-====================|"));
                showMenu.menuResources();
                System.out
                                .println(ConsoleColor.cyanText(
                                                "|===========================================================|"));
                System.out.println(ConsoleColor.cyanText("|======-")
                                + ConsoleColor.blueText("¿Desea agregar mas recursos al sistema? |S|N| ")
                                + ConsoleColor.cyanText("-=====|"));
                System.out
                                .println(ConsoleColor.cyanText(
                                                "|===========================================================|"));
                System.out.print(ConsoleColor.cyanText("|==-"));
                try {
                        var option = String.format(scanner.nextLine());
                        if (option.equalsIgnoreCase("s")) {
                                añadirRecursos();
                        } else if (option.equalsIgnoreCase("n")) {
                                System.out.println(
                                                ConsoleColor.orangeText(
                                                                "|===========================================================|"));
                                System.out.println(
                                                ConsoleColor.orangeText(
                                                                "|=============-No se registran nuevos recursos.-============|"));
                                System.out.println(
                                                ConsoleColor.orangeText(
                                                                "|===========================================================|"));
                        }
                } catch (NumberFormatException e) {
                        System.out
                                        .println(ConsoleColor.redText(
                                                        "|===========================================================|"));
                        System.out
                                        .println(ConsoleColor.redText(
                                                        "|======-Opción no válida. Por favor, ingrese |S| o |N|-=====|"));
                        System.out
                                        .println(ConsoleColor.redText(
                                                        "|===========================================================|"));
                        currenResources(scanner);
                } catch (NullPointerException e) {
                        showMenu.serrMenu();
                        currenResources(scanner);
                } catch (Exception e) {
                        System.out.println(
                                        ConsoleColor.orangeText(
                                                        "|===========================================================|"));
                        System.out.println(
                                        ConsoleColor.orangeText(
                                                        "|===============-Ocurrió un error inesperado.-==============|"));
                        System.out.println(
                                        ConsoleColor.orangeText(
                                                        "|===========================================================|"));
                }
        }
}
