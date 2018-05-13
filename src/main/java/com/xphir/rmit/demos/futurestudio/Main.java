package com.xphir.rmit.futurestudio;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

public class Main {

    public static void main(String[] args) {
        String generalInfoJson = "{'name': 'Future Studio Dev Team', 'website': 'https://futurestud.io', 'founders': [{'name': 'Christian', 'flowerCount': 1 }, {'name': 'Marcus','flowerCount': 3 }, {'name': 'Norman','flowerCount': 2 }]}";

        Gson gson = new Gson();

        GeneralInfo generalInfoObject = gson.fromJson(generalInfoJson, GeneralInfo.class);
        System.out.println("Name = " +generalInfoObject.getName());
        System.out.println("Website = " +generalInfoObject.getWebsite());
        System.out.println("Founders = " +generalInfoObject.getFounders());
    }
}
