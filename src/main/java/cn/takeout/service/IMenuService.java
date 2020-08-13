package cn.takeout.service;

import cn.takeout.domain.Confirm;
import cn.takeout.domain.Menu;
import cn.takeout.domain.MiniShowMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IMenuService {
    List<MiniShowMenu> MiniShowMenuByShopId(int shopId);
    List<Menu> getMenusByShopId(int shopId);
    List<Menu> getMenusByShopIdAndFamily(int shopId,String family);
    void addMenu(Menu menu);
    int calAmount(List<Confirm> menuList);
    void updateMenu(Menu menu);
    void deleteMenu(int shopId,String uuid);
    void updateSort(List<String> mySort, int shopId);

}
