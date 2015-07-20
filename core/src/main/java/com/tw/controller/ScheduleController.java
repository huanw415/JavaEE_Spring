package com.tw.controller;

import com.tw.entity.Schedule;
import com.tw.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
}
