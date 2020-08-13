package cn.takeout.test;

import cn.takeout.dao.*;
import cn.takeout.domain.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestMybatis {
    @Test
    public void run(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        IUserDao userDao = (IUserDao) ac.getBean("IUserDao");
        IAddsDao addsDao = (IAddsDao) ac.getBean("IAddsDao");
        IMenuDao menuDao = (IMenuDao) ac.getBean("IMenuDao");
        IShopDao shopDao = (IShopDao) ac.getBean("IShopDao");
        IOrderDao orderDao = (IOrderDao) ac.getBean("IOrderDao");
        IFamilyDao familyDao = (IFamilyDao) ac.getBean("IFamilyDao");
        List<Confirm> orderDetail = orderDao.getOrderDetail("f354e168-bcf9-4029-ad46-d15c6eba764b");
        for (Confirm confirm : orderDetail) {
            System.out.println(confirm);
        }


    }
}
