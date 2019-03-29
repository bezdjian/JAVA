package com.cybercom.example.springbootdemo.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "course", schema = "mylms", catalog = "")
public class CourseEntity {
    private int id;
    private Integer categoryid;
    private String courseimage;
    private String coursename;
    private String description;
    private String idnumber;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "categoryid")
    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    @Basic
    @Column(name = "courseimage")
    public String getCourseimage() {
        return courseimage;
    }

    public void setCourseimage(String courseimage) {
        this.courseimage = courseimage;
    }

    @Basic
    @Column(name = "coursename")
    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "idnumber")
    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseEntity that = (CourseEntity) o;
        return id == that.id &&
                Objects.equals(categoryid, that.categoryid) &&
                Objects.equals(courseimage, that.courseimage) &&
                Objects.equals(coursename, that.coursename) &&
                Objects.equals(description, that.description) &&
                Objects.equals(idnumber, that.idnumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoryid, courseimage, coursename, description, idnumber);
    }
}
