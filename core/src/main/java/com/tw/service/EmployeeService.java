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
    private EmployeeDao employeeDao;

    public List<Employee> getAllEmployees(){
        return employeeDao.getAllEmployees();
    }
    public Employee getEmployeeById(int id){
        return employeeDao.getEmployeeById(id);
    }

    public void updateEmployee(Employee employee){
        employeeDao.updateEmployee(employee);
    }
}