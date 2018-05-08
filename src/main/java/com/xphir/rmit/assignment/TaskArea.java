package com.xphir.rmit.assignment;

public class TaskArea
{
	public String courseCode, deptCode, schoolCode;
	
	public String getCourseCode()
	{
		return courseCode;
	}
	
	public void setCourseCode(String courseCode)
	{
		this.courseCode = courseCode;
	}
	
	public String getDeptCode()
	{
		return deptCode;
	}
	
	public void setDeptCode(String deptCode)
	{
		this.deptCode = deptCode;
	}
	
	public String getSchoolCode()
	{
		return schoolCode;
	}
	
	public void setSchoolCode(String schoolCode)
	{
		this.schoolCode = schoolCode;
	}
	
	
	
	public Task findAreaSC(String scCode)
	{
		//code
		Task foundTask = new Task(null, null);	//parameter needs to be coded
		return foundTask;
	}
	
	public Task findAreaDC(String deptCode)
	{
		//code
		Task foundTask = new Task(null,null);	//parameter needs to be coded
		return foundTask;
	}
	
	public Task getAllArea()
	{
		Task allTasks = new Task(null,null);	//parameter needs to be coded
		return allTasks;
	}
	
}
