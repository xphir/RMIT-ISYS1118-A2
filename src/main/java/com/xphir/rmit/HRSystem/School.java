package com.xphir.rmit.HRSystem;

import java.util.List;

//SCHOOL
public class School {
    private String schoolName;
    private String schoolCode;
    private List<Department> Department;

    public School(String schoolName, String schoolCode, List<Department> department) {
        this.schoolName = schoolName;
        this.schoolCode = schoolCode;
        Department = department;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolCode() {
        return schoolCode;
    }

    public void setSchoolCode(String schoolCode) {
        this.schoolCode = schoolCode;
    }

    public List<Department> getDepartment() {
        return Department;
    }

    public void setDepartment(List<Department> department) {
        Department = department;
    }

    //DEPARTMENT
    public static class Department {
        private String departmentName;
        private String departmentCode;
        private List<Course> Course;

        public Department(String departmentName, String departmentCode, List<Course> course) {
            this.departmentName = departmentName;
            this.departmentCode = departmentCode;
            Course = course;
        }

        public String getDepartmentName() {
            return departmentName;
        }

        public void setDepartmentName(String departmentName) {
            this.departmentName = departmentName;
        }

        public String getDepartmentCode() {
            return departmentCode;
        }

        public void setDepartmentCode(String departmentCode) {
            this.departmentCode = departmentCode;
        }

        public List<Course> getCourse() {
            return Course;
        }

        public void setCourse(List<Course> course) {
            Course = course;
        }

        //COURSE
        public static class Course {
            private String courseName;
            private String courseCode;

            public Course(String courseName, String courseCode) {
                this.courseName = courseName;
                this.courseCode = courseCode;
            }

            public String getCourseName() {
                return courseName;
            }

            public void setCourseName(String courseName) {
                this.courseName = courseName;
            }

            public String getCourseCode() {
                return courseCode;
            }

            public void setCourseCode(String courseCode) {
                this.courseCode = courseCode;
            }
        }
    }
}