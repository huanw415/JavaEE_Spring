package com.tw.entity;

import javax.persistence.*;

/**
 * Created by hgwang on 7/7/15.
 */

@Entity
@Table(name = "user")
public class User {
    
    private int id;
    private String name;
    private String gender;
    private String email;
    private int age;
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

    @Column(name = "Gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Column(name = "Email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "Age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column(name = "Password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
