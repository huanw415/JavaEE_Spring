package com.tw.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by hgwang on 7/16/15.
 */
@Entity
@Table(name = "COURSE")
public class Course {

    private int id;
    private String name;
    private Coach coach;
    private List<Customer> customers;

    public Course() {
    }

    public Course(int id, String name, Coach coach) {
        this.id = id;
        this.name = name;
        this.coach = coach;
    }

    @Id
    @Column(name = "Id")
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CoachId")
    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "CUSTOMER_COURSE",
            joinColumns = {@JoinColumn(name = "CourseId")},
            inverseJoinColumns = {@JoinColumn(name = "CustomerId")})
    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
