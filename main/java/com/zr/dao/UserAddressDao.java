package com.zr.dao;

import com.zr.model.UserAddress;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserAddressDao {


  

    List<UserAddress> select();

    List<String> findmonty();

    List<Integer> findData(String s);


    List<UserAddress> findAddress();

    List<String> findPro();

    List<String> findCity(String s);

    List<UserAddress> findCounty(String str);
}
