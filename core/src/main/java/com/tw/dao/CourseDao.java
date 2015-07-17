package com.tw.dao;

import com.tw.Util.HibernateUtil;
import com.tw.entity.Course;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Queue;

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

    public Course getCourseById(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();

        String hql = "FROM Course where id=:id";
        Query query = session.createQuery(hql);
        query.setInteger("id", id);

        Course course = (Course)query.list().get(0);

        session.getTransaction().commit();
        return course;
    }
}