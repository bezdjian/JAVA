package com.cybercom.example.springbootdemo.entities;

import javax.persistence.*;

@Entity
@Table(name = "personcourse", schema = "mylms")
public class PersoncourseEntity {
    private int id;
    private Integer courseid;
    private String enddate;
    private String enrolldate;
    private Integer personid;
    private String startdate;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "courseid")
    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    @Basic
    @Column(name = "enddate")
    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    @Basic
    @Column(name = "enrolldate")
    public String getEnrolldate() {
        return enrolldate;
    }

    public void setEnrolldate(String enrolldate) {
        this.enrolldate = enrolldate;
    }

    @Basic
    @Column(name = "personid")
    public Integer getPersonid() {
        return personid;
    }

    public void setPersonid(Integer personid) {
        this.personid = personid;
    }

    @Basic
    @Column(name = "startdate")
    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    @Override
    public String toString() {
        return "PersoncourseEntity{" +
                "id=" + id +
                ", courseid=" + courseid +
                ", enddate='" + enddate + '\'' +
                ", enrolldate='" + enrolldate + '\'' +
                ", personid=" + personid +
                ", startdate='" + startdate + '\'' +
                '}';
    }
}
