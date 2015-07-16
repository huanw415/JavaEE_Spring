package com.tw.dao;

import com.tw.Util.HibernateUtil;
import com.tw.entity.Employee;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hgwang on 7/16/15.
 */
@Repository
public class EmployeeDao {
    public List<Employee> getAllEmployees(){

        List<Employee> employees;

        Session session = HibernateUtil.getSessionFactory().openSession();
        employees = session.createQuery("FROM Employee").list();
        session.close();

        return employees;
    }
}
