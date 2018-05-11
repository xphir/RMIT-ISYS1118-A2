package com.xphir.rmit.HRSystem;

public class Tasks {
    private long taskId;
    private String taskTitle;
    private String location;
    private String day;
    private String taskType;
    private String startDate;
    private String endDate;
    private String notes;
    private double taskLengthHrs;
    private int time;
    private String taskQualifications;
    private String assignedStaff;

    //Constructor for All
    public Tasks(long taskId, String taskTitle, String location, String day, String taskType, String startDate, String endDate, String notes, double taskLengthHrs, int time, String taskQualifications, String assignedStaff) {
        this.taskId = taskId;
        this.taskTitle = taskTitle;
        this.location = location;
        this.day = day;
        this.taskType = taskType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.notes = notes;
        this.taskLengthHrs = taskLengthHrs;
        this.time = time;
        this.taskQualifications = taskQualifications;
        this.assignedStaff = assignedStaff;
    }

    //Constructor for Not Assigned
    public Tasks(long taskId, String taskTitle, String location, String day, String taskType, String startDate, String endDate, String notes, double taskLengthHrs, int time, String taskQualifications) {
        this.taskId = taskId;
        this.taskTitle = taskTitle;
        this.location = location;
        this.day = day;
        this.taskType = taskType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.notes = notes;
        this.taskLengthHrs = taskLengthHrs;
        this.time = time;
        this.taskQualifications = taskQualifications;
        this.assignedStaff = null;
    }

    //Getters and Setters

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public double getTaskLengthHrs() {
        return taskLengthHrs;
    }

    public void setTaskLengthHrs(double taskLengthHrs) {
        this.taskLengthHrs = taskLengthHrs;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getTaskQualifications() {
        return taskQualifications;
    }

    public void setTaskQualifications(String taskQualifications) {
        this.taskQualifications = taskQualifications;
    }

    public String getAssignedStaff() {
        return assignedStaff;
    }

    public void setAssignedStaff(String assignedStaff) {
        this.assignedStaff = assignedStaff;
    }


    @Override
    public String toString() {
        return "Tasks [Task ID=" + taskId + ", Task Title=" + taskTitle + ", Locations=" + location + ", Day=" + day + ", Task Type=" + taskType + ", Start Date=" + startDate + ", End Date=" + endDate + ", Notes=" + notes + ", Time=" + time + ", Task Qualifications=" + taskQualifications + ", Assigned Staff=" + assignedStaff + "]";
    }
}
