package com.tw.controller;

import com.tw.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by hgwang on 7/19/15.
 */
@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getEmployeesPage(){
        return new ModelAndView("employees", "employees", employeeService.getAllEmployees());
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public ModelAndView getEmployeesUpdatePage(@PathVariable int id){

        return new ModelAndView("updateEmployee", "employee", employeeService.getEmployeeById(id));
    }
}