package com.tw.service;

import com.tw.dao.EmployeeDao;
import com.tw.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hgwang on 7/16/15.
 */

@Service
public class EmployeeService {

    @Autowired
    private static EmployeeDao employeeDao;

    public static List<Employee> getAllEmployees(){
        return employeeDao.getAllEmployees();
    }
}