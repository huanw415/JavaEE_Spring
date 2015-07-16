package com.tw.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by hgwang on 7/16/15.
 */

@Entity
@Table(name="employee")
public class Coach {

    @Id
    @Column(name="Id")
    private int id;

    @Column(name="Name")
    private String name;

    @Column(name="Role")
    private String role;

    @Column(name="UserId")
    private int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
