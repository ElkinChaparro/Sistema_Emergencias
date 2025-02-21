package models.services;

import utils.*;
import controller.*;

public class Ambulancia {

    public static void executetrafficAccident(EmergencyLocation location, SeverityLevel severityLevel) {
        if ((dailyRequest.litersOfGasoline.get(0) == 0) || (dailyRequest.ambulances.get(0) == 0)
                || (dailyRequest.firstAidKits.get(0) == 0) || (dailyRequest.paramedics.get(0) == 0)) {
            System.out.println("No hay recursos disponibles para atender la emergencia");
        } else {
            var operator01 = dailyRequest.litersOfGasoline.get(0);
            var operator02 = dailyRequest.ambulances.get(0);
            var operator03 = dailyRequest.firstAidKits.get(0);
            var operator04 = dailyRequest.paramedics.get(0);
            switch (location) {
                case ZONA_NORTE:
                    operator01 -= 75;
                    operator02 -= 3;
                    dailyRequest.litersOfGasoline.clear();
                    dailyRequest.litersOfGasoline.add(operator01);
                    dailyRequest.ambulances.clear();
                    dailyRequest.ambulances.add(operator02);
                    break;
                case ZONA_SUR:
                    operator01 -= 75;
                    operator02 -= 3;
                    dailyRequest.litersOfGasoline.clear();
                    dailyRequest.litersOfGasoline.add(operator01);
                    dailyRequest.ambulances.clear();
                    dailyRequest.ambulances.add(operator02);
                    break;
                case ZONA_CENTRO:
                    operator01 -= 25;
                    operator02 -= 1;
                    dailyRequest.litersOfGasoline.clear();
                    dailyRequest.litersOfGasoline.add(operator01);
                    dailyRequest.ambulances.clear();
                    dailyRequest.ambulances.add(operator02);
                    break;
                case ZONA_ORIENTE:
                    operator01 -= 50;
                    operator02 -= 2;
                    dailyRequest.litersOfGasoline.clear();
                    dailyRequest.litersOfGasoline.add(operator01);
                    dailyRequest.ambulances.clear();
                    dailyRequest.ambulances.add(operator02);
                    break;
                case ZONA_OCCIDENTE:
                    operator01 -= 50;
                    operator02 -= 2;
                    dailyRequest.litersOfGasoline.clear();
                    dailyRequest.litersOfGasoline.add(operator01);
                    dailyRequest.ambulances.clear();
                    dailyRequest.ambulances.add(operator02);
                    break;
            }
            switch (severityLevel) {
                case BAJO:
                    operator03 -= 2;
                    operator04 -= 2;
                    dailyRequest.firstAidKits.clear();
                    dailyRequest.firstAidKits.add(operator03);
                    dailyRequest.paramedics.clear();
                    dailyRequest.paramedics.add(operator04);
                    break;
                case MEDIO:
                    operator03 -= 4;
                    operator04 -= 4;
                    dailyRequest.firstAidKits.clear();
                    dailyRequest.firstAidKits.add(operator03);
                    dailyRequest.paramedics.clear();
                    dailyRequest.paramedics.add(operator04);
                    break;
                case ALTO:
                    operator03 -= 6;
                    operator04 -= 6;
                    dailyRequest.firstAidKits.clear();
                    dailyRequest.firstAidKits.add(operator03);
                    dailyRequest.paramedics.clear();
                    dailyRequest.paramedics.add(operator04);
                    break;
            }
        }
    }
}