package com.xphir.rmit.HRSystem;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JUnitTests {

    @Test
    //Testing the expected password (this should return true)
    public void TestPasswordNormalCheck() {
        String testPassword = "ForTheWatch";
        HRAgent testAgent = new HRAgent(001, "John", "Snow", "Administrator", "Science", "John.Snow@rmit.edu.au", "ForTheWatch");
        boolean expected = true;
        boolean PasswordCorrect = testAgent.verifyPassword(testPassword);

        assertEquals(expected, PasswordCorrect);
    }

    @Test
    //Testing a lowercase password (this should return false)
    public void TestPasswordCaseCheck() {
        String testPassword = "forthewatch";
        HRAgent testAgent = new HRAgent(001, "John", "Snow", "Administrator", "Science", "John.Snow@rmit.edu.au", "ForTheWatch");
        boolean expected = false;
        boolean PasswordCorrect = testAgent.verifyPassword(testPassword);

        assertEquals(expected, PasswordCorrect);
    }
}
