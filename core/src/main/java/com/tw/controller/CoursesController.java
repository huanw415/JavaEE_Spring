package com.tw.controller;

import com.tw.entity.Course;
import com.tw.service.CoachService;
import com.tw.service.CourseService;
import com.tw.service.EmployeeService;
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

    @Autowired
    private EmployeeService employeeService;

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

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public void updateCourse(@PathVariable int id,
                             @RequestParam int coachId,
                             @RequestParam String courseName){

        Course course = new Course(id,courseName, coachService.getCoachById(coachId));
        courseService.updateCourse(course);
    }

    @RequestMapping(value = "/creation", method = RequestMethod.GET)
    public ModelAndView getCreationPage(){
        return new ModelAndView("createCourse", "coaches", coachService.getAllCoaches());
    }

    @RequestMapping(value = "/creation", method = RequestMethod.POST)
    public ModelAndView createCourse(@RequestParam String courseName,
                                     @RequestParam String coachName){

        Course course = new Course(courseName, employeeService.getEmployeeByName(coachName));
        courseService.createCourse(course);
        return new ModelAndView("redirect:/courses");
    }
}