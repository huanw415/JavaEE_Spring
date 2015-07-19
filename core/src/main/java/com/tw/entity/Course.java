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
    private Employee employee;
    private List<Customer> customers;

    public Course() {
    }

    public Course(int id, String name, Employee employee) {
        this.id = id;
        this.name = name;
        this.employee = employee;
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

    @ManyToOne(fetch = FetchType.LAZY, targetEntity=Employee.class)
    @JoinColumn(name = "CoachId")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
//    public Coach getCoach() {
//        return coach;
//    }
//
//    public void setCoach(Coach coach) {
//        this.coach = coach;
//    }

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
