package com.cybercom.example.springbootdemo.rest.responses;

import com.cybercom.example.springbootdemo.entities.CourseEntity;
import com.cybercom.example.springbootdemo.entities.PersonEntity;
import com.cybercom.example.springbootdemo.entities.PersoncourseEntity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonCoursesResponse {
    @XmlElement
    private String username;
    @XmlElement
    private String firstname;
    @XmlElement
    private String lastname;
    @XmlElement
    private String coursename;
    @XmlElement
    private String courseDescription;
    @XmlElement
    private String courseIdNumber;

    public PersonCoursesResponse(PersonEntity pe, CourseEntity c) {
        this.username = pe.getUsername();
        this.firstname = pe.getFirstname();
        this.lastname = pe.getLastname();
        this.coursename = c.getCoursename();
        this.courseIdNumber = c.getIdnumber();
        this.courseDescription = c.getDescription();
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

    @Override
    public String toString() {
        return "PersonCoursesResponse{" +
                "username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", coursename='" + coursename + '\'' +
                ", courseDescription='" + courseDescription + '\'' +
                ", courseIdNumber='" + courseIdNumber + '\'' +
                '}';
    }
}
