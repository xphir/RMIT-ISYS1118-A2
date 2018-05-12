package com.xphir.rmit.futurestudio;

import java.util.List;

public class GeneralInfo {
    String name;
    String website;
    List<Founder> founders;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public List<Founder> getFounders() {
        return founders;
    }

    public void setFounders(List<Founder> founders) {
        this.founders = founders;
    }
}