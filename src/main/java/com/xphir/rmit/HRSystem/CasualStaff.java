package com.xphir.rmit.HRSystem;

import java.util.List;

public class CasualStaff {
    private final long ID;
    private String firstName;
    private String lastName;
    private String title;
    private String email;
    private List<String> qualification;

    //Constructor
    public CasualStaff(long ID, String firstName, String lastName, String title, String email) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.email = email;
        this.qualification = null;
    }

    public CasualStaff(long ID, String firstName, String lastName, String title, String email, List<String> qualification) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.email = email;
        this.qualification = qualification;
    }

    //Getters and Setters
    public long getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getQualification() {
        return qualification;
    }

    public void setQualification(List<String> qualification) {
        this.qualification = qualification;
    }

    @Override
    public String toString() {
        return "CasualStaff [ID=" + ID + ", First Name=" + firstName + ", Last Name=" + lastName + ", Title=" + title + ", Email=" + email
                + ", Qualification=" + qualification + "]";
    }
}
