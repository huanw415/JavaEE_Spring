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
    private int userId;

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
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
