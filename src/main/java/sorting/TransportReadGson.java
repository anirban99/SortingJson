package sorting;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.JsonObject;
import java.io.FileReader;

public class TransportReadGson {

    public static void main(String[] args) {
        JsonObject jsonObject = null;

        try {
            jsonObject = new JsonParser().parse(new FileReader("transport.json")).getAsJsonObject();
        } catch (Exception e){
            System.out.println(e);
        }

        JsonArray arr = jsonObject.getAsJsonArray("transports");

        JsonArray plane = new JsonArray();
        JsonArray train = new JsonArray();
        JsonArray car = new JsonArray();


        for (int i = 0; i < arr.size(); i++) {
            String model = arr.get(i).getAsJsonObject().get("model").getAsString();
            System.out.println(model);

//            if(arr.get(i).getAsJsonObject().get("b-passenger-capacity") != "undefined"){
//                plane.add(arr.get(i));
//            }

            if(arr.get(i).getAsJsonObject().get("b-passenger-capacity").isJsonObject()){
                plane.add(arr.get(i));
                System.out.println(plane);
            } else if (arr.get(i).getAsJsonObject().get("passenger-capacity").isJsonObject()){
                car.add(arr.get(i));
            } else if (arr.get(i).getAsJsonObject().get("w-passenger-capacity").isJsonObject()){
                train.add(arr.get(i));
            }
        }

        System.out.print(plane);
        System.out.print(train);
        System.out.print(car);
    }
}
