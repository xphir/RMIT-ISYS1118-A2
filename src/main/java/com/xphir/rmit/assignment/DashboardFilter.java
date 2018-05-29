package com.xphir.rmit.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DashboardFilter {

	private static final Scanner sc = new Scanner(System.in);


	public static void main(String[] args)
	{
		ArrayList<CasualStaff> casualStaff = new ArrayList<>();
		// DO NOT CHANGE any code main method!

		// Used for testing code
		// startup();

		// declare variables used for menu
		String userInput;
		char selection = 0;

		// implementation of the program menu
		do {

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
			if (userInput.length() != 1) {
				System.out.println("Error - invalid selection!");
			} else {
				// make selection "case insensitive"
				selection = Character.toUpperCase(userInput.charAt(0));

				// process user's selection
				switch (selection) {
					case 'A':
						System.out.println("*** Option A Selected ***");
						startup();
						// methodSelect01();
						break;

					case 'B':
						System.out.println("*** Option B Selected ***");
						// methodSelect01();
						break;

					case 'C':
						System.out.println("*** Option C Selected ***");
						// methodSelect01();
						break;

					case 'D':
						System.out.println("*** Option D Selected ***");
						// methodSelect01();
						break;

					case 'E':
						System.out.println("*** Option E Selected ***");
						// methodSelect01();
						break;

					case 'X':
						System.out.println("Exiting the program...");
						// exit();
						break;

					default:
						System.out.println("Error - invalid selection!");
				}
			}
			System.out.println();

		} while (selection != 'X');
	}

	// used for loading test code
	private static void startup() {
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

		if (tasks.editTask(0, tasks.getId(), t_tit, tasks.getLocation(), tasks.getDay(), tasks.getTaskType(),
				tasks.getStartDate(), tasks.getEndDate(), tasks.getTaskQual(), tasks.getNotes(),
				tasks.getTaskLengthHrs(), tasks.getTime(), tasks.getAssignedStaff())) {
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

		if (tasks.deleteTask2()) {
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

	public void agentLogin() {

	}

	public void dashboard() {

	}

	public void dashboardFilter() {

	}

	public void viewTask() {

	}

	public void massViewTask() {

	}

	public void reportsMenu() {

	}
	public void casualStaffMenu(ArrayList<CasualStaff> casualstaff)
	{
		String input = null;
		boolean exit = false;
		int option = 0;
		while(exit != true)
		{
			System.out.printf("\n---Casual Staff Menu---\n\n1.Create Casual Staff\n2.Edit Casual Staff\n3.Delete Casual Staff\n4.View Casual Staff\n0.BACK\n\nEnter the index of the option:\n");
			input = sc.nextLine();
			option = Integer.parseInt(input);
			if(option == 0)
			{
				return;
			}
			else if(option == 1)
			{
				System.out.printf("\n\n\n\nPlease enter the credentials for the new staff: **use space to seperate each piece of info**\n"
						+ "Format:[staff ID] [staff first name] [staff last name] [staff title] [staff email]\n");
				input = sc.nextLine();
				createCasualStaff(input);
			}
			else if(option == 2)
			{
				boolean found = false;
				System.out.printf("\n\n\n\nEnter the ID of the casual staff to edit:\n");
				input = sc.nextLine();
				for(CasualStaff currentStaff: casualstaff)
				{
					if(currentStaff.csID == input)
					{
						currentStaff.editCasualStaff();
						found = true;
						break;
					}
				}
				if(found == false)
				{
					System.out.println("casual staff unfound");
				}
			}
			else if(option == 3)
			{
				boolean found = false;
				System.out.printf("\n\n\n\nEnter the ID of the casual staff to delete:\n");
				input = sc.nextLine();
				for(CasualStaff currentStaff: casualstaff)
				{
					if(currentStaff.csID == input)
					{
						casualstaff.remove(currentStaff);
						found = true;
						break;
					}
				}
				if(found == false)
				{
					System.out.println("casual staff unfound");
				}
			}
			else if(option == 4)
			{
				System.out.println("Casual Staff:\n");
				for(CasualStaff staff: casualstaff)
				{
					System.out.println(staff.toString());
				}
			}
			else
			{
				System.out.println("\nInvalid input\n");
			}
		}

	}
	public void createCasualStaff(String input)
	{
		String qual = null;
		CasualStaff newStaff = new CasualStaff();
		String[] token = input.split("\\ ");
		if(token.length != 5)
		{
			System.out.println("Invalid input");
			return;
		}
		else
		{
			newStaff.csID = token[0];
			newStaff.firstName = token[1];
			newStaff.lastName = token[2];
			newStaff.title = token[3];
			newStaff.email = token[4];
		}
		System.out.println("Now please enter their qualification: each qualification divided by a space\nFor example: qual1 qual2 qual3");
		qual = sc.nextLine();
		String[] qualToken = qual.split("\\ ");
		ArrayList<String> qualification = new ArrayList<>(Arrays.asList(qualToken));
		newStaff.setQualification(qualification);
		qualification.clear();
	}
}