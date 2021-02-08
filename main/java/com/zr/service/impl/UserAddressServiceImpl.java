package com.zr.service.impl;

import com.zr.dao.UserAddressDao;
import com.zr.model.UserAddress;
import com.zr.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAddressServiceImpl implements UserAddressService {

    @Autowired
    private UserAddressDao userAddressDao;

    @Override
    public List<UserAddress> findUserName() {
        return userAddressDao.select();
    }
}
