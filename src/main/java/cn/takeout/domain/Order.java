package cn.takeout.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Order implements Serializable {
    String shopName;
    String uuid;
    String openId;
    int shopId;
    int delivery;
    int total;
    String address;
    int status;
    Date addTime;
    List<Confirm> menuList;

    @Override
    public String toString() {
        return "Order{" +
                "shopName='" + shopName + '\'' +
                ", uuid='" + uuid + '\'' +
                ", openId='" + openId + '\'' +
                ", shopId=" + shopId +
                ", delivery=" + delivery +
                ", total=" + total +
                ", address='" + address + '\'' +
                ", status=" + status +
                ", addTime=" + addTime +
                ", menuList=" + menuList +
                '}';
    }

    public Order() {
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }


    public List<Confirm> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Confirm> menuList) {
        this.menuList = menuList;
    }


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public int getDelivery() {
        return delivery;
    }

    public void setDelivery(int delivery) {
        this.delivery = delivery;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}
