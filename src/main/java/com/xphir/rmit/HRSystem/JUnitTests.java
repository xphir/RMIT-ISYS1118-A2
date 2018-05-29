package com.xphir.rmit.HRSystem;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.junit.*;
import static org.junit.Assert.assertEquals;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class JUnitTests {
    //create testing data
    //Single Data
    HRAgent testAgent;
    CasualStaff testStaff;
    Tasks testTask;

    //List Data
    List<School> testSchoolList = null;
    List<School> testTaskList = null;

    @Before
    public void setUpSchoolsList(){
        //IMPORT
        Gson CoursesImportGson = new Gson();

        try (Reader reader = new FileReader("data/live/CoursesNested.json")) {
            // Convert JSON to Java Object
            Type collectionType = new TypeToken<ArrayList<School>>(){}.getType();
            testSchoolList = CoursesImportGson.fromJson(reader, collectionType);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void setUpTasksList(){
        //IMPORT
        Gson tasksImportGson = new Gson();

        try (Reader reader = new FileReader("data/live/Tasks.json")) {
            // Convert JSON to Java Object
            Type collectionType = new TypeToken<ArrayList<Tasks>>(){}.getType();
            testTaskList = tasksImportGson.fromJson(reader, collectionType);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void setUpAgent(){
        testAgent = new HRAgent(001, "John", "Snow", "Administrator", "Science", "John.Snow@rmit.edu.au", "ForTheWatch");
    }

    @Before
    public void setUpStaff(){
        testStaff = new CasualStaff(001, "John", "Snow", "Mr", "John.Snow@rmit.edu.au", "COSC1076");
    }

    @Before
    public void setUpTask(){
        testTask = new Tasks(001, "Take the Iron Throne", "Werteros", "Monday", "War", "10/03/2018", "20/05/2018", "Notes Filler", 55.00, 1130, "COSC1076", "John Snow");
    }

    @Test
    //Testing the expected password (this should return true)
    public void TestPasswordExactMatch() {
        String testPassword = "ForTheWatch";
        boolean expected = true;
        boolean PasswordCorrect = testAgent.verifyPassword(testPassword);

        assertEquals(expected, PasswordCorrect);
    }

    @Test
    //Testing a lowercase password (this should return false)
    public void TestPasswordCaseCheck() {
        String testPassword = "forthewatch";
        boolean expected = false;
        boolean PasswordCorrect = testAgent.verifyPassword(testPassword);

        assertEquals(expected, PasswordCorrect);
    }

    @Test
    //Testing the expected password (this should return true)
    public void TestPasswordCompletelyWrong() {
        String testPassword = "ThisIsWrong";
        boolean expected = false;
        boolean PasswordCorrect = testAgent.verifyPassword(testPassword);
        assertEquals(expected, PasswordCorrect);
    }

    @Test
    //Testing a Null password (this should return false)
    public void TestPasswordNull() {
        String testPassword = "ThisIsWrong";
        boolean expected = false;
        boolean PasswordCorrect = testAgent.verifyPassword(null);
        assertEquals(expected, PasswordCorrect);
    }


    @Test
    //Testing View Access
    public void TestSchoolAccessCorrect(){

    }








    @Test
    //Testing a simple getter function (NOTE THIS WONT COUNT AS FOR THE ASSIGNMENT)
    public void testGetTaskTitle() {
        String expected = "Take the Iron Throne";
        String response = testTask.getTaskTitle();

        assertEquals(expected, response);
    }

    @Test
    //Testing a simple getter function (NOTE THIS WONT COUNT AS FOR THE ASSIGNMENT)
    public void testSetCasualStaffLastName() {
        String expected = "Targaryen";
        testStaff.setLastName("Targaryen");
        String response = testStaff.getLastName();
        assertEquals(expected, response);
    }
}
