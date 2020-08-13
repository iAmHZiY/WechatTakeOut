package cn.takeout.domain;

import java.io.Serializable;
import java.util.Date;

public class Menu implements Serializable {
    String uuid;
    int shopId;
    String title;
    int monthSell;
    int good;
    int money;
    String detail;
    String pic;
    String family;
    String note;
    Date addTime;

    @Override
    public String toString() {
        return "Menu{" +
                "uuid='" + uuid + '\'' +
                ", shopId=" + shopId +
                ", title='" + title + '\'' +
                ", monthSell=" + monthSell +
                ", good=" + good +
                ", money=" + money +
                ", detail='" + detail + '\'' +
                ", pic='" + pic + '\'' +
                ", family='" + family + '\'' +
                ", note='" + note + '\'' +
                ", addTime=" + addTime +
                '}';
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMonthSell() {
        return monthSell;
    }

    public void setMonthSell(int monthSell) {
        this.monthSell = monthSell;
    }

    public int getGood() {
        return good;
    }

    public void setGood(int good) {
        this.good = good;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}
