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
                showMenu.printLoadingBar();
                System.out.println(ConsoleColor.greenText("""
                                |===========================================================|
                                |==========-Suministros registrados correctamente-==========|
                                |===========================================================|"""));
        }

        public static void iniciarListas() {
                int operator = 0;
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
        }

        public static void solfirstAidKits() {
                var operator = firstAidKits.get(0);
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
}
