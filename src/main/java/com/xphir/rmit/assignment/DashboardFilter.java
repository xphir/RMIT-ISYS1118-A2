package com.xphir.rmit.assignment;
import java.util.*;



public class DashboardFilter{

	private static final Scanner sc = new Scanner(System.in);
		
	
	public static void main(String[] args)
	{
		// DO NOT CHANGE any code main method!

		//Used for testing code		
		//startup();
		
		// declare variables used for menu
		String userInput;
		char selection = 0;

		// implementation of the program menu
		do
		{

			// print menu to screen
			System.out.println("*** HR Task Assignment Menu ***");
			System.out.println();
			
			System.out.printf("%-25s%s\n", "Demo Menu (Create > Edit > Delete Tasks )", "A");
			System.out.printf("%-25s%s\n", "Filler Option 1", "B");
			System.out.printf("%-25s%s\n", "Filler Option 2", "C");
			System.out.printf("%-25s%s\n", "Filler Option 3", "D");
			System.out.printf("%-25s%s\n", "Filler Option 4", "E");
			System.out.printf("%-25s%s\n", "Exit Program", "X");
			System.out.println();

			// prompt user to enter selection
			System.out.print("Enter selection: ");
			userInput = sc.nextLine();

			System.out.println();

			// validate selection input length
			if (userInput.length() != 1)
			{
				System.out.println("Error - invalid selection!");
			}
			else
			{
				// make selection "case insensitive"
				selection = Character.toUpperCase(userInput.charAt(0));

				// process user's selection
				switch (selection)
		        {
			        case 'A':
			        	System.out.println("*** Option A Selected ***");
			    		startup();
			        	//methodSelect01();
			        	break;
			
			        case 'B':
			        	System.out.println("*** Option B Selected ***");
			        	//methodSelect01();
			        	break;
			
			        case 'C':
			        	System.out.println("*** Option C Selected ***");
			        	//methodSelect01();
			        	break;
			
			        case 'D':
			        	System.out.println("*** Option D Selected ***");
			        	//methodSelect01();
			        	break;
			
			        case 'E':
			        	System.out.println("*** Option E Selected ***");
			        	//methodSelect01();
			        	break;
			
			        case 'X':
			        	System.out.println("Exiting the program...");
			        	//exit();
			        	break;
			
			        default:
			           System.out.println("Error - invalid selection!");
		        }
			}
			System.out.println();
			
		} 
		while (selection != 'X');
	}
	
    //used for loading test code
	private static void startup()
	   {
		Task tasks = new Task("001", "TITLE");
		if (tasks.createTask()) {
			System.out.println("Task Created");
		} else {
			System.out.println("Task Not Created");
		}
		
		System.out.println("Current Task Values");
		System.out.println("Title: " + tasks.getTitle());
		System.out.println("Location: " + tasks.getLocation());
		System.out.println("Day: " + tasks.getDay());
		System.out.println("Type: " + tasks.getTaskType());
		System.out.println("Start Date: " + tasks.getStartDate());
		System.out.println("End Date: " + tasks.getEndDate());
		System.out.println("Qualifications: " + tasks.getTaskQual());
		System.out.println("Notes: " + tasks.getNotes());
		System.out.println("Time: " + tasks.getTime());
		System.out.println("Staff: " + tasks.getAssignedStaff());
		System.out.println("");
		System.out.println("======================================");
		System.out.println("");

		
		System.out.println("You will now edit a Task");
		System.out.println("Type a new task Title");
		String t_tit = sc.nextLine();
		
		if (tasks.editTask(0, tasks.getId(), t_tit, tasks.getLocation(), tasks.getDay(), tasks.getTaskType(), tasks.getStartDate(), tasks.getEndDate(), tasks.getTaskQual(), tasks.getNotes(), tasks.getTaskLengthHrs(), tasks.getTime(), tasks.getAssignedStaff())){
			System.out.println("Task Created");
		} else {
			System.out.println("Task Not Created");
		}
		
		System.out.println("Current Task Values");
		System.out.println("Title: " + tasks.getTitle());
		System.out.println("Location: " + tasks.getLocation());
		System.out.println("Day: " + tasks.getDay());
		System.out.println("Type: " + tasks.getTaskType());
		System.out.println("Start Date: " + tasks.getStartDate());
		System.out.println("End Date: " + tasks.getEndDate());
		System.out.println("Qualifications: " + tasks.getTaskQual());
		System.out.println("Notes: " + tasks.getNotes());
		System.out.println("Time: " + tasks.getTime());
		System.out.println("Staff: " + tasks.getAssignedStaff());
		System.out.println("");
		System.out.println("======================================");
		System.out.println("");
		
		if (tasks.deleteTask2()){
			System.out.println("Task Created");
		} else {
			System.out.println("Task Not Created");
		}
		
		System.out.println("Current Task Values");
		System.out.println("Title: " + tasks.getTitle());
		System.out.println("Location: " + tasks.getLocation());
		System.out.println("Day: " + tasks.getDay());
		System.out.println("Type: " + tasks.getTaskType());
		System.out.println("Start Date: " + tasks.getStartDate());
		System.out.println("End Date: " + tasks.getEndDate());
		System.out.println("Qualifications: " + tasks.getTaskQual());
		System.out.println("Notes: " + tasks.getNotes());
		System.out.println("Time: " + tasks.getTime());
		System.out.println("Staff: " + tasks.getAssignedStaff());
		System.out.println("");
		System.out.println("======================================");
		System.out.println("");
		
		return;
	   }
	
	public void agentLogin()
	{
		
	}
	
	public void dashboard()
	{
		
	}
	
	public void dashboardFilter()
	{
		
	}
	
	public void viewTask()
	{
		
	}
	
	public void massViewTask()
	{
		
	}
	
	public void reportsMenu()
	{
		
	}
	
	public void payrollMenu()
	{
		
	}
}