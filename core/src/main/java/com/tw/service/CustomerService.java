package com.tw.service;

import com.tw.dao.CustomerDao;
import com.tw.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
