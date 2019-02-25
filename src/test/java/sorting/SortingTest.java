package sorting;

import net.joshka.junit.json.params.JsonFileArgumentsProvider;
import net.joshka.junit.json.params.JsonFileSource;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class SortingTest {

    @Test
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

    }

    @Test
    public void testSortTrainCapacity() {

    }

    @Test
    public void testSortPlaneDistinctType() {

    }

    @Test
    public void testSortCarDistinctType() {

    }

    @Test
    public void testSortTrainDistinctType() {

    }

    @Test
    public void testWriteResult() {

        JSONObject formDetailsJson = new JSONObject();
        formDetailsJson.put("planes", 934);
        formDetailsJson.put("cars", 18);
        formDetailsJson.put("trains", 350);

        assertTrue(formDetailsJson.containsKey("planes"));
        assertTrue(formDetailsJson.containsKey("cars"));
        assertTrue(formDetailsJson.containsKey("trains"));
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

        assertEquals(9, transportList.size());
    }

    @Test
    public void testSetFiles() {
        File file = new File("transport.json");
        assertTrue(file.exists());
    }

    @Test
    public void testSetFilesPath() {
        File file = new File("/Users/anirbanchatterjee/Other/SortingJson/transport.json");
        assertTrue(file.exists());
    }
}
