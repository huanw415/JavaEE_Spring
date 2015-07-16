package com.tw.dao;

import com.tw.Util.HibernateUtil;
import com.tw.entity.User;
import org.hibernate.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hgwang on 7/7/15.
 */
@Repository
public class UserDao {

    public List<User> getUsersByName(String name) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "from User where name=:name";
        Query query = session.createQuery(hql);
        query.setString("name", name);

        return query.list();
    }

    public User getUserById(int id) {


        Session session = HibernateUtil.getSessionFactory().openSession();

        String hql = "from User where id=:id";
        Query query = session.createQuery(hql);
        query.setInteger("id", id);

        return (User) query.list().get(0);
    }

    public List<User> getAllUsers() {

        List<User> users;

        Session session = HibernateUtil.getSessionFactory().openSession();

        users = session.createQuery("FROM User").list();
//        session.close();

        return users;
    }

    public void createUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        //创建事务对象
        session.beginTransaction();

        session.save(user);

        //提交事务对象
        session.getTransaction().commit();
//        session.close();
    }

    public void deleteUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        session.delete(user);

        session.getTransaction().commit();
//        session.close();
    }

    public void updateUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();

//        session.close();
    }
}