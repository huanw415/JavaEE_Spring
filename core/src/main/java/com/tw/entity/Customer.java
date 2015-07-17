package com.tw.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by hgwang on 7/16/15.
 */

@Entity
@Table(name="CUSTOMER")
public class Customer {
    private int id;
    private String name;
    private List<Course> courses;

    @Id
    @Column(name="Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "customers")
    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
