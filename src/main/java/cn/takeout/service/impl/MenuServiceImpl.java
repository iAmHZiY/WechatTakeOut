package cn.takeout.service.impl;

import cn.takeout.dao.IFamilyDao;
import cn.takeout.dao.IMenuDao;
import cn.takeout.domain.Confirm;
import cn.takeout.domain.Family;
import cn.takeout.domain.Menu;
import cn.takeout.domain.MiniShowMenu;
import cn.takeout.service.IMenuService;
import cn.takeout.util.MenuSortUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("menuService")
public class MenuServiceImpl implements IMenuService {

    @Autowired
    IMenuDao menuDao;
    @Autowired
    IFamilyDao familyDao;

    @Override
    public List<MiniShowMenu> MiniShowMenuByShopId(int shopId) {
        List<MiniShowMenu> ret = new ArrayList<>();
        List<Family> families = familyDao.getFamilies(shopId);
        for (Family family : families) {
            MiniShowMenu ms = new MiniShowMenu();
            ms.setTitle(family.getFamilyName());
            ms.setTitleId(family.getUuid());
            List<Menu> menusByShopIdAndFamily = menuDao.getMenusByShopIdAndFamily(shopId, family.getUuid());
            ms.setItems(menusByShopIdAndFamily);
            ms.setFoodCount(menusByShopIdAndFamily.size());
            ret.add(ms);
        }
        return ret;
    }

    @Override
    public List<Menu> getMenusByShopId(int shopId) {
        List<Menu> menusByShopId = menuDao.getMenusByShopId(shopId);
        if (menusByShopId == null || menusByShopId.size() == 0) {
            return null;
        }
        List<Menu> ret = sortMenu(menusByShopId, shopId);
        return ret;
    }

    @Override
    public List<Menu> getMenusByShopIdAndFamily(int shopId, String family) {
        List<Menu> menusByShopIdAndFamily = menuDao.getMenusByShopIdAndFamily(shopId, family);
        if (menusByShopIdAndFamily == null || menusByShopIdAndFamily.size() == 0) {
            return null;
        }
        List<Menu> ret = sortMenu(menusByShopIdAndFamily, shopId);
        return ret;
    }

    private List<Menu> sortMenu(List<Menu> menu, int shopId) {
        List<Menu> ret = new ArrayList<>();
        String sortOrder = menuDao.getSortOrder(shopId);
        List<String> targetOrder = MenuSortUtils.stringToList(sortOrder);
        for (String s : targetOrder) {
            for (int i = 0; i < menu.size(); i++) {
                if (menu.get(i).getUuid().equals(s)) {
                    ret.add(menu.get(i));
                    menu.remove(i);
                    break;
                }
            }
        }
        return ret;
    }

    @Override
    public void addMenu(Menu menu) {
        menuDao.addMenu(menu);
        String sortOrder = menuDao.getSortOrder(menu.getShopId());
        String newSortOrder = MenuSortUtils.add(sortOrder, menu.getUuid());
        menuDao.updateSortOrder(menu.getShopId(), newSortOrder);
    }

    @Override
    public int calAmount(List<Confirm> menuList) {
        int ret = 0;
        for (Confirm confirm : menuList) {
            int price = menuDao.getPrice(confirm.getUuid());
            ret += price * confirm.getNumber();
        }
        return ret;
    }

    @Override
    public void updateMenu(Menu menu) {
        menuDao.updateMenu(menu);
    }

    @Override
    public void deleteMenu(int shopId, String uuid) {
        menuDao.deleteMenu(uuid);
        String sortOrder = menuDao.getSortOrder(shopId);
        String newSortOrder = MenuSortUtils.delete(sortOrder, uuid);
        menuDao.updateSortOrder(shopId, newSortOrder);
    }

    @Override
    public void updateSort(List<String> mySort, int shopId) {
        String s = MenuSortUtils.listToString(mySort);
        menuDao.updateSortOrder(shopId, s);
    }
}
