package models.observer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import images.ConsoleColor;
import models.Emergency;

public class ConsoleObserver implements ObserverEmergencies {

    public String GetDateTime(){
        // obtener fecha y hora actual
        LocalDateTime now = LocalDateTime.now();

        // Definir formato
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyy HH:mm");
        String formattedDateTime = now.format(formatter);

        return formattedDateTime;
    }


    @Override
    public void update(Emergency emergency) {
        System.out.println(ConsoleColor.redText("""
                |================= ALERTA DE EMERGENCIA ====================|
                |===========================================================|
                |============== NUEVA EMERGENCIA RECIBIDA ==================|
                """));
        System.out.println("Tipo de emergencia: " + emergency.getType());
        System.out.println("Ubicación: " + emergency.getLocation());
        System.out.println("Prioridad: " + emergency.getPriority());
        System.out.println("Fecha y hora del suceso: " + GetDateTime());
    }

}
