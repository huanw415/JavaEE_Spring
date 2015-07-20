package com.tw.controller;

import com.tw.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by hgwang on 7/20/15.
 */

@RestController
@RequestMapping(value = "/schedules")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getSchedulesPage(){
        System.out.println("=========================");
        System.out.println(scheduleService.getAllSchedules().size());
        System.out.println("=========================");

        return new ModelAndView("schedules", "schedules", scheduleService.getAllSchedules());
    }
}
