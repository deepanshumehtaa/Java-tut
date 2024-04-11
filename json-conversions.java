package org.practice;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;


public class JSONHandler {

    public static JSONArray sampleData1() {
        // hardcoded json data
        JSONArray jArray = new JSONArray();

        JSONObject jObj1 = new JSONObject();
        jObj1.put("id",1);
        jObj1.put("disease","Cholera");
        jObj1.put("risk","High");

        JSONObject jObj2 = new JSONObject();
        jObj2.put("id",2);
        jObj2.put("disease","Diabetes");
        jObj2.put("risk","Moderate");

        jArray.put(jObj1);
        jArray.put(jObj2);


        return jArray;
    }

    public static JSONObject sampleData2() {
        String myjsonString = """
                {"emp": [
                    {"id": 1, "fname": "Deepanshu", "lname": "Mehta"},
                    {"id": 2, "fname": "Urvashi", "lname": "Sharma"},
                    {"id": 3, "fname": "Manish", "lname": "Jain"}],
                "dept": ["IT", "TAX", "Managemet"],
                "place": "Gurugram",
                "time": "2024-04-01",
                "isAdmin": false,
                "price": 100.32,
                "dict": {"sample1": true, "sample2": false}
                }
                """;

        JSONObject jObj = new JSONObject(myjsonString);
        System.out.println(jObj);

        JSONArray emp = jObj.getJSONArray("emp");
        boolean isAdmin = jObj.getBoolean("isAdmin");
        int price = jObj.getInt("price");
        String place = jObj.getString("place");

        boolean flag = jObj.getJSONObject("dict").getBoolean("sample1");
        String firstName = jObj.getJSONArray("emp").getJSONObject(0).getString("fname");

        System.out.println(isAdmin);
        return jObj;
    }

    public static JSONArray sampleData3() {
        String employeeURL = "https://freetestapi.com/api/v1/countries?limit=10";
        String response = "";

        try {
            URL url = new URL(employeeURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            System.out.println(in);

            String inputLine;
            StringBuilder responseString = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                responseString.append(inputLine);
            }

            response = responseString.toString();
        }
        catch(Exception e) {
            System.out.println("Error hitting the api or invalid response " + e);
        }

        return new JSONArray(response);
    }

    public static JSONObject sampleData4() throws JsonProcessingException {
        Map<Object, Object> dict1 = new HashMap<Object, Object>(5);
        dict1.put("A", 1);
        dict1.put("B", 3);

        Map<Object, Object> dict2 = new HashMap<Object, Object>()
        {{
            put("key1", "value1");
            put("key2", false);
            put("key3", 10.82);
            put("key4", dict1);
        }};

        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");

        // adding array as value of json
        dict2.put("key5", colors);


        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(dict2);

        return new JSONObject(jsonString);
    }
}
