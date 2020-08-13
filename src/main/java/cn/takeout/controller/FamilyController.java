package cn.takeout.controller;

import cn.takeout.domain.Family;
import cn.takeout.domain.Menu;
import cn.takeout.service.IMenuService;
import cn.takeout.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value = "/family", produces = "application/json")
public class FamilyController {

    @Autowired
    IShopService shopService;
    @Autowired
    IMenuService menuService;

    @RequestMapping("/addFamily")
    void addFamily(String familyName, int shopId, HttpServletResponse response, HttpServletRequest request) {
        shopService.addFamily(familyName, shopId);
    }

    @RequestMapping("/getFamilies")
    @ResponseBody
    List<Family> getFamilies(int shopId) {
        return shopService.getFamilies(shopId);
    }

    @RequestMapping("/isEmpty")
    @ResponseBody
    int checkFamilyEmpty(String family, int shopId) {
        List<Menu> menusByShopIdAndFamily = menuService.getMenusByShopIdAndFamily(shopId, family);
        if (menusByShopIdAndFamily == null || menusByShopIdAndFamily.size() == 0) {
            return 1;
        }
        return 0;
    }

    @RequestMapping("/delete")
    @ResponseBody
    List<Family> delete(String family, int shopId) {
        shopService.deleteFamily(family);
        return shopService.getFamilies(shopId);
    }


}
