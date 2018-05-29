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


    private static List<School> schoolList = null;
    private static List<Tasks> taskList = null;
    private static List<HRAgent> agentList = null;
    private static List<CasualStaff> casualStaffList = null;

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {


        //run
        //System.out.println("*** Running Test ***");
        //hardCodedTasks();

        //Declare Values
        Scanner input = new Scanner(System.in);
        int userChoice;


        //ImportData
        System.out.println("*** STARTING DATA IMPORT ***");
        System.out.println("Importing Courses...");
        schoolList = importCourseNested();
        System.out.println("Importing Tasks...");
        taskList = importTasks();
        System.out.println("Importing Agents...");
        agentList = importHRAgents();
        System.out.println("Importing Casual Staff...");
        casualStaffList = importCasualStaff();

        System.out.println();
        HRAgent CurrentAgent = LoginNew(agentList);
        System.out.println("You are now logged in as " + CurrentAgent.getFirstName() + " " + CurrentAgent.getLastName());

        showAreaTasks(CurrentAgent);
        //Menu
        //userChoice = menu();

        //ExportData
        System.out.println("*** STARTING DATA EXPORT ***");
        System.out.println("Exporting Courses...");
        exportCourseNested(schoolList);
        System.out.println("Exporting Tasks...");
        exportTasks(taskList);
        System.out.println("Exporting Agents...");
        exportHRAgents(agentList);
        System.out.println("Exporting Casual Staff...");
        exportCasualStaff(casualStaffList);
    }

    public static void showMenu() {
        //this class is for testing (it will end up in main)

    }

    //TASKS IMPORT
    public static List<Tasks> importTasks() {
        //Declare
        List<Tasks> tasksList = null;

        //IMPORT
        Gson tasksImportGson = new Gson();

        try (Reader reader = new FileReader("data/live/Tasks.json")) {
            // Convert JSON to Java Object
            Type collectionType = new TypeToken<ArrayList<Tasks>>() {
            }.getType();
            tasksList = tasksImportGson.fromJson(reader, collectionType);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return tasksList;
    }

    //TASKS Export
    public static void exportTasks(List<Tasks> taskList) {
        //1. Convert object to JSON string
        //Gson CoursesExportGson = new Gson();
        Gson CoursesExportGson = new GsonBuilder().setPrettyPrinting().create();
        String tasksJSON = CoursesExportGson.toJson(taskList);

        //2. Convert object to JSON string and save into a file directly
        try (FileWriter writer = new FileWriter("data/live/Tasks.json")) {

            CoursesExportGson.toJson(taskList, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //SCHOOL IMPORT
    public static List<School> importCourseNested() {
        //IMPORT
        Gson CoursesImportGson = new Gson();

        List<School> courseList = null;
        try (Reader reader = new FileReader("data/live/CoursesNested.json")) {
            // Convert JSON to Java Object
            Type collectionType = new TypeToken<ArrayList<School>>() {
            }.getType();
            courseList = CoursesImportGson.fromJson(reader, collectionType);


        } catch (IOException e) {
            e.printStackTrace();
        }

        return courseList;
    }

    //SCHOOL EXPORT
    public static void exportCourseNested(List<School> schoolList) {
        //1. Convert object to JSON string
        //Gson CoursesExportGson = new Gson();
        Gson CoursesExportGson = new GsonBuilder().setPrettyPrinting().create();
        String schoolJSON = CoursesExportGson.toJson(schoolList);

        //2. Convert object to JSON string and save into a file directly
        try (FileWriter writer = new FileWriter("data/live/CoursesNested.json")) {

            CoursesExportGson.toJson(schoolList, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //AGENT IMPORT
    public static List<HRAgent> importHRAgents() {
        //IMPORT
        Gson hrAgentImportGson = new Gson();

        List<HRAgent> agentList = null;
        try (Reader reader = new FileReader("data/live/HRAgents.json")) {
            // Convert JSON to Java Object
            Type collectionType = new TypeToken<ArrayList<HRAgent>>() {
            }.getType();
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
        try (FileWriter writer = new FileWriter("data/live/HRAgents.json")) {

            agentExportGson.toJson(agentList, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //CASUAL STAFF IMPORT
    public static List<CasualStaff> importCasualStaff() {
        Gson casualStaffImportGson = new Gson();

        List<CasualStaff> returnStaffList = null;
        try (Reader reader = new FileReader("data/live/CasualStaff.json")) {
            // Convert JSON to Java Object
            Type collectionType = new TypeToken<ArrayList<CasualStaff>>() {
            }.getType();
            returnStaffList = casualStaffImportGson.fromJson(reader, collectionType);


        } catch (IOException e) {
            e.printStackTrace();
        }

        return returnStaffList;
    }

    //CASUAL STAFF EXPORT
    public static void exportCasualStaff(List<CasualStaff> casualStaffList) {
        //1. Convert object to JSON string
        //Gson CoursesExportGson = new Gson();
        Gson casualStaffGson = new GsonBuilder().setPrettyPrinting().create();

        //2. Convert object to JSON string and save into a file directly
        try (FileWriter writer = new FileWriter("data/live/CasualStaff.json")) {

            casualStaffGson.toJson(casualStaffList, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //LOGIN METHOD
    public static HRAgent LoginNew(List<HRAgent> agentList) {
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
        for (HRAgent agent : agentList) {
            if (agent.getEmail().equalsIgnoreCase(emailInput)) {
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

    //Set the
    public static void showAreaTasks(HRAgent loggedInAgent) {
        List<School> restrictedSchoolList = new ArrayList<>();
        List<Tasks> restrictedTaskList = new ArrayList<>();

        restrictedSchoolList = getRestrictedSchoolList(loggedInAgent, schoolList);
        printOutCourses(schoolList, "ALL COURSES");
        printOutCourses(restrictedSchoolList, "COURSES ACCESS");

        restrictedTaskList = getRestictedTaskList(restrictedSchoolList, taskList);

        printOutTasks(restrictedTaskList, "TASK ACCESS");
        printOutTasks(taskList, "ALL TASKS");
    }

    public static List<Tasks> getRestictedTaskList(List<School> restrictedSchoolList, List<Tasks> inputTaskList) {
        List<Tasks> restictedTaskList = new ArrayList<>();
        if (restrictedSchoolList != null) {
            for (School school : restrictedSchoolList) {
                for (School.Department department : school.getDepartment()) {
                    for (School.Department.Course course : department.getCourse()) {
                        for (Tasks task : inputTaskList) {
                            if (course.getCourseCode().equals(task.getTaskQualifications())) {
                                //Task Matches
                                restictedTaskList.add(task);
                            } else {
                                //Task does not match
                            }
                        }

                    }
                }
            }
        } else {
            //NO COURSES
        }

        return restictedTaskList;
    }

    //Gets the list of accessible schools for an agent
    public static List<School> getRestrictedSchoolList(HRAgent loggedInAgent, List<School> inputSchoolList) {
        List<School> schoolAcessArea = new ArrayList<>();
        for (School school : inputSchoolList) {
            if (school.getSchoolCode().equals(loggedInAgent.getAccessArea())) {
                schoolAcessArea.add(school);
            } else {
                //System.out.println("*** No Match ***");
            }
        }
        return schoolAcessArea;
    }


    public static void printOutTasks(List<Tasks> inputTaskList, String printTitle) {
        if (inputTaskList != null) {
            System.out.println();
            System.out.println("===========================================================");
            System.out.println(printTitle);
            System.out.println("===========================================================");
            for (Tasks task : inputTaskList) {
                System.out.println("TaskID: " + task.getTaskId());
                System.out.println("\tTitle: " + task.getTaskTitle());
                System.out.println("\tLocation: " + task.getLocation());
                System.out.println("\tDay: " + task.getDay());
                System.out.println("\tType: " + task.getTaskType());
                System.out.println("\tStart Date: " + task.getStartDate());
                System.out.println("\tEnd Date: " + task.getEndDate());
                System.out.println("\tNotes: " + task.getNotes());
                System.out.println("\tLength (Hours): " + task.getTaskLengthHrs());
                System.out.println("\tTime: " + task.getTime());
                System.out.println("\tQualifications Needed: " + task.getTaskQualifications());
                System.out.println("\tAssignedStaff: " + task.getAssignedStaff());
                System.out.println("===========================================================");
            }
            System.out.println("===========================================================");
        }
    }

    //Prints out courses
    public static void printOutCourses(List<School> inputSchoolList, String printTitle) {
        if (inputSchoolList != null) {
            System.out.println();
            System.out.println("===========================================================");
            System.out.println(printTitle);
            System.out.println("===========================================================");
            for (School school : inputSchoolList) {
                System.out.println("SCHOOL: " + school.getSchoolName());
                for (School.Department department : school.getDepartment()) {
                    System.out.println("\tDEPARTMENT: " + department.getDepartmentName());
                    for (School.Department.Course course : department.getCourse()) {
                        System.out.println("\t\tCourse Code: " + course.getCourseCode() + "\t\t" + "Course Name: " + course.getCourseName());
                    }
                }
                System.out.println("===========================================================");
            }
            System.out.println("===========================================================");
            System.out.println();
        } else {
            System.out.println("*** No Vaild Courses ***");
        }
    }

    public static int getSchoolListLength(List<School> inputSchoolList){
        int courseCount = 0;
        if (inputSchoolList != null) {
            for (School school : inputSchoolList) {
                for (School.Department department : school.getDepartment()) {
                    for (School.Department.Course course : department.getCourse()) {
                        courseCount = courseCount + 1;
                    }
                }
            }
        } else {
            courseCount = 0;
        }
        return courseCount;
    }
    
    public static boolean checkQualCasualStaff(List<Tasks> taskList, CasualStaff staff)
    {
    	boolean qualify = false;
    	String qualification = staff.getQualification();
    	for(Tasks task:taskList)
    	{
    		if(Objects.equals(qualification, task.getTaskQualifications()))
    		{
    			qualify = true;
    			return qualify;
    		}
    	}
    	return qualify;
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
//        try (Reader reader = new FileReader("data/live/HRAgents.json")) {
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
