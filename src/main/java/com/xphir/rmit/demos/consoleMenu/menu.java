package com.xphir.rmit.demos.consoleMenu;

import java.util.Scanner;

public class menu {

    public static void menu() {
        // print menu to screen
        System.out.println("*** Menu ***");
        System.out.println();
        System.out.printf("%-25s%s\n", "Option 1", "1");
        System.out.printf("%-25s%s\n", "Option 1", "2");
        System.out.printf("%-25s%s\n", "Option 2", "3");
        System.out.printf("%-25s%s\n", "Option 3", "4");
        System.out.printf("%-25s%s\n", "Option 4", "5");
        System.out.printf("%-25s%s\n", "Exit Program", "0");
        System.out.println();
    }

    public static void include() {
        System.out.println("You are in include() method.");
    }

    public static void change() {
        System.out.println("You are in change() method.");
    }

    public static void delete() {
        System.out.println("You are in delete() method.");
    }

    public static void search() {
        System.out.println("You are in search() method.");
    }

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // DO NOT CHANGE any code main method!

        // Used for testing code
        // startup();

        // declare variables used for menu
        int userInput;
        char selection = 0;

        // implementation of the program menu
        do {

            //call menu
            menu();

            // prompt user to enter selection
            System.out.print("Enter selection: ");
            userInput = sc.nextInt();

            System.out.println();


            // process user's selection
            switch (selection) {
                case '1':
                    System.out.println("*** Option 1 Selected ***");
                    // methodSelect01();
                    break;

                case '2':
                    System.out.println("*** Option 2 Selected ***");
                    // methodSelect01();
                    break;

                case '3':
                    System.out.println("*** Option 3 Selected ***");
                    // methodSelect01();
                    break;

                case '4':
                    System.out.println("*** Option 4 Selected ***");
                    // methodSelect01();
                    break;

                case '5':
                    System.out.println("*** Option 5 Selected ***");
                    // methodSelect01();
                    break;

                case '0':
                    System.out.println("Exiting the program...");
                    // exit();
                    break;

                default:
                    System.out.println("Error - invalid selection!");
            }

            System.out.println();

        } while (selection != 'X');
    }
}

