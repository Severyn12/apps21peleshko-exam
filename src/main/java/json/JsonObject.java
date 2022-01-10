package json;

import java.util.ArrayList;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {

    private ArrayList<JsonPair> dataStorage = new ArrayList();
    private ArrayList<String> keys = new ArrayList();

    public JsonObject(JsonPair... jsonPairs) {
        for (JsonPair pair: jsonPairs) {
            String key = pair.getKey();
            if (keys.contains(key)) {
                int idx = keys.indexOf(key);
                dataStorage.set(idx, pair);
            }
            else {
                dataStorage.add(pair);
                keys.add(pair.getKey());
            }
        }
    }

    @Override
    public String toJson() {
        String represent = "{";
        if (dataStorage.size() > 0) {
            for (JsonPair pair : dataStorage) {
                represent += pair.toJson() + ", ";
            }

            return represent.substring(0, represent.length() - 2) + "}";
        }
        return represent + "}";
    }

    public void add(JsonPair jsonPair) {
        String key = jsonPair.getKey();
        if (keys.contains(key)) {
            int idx = keys.indexOf(key);
            dataStorage.set(idx, jsonPair);
        }
        else {
            dataStorage.add(jsonPair);
            keys.add(key);
        }
    }

    public Json find(String name) {
        for (JsonPair pair: dataStorage) {
            String key = pair.getKey();
            if (key.equals(name)) {
                return pair.getValue();
            }
        }
        return null;
    }

    public JsonObject projection(String... names) {
        ArrayList<JsonPair> nwPairs = new ArrayList();
        for (String name: names) {
            for (JsonPair pair: dataStorage) {
                String key = pair.getKey();
                if (key.equals(name)) {
                    nwPairs.add(pair);
                }
            }



        }
        return new JsonObject(nwPairs.toArray(new JsonPair[0]));


    }

}
