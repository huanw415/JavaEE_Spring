package com.tw.entity;

import javax.persistence.*;

/**
 * Created by hgwang on 7/17/15.
 */
@Entity
@Table(name="employee")
public class Coach {
    private int id;
    private String name;
    private User user;


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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="UserId")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
