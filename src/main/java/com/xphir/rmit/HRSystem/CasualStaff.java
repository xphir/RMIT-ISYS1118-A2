package com.xphir.rmit.HRSystem;

import java.util.List;
import java.util.ArrayList;

public class CasualStaff {
    private final long ID;
    private String firstName;
    private String lastName;
    private String title;
    private String email;
    private ArrayList<String> qualification;

    //Constructor
    /*
    public CasualStaff(long ID, String firstName, String lastName, String title, String email) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.email = email;
        this.qualification = null;
    }
    */

    public CasualStaff(long ID, String firstName, String lastName, String title, String email, ArrayList<String> qualification) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.email = email;
        this.qualification =  new ArrayList(qualification);
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

    public ArrayList getQualification() {
        return qualification;
    }

    public void setQualification(ArrayList<String> qualification) {
        this.qualification = qualification;
    }

    @Override
    public String toString() {
        return "CasualStaff [ID=" + ID + ", First Name=" + firstName + ", Last Name=" + lastName + ", Title=" + title + ", Email=" + email
                + ", Qualification=" + qualification + "]";
    }
}
