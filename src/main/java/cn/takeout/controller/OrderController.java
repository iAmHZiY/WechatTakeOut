package cn.takeout.controller;

import cn.takeout.domain.Order;
import cn.takeout.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/order",produces = "application/json")
public class OrderController {
    @Autowired
    IOrderService orderService;
    @RequestMapping("/getOrderList")
    @ResponseBody
    List<Order> getOrderList(String openId,int param){
        List<Order> orderList = orderService.getOrderList(openId, param);
        return orderList;
    }

    @RequestMapping("/getDetail")
    @ResponseBody
    Order getDetail(String openId,String uuid){
        Order orderDetail = orderService.getOrderDetail(openId, uuid);
        return orderDetail;
    }


}
