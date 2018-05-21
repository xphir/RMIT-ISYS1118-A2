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

    public static HRAgent LoginNew(List<HRAgent> agentList){
        String emailInput;
        String passwordInput;
        HRAgent selectedAgent = null;
        HRAgent loggedInAs = null;

        System.out.println("*** HR System Login ***");
        System.out.println();
        System.out.print("Please enter your email address: ");
        //auto settings user to John Snow for simplicities sake
        //emailInput = sc.nextLine();
        emailInput = "John.Snow@rmit.edu.au";
        System.out.println();

        //selection = Character.toUpperCase(userInput.charAt(0));

        //Find the email in the system and set the value of said match to 'selectedAgent'
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

    public static HRAgent Login(){
        String emailInput;
        String passwordInput;
        HRAgent selectedAgent = null;
        HRAgent loggedInAs = null;
        List<HRAgent> hrAgentsList = null;

        Gson HRAgentsImportGson = new Gson();

        //READ JSON FILE
        try (Reader reader = new FileReader("data/examples/HRAgents.json")) {
            // Convert JSON to Java Object
            Type collectionType = new TypeToken<ArrayList<HRAgent>>(){}.getType();
            hrAgentsList = HRAgentsImportGson.fromJson(reader, collectionType);

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("*** HR System Login ***");
        System.out.println();
        System.out.print("Please enter your email address: ");
        //auto settings user to John Snow for simplicities sake
        //emailInput = sc.nextLine();
        emailInput = "John.Snow@rmit.edu.au";
        System.out.println();

        //selection = Character.toUpperCase(userInput.charAt(0));

        //Find the email in the system and set the value of said match to 'selectedAgent'
        for(HRAgent agent : hrAgentsList) {
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
        System.out.println("Password Correct: " + PasswordCorrect);
        System.out.println("You are now logged in as " + selectedAgent.getFirstName() + " " + selectedAgent.getLastName());
        return selectedAgent;
    }


    //SHOW
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












    //IGNORE BELLOW
    //OLD HARDCODED DATA

    public static void hardCodedHRAgents() {
        String John_passwd = "ForTheWatch";
        String Gregor_passwd = "BigGregor";

        List<HRAgent> hrAgentsList = new ArrayList<HRAgent>();
        hrAgentsList.add(new HRAgent(001, "John", "Snow", "Administrator", "Science", "John.Snow@rmit.edu.au", John_passwd));
        hrAgentsList.add(new HRAgent(002, "Gregor", "Clegane", "Administrator", "Business and Law", "Gregor.Clegane@rmit.edu.au", Gregor_passwd));
    }

    public static void hardCodedCasualStaff(){
        List<CasualStaff> hcCasualStaffList = new ArrayList<CasualStaff>();
        hcCasualStaffList.add(new CasualStaff(001, "John", "Snow", "Mr", "John.Snow@rmit.edu.au", "COSC1076"));
        hcCasualStaffList.add(new CasualStaff(002, "Gregor", "Clegane", "Mr", "Gregor.Clegane@rmit.edu.au", "MKTG1276"));
        hcCasualStaffList.add(new CasualStaff(003, "Tyrion", "Lannister", "Dr", "Tyrion.Lannister@rmit.edu.au", "ISYS1057"));
        hcCasualStaffList.add(new CasualStaff(004, "Daenerys", "Targaryen", "Ms", "Daenerys.Targaryen@rmit.edu.au", "BUSM4141"));
    }

    public static void test() {
        //COURSES
        List<School.Department.Course> courseCOSC = new ArrayList<>();
        courseCOSC.add(new School.Department.Course("Advanced Programming Techniques", "COSC1076"));
        courseCOSC.add(new School.Department.Course("Scripting Language Programming", "COSC1093"));
        courseCOSC.add(new School.Department.Course("Electronic Commerce and Enterprise Systems", "COSC2353"));

        List<School.Department.Course> courseISYS = new ArrayList<>();
        courseISYS.add(new School.Department.Course("Database Concepts", "ISYS1057"));
        courseISYS.add(new School.Department.Course("Software Engineering Fundamentals", "ISYS1118"));

        List<School.Department.Course> courseBUSM = new ArrayList<>();
        courseBUSM.add(new School.Department.Course("Financial Management", "BUSM4141"));
        courseBUSM.add(new School.Department.Course("Managing Business Operations", "BUSM4525"));

        List<School.Department.Course> courseMKTG = new ArrayList<>();
        courseMKTG.add(new School.Department.Course("Marketing", "MKTG1276"));

        //DEPARTMENTS
        List<School.Department> departmentSCI = new ArrayList<>();
        departmentSCI.add(new School.Department("Computer Science", "COSC", courseCOSC));
        departmentSCI.add(new School.Department("Information Technology", "ISYS", courseISYS));

        List<School.Department> departmentBUS = new ArrayList<>();
        departmentBUS.add(new School.Department("Business Management", "BUSM", courseBUSM));
        departmentBUS.add(new School.Department("Marketing", "MKTG", courseMKTG));

        //SCHOOLS
        List<School> schools = new ArrayList<>();
        schools.add(new School("School of Science", "SCI", departmentSCI));
        schools.add(new School("Business and Law", "BUS", departmentBUS));

        //EXPORT

        //1. Convert object to JSON string
        //Gson CoursesExportGson = new Gson();
        Gson CoursesExportGson = new GsonBuilder().setPrettyPrinting().create();
        String schoolJSON = CoursesExportGson.toJson(schools);
        System.out.println(schoolJSON);

        //2. Convert object to JSON string and save into a file directly
        try (FileWriter writer = new FileWriter("data/examples/CoursesNested.json")) {

            CoursesExportGson.toJson(schools, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }

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

        //hcCourseList.forEach(System.out::println);

        //EXPORT LIST TO JSON

        //1. Convert object to JSON string
        //Gson CoursesExportGson = new Gson();
        Gson CoursesExportGson = new GsonBuilder().setPrettyPrinting().create();
        String restaurantJson = CoursesExportGson.toJson(hcCourseList);
        System.out.println(restaurantJson);


        //2. Convert object to JSON string and save into a file directly
        try (FileWriter writer = new FileWriter("data/examples/Courses.json")) {

            CoursesExportGson.toJson(hcCourseList, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }


        //IMPORT JSON TO LIST

        Gson CoursesImportGson = new Gson();

        try (Reader reader = new FileReader("data/examples/Courses.json")) {
            // Convert JSON to Java Object
            Courses[] courseList = CoursesImportGson.fromJson(reader, Courses[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void hardCodedTasks(){
        List<Tasks> hcTasksList = new ArrayList<Tasks>();
        hcTasksList.add(new Tasks(001, "Take the Iron Throne", "Werteros", "Monday", "War", "10/03/2018", "20/05/2018", "Notes Filler", 55.00, 1130, "COSC1076", "John Snow"));

        Gson tasksExportGson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter("data/examples/Tasks.json")) {

            tasksExportGson.toJson(hcTasksList, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
