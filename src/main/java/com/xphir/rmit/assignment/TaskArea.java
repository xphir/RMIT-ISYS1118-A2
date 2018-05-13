package com.xphir.rmit.assignment;

public class TaskArea {
	public String courseCode, deptCode, schoolCode;

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getSchoolCode() {
		return schoolCode;
	}

	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}

	String school_1[][] = { { "Science", }, { "Applied Science ", "Chemistry ", "Computer Science" },
			{ "ID: COSC1076, Name : Advanced Programming Techniques",
					"ID:COSC1093,Name : Scripting Language Programming", "ID:COSC1107,Name : Computing Theory",
					"ID: COSC1111,Name: Data Communication and Net-Centric Computing" } };

	public void disp() {

		for (int x = 0; x < school_1.length; x++) {

			String subArray[] = school_1[x];
			String item = subArray[x];

			System.out.println("School is " + item);

			for (int y = 0; y < subArray.length; y++) {

				String subArray1[] = school_1[y];
				String item1 = subArray1[y];
				System.out.println(" Departments are: " + item1);
				{
					for (int z = 0; z < subArray1.length; z++) {

						String subArray2[] = school_1[z];
						String item2 = subArray[z];
						System.out.println("  Courses are : " + item2);

					}

				}
			}
		}
	}

	public Task findAreaSC(String scCode) {
		// code
		Task foundTask = new Task(null, null); // parameter needs to be coded
		return foundTask;
	}

	public Task findAreaDC(String deptCode) {
		// code
		Task foundTask = new Task(null, null); // parameter needs to be coded
		return foundTask;
	}

	public Task getAllArea() {
		Task allTasks = new Task(null, null); // parameter needs to be coded
		return allTasks;
	}

}
