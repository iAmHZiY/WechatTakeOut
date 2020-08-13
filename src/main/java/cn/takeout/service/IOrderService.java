package cn.takeout.service;

import cn.takeout.domain.Order;

import java.util.List;

public interface IOrderService {
    void createOrder(Order order);
    List<Order> getOrderList(String openId,int param);
    Order getOrderDetail(String openId,String uuid);
}
