package com.xphir.rmit.demos.FilePath;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {

    public static void main(String[] args) {
        Path firstPath = Paths.get("C:\\Users\\Elliot\\Documents\\GitKracken\\HRSystem\\src\\main\\java\\com\\xphir\\rmit\\FilePath\\Test.java");
        Path secondPath = Paths.get("C:\\Users\\Elliot\\Documents\\GitKracken\\HRSystem\\src\\main\\java\\com\\xphir\\rmit\\FilePath\\MainClass.java");

        System.out.println("From firstPath to secondPath: "
                + firstPath.relativize(secondPath));
        System.out.println("From secondPath to firstPath: "
                + secondPath.relativize(firstPath));
        System.out.println();

    }
}
