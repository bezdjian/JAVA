package com.cybercom.example.springbootdemo.rest.responses;

import com.cybercom.example.springbootdemo.entities.PersonEntity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonResponse {
    @XmlElement
    private String username;
    @XmlElement
    private String firstname;
    @XmlElement
    private String lastname;
    @XmlElement
    private String email;
    @XmlElement
    private String country;
    @XmlElement
    private String role;
    @XmlElement
    private String accounttype;
    @XmlElement
    private String companylocation;
    @XmlElement
    private String companyname;
    @XmlElement
    private String companyservices;

    public PersonResponse(PersonEntity entity) {
        this.username = entity.getUsername();
        this.firstname = entity.getFirstname();
        this.lastname = entity.getLastname();
        this.email = entity.getEmail();
        this.country = entity.getCountry();
        this.role = entity.getRole();
        this.accounttype = entity.getAccounttype();
        this.companylocation = entity.getCompanylocation();
        this.companyname = entity.getCompanyname();
        this.companyservices = entity.getCompanyservices();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(String accounttype) {
        this.accounttype = accounttype;
    }

    public String getCompanylocation() {
        return companylocation;
    }

    public void setCompanylocation(String companylocation) {
        this.companylocation = companylocation;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getCompanyservices() {
        return companyservices;
    }

    public void setCompanyservices(String companyservices) {
        this.companyservices = companyservices;
    }

    @Override
    public String toString() {
        return "PersonResponse{" +
                "username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                ", role='" + role + '\'' +
                ", accounttype='" + accounttype + '\'' +
                ", companylocation='" + companylocation + '\'' +
                ", companyname='" + companyname + '\'' +
                ", companyservices='" + companyservices + '\'' +
                '}';
    }
}
