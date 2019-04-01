package com.cybercom.example.springbootdemo.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "person", schema = "mylms")
public class PersonEntity {

    private int id;
    private String accounttype;
    private String companylocation;
    private String companyname;
    private String companyservices;
    private String country;
    private String email;
    private String firstname;
    private String fullName;
    private String gender;
    private String lastname;
    private String password;
    private String profileImage;
    private String role;
    private String username;

    private List<PersoncourseEntity> personcourse;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "accounttype")
    public String getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(String accounttype) {
        this.accounttype = accounttype;
    }

    @Basic
    @Column(name = "companylocation")
    public String getCompanylocation() {
        return companylocation;
    }

    public void setCompanylocation(String companylocation) {
        this.companylocation = companylocation;
    }

    @Basic
    @Column(name = "companyname")
    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    @Basic
    @Column(name = "companyservices")
    public String getCompanyservices() {
        return companyservices;
    }

    public void setCompanyservices(String companyservices) {
        this.companyservices = companyservices;
    }

    @Basic
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "firstname")
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "fullName")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "lastname")
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "profileImage")
    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @OneToMany(targetEntity = PersoncourseEntity.class,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "personid")
    public List<PersoncourseEntity> getPersoncourse() {
        return personcourse;
    }

    public void setPersoncourse(List<PersoncourseEntity> personcourse) {
        this.personcourse = personcourse;
    }
}
