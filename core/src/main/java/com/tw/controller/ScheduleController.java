package com.tw.controller;

import com.tw.entity.Schedule;
import com.tw.service.CourseService;
import com.tw.service.CustomerService;
import com.tw.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by hgwang on 7/20/15.
 */

@RestController
@RequestMapping(value = "/schedules")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getSchedulesPage(){
        return new ModelAndView("schedules", "schedules", scheduleService.getAllSchedules());
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView getUpdatePage(@PathVariable int id){
        return new ModelAndView("updateSchedule", "schedule", scheduleService.getScheduleById(id));
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ModelAndView updateSchedule(@PathVariable int id,
                              @RequestParam String time){

        Schedule schedule = new Schedule(id, time);
        scheduleService.updateSchedule(schedule);

        return new ModelAndView("redirect:/schedules");
    }

    @RequestMapping(value = "/creation", method = RequestMethod.GET)
    public ModelAndView getCreatePage(){

        ModelAndView modelAndView = new ModelAndView("createSchedule");

        modelAndView.addObject("courses", courseService.getAllCourses());
        modelAndView.addObject("customers", customerService.getAllCustomers());


        return modelAndView;
    }

    @RequestMapping(value = "/creation", method = RequestMethod.POST)
    public String createSchedule(@RequestParam int courseId,
                                 @RequestParam int customerId,
                                 @RequestParam String time){

        List<String> timeList = scheduleService.getTimeListOfCourse(courseId);

        if(timeList.contains(time)){
            return "coach is busy";
        }else{
            scheduleService.createSchedule(courseId, customerId, time);
            return "coach is not busy";
        }
    }

    @RequestMapping(value = "/deletion/{id}", method = RequestMethod.DELETE)
    public void deleteSchedule(@PathVariable int id){
        scheduleService.deleteScheduleById(id);
    }
}
