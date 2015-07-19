package com.tw.service;

import com.tw.dao.CoachDao;
import com.tw.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hgwang on 7/17/15.
 */
@Service
public class CoachService {

    @Autowired
    private CoachDao coachDao;

    public List<Employee> getAllCoaches(){
    return coachDao.getAllCoaches();
}

    public Employee getCoachById(int id){
        return coachDao.getCoachById(id);
    }
}
