package com.tw.dao;

import com.tw.Util.HibernateUtil;
import com.tw.entity.Course;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hgwang on 7/17/15.
 */
@Repository
public class CourseDao {
    public List<Course> getAllCourses(){

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        List<Course> courses = session.createQuery("FROM Course").list();

        session.getTransaction().commit();

        return courses;
    }
}