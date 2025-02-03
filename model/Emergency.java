package model;

import model.strategy.PrioritizationEmergenciesStrategy;
import utils.*;

public abstract class Emergency implements Comparable<Emergency> {
    private String type;
    private EmergencyLocation location;
    private SeverityLevel severityLevel;
    private int responseTime;
    private boolean attended;
    private int priority;
    private long startTimeAttention;
    private long finalTimeAttention;

    public Emergency(String type, EmergencyLocation location, SeverityLevel severityLevel, int responseTime) {
        this.type = type;
        this.location = location;
        this.severityLevel = severityLevel;
        this.responseTime = responseTime;
        this.attended = false;

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
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

    public void setStartTimeAttention(long startTimeAttention) {
        this.startTimeAttention = startTimeAttention;
    }

    public long getFinalTimeAttention() {
        return finalTimeAttention;
    }

    public void setFinalTimeAttention(long finalTimeAttention) {
        this.finalTimeAttention = finalTimeAttention;
    }

    public void startAttention() {
        this.startTimeAttention = System.currentTimeMillis();
    }


    public void endAttention() {
        this.attended = true;
        this.finalTimeAttention = System.currentTimeMillis();
    }

    public String getDescription() {
        return String.format("%s en %s (gravedad: %s)", type, location, severityLevel + " prioridad:  " + priority);
    }

    @Override
    public int compareTo(Emergency other) {
        return other.priority - this.priority; // Orden descendente
    }

    PrioritizationEmergenciesStrategy strategy = new PrioritizationEmergenciesStrategy();

    @Override
    public String toString() {
        return "Emergencia [tipo: " + type + ", ubicacion: " + location + ", Nivel de gravedad: " + severityLevel
                + ", Con prioridad: " + priority + "]";
    }

}
