package com.zr.model;

import java.util.Map;

public class UserAddress {

    private String province;

    private String county;

    private String city;

//    private UserAddressCity userAddressCity;
//
//
//    private String b_city;
//
//    private String c_county;


//    public UserAddressCity getUserAddressCity() {
//        return userAddressCity;
//    }
//
//    public void setUserAddressCity(UserAddressCity userAddressCity) {
//        this.userAddressCity = userAddressCity;
//    }
//
//    public String getB_city() {
//        return b_city;
//    }
//
//    public void setB_city(String b_city) {
//        this.b_city = b_city;
//    }
//
//    public String getC_county() {
//        return c_county;
//    }
//
//    public void setC_county(String c_county) {
//        this.c_county = c_county;
//    }




    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setData(Map<String, Object> objectHashMap) {
    }

    public void setStatusCode(int i) {
    }
}
