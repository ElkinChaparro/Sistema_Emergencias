package models;

import images.ConsoleColor;
import models.strategy.PrioritizationEmergenciesStrategy;
import utils.*;

public abstract class Emergency implements Comparable<Emergency> {
    private EmergencyType type;
    private EmergencyLocation location;
    private SeverityLevel severityLevel;
    private int responseTime, priority;
    private boolean attended;
    private long startTimeAttention, finalTimeAttention;
    private int attentionDurationMinutes, attentionDurationSeconds;

    PrioritizationEmergenciesStrategy strategy = new PrioritizationEmergenciesStrategy();

    public Emergency(EmergencyType type, EmergencyLocation location, SeverityLevel severityLevel, int responseTime) {
        this.type = type;
        this.location = location;
        this.severityLevel = severityLevel;
        this.responseTime = responseTime;
        this.attended = false;
    }

    public EmergencyType getType() {
        return type;
    }

    public void setType(EmergencyType type) {
        this.type = type;
    }

    public EmergencyLocation getLocation() {
        return location;
    }

    public void setLocation(EmergencyLocation location) {
        this.location = location;
    }

    public SeverityLevel getSeverityLevel() {
        return severityLevel;
    }

    public void setSeverityLevel(SeverityLevel severityLevel) {
        this.severityLevel = severityLevel;
    }

    public int getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(int responseTime) {
        this.responseTime = responseTime;
    }

    public boolean isAttended() {
        return attended;
    }

    public void setAttended(boolean attended) {
        this.attended = attended;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public long getStartTimeAttention() {
        return startTimeAttention;
    }


    public long getFinalTimeAttention() {
        return finalTimeAttention;
    }

    public void startAttention() {
        this.startTimeAttention = System.currentTimeMillis();
    }

    public void endAttention() {
        this.finalTimeAttention = System.currentTimeMillis();
        int totalSeconds= (int) ((finalTimeAttention - startTimeAttention) / 1000);
        this.attentionDurationMinutes = totalSeconds / 60; // Obtener los minutos completos
        this.attentionDurationSeconds = totalSeconds % 60; // Obtener los segundos restantes
    }

    public long calculateAttentionTime() {
        return (finalTimeAttention - startTimeAttention);
    }

    public int getAttentionDurationMinutes() {
        return attentionDurationMinutes;
    }

    public int getAttentionDurationSeconds() {
        return attentionDurationSeconds;
    }

    public String getDescription() {
        return String.format(
                ConsoleColor.orangeText("\n|-Tipo: %s \n|-En %s \n|-Con gravedad: %s \n|-Con prioridad %s"),
                type, location, severityLevel, priority);
    }

    @Override
    public int compareTo(Emergency other) {
        return other.priority - this.priority; // Orden descendente
    }

    @Override
    public String toString() {
        return "\n" + ConsoleColor.cyanText("|-") + ConsoleColor.blueText("Emergencia tipo:   ") + type
                + ConsoleColor.cyanText("\n|-") + ConsoleColor.blueText("Ubicacion:         ") + location
                + ConsoleColor.cyanText("\n|-") + ConsoleColor.blueText("Nivel de gravedad: ") + severityLevel
                + ConsoleColor.cyanText("\n|-") + ConsoleColor.blueText("Con prioridad:     ") + priority
                + ConsoleColor.cyanText("\n|-") + ConsoleColor.blueText("Tiempo estimado de atención: ") + responseTime
                + ConsoleColor.blueText(" minutos");
    }


}
