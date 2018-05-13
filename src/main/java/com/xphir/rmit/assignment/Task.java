package com.xphir.rmit.assignment;

import java.util.Scanner;

public class Task extends TaskArea {
	public String taskId, taskTitle, location, day, taskType, startDate, endDate, taskQual, notes;
	public double taskLengthHrs;
	public int time;
	public String assignedStaff;

	Task[] tasks = new Task[50]; // NOT SURE WHETHER TO STORE ALL TASKS INSIDE TASK CLASS OR NOT...

	Scanner scanner = new Scanner(System.in);

	public Task(String taskId, String taskTitle) {
		this.taskId = taskId;
		this.taskTitle = taskTitle;
	}

	// GET METHODS
	public String getTaskID() {
		return this.taskId;
	}

	// END OF GET METHODS

	// SET METHODS
	public void setTask(String taskId, String taskTitle, String location, String day, String taskType, String startDate,
			String endDate, String taskQual, String notes, double taskLengthHrs, int time, String assignedStaff) {
		setTaskId(taskId);
		setTaskTitle(taskTitle);
		setLocation(location);
		setDay(day);
		setTaskType(taskType);
		setStartDate(startDate);
		setEndDate(endDate);
		setTaskQual(taskQual);
		setNotes(notes);
		setTaskLengthHrs(taskLengthHrs);
		setTime(time);
		setAssignedStaff(assignedStaff);
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public void setTaskQual(String taskQual) {
		this.taskQual = taskQual;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public void setTaskLengthHrs(double taskLengthHrs) {
		this.taskLengthHrs = taskLengthHrs;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public void setAssignedStaff(String assignedStaff) {
		this.assignedStaff = assignedStaff;
	}
	// END OF SET METHODS

	// START OF GET METHODS
	public String getId() {
		return this.taskId;
	}

	public String getTitle() {
		return this.taskTitle;
	}

	public String getLocation() {
		return this.location;
	}

	public String getDay() {
		return this.day;
	}

	public String getTaskType() {
		return this.taskType;
	}

	public String getStartDate() {
		return this.startDate;
	}

	public String getEndDate() {
		return this.endDate;
	}

	public String getTaskQual() {
		return this.taskQual;
	}

	public String getNotes() {
		return this.notes;
	}

	public double getTaskLengthHrs() {
		return this.taskLengthHrs;
	}

	public int getTime() {
		return this.time;
	}

	public String getAssignedStaff() {
		return this.assignedStaff;
	}
	// END OF GET METHODS

	public boolean createTask() // parameters needs to be coded
	{
		/*
		 * int t_count = 0;
		 * 
		 * for (int i = 0; i < tasks.length + 1; i++) { if(tasks[i] == null) { t_count =
		 * i;
		 * 
		 */
		System.out.println("Enter the folllowing details to add a task");

		System.out.println(" Enter the ID of the task:");
		String t_ID = scanner.nextLine();

		System.out.println(" Enter the length of the task:");
		Double t_len = scanner.nextDouble();

		System.out.println(" Enter the title of the task:");
		String t_tit = scanner.nextLine();

		System.out.println(" Enter the location of the task:");
		String t_loc = scanner.nextLine();

		System.out.println(" Enter the day of the task:");
		String t_day = scanner.nextLine();

		System.out.println(" Enter the time of the task:");
		String t_time = scanner.nextLine();

		System.out.println(" Enter the type of the task:");
		String t_type = scanner.nextLine();

		System.out.println(" Enter the start date of the task:");
		String t_start = scanner.nextLine();

		System.out.println(" Enter the end date of the task:");
		String t_end = scanner.nextLine();

		System.out.println(" Enter the course code of the task:");
		String t_courseCode = scanner.nextLine();

		System.out.println(" Enter the qualification of the task:");
		String t_qual = scanner.nextLine();

		System.out.println(" Enter the assigned staff member:");
		String t_assign = scanner.nextLine();

		/*
		 * tasks[t_count].setTaskId(t_ID); tasks[t_count].setTaskLengthHrs(t_len);
		 * tasks[t_count].setTaskTitle(t_tit); tasks[t_count].setLocation(t_loc);
		 * tasks[t_count].setTaskType(t_type); tasks[t_count].setStartDate(t_start);
		 * tasks[t_count].setEndDate(t_end); tasks[t_count].setCourseCode(t_courseCode);
		 * tasks[t_count].setTaskQual(t_qual);
		 * tasks[t_count].setAssignedStaff(t_assign);
		 */
		this.setTaskId(t_ID);
		this.setTaskLengthHrs(t_len);
		this.setTaskTitle(t_tit);
		this.setLocation(t_loc);
		this.setTaskType(t_type);
		this.setStartDate(t_start);
		this.setEndDate(t_end);
		this.setCourseCode(t_courseCode);
		this.setTaskQual(t_qual);
		this.setAssignedStaff(t_assign);

		return true;
		// }
		// }
		// return false;
	}

	public boolean editTask(int taskNum, String taskId, String taskTitle, String location, String day, String taskType,
			String startDate, String endDate, String taskQual, String notes, double taskLengthHrs, int time,
			String assignedStaff) {
		if (tasks[taskNum] != null) {
			setTask(taskId, taskTitle, location, day, taskType, startDate, endDate, taskQual, notes, taskLengthHrs,
					time, assignedStaff);
			return true;
		}
		return false;
	}

	public boolean deleteTask() {
		int taskIndex = 0; // the task id to be deleted

		System.out.println(" Enter the ID of the task to delete:");
		String taskID = scanner.nextLine();

		for (int i = 0; i < tasks.length + 1; i++) {
			if (tasks[i].getTaskID() == taskID) {
				taskIndex = i;
				tasks[i] = null;
				for (int k = taskIndex; taskIndex < tasks.length; k++) {
					tasks[k] = tasks[k + 1];
				}
				return true;
			}
		}
		return false;
	}

	public boolean deleteTask2() {
		this.tasks = null;
		return true;
	}

	public boolean viewTask() {
		System.out.println("Enter the ID of the task to view it's details: ");
		String ID = scanner.nextLine();

		for (Task t : tasks) {
			if (taskId == ID) {

				System.out.println("\n The details of the task are : " + "\n Task ID \t:\t" + taskId
						+ "\n Task Title   \t:\t" + taskTitle + "\n Location \t:\t" + location + "\n Day   \t:\t" + day
						+ "\n Task Type   \t:\t" + taskType + "\n Start Date   \t:\t" + startDate + "\n End Date \t:\t"
						+ endDate + "\n Task Qualification \t:\t" + taskQual + "\n Notes   \t:\t" + notes
						+ "\n Task Length in Hours \t:\t" + taskLengthHrs + "\n Time  \t:\t" + time
						+ "\n Assigned Staff   \t:\t" + assignedStaff);

			}
		}
		return false;
	}

	public boolean viewAllTasks() {
		System.out.println("The details of all tasks are : ");

		for (Task t : tasks) {

			System.out.println("\n" + "\n Task ID \t:\t" + taskId + "\n Task Title   \t:\t" + taskTitle
					+ "\n Location \t:\t" + location + "\n Day   \t:\t" + day + "\n Task Type   \t:\t" + taskType
					+ "\n Start Date   \t:\t" + startDate + "\n End Date \t:\t" + endDate
					+ "\n Task Qualification \t:\t" + taskQual + "\n Notes   \t:\t" + notes
					+ "\n Task Length in Hours \t:\t" + taskLengthHrs + "\n Time  \t:\t" + time
					+ "\n Assigned Staff   \t:\t" + assignedStaff);
		}

		return false;
	}

	public boolean taskAllocate() {

		return false;
	}

	public void checkQual() {

	}

	public void massAllocate() {
		boolean allocateSuccess = false;
		allocateSuccess = taskAllocate();

	}

	public void massCreate() {
		boolean createSuccess = false;
		createSuccess = createTask();

	}

	public void Main() {
		Task t = new Task(null, null);
		t.createTask();
		int taskNum = 0;
		t.editTask(taskNum, taskId, taskTitle, location, day, taskType, startDate, endDate, taskQual, notes,
				taskLengthHrs, time, assignedStaff);
		t.deleteTask();
		t.viewTask();
		t.viewAllTasks();

	}

}
