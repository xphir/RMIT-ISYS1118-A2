package com.xphir.rmit.demos.futurestudio.Array;

import java.util.List;

public class RestaurantNew {
    String name;

    List<RestaurantMenuItem> menu;
    //RestaurantMenuItem[] menu; // alternative, either one is fine


    public RestaurantNew(String name, List<RestaurantMenuItem> menu) {
        this.name = name;
        this.menu = menu;
    }

    public static class RestaurantMenuItem {
        String description;
        float price;

        public RestaurantMenuItem(String description, float price) {
            this.description = description;
            this.price = price;
        }
    }

}