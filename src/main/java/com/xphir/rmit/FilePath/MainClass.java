package com.xphir.rmit.FilePath;
import java.io.File;

public class MainClass {

    public static void main(String[] args) {

        File absolute = new File("C:\\Users\\Elliot\\Documents\\GitKracken\\HRSystem\\data\\courses.json");
        File relative = new File("data/courses.json");

        System.out.println("absolute: ");
        System.out.println(absolute.getName());
        System.out.println(absolute.getPath());

        System.out.println("relative: ");
        System.out.println(relative.getName());
        System.out.println(relative.getPath());
    }
}