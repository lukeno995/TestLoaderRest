package com.example.luca.testloaderrest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Luca on 13/02/2018.
 */

public class JsonParser {
    public static List<String> getAllUsers(JSONObject result){
        List<String> listU = new ArrayList<String>();
        try {
            Iterator i = result.keys();
            while(i.hasNext()){
                Object key = i.next();
                JSONObject value = result.getJSONObject((String)key);
                String name = value.getString("Id");
                listU.add(name);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return listU;
    }
}
