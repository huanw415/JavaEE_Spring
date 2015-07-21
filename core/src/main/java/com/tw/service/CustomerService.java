package com.tw.service;

import com.tw.dao.CustomerDao;
import com.tw.entity.Course;
import com.tw.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hgwang on 7/17/15.
 */
@Service
public class CustomerService {

    @Autowired
    CustomerDao customerDao;

    public List<Customer> getAllCustomers(){
        return customerDao.getAllCustomers();
    }

    public Customer getCustomerById(int customerId) {
        return customerDao.getCustomerById(customerId);
    }

    public List<Customer> getCustomersWithOutPrivate(){
        List<Customer> customers = customerDao.getAllCustomers();
        List<Customer> customerResultList = new ArrayList<Customer>();


        for (Customer customer : customers) {
            int times = 0;

            List<Course> courses = customer.getCourses();

            for (Course course : courses) {

                if (course.getName().equals("private")) {
                    times++;
                }
            }

            if (times == 0) {
                customerResultList.add(customer);
            }
        }
        return customerResultList;
    }

    public void updateCourseOfCustomer(Course course, Customer customer) {
        customerDao.updateCourseOfCustomer(course, customer);
    }

    public void createCustomer(Customer customer) {
        customerDao.createCustomer(customer);
    }
}
