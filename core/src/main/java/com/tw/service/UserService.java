package com.tw.service;

import com.tw.dao.UserDao;
import com.tw.entity.User;

import java.util.List;

public class UserService {

    private UserDao userDao = new UserDao();
    public String service() {
        return "Hello World";
    }

    public List<User> getAllUsers(){

        return userDao.getAllUsers();
    }
    public void createUser(User user){
         userDao.createUser(user);
     }

    public User getUserById(int id){
        return userDao.getUserByName(id);
    }

    public void deleteUser(User user){
        userDao.deleteUser(user);
    }

    public void updateUser(User user){
        userDao.updateUser(user);
    }
}