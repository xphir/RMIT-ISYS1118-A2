package com.xphir.rmit.HRSystem;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.xphir.rmit.HRSystem.CasualStaff;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        importCasualStaff();
        //exportCasualStaff();
    }

    public static void exportCasualStaff(){
        System.out.println("exportCasualStaff: Start");


        List<CasualStaff> casualstafflist = new ArrayList<CasualStaff>();
        for (int i = 0; i < 20; i++) {
            casualstafflist.add(new CasualStaff(i, "First", "Last", "Mr", "First.Last@mail.com", new ArrayList<String>));
        }
        //Convert object to JSON string
        // Gson gson = new Gson();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Type type = new TypeToken<List<CasualStaff>>() {}.getType();
        String json = gson.toJson(list, type);
        /* Testing Printout
        System.out.println(json);
        */
        List<CasualStaff> fromJson = gson.fromJson(json, type);

        /* Testing Printout
        for (CasualStaff casualstaff : fromJson) {
            System.out.println(casualstaff);
        }
        */


        //Convert object to JSON string and save into a file directly
        try (FileWriter writer = new FileWriter("C:\\Users\\Elliot\\Documents\\GitKracken\\HRSystem\\data\\examples\\CasualStaff.json")) {

            gson.toJson(list, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("exportCasualStaff: End");
        return;
    }
    public static void importCasualStaff(){
        System.out.println("importCasualStaff: Start");

        Gson gson = new Gson();

        /*
        try {
            File jsonFile = Paths.get("C:\\Users\\Elliot\\Documents\\GitKracken\\HRSystem\\data\\examples\\CasualStaff.json").toFile();
            JsonObject jsonObject = gson.fromJson(new FileReader(jsonFile), JsonObject.class);

            long id = jsonObject.get("ID").getAsLong();
            String firstName = jsonObject.get("firstName").getAsString();
            String lastName = jsonObject.get("lastName").getAsString();
            String title = jsonObject.get("title").getAsString();
            String email = jsonObject.get("email").getAsString();
            JsonArray qualifications = jsonObject.getAsJsonArray("qualifications");


            System.out.println("ID = " + id);
            System.out.println("firstName = " + firstName);
            System.out.println("lastName = " + lastName);
            System.out.println("title = " + title);
            System.out.println("email = " + email);

            for (JsonElement qualification : qualifications) {
                System.out.println("Qualification = " + qualification.getAsString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        try {

            System.out.println("Reading JSON from a file");
            System.out.println("----------------------------");

            BufferedReader br = new BufferedReader(
                    new FileReader("C:\\Users\\Elliot\\Documents\\GitKracken\\HRSystem\\data\\examples\\CasualStaff.json"));

            //convert the json string back to object
            CasualStaff casualstaffobj = gson.fromJson(br, CasualStaff.class);

            System.out.println("ID = " +casualstaffobj.getID());
            System.out.println("firstName = " +casualstaffobj.getFirstName());
            System.out.println("lastName = " +casualstaffobj.getLastName());
            System.out.println("title = " +casualstaffobj.getTitle());
            System.out.println("email = " +casualstaffobj.getEmail());

            List listOfQualifications = casualstaffobj.getQualification();
            for (int i = 0; i < listOfQualifications.size(); i++) {
                System.out.println(listOfQualifications.get(i));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("importCasualStaff: End");
        return;
    }
}
