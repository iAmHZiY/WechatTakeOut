package cn.takeout.controller;

import cn.takeout.domain.Menu;
import cn.takeout.domain.MiniShowMenu;
import cn.takeout.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/menu",produces = "application/json")
public class MenuController {
    @Autowired
    IMenuService menuService;

    @RequestMapping("/getMenusByShopId")
    @ResponseBody
    List<MiniShowMenu>  getMenusById(int shopId){
        List<MiniShowMenu> miniShowMenus = menuService.MiniShowMenuByShopId(shopId);
        return miniShowMenus;
    }

    @RequestMapping("/getMenusByShopIdAndFamily")
    @ResponseBody
    List<Menu> getMenusByShopIdAndFamily(int shopId,String family){
        return menuService.getMenusByShopIdAndFamily(shopId,family);
    }
}
