package com.xphir.rmit.demos.futurestudio.Array;

public class Restaurant {
    String name;
    Owner owner;
    Cook cook;
    Waiter waiter;

    public class Owner {
        String name;
        UserAddress address;
    }

    public class Cook {
        String name;
        int age;
        int salary;
    }

    public class Waiter {
        String name;
        int age;
        int salary;
    }

}

