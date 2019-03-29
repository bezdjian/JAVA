package com.cybercom.example.springbootdemo.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "personproducts", schema = "mylms", catalog = "")
public class PersonproductsEntity {
    private int id;
    private Integer personid;
    private Integer productid;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "productid")
    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonproductsEntity that = (PersonproductsEntity) o;
        return id == that.id &&
                Objects.equals(personid, that.personid) &&
                Objects.equals(productid, that.productid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, personid, productid);
    }
}
