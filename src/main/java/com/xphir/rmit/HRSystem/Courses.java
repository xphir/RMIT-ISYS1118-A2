package com.xphir.rmit.HRSystem;

public class Courses {
    private String schoolCode;
    private String deptCode;
    private String courseCode;
    private String courseName;

    //Constructor
    public Courses(String schoolCode, String deptCode, String courseCode, String courseName) {
        this.schoolCode = schoolCode;
        this.deptCode = deptCode;
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    //Getters
    public String getCourseCode() {
        return courseCode;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public String getSchoolCode() {
        return schoolCode;
    }

    public String getCourseName() {
        return courseName;
    }

    @Override
    public String toString() {
        return "Courses [School Code=" + schoolCode + ", First Name=" + deptCode + ", Course Code=" + courseCode + ", Course Name=" + courseName + "]";
    }
}