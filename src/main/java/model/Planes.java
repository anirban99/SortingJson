package model;

public class Planes {

    private String model;
    private String bPassengerCapacity;
    private String ePassengerCapacity;

    public Planes() {
    }

    public Planes(String model, String bPassengerCapacity, String ePassengerCapacity) {
        this.model = model;
        this.bPassengerCapacity = bPassengerCapacity;
        this.ePassengerCapacity = ePassengerCapacity;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getbPassengerCapacity() {
        return bPassengerCapacity;
    }

    public void setbPassengerCapacity(String bPassengerCapacity) {
        this.bPassengerCapacity = bPassengerCapacity;
    }

    public String getePassengerCapacity() {
        return ePassengerCapacity;
    }

    public void setePassengerCapacity(String ePassengerCapacity) {
        this.ePassengerCapacity = ePassengerCapacity;
    }
}
