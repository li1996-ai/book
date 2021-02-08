package com.zr.dao;

import com.zr.model.ProCC;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProCCDao {
    List<ProCC> findPro();

    List<ProCC> findCity(String cname);

    List<ProCC> findCounty(String cname);

    Integer findId(String cname);


}
