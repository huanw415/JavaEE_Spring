package com.tw.dao;

import com.tw.Util.HibernateUtil;
import com.tw.entity.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hgwang on 7/16/15.
 */
@Repository
public class EmployeeDao {
    public List<Employee> getAllEmployees(){

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        List<Employee> employees = session.createQuery("FROM Employee").list();

        session.getTransaction().commit();

        return employees;
    }

    public Employee getEmployeeById(int id){

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        String hql = "FROM Employee where id=:id";
        Query query = session.createQuery(hql);
        query.setInteger("id", id);

        Employee employee = (Employee) query.list().get(0);

        session.getTransaction().commit();

        return employee;
    }

//    public User getUserById(int id) {
//
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//
//        session.beginTransaction();
//
//        String hql = "from User where id=:id";
//        Query query = session.createQuery(hql);
//        query.setInteger("id", id);
//
//        User user = (User)query.list().get(0);
//
//        session.getTransaction().commit();
//
//        return user;
//    }

}

//public class EmployeeDao extends HibernateDaoSupport {
//
//    private SessionFactory sessionFactory;
//
//    @Autowired
//    public EmployeeDao(SessionFactory sessionfactory){
//        this.sessionFactory = sessionfactory;
//        setSessionFactory(sessionfactory);
//    }
//
//
//    public List<Employee> getAllEmployees(){
//System.out.println("++++++++++++++++++" + sessionFactory +"++++++++++++++++++");
////        Session session = getSessionFactory().getCurrentSession();
////        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
////        sessionFactory.openSession();
////        session.beginTransaction();
//        List<Employee> employees = (List<Employee>)getHibernateTemplate().find("from Employee");
////        List<Employee> employees = session.createQuery("FROM Employee").list();
////        session.getTransaction().commit();
//
//        return employees;
//    }
//}
