package cn.takeout.controller;

import cn.takeout.domain.User;
import cn.takeout.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/user",produces = "application/json")
public class UserController {
    @Autowired
    IUserService userService;

    @RequestMapping("/saveUser")
    void saveUser(String openId, HttpServletRequest request, HttpServletResponse response) {
        User user = userService.checkUser(openId);
        if(user == null){
            userService.saveUser(openId);
        }
    }

    @RequestMapping("/checkUserExist")
    @ResponseBody
    User checkUser(String openId, HttpServletRequest request, HttpServletResponse response) {
        return userService.checkUser(openId);
    }
}
