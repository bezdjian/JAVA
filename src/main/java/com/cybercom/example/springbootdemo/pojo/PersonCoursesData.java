package com.cybercom.example.springbootdemo.pojo;

public class PersonCoursesData {
    private String username;
    private String firstname;
    private String lastname;
    private String coursename;
    private String courseDescription;
    private String courseIdNumber;

    public PersonCoursesData(String username, String firstname, String lastname, String coursename, String courseDescription, String courseIdNumber) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.coursename = coursename;
        this.courseDescription = courseDescription;
        this.courseIdNumber = courseIdNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getCourseIdNumber() {
        return courseIdNumber;
    }

    public void setCourseIdNumber(String courseIdNumber) {
        this.courseIdNumber = courseIdNumber;
    }
}
