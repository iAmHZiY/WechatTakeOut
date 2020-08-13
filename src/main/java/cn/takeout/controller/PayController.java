package cn.takeout.controller;

import cn.takeout.dao.IShopDao;
import cn.takeout.domain.Confirm;
import cn.takeout.domain.Menu;
import cn.takeout.domain.Order;
import cn.takeout.domain.Shop;
import cn.takeout.service.IMenuService;
import cn.takeout.service.IOrderService;
import cn.takeout.service.IPayService;
import cn.takeout.vo.WxPayNotifyVO;
import cn.takeout.wxpay.sdk.WXPayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping(value = "/toPay",produces = "application/json")
public class PayController {
    @Autowired
    IPayService payService;
    @Autowired
    IMenuService menuService;
    @Autowired
    IOrderService orderService;
    @Autowired
    IShopDao shopDao;
    @RequestMapping("/pay")
    @ResponseBody
    public Map<String,String> pay(HttpServletRequest request,@RequestBody Order order) throws Exception {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getRemoteAddr();
        }
        if(ip.indexOf(",") != -1){
            String[] ips = ip.split(",");
            ip = ips[0].trim();
        }

        order.setUuid(UUID.randomUUID().toString());
        order.setTotal(menuService.calAmount(order.getMenuList())); // 计算菜品总价

        orderService.createOrder(order);
        return payService.wxPay(order.getOpenId(),ip,order.getUuid());
    }
    @RequestMapping(value = "/success",produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String success(HttpServletRequest request, @RequestBody WxPayNotifyVO param) throws Exception {
        Map<String,String> result = new HashMap<String,String>();
        if("SUCCESS".equals(param.getReturn_code())){
            result.put("return_code","SUCCESS");
            result.put("return_msg","OK");
        }
        System.out.println(param);
        return WXPayUtil.mapToXml(result);
    }

    @RequestMapping("/prePay")
    @ResponseBody
    public int prePay(@RequestBody Order order){
        for (Confirm confirm : order.getMenuList()) {
            System.out.println(confirm);
        }
        return menuService.calAmount(order.getMenuList());
    }
}
