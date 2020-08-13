package cn.takeout.service;

import cn.takeout.domain.Family;
import cn.takeout.domain.Shop;

import java.util.List;

public interface IShopService {
    Shop findShop(String name,String password);
    Shop getShopInfo(int shopId);
    void addFamily(String familyName,int shopId);
    List<Family> getFamilies(int shopId);
    void deleteFamily(String family);
    List<Shop> getAllShopInfo();
}
