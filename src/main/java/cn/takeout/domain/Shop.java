package cn.takeout.domain;

import java.io.Serializable;
import java.util.Date;

public class Shop implements Serializable {
    int id;
    String openId;
    String name;
    String announcement;
    int star;
    String pic;
    int monthSell;
    int startTakeOut;
    int delivery;
    int average;
    String password;
    Date addTime;

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", openId='" + openId + '\'' +
                ", name='" + name + '\'' +
                ", announcement='" + announcement + '\'' +
                ", star=" + star +
                ", pic='" + pic + '\'' +
                ", monthSell=" + monthSell +
                ", startTakeOut=" + startTakeOut +
                ", delivery=" + delivery +
                ", average=" + average +
                ", password='" + password + '\'' +
                ", addTime=" + addTime +
                '}';
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public int getMonthSell() {
        return monthSell;
    }

    public void setMonthSell(int monthSell) {
        this.monthSell = monthSell;
    }

    public int getStartTakeOut() {
        return startTakeOut;
    }

    public void setStartTakeOut(int startTakeOut) {
        this.startTakeOut = startTakeOut;
    }

    public int getDelivery() {
        return delivery;
    }

    public void setDelivery(int delivery) {
        this.delivery = delivery;
    }

    public int getAverage() {
        return average;
    }

    public void setAverage(int average) {
        this.average = average;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}
