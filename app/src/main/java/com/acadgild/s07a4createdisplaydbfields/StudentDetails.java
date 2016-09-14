package com.acadgild.s07a4createdisplaydbfields;

/**
 * Created by sunny on 9/14/16.
 */
public class StudentDetails
{

    private int id;
    private String fName;
    private String lName;

    public StudentDetails() { }

    public StudentDetails(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
    }

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    public String getFName() { return fName; }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }
}
