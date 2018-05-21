package com.xphir.rmit.demos.futurestudio.Array;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Arrays & Lists!");
        serializeFutureStudio();
        deserializeFutureStudio();
    }

    private static void userJSON() {
        String userJson = "{'age':26,'email':'norman@futurestud.io','isDeveloper':true,'name':'Norman'}";

        Gson gson = new Gson();
        UserSimple userObject = gson.fromJson(userJson, UserSimple.class);
    }

    private static void userAddress() {
        UserAddress userAddress = new UserAddress(
                "Main Street",
                "42A",
                "Magdeburg",
                "Germany"
        );

        UserNested userObject = new UserNested(
                "Norman",
                "norman@futurestud.io",
                true,
                26,
                userAddress
        );

        Gson gson = new Gson();
        String userWithAddressJson = gson.toJson(userObject);

    }

    private static void restaurant() {
        String restaurantJson = "{ 'name':'Future Studio Steak House', 'owner':{ 'name':'Christian', 'address':{ 'city':'Magdeburg', 'country':'Germany', 'houseNumber':'42', 'street':'Main Street'}},'cook':{ 'age':18, 'name': 'Marcus', 'salary': 1500 }, 'waiter':{ 'age':18, 'name': 'Norman', 'salary': 1000}}";

        Gson gson = new Gson();

        Restaurant restaurantObject = gson.fromJson(restaurantJson, Restaurant.class);
    }

    private static void serializeFutureStudio() {
        List<RestaurantNew.RestaurantMenuItem> menu = new ArrayList<>();
        menu.add(new RestaurantNew.RestaurantMenuItem("Spaghetti", 7.99f));
        menu.add(new RestaurantNew.RestaurantMenuItem("Steak", 12.99f));
        menu.add(new RestaurantNew.RestaurantMenuItem("Salad", 5.99f));

        RestaurantNew restaurant =
                new RestaurantNew("Future Studio Steak House", menu);

        Gson gson = new Gson();
        String restaurantJson = gson.toJson(restaurant);
        System.out.println(restaurantJson);
    }

    private static void deserializeFutureStudio() {
        String founderJson = "[{'name': 'Christian','flowerCount': 1}, {'name': 'Marcus', 'flowerCount': 3}, {'name': 'Norman', 'flowerCount': 2}]";

        Gson gson = new Gson();
        Founder[] founderArray = gson.fromJson(founderJson, Founder[].class);
        for (Founder founder : founderArray) {
            System.out.println(founder.getName());
            System.out.println(founder.getFlowerCount());
        }
    }
}
