package com.adong3.fullstack.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.adong3.fullstack.base.result.PageTableRequest;
import com.adong3.fullstack.base.result.Results;
import com.adong3.fullstack.dao.UserDao;
import com.adong3.fullstack.model.SysUser;
import com.adong3.fullstack.service.UserService;
import com.adong3.fullstack.service.impl.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("user")
public class UserController {
    @Resource
    UserDao userDao;

    @Autowired
    UserService service;

    // @GetMapping("/list")
    // @ResponseBody
    // public SysUser userList() {
    // System.out.println(userDao.countAllUsers());
    // System.out.println(userDao.getUser("alex"));
    // SysUser su = userDao.getUser("alex");
    // // su.setUsername("hi");
    // // System.out.println(su);
    // // return "userlist";
    // return su;
    // }
    @GetMapping("/list")
    @ResponseBody
    public Results<SysUser> getUsers(String username) {
        ArrayList<SysUser> list = new ArrayList<>();
        SysUser su = service.getUser("alex");
        list.add(su);
        Results<SysUser> re = Results.success("success", 1000, list);
        // return Results.success("success", 1000, list);
        return re;
    }

    @GetMapping("/{username}")
    @ResponseBody
    public SysUser getUserByName(@PathVariable String username, Model model) {
        SysUser su = userDao.getUser(username);
        // model.addAttribute("username", su.getEmail());
        return su;
    }

    @RequestMapping("/")
    public String first() {
        return "index";
    }
}