package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.mapper.userMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {
    @Autowired

    private userMapper usermapper;
    @RequestMapping("/hello")
//    public String index(ModelMap map) {
//        // 加入一个属性，用来在模板中读取
//        map.addAttribute("host", "http://blog.didispace.com");
//        // return模板文件的名称，对应src/main/resources/templates/index.html
//        return "index";
//    }hello
    public String index(){
        User user = new User();
        user.setName("yyy");
        user.setPassword("123456");
        usermapper.addUser(user);
        return "hello";
    }

}