package com.example.jerseyapi.entities;

import javax.persistence.*;

/**
 * Created by bezdj on 22/04/2018.
 */
@Entity
@Table(name = "personproducts", schema = "mylms", catalog = "")
public class PersonproductsEntity {
    private int id;
    private int personid;
    private int productid;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "personid", nullable = false)
    public int getPersonid() {
        return personid;
    }

    public void setPersonid(int personid) {
        this.personid = personid;
    }

    @Basic
    @Column(name = "productid", nullable = false)
    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonproductsEntity that = (PersonproductsEntity) o;

        if (id != that.id) return false;
        if (personid != that.personid) return false;
        if (productid != that.productid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + personid;
        result = 31 * result + productid;
        return result;
    }
}
