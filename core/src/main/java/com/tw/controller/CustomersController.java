package com.tw.controller;

import com.tw.entity.Customer;
import com.tw.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by hgwang on 7/17/15.
 */
@RestController
@RequestMapping("/customers")
public class CustomersController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getCustomersPage(){
        return new ModelAndView("customers", "customers", customerService.getAllCustomers() );
    }

    @RequestMapping(value = "/creation", method = RequestMethod.GET)
    public ModelAndView getCreationPage(){
        return new ModelAndView("createCustomer");
    }

    @RequestMapping(value = "/creation", method = RequestMethod.POST)
    public ModelAndView createCustomer(@RequestParam String customerName){
        Customer customer = new Customer(customerName);
        customerService.createCustomer(customer);

        return new ModelAndView("redirect:/customers");
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView getUpdatePage(@PathVariable int id){

        return new ModelAndView("updateCustomer", "customer", customerService.getCustomerById(id));
    }
}
