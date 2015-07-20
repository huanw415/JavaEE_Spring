package com.tw.service;

import com.tw.dao.CourseDao;
import com.tw.dao.ScheduleDao;
import com.tw.entity.Course;
import com.tw.entity.Employee;
import com.tw.entity.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hgwang on 7/20/15.
 */
@Service
public class ScheduleService {

    @Autowired
    private ScheduleDao scheduleDao;

    @Autowired
    private CourseDao courseDao;

    public List<Schedule> getAllSchedules(){
        return scheduleDao.getAllSchedules();
    }

    public Schedule getScheduleById(int id){
        return scheduleDao.getScheduleById(id);
    }

    public void updateSchedule(Schedule schedule){
        scheduleDao.updateSchedule(schedule);
    }

    public List<String> getTimeListOfCourse(int courseId) {

        Employee employee = courseDao.getCourseById(courseId).getEmployee();
        List<Course> courses = courseDao.getCourseByCoach(employee);

        List<String> timeList = new ArrayList<String>();

        for(int i=0; i<courses.size(); i++){
            List<Schedule> scheduleList = scheduleDao.getTimeListOfCourse(courses.get(i));
            for(int j=0; j<scheduleList.size(); j++){
                timeList.add(scheduleList.get(j).getTime());
            }
        }

        return timeList;
    }

    public void createSchedule(int courseId, String time) {
        Course course = courseDao.getCourseById(courseId);
        Schedule schedule = new Schedule(time, course);

        courseDao.createSchedule(schedule);
    }
}
