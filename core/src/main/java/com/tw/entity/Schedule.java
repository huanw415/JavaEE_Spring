package com.tw.entity;

import javax.persistence.*;

/**
 * Created by hgwang on 7/20/15.
 */
@Entity
@Table(name = "SCHEDULE")
public class Schedule {
    private int id;
    private String time;
    private Course course;
    private Customer customer;

    public Schedule() {
    }

    public Schedule(int id, String time) {
        this.id = id;
        this.time = time;
    }

    public Schedule(String time, Course course) {
        this.time = time;
        this.course = course;
    }

    public Schedule(String time, Course course, Customer customer) {
        this.time = time;
        this.course = course;
        this.customer = customer;
    }

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "Time")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Course.class)
    @JoinColumn(name="CourseId")
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Customer.class)
    @JoinColumn(name="PrivateCustomerId")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
