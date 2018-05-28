package com.xphir.rmit.HRSystem;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class JUnitTests {
    //create testing data
    HRAgent testAgent = new HRAgent(001, "John", "Snow", "Administrator", "Science", "John.Snow@rmit.edu.au", "ForTheWatch");
    CasualStaff testStaff = new CasualStaff(001, "John", "Snow", "Mr", "John.Snow@rmit.edu.au", "COSC1076");
    Tasks testTask = new Tasks(001, "Take the Iron Throne", "Werteros", "Monday", "War", "10/03/2018", "20/05/2018", "Notes Filler", 55.00, 1130, "COSC1076", "John Snow");


    @Test
    //Testing the expected password (this should return true)
    public void TestPasswordNormalCheck() {
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
