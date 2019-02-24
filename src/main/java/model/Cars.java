package model;

public class Cars {

    private String manufacturer;
    private String model;
    private String passengerCapacity;

    public Cars() {

    }

    public Cars(String manufacturer, String model, String passengerCapacity) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.passengerCapacity = passengerCapacity;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(String passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }
}
