package sorting;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Sorting {

    private static File transportFile;
    private JSONArray plane = new JSONArray();
    private JSONArray car = new JSONArray();
    private JSONArray train = new JSONArray();

    public int sortPlaneCapacity(JSONArray planeArray) {

        int totalPlaneCapacity = 0;

        for(int i =0; i < planeArray.size(); i++){
            JSONObject childJSONObject = (JSONObject) planeArray.get(i);
            String ePassengerCapacity = childJSONObject.get("e-passenger-capacity").toString();
            String bPassengerCapacity = childJSONObject.get("b-passenger-capacity").toString();
            totalPlaneCapacity = totalPlaneCapacity + Integer.parseInt(ePassengerCapacity) + Integer.parseInt(bPassengerCapacity);
        }

        System.out.println("Total Plane Capacity : " +totalPlaneCapacity);
        return totalPlaneCapacity;
    }

    public int sortCarCapacity(JSONArray carArray) {

        int totalCarCapacity = 0;

        for(int i =0; i < carArray.size(); i++){
            JSONObject childJSONObject = (JSONObject) carArray.get(i);
            String passengerCapacity = childJSONObject.get("passenger-capacity").toString();
            totalCarCapacity = totalCarCapacity + Integer.parseInt(passengerCapacity);
        }

        System.out.println("Total Car Capacity : " +totalCarCapacity);
        return totalCarCapacity;
    }

    public int sortTrainCapacity(JSONArray trainArray) {

        int totalTrainCapacity = 0;

        for(int i =0; i < trainArray.size(); i++){
            JSONObject childJSONObject = (JSONObject) trainArray.get(i);
            String numberOfWagons = childJSONObject.get("number-wagons").toString();
            String wagonPassengerCapacity = childJSONObject.get("w-passenger-capacity").toString();
            totalTrainCapacity = totalTrainCapacity + (Integer.parseInt(numberOfWagons) * Integer.parseInt(wagonPassengerCapacity));
        }

        System.out.println("Total Train Capacity : " +totalTrainCapacity);
        return totalTrainCapacity;
    }


    public int sortPlaneDistinctType(JSONArray planeArray) {

        Set<String> planeSet = new HashSet<>();

        for (int i = 0; i < planeArray.size(); i++) {
            JSONObject childJSONObject = (JSONObject) planeArray.get(i);
            String model = childJSONObject.get("model").toString();
            planeSet.add(model);
        }

        System.out.println("Distinct Planes : " +planeSet.size());
        return planeSet.size();
    }

    public int sortCarDistinctType(JSONArray carArray) {

        Set<String> carSet = new HashSet<>();

        for (int i = 0; i < carArray.size(); i++) {
            JSONObject childJSONObject = (JSONObject) carArray.get(i);
            String manufacturer = childJSONObject.get("manufacturer").toString();
            carSet.add(manufacturer);
        }

        System.out.println("Distinct Cars : " +carSet.size());
        return carSet.size();
    }

    public int sortTrainDistinctType(JSONArray trainArray) {

        Set<String> trainSet = new HashSet<>();

        for (int i = 0; i < trainArray.size(); i++) {
            JSONObject childJSONObject = (JSONObject) trainArray.get(i);
            String model = childJSONObject.get("model").toString();
            trainSet.add(model);
        }

        System.out.println("Distinct Trains : " +trainSet.size());
        return trainSet.size();
    }

    public void writeResult() {
        JSONObject formDetailsJson = new JSONObject();
        formDetailsJson.put("planes", sortPlaneCapacity(plane));
        formDetailsJson.put("cars", sortCarCapacity(car));
        formDetailsJson.put("trains", sortTrainCapacity(train));
        formDetailsJson.put("distinct-planes", sortPlaneDistinctType(plane));
        formDetailsJson.put("distinct-cars", sortCarDistinctType(car));
        formDetailsJson.put("distinct-trains", sortTrainDistinctType(train));

        System.out.println("Result : " +formDetailsJson);
    }


    public void readFile() {

        Object object = null;
        try {
            object = new JSONParser().parse(new FileReader(transportFile));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JSONObject jsonObject = (JSONObject) object;
        JSONArray transportList = (JSONArray) jsonObject.get("transports");

        for(int i=0; i < transportList.size(); i++) {
            JSONObject childJSONObject = (JSONObject) transportList.get(i);

            if (childJSONObject.containsKey("b-passenger-capacity")){
                plane.add(transportList.get(i));
            } else if (childJSONObject.containsKey("passenger-capacity")) {
                car.add(transportList.get(i));
            } else if (childJSONObject.containsKey("w-passenger-capacity")) {
                train.add(transportList.get(i));
            }
        }
    }

    public void setFiles(String product) {
        Sorting.transportFile = new File(product);
    }
}
