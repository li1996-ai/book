package com.zr.service.impl;

import com.zr.dao.UserDao;

import com.zr.model.User;
import com.zr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public List<User> findByName(String userName) {
        return userDao.findUserByName(userName);
    }

    @Override
    public List<User> queryPage(int startRows) {

        return userDao.queryPage(startRows);
    }

    public List<User> ListUser() {
        return userDao.ListUser();
    }

    public List<User> queryPage(Integer starRows) {
        return userDao.queryPage(starRows);
    }

    public int getRowCount() {
        int count= userDao.getRowCount();
        return count;
    }

    @Override
    public int getRow() {
        return userDao.getRow();
    }

    @Override
    public List<User> findUserName() {
        return userDao.findUserName();
    }


    public User insertUser(User user) {
        userDao.insertUser(user);
        return user;
    }

    public int delete(int userId) {
        return userDao.delete(userId);
    }

    @Override
    public User findByUserName(String username) {
        return null;
    }

    @Override
    public void add(String username) {

    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public int delete(Integer userId) {

        return userDao.delete(userId);
    }

    public int Update(User user) {
        return userDao.Update(user);
    }


}