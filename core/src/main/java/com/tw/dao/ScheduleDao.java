package com.tw.dao;

import com.tw.Util.HibernateUtil;
import com.tw.entity.Schedule;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hgwang on 7/20/15.
 */
@Repository
public class ScheduleDao {

    public List<Schedule> getAllSchedules(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        List<Schedule> schedules = session.createQuery("from Schedule").list();
        session.getTransaction().commit();

        return schedules;
    }
}
