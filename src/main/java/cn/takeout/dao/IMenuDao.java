package cn.takeout.dao;

import cn.takeout.domain.Menu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMenuDao {
    List<Menu> getMenusByShopId(int shopId);
    List<Menu> getMenusByShopIdAndFamily(@Param("shopId") int shopId,@Param("family") String family);
    Menu getMenuByUuid(String uuid);
    void addMenu(Menu menu);
    int getPrice(String uuid);
    void updateMenu(Menu menu);
    String getSortOrder(int shopId);
    void updateSortOrder(@Param("shopId") int shopId,@Param("newOrder") String newOrder);
    void deleteMenu(String uuid);
}
