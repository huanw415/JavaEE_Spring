package com.tw.controller;

import com.tw.entity.Course;
import com.tw.service.CoachService;
import com.tw.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by hgwang on 7/17/15.
 */

@RestController
@RequestMapping("/courses")
public class CoursesController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CoachService coachService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getCoursesPage(){
        List<Course> courses = courseService.getAllCourses();
        return new ModelAndView("courses", "courses", courses);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView getUpdateCoursesPage(@PathVariable int id){

        ModelAndView modelAndView = new ModelAndView("updateCourse");

        modelAndView.addObject("course", courseService.getCourseById(id));
        modelAndView.addObject("coaches", coachService.getAllCoaches());

        return modelAndView;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public void updateCourse(@PathVariable int id,
                             @RequestBody int coachId,
                             @RequestBody String courseName){
        System.out.println("=================================");
//        return "===========";
//System.out.println(coachService.getCoachById(coachId));
//        System.out.println("=================================");
//
//        Course course = new Course(id , courseName, coachService.getCoachById(coachId));
//        courseService.updateCourse(course);
    }



}