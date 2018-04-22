package com.example.jerseyapi.entities;

import javax.persistence.*;

/**
 * Created by bezdj on 22/04/2018.
 */
@Entity
@Table(name = "personcourse", schema = "mylms", catalog = "")
public class PersoncourseEntity {
    private int id;
    private Integer courseid;
    private String enddate;
    private String enrolldate;
    private Integer personid;
    private String startdate;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "courseid", nullable = true)
    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    @Basic
    @Column(name = "enddate", nullable = true, length = 255)
    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    @Basic
    @Column(name = "enrolldate", nullable = true, length = 255)
    public String getEnrolldate() {
        return enrolldate;
    }

    public void setEnrolldate(String enrolldate) {
        this.enrolldate = enrolldate;
    }

    @Basic
    @Column(name = "personid", nullable = true)
    public Integer getPersonid() {
        return personid;
    }

    public void setPersonid(Integer personid) {
        this.personid = personid;
    }

    @Basic
    @Column(name = "startdate", nullable = true, length = 255)
    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersoncourseEntity that = (PersoncourseEntity) o;

        if (id != that.id) return false;
        if (courseid != null ? !courseid.equals(that.courseid) : that.courseid != null) return false;
        if (enddate != null ? !enddate.equals(that.enddate) : that.enddate != null) return false;
        if (enrolldate != null ? !enrolldate.equals(that.enrolldate) : that.enrolldate != null) return false;
        if (personid != null ? !personid.equals(that.personid) : that.personid != null) return false;
        if (startdate != null ? !startdate.equals(that.startdate) : that.startdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (courseid != null ? courseid.hashCode() : 0);
        result = 31 * result + (enddate != null ? enddate.hashCode() : 0);
        result = 31 * result + (enrolldate != null ? enrolldate.hashCode() : 0);
        result = 31 * result + (personid != null ? personid.hashCode() : 0);
        result = 31 * result + (startdate != null ? startdate.hashCode() : 0);
        return result;
    }
}
