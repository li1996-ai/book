package com.zr.controller;

import com.zr.dao.ProCCDao;
import com.zr.dao.UserAddressDao;
import com.zr.dao.UserDao;
import com.zr.model.ProCC;
import com.zr.model.User;

import com.zr.model.UserAddress;
import com.zr.service.UserAddressService;
import com.zr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserAddressService userAddressService;

    @Autowired
    UserDao userDao;

    @Autowired
    UserAddressDao userAddressDao;

    @Autowired
    ProCCDao proCCDao;

    /**
     * 通过用户id删除用户
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Integer delete(Integer userId) {

        int result = userService.delete(userId);
        return result;
    }

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String update(User user) {
        int result = userService.Update(user);
        if (result >= 1) {
            return "修改成功";
        } else {
            return "修改失败";
        }
    }

    /**
     * 插入用户
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public User insert(User user) {
        return userService.insertUser(user);
    }

    /**
     * 查询所有
     *
     * @return
     */
    @RequestMapping(value = "/ListUser")
    @ResponseBody
    public List<User> ListUser() {
        return userService.ListUser();
    }

    /**
     * 通过名字查询  模糊查询
     *
     * @param userName
     * @return
     */
    @RequestMapping(value = "/ListByName")
    @ResponseBody
    public List<User> ListUserByName(String userName) {
        return userService.findByName(userName);
    }

    @RequestMapping(value = "/findName")
    @ResponseBody
    public String findName(String userName) {
        System.out.println(userName);
        return userDao.findName(userName);
    }

    /**
     * 查询页数
     * @param page
     * @return
     */
    @RequestMapping(value ="/page")
    @ResponseBody
    public List<User> page(Integer page) {
        int pageNow = page == null ? 1 : page;//传入的页数是null  就查询第一页   否则就根据传入的页数进行查询
        int pageSize=5;
        int startRows = pageSize * (pageNow - 1);//开始的行数
        List<User> list = userService.queryPage(startRows);
        return list;
    }

    @RequestMapping(value ="rows")
    @ResponseBody
    public int rows(){
        return userService.getRow();
    }

    @RequestMapping(value ="findUsername")
    @ResponseBody
    public List<User> findUsername(){
        return userService.findUserName();
    }

    @RequestMapping(value ="select")
    @ResponseBody
    public List<UserAddress> select(){
        return userAddressService.findUserName();
    }

    @RequestMapping(value ="username")
    @ResponseBody
    public List<String> findAllUser() {
       List<String>  stringList = userDao.findUser(); //姓名集合
        return stringList;
    }

    @RequestMapping(value ="sumusername")
    @ResponseBody
    public List<Integer> findSumUser() {
        List<String> stringList = userDao.findUser(); //姓名集合
        List<Integer> integerList1=new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {
            List<Integer> integerList = userDao.count(i);
            for(int j = 0; j < integerList.size(); j++){
               integerList1.add(integerList.get(j));
            }
        }
        return integerList1;
    }

    @RequestMapping(value ="monty")
    @ResponseBody
    public Map<String, Object> findAllMonty() {
        UserAddress userAddress = new UserAddress();
        List<Integer> integerList1=new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        List<String> monty = userAddressDao.findmonty();

        for(String s:monty){
            List<Integer> data = userAddressDao.findData(s);
            for(int j = 0; j < data.size(); j++){
                integerList1.add(data.get(j));
            }
        }
        map.put("monty", monty);
        map.put("integerList1", integerList1);
        userAddress.setData(map);
        userAddress.setStatusCode(200);
//        System.out.println(map);
        return map;
    }

    @RequestMapping(value ="findPro")
    @ResponseBody
    public List<ProCC> findPro() {
        List<ProCC> province = proCCDao.findPro(); //省份集合
        return province;
    }

    @RequestMapping(value = "/findCity" ,method = RequestMethod.POST)
    @ResponseBody
    public List<ProCC> findCity(String cname) {
//     Integer a=proCCDao.findId(cname);
     List<ProCC> city = proCCDao.findCity(cname); //省份集合
        return city;
    }

    @RequestMapping(value = "/findCounty" ,method = RequestMethod.POST)
    @ResponseBody
    public List<ProCC> findCounty(String cname) {
        List<ProCC> county = proCCDao.findCounty(cname); //省份集合
        return county;
    }
}

