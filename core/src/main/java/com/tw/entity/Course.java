package com.tw.entity;

import javax.persistence.*;

/**
 * Created by hgwang on 7/16/15.
 */
@Entity
@Table(name = "COURSE")
public class Course {

    private int id;
    private String name;
    private Employee coach;

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
    public Employee getCoach() {
        return coach;
    }

    public void setCoach(Employee coach) {
        this.coach = coach;
    }
}
