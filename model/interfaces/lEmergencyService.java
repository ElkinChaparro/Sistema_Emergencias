package model.interfaces;

public interface lEmergencyService {

    String getId();

    int getAvailableStaff();

    int getAvailableVehicle();

    boolean isFree();

    void assignStaff(int amount);

    void setFreeStaff(int amount);

    void setFreeVehicle(int amount);

    void spendFuel(int anount);

}
