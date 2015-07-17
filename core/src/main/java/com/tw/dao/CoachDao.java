package com.tw.dao;

import com.tw.Util.HibernateUtil;
import com.tw.entity.Coach;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hgwang on 7/17/15.
 */
@Repository
public class CoachDao {
    public List<Coach> getAllCoaches(){

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        List<Coach> Coaches = session.createQuery("FROM Coach").list();

        session.getTransaction().commit();

        return Coaches;
    }
}