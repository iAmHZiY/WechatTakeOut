package cn.takeout.service.impl;

import cn.takeout.dao.IMenuDao;
import cn.takeout.dao.IOrderDao;
import cn.takeout.dao.IShopDao;
import cn.takeout.domain.Confirm;
import cn.takeout.domain.Menu;
import cn.takeout.domain.Order;
import cn.takeout.service.IOrderService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    IOrderDao orderDao;
    @Autowired
    IShopDao shopDao;
    @Autowired
    IMenuDao menuDao;

    @Override
    public void createOrder(Order order) {
        int delivery = shopDao.getDelivery(order.getShopId()); // 配送费
        order.setDelivery(delivery);
        order.setTotal(order.getTotal() + delivery); // 菜品总价+配送费
        orderDao.createOrder(order);
        for (int i = 0; i < order.getMenuList().size(); i++) {
            Menu menu = menuDao.getMenuByUuid(order.getMenuList().get(i).getUuid());
            order.getMenuList().get(i).setMoney(menu.getMoney());
            order.getMenuList().get(i).setPic(menu.getPic());
            order.getMenuList().get(i).setTitle(menu.getTitle());
            orderDao.createOrderMenu(order.getUuid(), order.getMenuList().get(i));
        }
    }

    @Override
    public List<Order> getOrderList(String openId, int param) {
        List<Order> ret;
        if(param == -1){
            //所有订单
           ret = orderDao.getAllOrder(openId);
        } else {
            ret = orderDao.getOrders(openId, param);
        }
        //获取到列表，并未获取menuList
        return ret;
    }

    @Override
    public Order getOrderDetail(String openId, String uuid) {
        Order order = orderDao.getOneOrder(openId, uuid);
        order.setMenuList(orderDao.getOrderDetail(uuid));
        return order;
    }
}
