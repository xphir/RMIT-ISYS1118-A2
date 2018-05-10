package com.xphir.rmit.gson.example;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("CasualStaff")
    @Expose
    private List<CasualStaff> casualStaff = null;

    public List<CasualStaff> getCasualStaff() {
        return casualStaff;
    }

    public void setCasualStaffData(List<CasualStaff> casualStaff) {
        this.casualStaff = casualStaff;
    }

}