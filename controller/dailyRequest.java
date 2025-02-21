package controller;

import java.util.*;

import images.ConsoleColor;
import images.showMenu;

public class dailyRequest {
        static Scanner scGame = new Scanner(System.in);
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

        public static void Application() {
                System.out.println(ConsoleColor.greenText("""
                                |===========================================================|
                                |======-Bienvenido al sistema de suministros diarios-=======|
                                |===========================================================|
                                |=-Por favor, ingrese la cantidad de suministros            |
                                |=-con los que cuenta el dia de hoy.                        |"""));
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
                System.out.println(ConsoleColor.greenText("""
                                |===========================================================|
                                |==========-Suministros registrados correctamente-==========|
                                |===========================================================|"""));
        }

        public static void solfirstAidKits() {
                System.out.print(ConsoleColor.greenText("""
                                |===========================================================|
                                |-Con cuantos botiquines contamos el dia de hoy?            |
                                |==-"""));
                try {
                        var option = Integer.parseInt(scGame.nextLine());
                        firstAidKits.add(option);
                } catch (NumberFormatException e) {
                        showMenu.serrMenu();
                        solfirstAidKits();
                } catch (NullPointerException e) {
                        showMenu.serrMenu();
                        solfirstAidKits();
                }
        }

        private static void solambulances() {
                System.out.print(ConsoleColor.greenText("""
                                |===========================================================|
                                |-Con cuantas ambulancias contamos el dia de hoy?           |
                                |==-"""));
                try {
                        var option = Integer.parseInt(scGame.nextLine());
                        ambulances.add(option);
                } catch (NumberFormatException e) {
                        showMenu.serrMenu();
                        solambulances();
                } catch (NullPointerException e) {
                        showMenu.serrMenu();
                        solambulances();
                }
        }

        private static void solparamedics() {
                System.out.print(ConsoleColor.greenText("""
                                |===========================================================|
                                |-Con cuantos paramedicos contamos el dia de hoy?           |
                                |==-"""));
                try {
                        var option = Integer.parseInt(scGame.nextLine());
                        paramedics.add(option);
                } catch (NumberFormatException e) {
                        showMenu.serrMenu();
                        solparamedics();
                } catch (NullPointerException e) {
                        showMenu.serrMenu();
                        solparamedics();
                }
        }

        private static void solLitersOfWater() {
                System.out.print(ConsoleColor.greenText("""
                                |===========================================================|
                                |-Con cuantos Litros de agua contamos el dia de hoy?        |
                                |==-"""));
                try {
                        var option = Integer.parseInt(scGame.nextLine());
                        litersOfWater.add(option);
                } catch (NumberFormatException e) {
                        showMenu.serrMenu();
                        solLitersOfWater();
                } catch (NullPointerException e) {
                        showMenu.serrMenu();
                        solLitersOfWater();
                }
        }

        private static void solfireTrucks() {
                System.out.print(ConsoleColor.greenText("""
                                |===========================================================|
                                |-Con cuantos carros de bomberos contamos el dia de hoy?    |
                                |==-"""));
                try {
                        var option = Integer.parseInt(scGame.nextLine());
                        fireTrucks.add(option);
                } catch (NumberFormatException e) {
                        showMenu.serrMenu();
                        solfireTrucks();
                } catch (NullPointerException e) {
                        showMenu.serrMenu();
                        solfireTrucks();
                }
        }

        private static void solfirefighters() {
                System.out.print(ConsoleColor.greenText("""
                                |===========================================================|
                                |-Con cuantos bomberos contamos el dia de hoy?              |
                                |==-"""));
                try {
                        var option = Integer.parseInt(scGame.nextLine());
                        firefighters.add(option);
                } catch (NumberFormatException e) {
                        showMenu.serrMenu();
                        solfirefighters();
                } catch (NullPointerException e) {
                        showMenu.serrMenu();
                        solfirefighters();
                }
        }

        private static void solammunition() {
                System.out.print(ConsoleColor.greenText("""
                                |===========================================================|
                                |-Con cuantas municiones contamos el dia de hoy?            |
                                |==-"""));
                try {
                        var option = Integer.parseInt(scGame.nextLine());
                        ammunition.add(option);
                } catch (NumberFormatException e) {
                        showMenu.serrMenu();
                        solammunition();
                } catch (NullPointerException e) {
                        showMenu.serrMenu();
                        solammunition();
                }
        }

        private static void solpatrols() {
                System.out.print(ConsoleColor.greenText("""
                                |===========================================================|
                                |-Con cuantas patrullas contamos el dia de hoy?             |
                                |==-"""));
                try {
                        var option = Integer.parseInt(scGame.nextLine());
                        patrols.add(option);
                } catch (NumberFormatException e) {
                        showMenu.serrMenu();
                        solpatrols();
                } catch (NullPointerException e) {
                        showMenu.serrMenu();
                        solpatrols();
                }
        }

        private static void solpolice() {
                System.out.print(ConsoleColor.greenText("""
                                |===========================================================|
                                |-Con cuantos policias contamos el dia de hoy?              |
                                |==-"""));
                try {
                        var option = Integer.parseInt(scGame.nextLine());
                        police.add(option);
                } catch (NumberFormatException e) {
                        showMenu.serrMenu();
                        solpolice();
                } catch (NullPointerException e) {
                        showMenu.serrMenu();
                        solpolice();
                }
        }

        private static void sollitersOfGasoline() {
                System.out.print(ConsoleColor.greenText("""
                                |===========================================================|
                                |-Con cuantos litros de gasolina contamos el dia de hoy?    |
                                |==-"""));
                try {
                        var option = Integer.parseInt(scGame.nextLine());
                        litersOfGasoline.add(option);
                } catch (NumberFormatException e) {
                        showMenu.serrMenu();
                        sollitersOfGasoline();
                } catch (NullPointerException e) {
                        showMenu.serrMenu();
                        sollitersOfGasoline();
                }
        }
}
