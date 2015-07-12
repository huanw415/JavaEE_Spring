package com.tw.entity;

import javax.persistence.*;

/**
 * Created by hgwang on 7/7/15.
 */

@Entity
@Table(name="user")
public class User {

    @Id
    @Column(name="Id")
    private int id;

    @Column(name="Name")
    private String name;

    @Column(name="Gender")
    private String gender;

    @Column(name="Email")
    private String email;

    @Column(name="Age")
    private int age;

    @Column(name="Password")
    private String password;

    public User() {
    }

    public User(String name, String gender, String email, int age, String password) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.age = age;
        this.password = password;
    }

    public User(int id, String name, String gender, String email, int age, String password) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.age = age;
        this.password = password;
    }

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
