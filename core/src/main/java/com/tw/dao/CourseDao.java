package com.tw.dao;

import com.tw.Util.HibernateUtil;
import com.tw.entity.Coach;
import com.tw.entity.Course;
import com.tw.entity.Employee;
import com.tw.entity.Schedule;
import com.tw.service.CourseService;
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

    public void updateCourse(Course course) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.update(course);
        session.getTransaction().commit();
    }

    public void createSchedule(Schedule schedule) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.save(schedule);
        session.getTransaction().commit();
    }

    public List<Course> getCourseByCoach(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        Query query= session.createQuery("FROM Course where employee=:employee");
        query.setParameter("employee", employee);
        List<Course> courses = query.list();

        session.getTransaction().commit();

        return courses;
    }
}