package com.tw.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by hgwang on 7/20/15.
 */
@Entity
@Table(name = "SCHEDULE")
public class Schedule {
    private int id;
    private Date time;
    private Course course;

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "Time")
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
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
