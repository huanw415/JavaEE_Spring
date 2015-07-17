package com.tw.controller;

import com.tw.entity.Course;
import com.tw.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getCoursesPage(){
        List<Course> courses = courseService.getAllCourses();
        return new ModelAndView("courses", "courses", courses);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView getUpdateCoursesPage(@PathVariable int id){

        return new ModelAndView("updateCourse", "course", courseService.getCourseById(id));
    }

//    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
//    public ModelAndView getUpdateUserAge(@PathVariable int id) {
//
//        User user = userService.getUserById(id);
//        return createModelAndView("updateUser", "user", user);
//    }
//
//    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
//    public ModelAndView UpdateUser(@PathVariable int id,
//                                   @RequestParam String name,
//                                   @RequestParam String gender,
//                                   @RequestParam String email,
//                                   @RequestParam int age,
//                                   @RequestParam String password){
//        User user = new User(id, name, gender, email, age, Md5Util.md5(password));
//        userService.updateUser(user);
//
//        return new ModelAndView("redirect:/users");
//    }

}