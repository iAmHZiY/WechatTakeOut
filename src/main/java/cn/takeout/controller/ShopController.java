package cn.takeout.controller;

import cn.takeout.domain.Family;
import cn.takeout.domain.Menu;
import cn.takeout.domain.Shop;
import cn.takeout.service.IMenuService;
import cn.takeout.service.IShopService;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/shop", produces = "application/json")
public class ShopController {

    @Autowired
    IMenuService menuService;

    @Autowired
    IShopService shopService;

    @RequestMapping("/addMenu")
    void addMenu(Menu menu, HttpServletRequest request, HttpServletResponse response) {
//        Shop shop = (Shop) request.getAttribute("login");
//        if(shop == null){
//            return;
//        }
//        int id = shop.getId();
        int id = 1;
        menu.setUuid(UUID.randomUUID().toString());
        menu.setShopId(id); // 设置shopid
//        System.out.println(menu);
        menuService.addMenu(menu);
    }

    @RequestMapping("/deleteMenu")
    void deleteMenu(int shopId, String uuid, HttpServletRequest request, HttpServletResponse response) {
        menuService.deleteMenu(shopId, uuid);
    }

    @RequestMapping("/login")
    Shop login(String name, String password, HttpServletRequest request) {
        Shop shop = shopService.findShop(name, password);
        if (shop != null) {
            request.setAttribute("login", shop);
        }
        return shop;
    }

    @RequestMapping("/loginStatus")
    @ResponseBody
    int loginStatus(HttpServletRequest request) {
        Object login = request.getAttribute("login");
        if (login != null) {
            return 1;
        }
        return 0;
    }

    @RequestMapping("/updateMenu")
    void updateMenu(Menu menu) {
        menuService.updateMenu(menu);
    }

    @RequestMapping("/getShop")
    @ResponseBody
    Shop getShop(int shopId) {
        Shop shopInfo = shopService.getShopInfo(shopId);
        return shopInfo;
    }

    @RequestMapping("/updateOrder")
    List<Menu> updateOrder(List<String> mySort) {
        //        Shop shop = (Shop) request.getAttribute("login");
//        if(shop == null){
//            return null;
//        }
//        int id = shop.getId();
        int id = 1;
        menuService.updateSort(mySort, id);
        return menuService.getMenusByShopId(id);
    }

    @RequestMapping("/getAllShop")
    @ResponseBody
    List<Shop> getAllShop(){
        return shopService.getAllShopInfo();
    }

}
