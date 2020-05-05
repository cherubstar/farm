package com.roper.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.roper.entity.User;

@Controller
@RequestMapping("authc")
public class AuthcController {
    @RequestMapping("anyuser")
    public ModelAndView anyuser() {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getSession().getAttribute("user");
        System.out.println(user);
        return new ModelAndView("inner");
    }

    @RequestMapping("admin")
    public ModelAndView admin() {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getSession().getAttribute("user");
        System.out.println(user);
        return new ModelAndView("inner");
    }
}