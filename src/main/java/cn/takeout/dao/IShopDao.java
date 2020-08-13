package cn.takeout.dao;

import cn.takeout.domain.Menu;
import cn.takeout.domain.Shop;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IShopDao {
    Shop findShop(@Param("name") String name,@Param("password") String password);
    Shop getShopInfo(int shopId);
    int getDelivery(int shopId);
    List<Shop> getAllShopInfo();
}
