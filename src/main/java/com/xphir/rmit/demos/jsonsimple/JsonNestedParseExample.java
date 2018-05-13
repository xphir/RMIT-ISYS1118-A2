package com.xphir.rmit.jsonsimple;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonNestedParseExample {

    public static void main(String[] args) {

        JSONParser jsonParser = new JSONParser();
        Object object;

        try {

            object = jsonParser.parse(new FileReader("data/nestedobjects.json"));
            JSONObject jsonObject = (JSONObject) object;

            String name = (String) jsonObject.get("name");
            System.out.println("Name: " + name);

            String website = (String) jsonObject.get("website");
            System.out.println("Website: " + website);

            JSONObject technology = (JSONObject) jsonObject.get("technology");
            System.out.println("Technology: " + technology);
            long java = (Long) technology.get("java");
            System.out.println("\tjava: " + java);

            JSONObject compose = (JSONObject) jsonObject.get("compose");
            System.out.println("compose: " + compose);
            long total = (Long) compose.get("total");
            System.out.println("\ttotal: " + total);
            JSONArray soundex = (JSONArray) compose.get("soundex");
            System.out.println("\tsoundex: " + soundex);

            Object composeObj = jsonObject.get("compose");
            JSONObject jsonObject1 = (JSONObject) composeObj;
            Iterator itr = soundex.iterator();

            while (itr.hasNext()) {

                Object slide = itr.next();
                JSONObject jsonObject2 = (JSONObject) slide;
                JSONObject info = (JSONObject) jsonObject2.get("info");

                String date_of_birth = (String) info.get("date_of_birth");
                String name_id = (String) info.get("name_id");

                System.out.println("\t\tDate of Birth: " + date_of_birth);
                System.out.println("\t\tName Id: " + name_id);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}