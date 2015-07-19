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

        String hql = "FROM Employee where Role=:role";
        Query query = session.createQuery(hql);
        query.setString("role", "coach");
        List<Employee> employees = query.list();

        session.getTransaction().commit();

        return employees;
    }

    public Employee getCoachById(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();

        String hql = "FROM Employeee where id=:id";
        Query query = session.createQuery(hql);
        query.setInteger("id", id);

        Employee employee = (Employee)query.list().get(0);

        session.getTransaction().commit();
        return employee;
    }
}