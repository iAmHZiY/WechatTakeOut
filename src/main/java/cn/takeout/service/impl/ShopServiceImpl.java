package cn.takeout.service.impl;

import cn.takeout.dao.IFamilyDao;
import cn.takeout.dao.IShopDao;
import cn.takeout.domain.Family;
import cn.takeout.domain.Shop;
import cn.takeout.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("shopService")
public class ShopServiceImpl implements IShopService {
    @Autowired
    IShopDao shopDao;

    @Autowired
    IFamilyDao familyDao;

    @Override
    public Shop findShop(String name, String password) {
        Shop shop = shopDao.findShop(name,password);
        return shop;
    }

    @Override
    public Shop getShopInfo(int shopId) {
        Shop shopInfo = shopDao.getShopInfo(shopId);
        shopInfo.setAddTime(null);
        shopInfo.setOpenId(null);
        shopInfo.setPassword(null);
        System.out.println(shopInfo);
        return shopInfo;
    }

    @Override
    public void addFamily(String familyName, int shopId) {
        Family family = new Family(shopId,familyName);
        familyDao.addFamily(family);
    }

    @Override
    public List<Family> getFamilies(int shopId) {
       return familyDao.getFamilies(shopId);
    }

    @Override
    public void deleteFamily(String family) {
        familyDao.deleteFamily(family);
    }

    @Override
    public List<Shop> getAllShopInfo() {
        List<Shop> allShopInfo = shopDao.getAllShopInfo();
        for (Shop shop : allShopInfo) {
            shop.setPassword("");
            shop.setOpenId("");
        }
        return allShopInfo;
    }
}