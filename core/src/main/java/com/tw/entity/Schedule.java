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

    public Schedule() {
    }

    public Schedule(int id, String time) {
        this.id = id;
        this.time = time;
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
}
