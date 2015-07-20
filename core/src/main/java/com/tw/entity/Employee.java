package com.tw.entity;

import javax.persistence.*;

/**
 * Created by hgwang on 7/16/15.
 */

@Entity
@Table(name="employee")
public class Employee {

    private int id;
    private String name;
    private String role;
    private User user;

    public Employee() {
    }

    public Employee(String name, String role, User user) {
        this.name = name;
        this.role = role;
        this.user = user;
    }

    public Employee(int id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    @Id
    @Column(name="Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="Role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="UserId")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
