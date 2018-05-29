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
import static org.junit.Assert.assertNotEquals;

public class JUnitTests {
    //create testing data
    //Single Data
    HRAgent testAgent;
    CasualStaff testStaff;
    Tasks testTask;
    HRAgent testAgentNoArea;

    //List Data
    List<School> testSchoolList = null;
    List<Tasks> testTaskList = null;
    List<HRAgent> testAgentList = null;
    List<CasualStaff> testCasualStaff = null;
    
    @Before
    public void setUpSchoolsList(){
        //IMPORT
        Gson CoursesImportGson = new Gson();

        try (Reader reader = new FileReader("data/tests/CoursesNested.json")) {
            // Convert JSON to Java Object
            Type collectionType = new TypeToken<ArrayList<School>>(){}.getType();
            testSchoolList = CoursesImportGson.fromJson(reader, collectionType);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void setUpAgentList(){
        //IMPORT
        Gson hrAgentImportGson = new Gson();

        List<HRAgent> agentList = null;
        try (Reader reader = new FileReader("data/tests/HRAgents.json")) {
            // Convert JSON to Java Object
            Type collectionType = new TypeToken<ArrayList<HRAgent>>() {
            }.getType();
            testAgentList = hrAgentImportGson.fromJson(reader, collectionType);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void setUpTasksList(){
        //IMPORT
        Gson tasksImportGson = new Gson();

        try (Reader reader = new FileReader("data/tests/Tasks.json")) {
            // Convert JSON to Java Object
            Type collectionType = new TypeToken<ArrayList<Tasks>>(){}.getType();
            testTaskList = tasksImportGson.fromJson(reader, collectionType);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Before
    public void setUpCasualStaffList()
    {
    	Gson tasksImportGson = new Gson();

        try (Reader reader = new FileReader("data/tests/CasualStaff.json"))
        {
            // Convert JSON to Java Object
            Type collectionType = new TypeToken<ArrayList<CasualStaff>>(){}.getType();
            testCasualStaff = tasksImportGson.fromJson(reader, collectionType);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void setUpAgent(){
        testAgent = new HRAgent(001, "John", "Snow", "Administrator", "SCI", "John.Snow@rmit.edu.au", "ForTheWatch");
    }

    @Before
    public void setUpAgentNoArea(){
        testAgentNoArea = new HRAgent(001, "Tyrion", "Lannister", "Administrator", "NOTHING", "Tyrion.Lannister@rmit.edu.au", "ForTheWatch");
    }

    @Before
    public void setUpStaff(){
        testStaff = new CasualStaff(001, "John", "Snow", "Mr", "John.Snow@rmit.edu.au", "COSC1076");
    }

    @Before
    public void setUpTask(){
        testTask = new Tasks(001, "Take the Iron Throne", "Werteros", "Monday", "War", "10/03/2018", "20/05/2018", "Notes Filler", 55.00, 1130, "COSC1076", "John Snow");
    }

    /*
    TEST 1 - verifyPassword()
     */
    @Test
    //[TEST 1.1] Testing the expected password (this should return true)
    public void TestPasswordExactMatch() {
        String testPassword = "ForTheWatch";
        boolean expected = true;
        boolean PasswordCorrect = testAgent.verifyPassword(testPassword);

        assertEquals(expected, PasswordCorrect);
    }

    @Test
    //[TEST 1.2] Testing a lowercase password (this should return false)
    public void TestPasswordCaseCheck() {
        String testPassword = "forthewatch";
        boolean expected = false;
        boolean PasswordCorrect = testAgent.verifyPassword(testPassword);

        assertEquals(expected, PasswordCorrect);
    }

    @Test
    //[TEST 1.3] Testing the expected password (this should return true)
    public void TestPasswordCompletelyWrong() {
        String testPassword = "ThisIsWrong";
        boolean expected = false;
        boolean PasswordCorrect = testAgent.verifyPassword(testPassword);
        assertEquals(expected, PasswordCorrect);
    }

    @Test
    //[TEST 1.4] Testing a Null password (this should return false)
    public void TestPasswordNull() {
        String testPassword = "ThisIsWrong";
        boolean expected = false;
        boolean PasswordCorrect = testAgent.verifyPassword(null);
        assertEquals(expected, PasswordCorrect);
    }


    //getRestrictedSchoolList testing

    /*
    TEST 2 - getRestrictedSchoolList()
     */
    @Test
    //[TEST 2.0] checking test data is correct, if this is wrong it means the input data changed
    public void TestSchoolListLength() {
        int inputListCount = 0;

        inputListCount = Main.getSchoolListLength(testSchoolList);

        assertEquals(9, inputListCount);
    }

    @Test
    //[TEST 2.1] checking resrticted data length is correct
    public void TestRestrictedSchoolListLength(){
        int restrictedListCount = 0;
        List<School> restrictedSchoolList = new ArrayList<>();
        restrictedSchoolList = Main.getRestrictedSchoolList(testAgent, testSchoolList);
        restrictedListCount = Main.getSchoolListLength(restrictedSchoolList);

        assertEquals(6,restrictedListCount);
    }

    @Test
    //[TEST 2.2] testing the created list is correct
    public void TestRestrictedSchoolContains1(){
        HRAgent selectedAgentGregor = testAgentList.get(1); //Selecting Gregor.Clegane@rmit.edu.au

        List<School> restrictedSchoolList = new ArrayList<>();

        restrictedSchoolList = Main.getRestrictedSchoolList(selectedAgentGregor, testSchoolList); //Creating the restricted course list for Gregor

        String resultTitle = restrictedSchoolList.get(0).getDepartment().get(0).getCourse().get(0).getCourseName(); //Getting the title of a subject from his restricted course list

        assertEquals("Financial Management", resultTitle);
    }

    @Test
    //[TEST 2.3] testing the created list is correct
    public void TestRestrictedSchoolContains2(){
        HRAgent selectedAgentGregor = testAgentList.get(1); //Selecting Gregor.Clegane@rmit.edu.au

        List<School> restrictedSchoolList = new ArrayList<>();

        restrictedSchoolList = Main.getRestrictedSchoolList(selectedAgentGregor, testSchoolList); //Creating the restricted course list for Gregor

        String resultTitle = restrictedSchoolList.get(0).getDepartment().get(1).getCourse().get(0).getCourseName(); //Getting the title of a subject from his restricted course list

        assertEquals("Marketing", resultTitle);
    }

    @Test
    //[TEST 2.4] testing a staff with no valid access areas
    public void TestRestrictedSchool(){
        int expected = 0;
        int listSize;
        List<School> restrictedSchoolList = new ArrayList<>();

        HRAgent selectedAgentNoArea = testAgentNoArea; //selecting the "logged in agent" to be an agent with no aplicable area

        restrictedSchoolList = Main.getRestrictedSchoolList(selectedAgentNoArea, testSchoolList); //process method
        
        listSize = restrictedSchoolList.size(); //figures out how many objects are in the list

        assertEquals(0, listSize);
    }




    @Test
    //[TEST 0.1] Testing a simple getter function (NOTE THIS WONT COUNT AS FOR THE ASSIGNMENT)
    public void testGetTaskTitle() {
        String expected = "Take the Iron Throne";
        String response = testTask.getTaskTitle();

        assertEquals(expected, response);
    }

    @Test
    //[TEST 0.2] Testing a simple getter function (NOTE THIS WONT COUNT AS FOR THE ASSIGNMENT)
    public void testSetCasualStaffLastName() {
        String expected = "Targaryen";
        testStaff.setLastName("Targaryen");
        String response = testStaff.getLastName();
        assertEquals(expected, response);
    }




    /*
    TEST 3.1
     */

    //getRestictedTaskList testing
    //Test Title
    
    @Test
    public void TestgetRestictedTaskList(){
        String expected = "Financial Management Lecture 01";
        HRAgent selectedAgentGregor = testAgentList.get(1); //Selecting Gregor.Clegane@rmit.edu.au
        List<School> restrictedSchoolList = new ArrayList<>(); //Creating a blank list
        restrictedSchoolList = Main.getRestrictedSchoolList(selectedAgentGregor, testSchoolList); //Creating the restricted course list for Gregor

        List<Tasks> restrictedTaskList = new ArrayList<>();
        restrictedTaskList = Main.getRestictedTaskList(restrictedSchoolList, testTaskList);

        String resultTask = restrictedTaskList.get(0).getTaskTitle();

        assertEquals(expected, resultTask);
    }


    /*
    TEST 3.2
    */
    
    //Test location
    
    @Test
    public void TestgetRestrictedTaskList2() 
    {
    	String expected = "";
    	HRAgent agentJon = testAgentList.get(0);
    	List<School> restrictedSchoolList = new ArrayList<>();
    	restrictedSchoolList = Main.getRestrictedSchoolList(agentJon, testSchoolList);
    	
    	List<Tasks> restrictedTasklist = new ArrayList<>();
    	restrictedTasklist = Main.getRestictedTaskList(restrictedSchoolList, testTaskList);
    	
    	String Tasklocation = restrictedTasklist.get(0).getLocation();
    	assertEquals(expected, Tasklocation);
    }
    
    /*
    TEST 3.2
    */
    //Test day
    
    @Test
    public void TestgetRestrictedTaskList3() 
    {
    	String expected = "Monday";
    	HRAgent agentJon = testAgentList.get(0);
    	List<School> restrictedSchoolList = new ArrayList<>();
    	restrictedSchoolList = Main.getRestrictedSchoolList(agentJon, testSchoolList);
    	
    	List<Tasks> restrictedTasklist = new ArrayList<>();
    	restrictedTasklist = Main.getRestictedTaskList(restrictedSchoolList, testTaskList);
    	
    	String Tasklocation = restrictedTasklist.get(0).getDay();
    	assertEquals(expected, Tasklocation);
    }

    /*
    TEST 3.2
    */
    //Test task type
    
    @Test
    public void TestgetRestrictedTaskList4() 
    {
    	String expected = "Lecture";
    	HRAgent agentGreg = testAgentList.get(1);
    	List<School> restrictedSchoolList = new ArrayList<>();
    	restrictedSchoolList = Main.getRestrictedSchoolList(agentGreg, testSchoolList);
    	
    	List<Tasks> restrictedTasklist = new ArrayList<>();
    	restrictedTasklist = Main.getRestictedTaskList(restrictedSchoolList, testTaskList);
    	
    	String Tasktype = restrictedTasklist.get(0).getTaskType();
    	assertEquals(expected, Tasktype);
    }    
    
    //TEST 4.1
    //checkQualCasualStaff testing
    @Test
    public void TestCheckQualCasualStaff1() //staff 0 doesn't have matching tasks qual so expected to return false
    {
    	boolean expected = false;
    	CasualStaff testStaff = testCasualStaff.get(0);
    	boolean testResult = Main.checkQualCasualStaff(testTaskList, testStaff);
    	assertEquals(expected, testResult);
    }   
    
    //TEST 4.2
    @Test
    public void TestCheckQualCasualStaff2() //staff 1 doesn't have matching tasks qual so expected to return false
    {
    	boolean expected = false;
    	CasualStaff testStaff = testCasualStaff.get(1);
    	boolean testResult = Main.checkQualCasualStaff(testTaskList, testStaff);
    	assertEquals(expected, testResult);
    }   
    
    //TEST 4.3
    @Test
    public void TestCheckQualCasualStaff3() //staff 2 doesn't have matching tasks qual so expected to return false
    {
    	boolean expected = false;
    	CasualStaff testStaff = testCasualStaff.get(2);
    	boolean testResult = Main.checkQualCasualStaff(testTaskList, testStaff);
    	assertEquals(expected, testResult);
    }  
    
    //TEST 4.4
    @Test
    public void TestCheckQualCasualStaff4() //staff 3 doesn't have matching tasks qual so expected to return false
    {
    	boolean expected = true;
    	CasualStaff testStaff = testCasualStaff.get(3);
    	System.out.println(testStaff.getQualification() + testTaskList.get(3).getTaskQualifications());
    	boolean testResult = Main.checkQualCasualStaff(testTaskList, testStaff);
    	assertEquals(expected, testResult);
    }   

}
