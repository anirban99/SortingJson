package sorting;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SortingTest {

    @Test
    public void testSetFiles() {
        File file = new File("transport.json");
        assertTrue(file.exists());
    }

    @Test
    public void testReadFile() {

        Object object = null;
        try {
            object = new JSONParser().parse(new FileReader("transport.json"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JSONObject jsonObject = (JSONObject) object;
        JSONArray transportList = (JSONArray) jsonObject.get("transports");

        assertEquals(10, transportList.size());
    }

    @Test
    @SuppressWarnings("Duplicates")
    public void testSortPlaneCapacity() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("model", "Boeing 777");
        jsonObject.put("b-passenger-capacity", "14");
        jsonObject.put("e-passenger-capacity", "300");

        JSONArray planeTestArray = new JSONArray();
        planeTestArray.add(jsonObject);

        int totalCapacity = 0;

        for(int i =0; i < planeTestArray.size(); i++){
            JSONObject childJSONObject = (JSONObject) planeTestArray.get(i);
            String ePassengerCapacity = childJSONObject.get("e-passenger-capacity").toString();
            String bPassengerCapacity = childJSONObject.get("b-passenger-capacity").toString();
            totalCapacity = totalCapacity + Integer.parseInt(ePassengerCapacity) + Integer.parseInt(bPassengerCapacity);
        }

        assertEquals(314, totalCapacity);
    }

    @Test
    public void testSortCarCapacity() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("manufacturer", "BMW");
        jsonObject.put("model", "M3");
        jsonObject.put("passenger-capacity", "4");

        JSONArray carTestArray = new JSONArray();
        carTestArray.add(jsonObject);

        int totalCapacity = 0;

        for(int i =0; i < carTestArray.size(); i++){
            JSONObject childJSONObject = (JSONObject) carTestArray.get(i);
            String passengerCapacity = childJSONObject.get("passenger-capacity").toString();
            totalCapacity = totalCapacity + Integer.parseInt(passengerCapacity);
        }

        assertEquals(4, totalCapacity);
    }

    @Test
    @SuppressWarnings("Duplicates")
    public void testSortTrainCapacity() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("model", "ICE");
        jsonObject.put("number-wagons", "5");
        jsonObject.put("w-passenger-capacity", "30");

        JSONArray trainTestArray = new JSONArray();
        trainTestArray.add(jsonObject);

        int totalCapacity = 0;

        for(int i =0; i < trainTestArray.size(); i++){
            JSONObject childJSONObject = (JSONObject) trainTestArray.get(i);
            String numberOfWagons = childJSONObject.get("number-wagons").toString();
            String wagonPassengerCapacity = childJSONObject.get("w-passenger-capacity").toString();
            totalCapacity = totalCapacity + (Integer.parseInt(numberOfWagons) * Integer.parseInt(wagonPassengerCapacity));
        }

        assertEquals(150, totalCapacity);
    }

    @Test
    public void testSortPlaneDistinctType() {
        JSONObject firstJsonObject = new JSONObject();
        firstJsonObject.put("model", "Boeing 777");
        firstJsonObject.put("b-passenger-capacity", "14");
        firstJsonObject.put("e-passenger-capacity", "300");

        JSONObject secondJsonObject = new JSONObject();
        secondJsonObject.put("model", "Boeing 777S");
        secondJsonObject.put("b-passenger-capacity", "10");
        secondJsonObject.put("e-passenger-capacity", "200");

        JSONArray planeTestArray = new JSONArray();
        planeTestArray.add(firstJsonObject);
        planeTestArray.add(secondJsonObject);

        Set<String> planeSetTest = new HashSet<>();

        for (int i = 0; i < planeTestArray.size(); i++) {
            JSONObject childJSONObject = (JSONObject) planeTestArray.get(i);
            String model = childJSONObject.get("model").toString();
            planeSetTest.add(model);
        }

        assertEquals(2, planeSetTest.size());
    }

    @Test
    public void testSortCarDistinctType() {
        JSONObject firstJsonObject = new JSONObject();
        firstJsonObject.put("manufacturer", "Mercedes-Benz");
        firstJsonObject.put("model", "C-Klasse");
        firstJsonObject.put("passenger-capacity", "4");

        JSONObject secondJsonObject = new JSONObject();
        secondJsonObject.put("manufacturer", "Mercedes-Benz");
        secondJsonObject.put("model", "E-Klasse");
        secondJsonObject.put("passenger-capacity", "4");

        JSONArray carTestArray = new JSONArray();
        carTestArray.add(firstJsonObject);
        carTestArray.add(secondJsonObject);

        Set<String> carSetTest = new HashSet<>();

        for (int i = 0; i < carTestArray.size(); i++) {
            JSONObject childJSONObject = (JSONObject) carTestArray.get(i);
            String manufacturer = childJSONObject.get("manufacturer").toString();
            carSetTest.add(manufacturer);
        }

        assertEquals(1, carSetTest.size());
    }

    @Test
    public void testSortTrainDistinctType() {

        JSONObject firstJsonObject = new JSONObject();
        firstJsonObject.put("model", "ICE");
        firstJsonObject.put("number-wagons", "5");
        firstJsonObject.put("w-passenger-capacity", "30");

        JSONObject secondJsonObject = new JSONObject();
        secondJsonObject.put("model", "ICE");
        secondJsonObject.put("number-wagons", "6");
        secondJsonObject.put("w-passenger-capacity", "50");

        JSONObject thirdJsonObject = new JSONObject();
        thirdJsonObject.put("model", "TGV");
        thirdJsonObject.put("number-wagons", "8");
        thirdJsonObject.put("w-passenger-capacity", "40");

        JSONArray trainTestArray = new JSONArray();
        trainTestArray.add(firstJsonObject);
        trainTestArray.add(secondJsonObject);
        trainTestArray.add(thirdJsonObject);

        Set<String> trainSetTest = new HashSet<>();

        for (int i = 0; i < trainTestArray.size(); i++) {
            JSONObject childJSONObject = (JSONObject) trainTestArray.get(i);
            String model = childJSONObject.get("model").toString();
            trainSetTest.add(model);
        }

        assertEquals(2, trainSetTest.size());
    }

    @Test
    public void testWriteResult() {

        JSONObject formDetailsJson = new JSONObject();
        formDetailsJson.put("planes", 934);
        formDetailsJson.put("cars", 18);
        formDetailsJson.put("trains", 770);

        assertTrue(formDetailsJson.containsKey("planes"));
        assertTrue(formDetailsJson.containsKey("cars"));
        assertTrue(formDetailsJson.containsKey("trains"));
    }
}
