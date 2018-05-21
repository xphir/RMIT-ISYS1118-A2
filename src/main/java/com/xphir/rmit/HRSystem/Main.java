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
import java.util.*;

/*
LOGIN INFORMATION
John.Snow@rmit.edu.au Password = "ForTheWatch";
Gregor.Clegane@rmit.edu.au Password = "BigGregor";
*/

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {


        //run
        System.out.println("*** Running Test ***");
        //hardCodedTasks();

        //Declare Values
        List<School> schoolList = null;
        List<Tasks> taskList = null;
        List<HRAgent> agentList = null;

        //ImportData
        System.out.println("*** Importing Courses ***");
        schoolList = importCourseNested();
        System.out.println("*** Importing Tasks ***");
        taskList = importTasks();
        System.out.println("*** Importing Agents ***");
        agentList = importHRAgents();

        System.out.println();
        HRAgent CurrentAgent = LoginNew(agentList);
        System.out.println("You are now logged in as " + CurrentAgent.getFirstName() + " " + CurrentAgent.getLastName());


        //ExportData
        System.out.println("*** Exporting Tasks ***");
        exportTasks(taskList);
        System.out.println("*** Exporting Courses ***");
        exportCourseNested(schoolList);
    }


    //TASKS IMPORT
    public static List<Tasks> importTasks(){
        //Declare
        List<Tasks> tasksList = null;

        //IMPORT
        Gson tasksImportGson = new Gson();

        try (Reader reader = new FileReader("data/examples/Tasks.json")) {
            // Convert JSON to Java Object
            Type collectionType = new TypeToken<ArrayList<Tasks>>(){}.getType();
            tasksList = tasksImportGson.fromJson(reader, collectionType);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return tasksList;
    }

    //TASKS Export
    public static void exportTasks(List<Tasks> taskList){
        //1. Convert object to JSON string
        //Gson CoursesExportGson = new Gson();
        Gson CoursesExportGson = new GsonBuilder().setPrettyPrinting().create();
        String tasksJSON = CoursesExportGson.toJson(taskList);

        //2. Convert object to JSON string and save into a file directly
        try (FileWriter writer = new FileWriter("data/examples/Tasks.json")) {

            CoursesExportGson.toJson(taskList, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //SCHOOL IMPORT
    public static List<School> importCourseNested(){
        //IMPORT
        Gson CoursesImportGson = new Gson();

        List<School> courseList = null;
        try (Reader reader = new FileReader("data/examples/CoursesNested.json")) {
            // Convert JSON to Java Object
            Type collectionType = new TypeToken<ArrayList<School>>(){}.getType();
            courseList = CoursesImportGson.fromJson(reader, collectionType);


        } catch (IOException e) {
            e.printStackTrace();
        }

        return courseList;
    }

    //SCHOOL EXPORT
    public static void exportCourseNested(List<School> schoolList){
        //1. Convert object to JSON string
        //Gson CoursesExportGson = new Gson();
        Gson CoursesExportGson = new GsonBuilder().setPrettyPrinting().create();
        String schoolJSON = CoursesExportGson.toJson(schoolList);

        //2. Convert object to JSON string and save into a file directly
        try (FileWriter writer = new FileWriter("data/examples/CoursesNested.json")) {

            CoursesExportGson.toJson(schoolList, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //AGENT IMPORT
    public static List<HRAgent> importHRAgents(){
        //IMPORT
        Gson hrAgentImportGson = new Gson();

        List<HRAgent> agentList = null;
        try (Reader reader = new FileReader("data/examples/HRAgents.json")) {
            // Convert JSON to Java Object
            Type collectionType = new TypeToken<ArrayList<HRAgent>>(){}.getType();
            agentList = hrAgentImportGson.fromJson(reader, collectionType);


        } catch (IOException e) {
            e.printStackTrace();
        }

        return agentList;
    }

    //AGENT EXPORT
    public static void exportHRAgents(List<HRAgent> agentList) {

        //1. Convert object to JSON string
        //Gson CoursesExportGson = new Gson();
        Gson agentExportGson = new GsonBuilder().setPrettyPrinting().create();
        String schoolJSON = agentExportGson.toJson(agentList);

        //2. Convert object to JSON string and save into a file directly
        try (FileWriter writer = new FileWriter("data/examples/HRAgents.json")) {

            agentExportGson.toJson(agentList, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //LOGIN METHOD
    public static HRAgent LoginNew(List<HRAgent> agentList){
        String emailInput;
        String passwordInput;
        HRAgent selectedAgent = null;
        HRAgent loggedInAs = null;

        System.out.println("*** HR System Login ***");
        System.out.println();
        System.out.print("Please enter your email address: ");
        //auto settings user to John Snow for simplicities sake
        //emailInput = "John.Snow@rmit.edu.au";
        emailInput = sc.nextLine();
        System.out.println();

        //selection = Character.toUpperCase(userInput.charAt(0));

        //Find the email in the system and set the value of said match to 'selectedAgent'
        //TODO NEED TO ADD TRY AND CATCH
        for(HRAgent agent : agentList) {
            if (agent.getEmail().equals(emailInput)) {
                selectedAgent = agent;
            } else {
                //email doest match
            }
        }

        System.out.println("Entered Email:   " + emailInput);
        System.out.println("Selected Email:   " + selectedAgent.getEmail());
        System.out.println();

        System.out.print("Please enter your password: ");
        passwordInput = sc.nextLine();

        System.out.println();
        System.out.println("Entered Password: " + passwordInput);
        boolean PasswordCorrect = selectedAgent.verifyPassword(passwordInput);


        if (PasswordCorrect) {
            System.out.println("Password Correct");
            loggedInAs = selectedAgent;
        } else {
            System.out.println("Password Incorrect");
            System.out.println("Ending Program...");
            System.exit(0);
        }
        return loggedInAs;
    }




    //TESTING METHODS
    public static void showAllSchools(List<School> schoolList){
        for(School school : schoolList) {
            for(School.Department department : school.getDepartment()) {
                for(School.Department.Course course : department.getCourse()){
                    System.out.printf("[SCHOOL]: %s\t [DEPARTMENT]: %s\n [COURSE]: %s %n", school.getSchoolName(), department.getDepartmentName(), course.getCourseName());
                    //System.out.print("School: " + school.getSchoolName());
                    //System.out.print("Department: " + department.getDepartmentName());
                    //System.out.println("Course: " + course.getCourseName());
                }
            }
        }
    }

    //OLD METHODS (USE ["CTRL" + "/"] TO COMMENT/UNCOMMENT CODE BLOCKS)

//    public static HRAgent LoginOLD(){
//        String emailInput;
//        String passwordInput;
//        HRAgent selectedAgent = null;
//        HRAgent loggedInAs = null;
//        List<HRAgent> hrAgentsList = null;
//
//        Gson HRAgentsImportGson = new Gson();
//
//        //READ JSON FILE
//        try (Reader reader = new FileReader("data/examples/HRAgents.json")) {
//            // Convert JSON to Java Object
//            Type collectionType = new TypeToken<ArrayList<HRAgent>>(){}.getType();
//            hrAgentsList = HRAgentsImportGson.fromJson(reader, collectionType);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("*** HR System Login ***");
//        System.out.println();
//        System.out.print("Please enter your email address: ");
//        //auto settings user to John Snow for simplicities sake
//        //emailInput = sc.nextLine();
//        emailInput = "John.Snow@rmit.edu.au";
//        System.out.println();
//
//        //selection = Character.toUpperCase(userInput.charAt(0));
//
//        //Find the email in the system and set the value of said match to 'selectedAgent'
//        for(HRAgent agent : hrAgentsList) {
//            if (agent.getEmail().equals(emailInput)) {
//                selectedAgent = agent;
//            } else {
//                //email doest match
//            }
//        }
//
//        System.out.println("Entered Email:   " + emailInput);
//        System.out.println("Selected Email:   " + selectedAgent.getEmail());
//        System.out.println();
//
//        System.out.print("Please enter your password: ");
//        passwordInput = sc.nextLine();
//
//        System.out.println();
//        System.out.println("Entered Password: " + passwordInput);
//        boolean PasswordCorrect = selectedAgent.verifyPassword(passwordInput);
//        System.out.println("Password Correct: " + PasswordCorrect);
//        System.out.println("You are now logged in as " + selectedAgent.getFirstName() + " " + selectedAgent.getLastName());
//        return selectedAgent;
//    }

}
