package cn.takeout.controller;

import cn.takeout.constant.WechatConstant;
import cn.takeout.domain.User;
import cn.takeout.service.IUserService;
import cn.takeout.util.HttpRequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/key")
public class KeyController {
    @Autowired
    IUserService userService;

    @RequestMapping("/openId")
    @ResponseBody
    String openId(String code){
        String openId = HttpRequestUtils.sendGet("https://api.weixin.qq.com/sns/jscode2session",
                "appId=" + WechatConstant.APPID + "&secret=" + WechatConstant.SECRET
                        + "&js_code=" + code + "&grant_type=authorization_code");
//        User user = userService.checkUser(openId);
//        System.out.println(openId);
//        if(user == null){
//            userService.saveUser(openId);
//        }
        return openId;
    }
}