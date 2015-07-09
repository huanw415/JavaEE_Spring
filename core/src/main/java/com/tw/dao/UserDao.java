package com.tw.dao;

import com.tw.Util.HibernateUtil;
import com.tw.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by hgwang on 7/7/15.
 */
public class UserDao {

    public User getUserByName(int id){


        Session session = HibernateUtil.getSessionFactory().openSession();

        String hql="from User where id=:id";
        Query query = session.createQuery(hql);
        query.setInteger("id", id);

        return (User) query.list().get(0);
    }

    public List<User> getAllUsers(){

        List<User> users;

        Session session = HibernateUtil.getSessionFactory().openSession();

        users = session.createQuery("FROM User").list();
        session.close();

        return users;
    }

    public void createUser(User user){
        Session session = HibernateUtil.getSessionFactory().openSession();

        //创建事物对象
        session.beginTransaction();

        session.save(user);

        //送出事物对象
        session.getTransaction().commit();
        session.close();
    }

    public void deleteUser(User user){
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        session.delete(user);

        session.getTransaction().commit();
        session.close();
    }

    public void updateUser(User user){
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();

        session.close();
    }
}