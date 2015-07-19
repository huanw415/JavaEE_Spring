package com.tw.controller;

import com.tw.entity.Employee;
import com.tw.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping(value = "update/{id}", method = RequestMethod.POST)
    public ModelAndView updateEmployee(@PathVariable int id,
                               @RequestParam String employeeName,
                               @RequestParam String role){

        Employee employee = new Employee(id, employeeName, role);
        employeeService.updateEmployee(employee);
        return new ModelAndView("redirect:/employees");
//        return new ModelAndView("updateEmployee", "employee", employeeService.getEmployeeById(id));
    }
}