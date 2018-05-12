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
        //hardCodedCasualStaff();
        //hardCodedTasks();
        //hardCodedCourses();
        Login();
        //printDataToScreen();
        //importCasualStaff();
        //exportCasualStaff();
    }

    public static void printDataToScreen(){

    }

    public static void hardCodedCasualStaff(){
        List<CasualStaff> hcCasualStaffList = new ArrayList<CasualStaff>();
        hcCasualStaffList.add(new CasualStaff(001, "John", "Snow", "Mr", "John.Snow@rmit.edu.au", "COSC1076"));
        hcCasualStaffList.add(new CasualStaff(002, "Gregor", "Clegane", "Mr", "Gregor.Clegane@rmit.edu.au", "MKTG1276"));
        hcCasualStaffList.add(new CasualStaff(003, "Tyrion", "Lannister", "Dr", "Tyrion.Lannister@rmit.edu.au", "ISYS1057"));
        hcCasualStaffList.add(new CasualStaff(004, "Daenerys", "Targaryen", "Ms", "Daenerys.Targaryen@rmit.edu.au", "BUSM4141"));

        hcCasualStaffList.forEach(System.out::println);
    }



    public static void hardCodedTasks(){
        List<Tasks> hcTasksList = new ArrayList<Tasks>();
        hcTasksList.add(new Tasks(001, "Take the Iron Throne", "Werteros", "Monday", "War", "10/03/2018", "20/05/2018", "Notes Filler", 55.00, 1130, "COSC1076", "John Snow"));

        hcTasksList.forEach(System.out::println);
    }
    public static void hardCodedCourses(){
        List<Courses> hcCourseList = new ArrayList<Courses>();
        hcCourseList.add(new Courses("Science", "Computer science", "COSC1076", "Advanced Programming Techniques"));
        hcCourseList.add(new Courses("Science", "Computer science", "COSC1093", "Scripting Language Programming"));
        hcCourseList.add(new Courses("Science", "Computer science", "COSC2353", "Electronic Commerce and Enterprise Systems"));
        hcCourseList.add(new Courses("Science", "Information technology", "ISYS1057", "Database Concepts"));
        hcCourseList.add(new Courses("Science", "Information technology", "ISYS1118", "Software Engineering Fundamentals"));
        hcCourseList.add(new Courses("Business and Law", "Business Management", "BUSM4141", "Financial Management"));
        hcCourseList.add(new Courses("Business and Law", "Business Management", "BUSM4525", "Managing Business Operations"));
        hcCourseList.add(new Courses("Business and Law", "Marketing", "MKTG1276", "Marketing"));

        hcCourseList.forEach(System.out::println);
    }

    /**
     * A simple test case for the main method, verify that a pre-generated test hash verifies successfully
     * for the password it represents, and also generate a new hash and ensure that the new hash verifies
     * just the same.
     */
    public static void Login() {
        
        String John_passwd = "ForTheWatch";
        String Gregor_passwd = "BigGregor";
        String selectedEmail = "John.Snow@rmit.edu.au";
        String fake_hash = "$2a$06$.rCVZVOThsIa97pEDOxvGuRRgzG64bvtJ0938xuqzv18d3ZpQhstC";

        List<HRAgent> hrAgentsList = new ArrayList<HRAgent>();
        hrAgentsList.add(new HRAgent(001, "John","Snow", "Administrator", "Science", "John.Snow@rmit.edu.au",John_passwd));
        hrAgentsList.add(new HRAgent(002, "Gregor","Clegane", "Administrator", "Business and Law", "Gregor.Clegane@rmit.edu.au",Gregor_passwd));

        for(HRAgent agent : hrAgentsList){
            if(agent.getEmail().equals(selectedEmail)){
                System.out.println(agent.getEmail());
                String compare_class = HRAgent.checkPassword(John_passwd, agent.getPasswordHash())
                        ? "Passwords Match" : "Passwords do not match";
                System.out.println("Verify password:   " + compare_class);
            } else {
                System.out.println(agent.getEmail());
                String compare_class = HRAgent.checkPassword(John_passwd, agent.getPasswordHash())
                        ? "Passwords Match" : "Passwords do not match";
                System.out.println("Verify password:   " + compare_class);
            }
        }

        /*
        System.out.println("Testing BCrypt Password hashing and verification");
        System.out.println("Test password: " + test_passwd);
        System.out.println("Hashing test password...");
        System.out.println();

        String class_hash = agentPasswordTestObj.getPasswordHash();
        System.out.println("Test class hash: " + class_hash);
        System.out.println();
        System.out.println("Verifying that hash and stored hash both match for the test password...");
        System.out.println();

        String compare_class = HRAgent.checkPassword(test_passwd, class_hash)
                ? "Passwords Match" : "Passwords do not match";
        String compare_fake = HRAgent.checkPassword(test_passwd, fake_hash)
                ? "Passwords Match" : "Passwords do not match";

        System.out.println("Verify against class hash:   " + compare_class);
        System.out.println("Verify against fake hash: " + compare_fake);
        */

    }
}
