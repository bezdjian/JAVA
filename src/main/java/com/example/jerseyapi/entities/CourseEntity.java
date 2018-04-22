package com.example.jerseyapi.entities;

import javax.persistence.*;

/**
 * Created by bezdj on 22/04/2018.
 */
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
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "categoryid", nullable = true)
    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    @Basic
    @Column(name = "courseimage", nullable = true, length = 255)
    public String getCourseimage() {
        return courseimage;
    }

    public void setCourseimage(String courseimage) {
        this.courseimage = courseimage;
    }

    @Basic
    @Column(name = "coursename", nullable = true, length = 255)
    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 5000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "idnumber", nullable = true, length = 255)
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

        if (id != that.id) return false;
        if (categoryid != null ? !categoryid.equals(that.categoryid) : that.categoryid != null) return false;
        if (courseimage != null ? !courseimage.equals(that.courseimage) : that.courseimage != null) return false;
        if (coursename != null ? !coursename.equals(that.coursename) : that.coursename != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (idnumber != null ? !idnumber.equals(that.idnumber) : that.idnumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (categoryid != null ? categoryid.hashCode() : 0);
        result = 31 * result + (courseimage != null ? courseimage.hashCode() : 0);
        result = 31 * result + (coursename != null ? coursename.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (idnumber != null ? idnumber.hashCode() : 0);
        return result;
    }
}
