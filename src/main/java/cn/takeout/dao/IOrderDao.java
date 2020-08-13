package cn.takeout.dao;

import cn.takeout.domain.Confirm;
import cn.takeout.domain.Menu;
import cn.takeout.domain.Order;
import org.apache.ibatis.annotations.Param;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderDao {
    void createOrder(Order order);

    void createOrderMenu(@Param("orderUuid") String orderUuid, @Param("confirm") Confirm confirm);

    List<Order> getOrders(@Param("openId") String openId,@Param("param") int param);

    List<Order> getAllOrder(String openId); //所有订单 -1

    Order getOneOrder(@Param("openId") String openId,@Param("uuid") String uuid);
    List<Confirm> getOrderDetail(String uuid);

//    List<Order> getNoPayOrder(String openId); // 待付款的订单 0
//    List<Order> getPayAlreadyOrder(String openId); // 已付款的订单 1
//    List<Order> getDeliveringOrder(String openId); // 骑手已经接单的订单/配送中 2
//    List<Order> getFinishOrder(String openId); // 正常完成的订单 3
//    List<Order> getCancelOrder(String openId); //取消的订单 4


}
