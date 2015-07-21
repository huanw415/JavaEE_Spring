package com.tw.dao;

import com.tw.Util.HibernateUtil;
import com.tw.entity.Course;
import com.tw.entity.Customer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hgwang on 7/17/15.
 */

@Repository
public class CustomerDao {
    public List<Customer> getAllCustomers(){

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        List<Customer> customers = session.createQuery("FROM Customer").list();

        session.getTransaction().commit();

        return customers;
    }

    public Customer getCustomerById(int customerId) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();

        Query query = session.createQuery("FROM Customer where id=:id");
        query.setInteger("id", customerId);
        Customer customer = (Customer) query.list().get(0);

        session.getTransaction().commit();

        return customer;
    }

    public void updateCourseOfCustomer(Course course, Customer customer) {

        List<Course> courses = customer.getCourses();
        courses.add(course);
        customer.setCourses(courses);

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(customer);

        session.getTransaction().commit();
    }

    public void createCustomer(Customer customer) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();
    }

    public void updateCustomer(Customer customer, String customerName) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();

        String hql = "update Customer t set t.name=:name where id=:id";
        Query query = session.createQuery(hql);
        query.setInteger("id", customer.getId());
        query.setString("name", customerName);
        query.executeUpdate();

        session.getTransaction().commit();
    }
}
