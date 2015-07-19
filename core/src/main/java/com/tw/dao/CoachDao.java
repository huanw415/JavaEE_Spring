package com.tw.dao;

import com.tw.Util.HibernateUtil;
import com.tw.entity.Coach;
import com.tw.entity.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hgwang on 7/17/15.
 */
@Repository
public class CoachDao {
    public List<Employee> getAllCoaches(){

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        List<Employee> employees = session.createQuery("FROM Employee where role= coach").list();
//        List<Coach> Coaches = session.createQuery("FROM Employee where role= coach").list();

        session.getTransaction().commit();

        return employees;

//        return Coaches;
    }

    public Coach getCoachById(int id) {
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//
//        session.beginTransaction();
//
//        String hql = "FROM Employeee where id=:id";
//        Query query = session.createQuery(hql);
//        query.setInteger("id", id);
//
//        Coach coach = (Coach)query.list().get(0);
//
//        session.getTransaction().commit();
//        return coach;
        return null;
    }
}