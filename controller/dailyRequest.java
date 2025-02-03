package controller;

import java.util.*;

public class dailyRequest {
        static Scanner scGame = new Scanner(System.in);
        // TODO remplazar los objet por sus respectivos objetos con caracteristicas
        // propias
        public static List<Integer> firstAidKits = new ArrayList<>();
        public static List<Integer> litersOfWater = new ArrayList<>();
        public static List<Integer> ammunition = new ArrayList<>();
        public static List<Integer> ambulances = new ArrayList<>();
        public static List<Integer> fireTrucks = new ArrayList<>();
        public static List<Integer> patrols = new ArrayList<>();

        public static void Application() {

                System.out.print("""
                                |===========================================================|
                                |-Con cuantos botiquines contamos el dia de hoy?
                                |==-""");
                var option01 = scGame.nextInt();
                firstAidKits.add(option01);

                System.out.print("""
                                |===========================================================|
                                |-Con cuantos Litros de agua contamos el dia de hoy?
                                |==-""");
                var option02 = scGame.nextInt();
                litersOfWater.add(option02);

                System.out.print("""
                                |===========================================================|
                                |-Con cuantas municiones contamos el dia de hoy?
                                |==-""");
                var option03 = scGame.nextInt();
                ammunition.add(option03);

                System.out.print("""
                                |===========================================================|
                                |-Con cuantas ambulancias contamos el dia de hoy?
                                |==-""");
                var option04 = scGame.nextInt();
                ambulances.add(option04);

                System.out.print("""
                                |===========================================================|
                                |-Con cuantos carros de bomberos contamos el dia de hoy?
                                |==-""");
                var option05 = scGame.nextInt();
                fireTrucks.add(option05);

                System.out.print("""
                                |===========================================================|
                                |-Con cuantas patrullas contamos el dia de hoy?
                                |==-""");
                var option06 = scGame.nextInt();
                patrols.add(option06);

                pressEnter(scGame);

        }

        public static void pressEnter(Scanner scGame) {
                System.out.print("""
                                |===========================================================|
                                |-Presione Enter para Continuar
                                |==-""");
                scGame.nextLine();
        }
}
