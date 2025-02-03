package views;

import java.util.Scanner;

import controller.dailyRequest;
import images.*;
//import models.*;

public class Main001 {

    static boolean exit = false;
    static Scanner scGame = new Scanner(System.in);

    public static void main(String[] args) {

        imagesACCI.Welcome();
        dailyRequest.Application();
        scGame.nextLine();
        do {
            // TODO comenzar codigo para menu de inicio

            var notify = dailyRequest.ambulances.get(0);
            int sum = notify + 15;
            System.out.println("Es " + sum);

            // Salida de emergencia
            exit = true;
        } while (exit = true);
    }
}
