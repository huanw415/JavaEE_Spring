package com.tw.service;

import com.tw.dao.CourseDao;
import com.tw.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hgwang on 7/17/15.
 */
@Service
public class CourseService {

    @Autowired
    private CourseDao courseDao;

    public List<Course> getAllCourses(){
        return courseDao.getAllCourses();
    }

    public Course getCourseById(int id){
        return courseDao.getCourseById(id);
    }

    public void updateCourse(Course course){
        courseDao.updateCourse(course);
    }
    public void createCourse(Course course){
        courseDao.createCourse(course);
    }
}
