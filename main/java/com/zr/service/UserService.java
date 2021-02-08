package com.zr.service;

import com.zr.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    User findByUserName(String username);

    void add(String username);

    List<User> findAll();

    int delete(Integer userId);

    int Update(User user);

    User insertUser(User user);



    List<User> findByName(String userName);

    List<User> queryPage(int startRows);

    int getRowCount();

    int getRow();


    List<User> findUserName();

    List<User> ListUser();
}
