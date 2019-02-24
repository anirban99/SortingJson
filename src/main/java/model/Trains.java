package model;

public class Trains {

    private String model;
    private String numberOfWagons;
    private String wPassengerCapacity;

    public Trains() {

    }

    public Trains(String model, String numberOfWagons, String wPassengerCapacity) {
        this.model = model;
        this.numberOfWagons = numberOfWagons;
        this.wPassengerCapacity = wPassengerCapacity;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumberOfWagons() {
        return numberOfWagons;
    }

    public void setNumberOfWagons(String numberOfWagons) {
        this.numberOfWagons = numberOfWagons;
    }

    public String getwPassengerCapacity() {
        return wPassengerCapacity;
    }

    public void setwPassengerCapacity(String wPassengerCapacity) {
        this.wPassengerCapacity = wPassengerCapacity;
    }
}
