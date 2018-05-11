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
        hardCodedCasualStaff();
        printDataToScreen();
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
}
