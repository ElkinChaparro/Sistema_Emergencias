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

                System.out.print(ConsoleColor.greenText("""
                                |===========================================================|
                                |-Con cuantos botiquines contamos el dia de hoy?            |
                                |==-"""));
                var option01 = scGame.nextInt();
                firstAidKits.add(option01);

                System.out.print(ConsoleColor.greenText("""
                                |===========================================================|
                                |-Con cuantas ambulancias contamos el dia de hoy?           |
                                |==-"""));
                var option02 = scGame.nextInt();
                ambulances.add(option02);

                System.out.print(ConsoleColor.greenText("""
                                |===========================================================|
                                |-Con cuantos paramedicos contamos el dia de hoy?           |
                                |==-"""));
                var option03 = scGame.nextInt();
                paramedics.add(option03);

                System.out.print(ConsoleColor.greenText("""
                                |===========================================================|
                                |-Con cuantos Litros de agua contamos el dia de hoy?        |
                                |==-"""));
                var option04 = scGame.nextInt();
                litersOfWater.add(option04);

                System.out.print(ConsoleColor.greenText("""
                                |===========================================================|
                                |-Con cuantos carros de bomberos contamos el dia de hoy?    |
                                |==-"""));
                var option05 = scGame.nextInt();
                fireTrucks.add(option05);

                System.out.print(ConsoleColor.greenText("""
                                |===========================================================|
                                |-Con cuantos bomberos contamos el dia de hoy?              |
                                |==-"""));
                var option06 = scGame.nextInt();
                firefighters.add(option06);

                System.out.print(ConsoleColor.greenText("""
                                |===========================================================|
                                |-Con cuantas municiones contamos el dia de hoy?            |
                                |==-"""));
                var option07 = scGame.nextInt();
                ammunition.add(option07);

                System.out.print(ConsoleColor.greenText("""
                                |===========================================================|
                                |-Con cuantas patrullas contamos el dia de hoy?             |
                                |==-"""));
                var option08 = scGame.nextInt();
                patrols.add(option08);

                System.out.print(ConsoleColor.greenText("""
                                |===========================================================|
                                |-Con cuantos policias contamos el dia de hoy?              |
                                |==-"""));
                var option09 = scGame.nextInt();
                police.add(option09);

                System.out.print(ConsoleColor.greenText("""
                                |===========================================================|
                                |-Con cuantos litros de gasolina contamos el dia de hoy?    |
                                |==-"""));
                var option10 = scGame.nextInt();
                litersOfGasoline.add(option10);

                showMenu.pressEnter(scGame);

        }

}
