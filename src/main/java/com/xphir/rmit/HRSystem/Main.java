package com.xphir.rmit.HRSystem;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.xphir.rmit.HRSystem.CasualStaff;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<CasualStaff> list = new ArrayList<CasualStaff>();
        for (int i = 0; i < 20; i++) {
            list.add(new CasualStaff(i, "First", "Last", "Mr", "First.Last@mail.com"));
        }
        //Convert object to JSON string
        // Gson gson = new Gson();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Type type = new TypeToken<List<CasualStaff>>() {}.getType();
        String json = gson.toJson(list, type);
        System.out.println(json);
        List<CasualStaff> fromJson = gson.fromJson(json, type);

        for (CasualStaff casualstaff : fromJson) {
            System.out.println(casualstaff);
        }


        //Convert object to JSON string and save into a file directly
        try (FileWriter writer = new FileWriter("C:\\Users\\Elliot\\Documents\\GitKracken\\HRSystem\\data\\examples\\CasualStaff.json")) {

            gson.toJson(list, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
