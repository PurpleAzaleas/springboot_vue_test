package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {
    @Resource
    private UserService userService;
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("regist")
    public Map<String, Object> regist(@RequestBody User user){
        logger.debug("==============");
        Map<String, Object> map = new HashMap<String, Object>();
        User u = userService.queryOne(user.getUsername());
        if(u == null){
            if(user.getPassword()!=null){
                userService.add(user);
                map.put("regist", true);
            }else {
                map.put("regist", false);
                map.put("errorPassword", "未输入密码");
            }
        }else {
            map.put("regist", false);
            map.put("errorUsername", "用户名已存在");
        }
        return map;
    }

    @RequestMapping("login")
    public Map<String, Object> login(@RequestBody User user){
        Map<String, Object> map = new HashMap<String, Object>();
        User u = userService.queryOne(user.getUsername());
        if(u != null){
            if(u.getPassword().equals(user.getPassword())){
                map.put("login", true);
            }else {
                map.put("login", false);
                map.put("errorPassword", "密码输入有误");
            }
        }else {
            map.put("login", false);
            map.put("errorUsername", "用户名不存在");
        }
        return map;
    }
}
