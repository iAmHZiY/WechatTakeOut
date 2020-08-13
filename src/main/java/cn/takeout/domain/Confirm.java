package cn.takeout.domain;

import java.io.Serializable;

public class Confirm implements Serializable {

    String uuid;
    int number;
    String title;
    String pic;
    int money;

    @Override
    public String toString() {
        return "Confirm{" +
                "uuid='" + uuid + '\'' +
                ", number=" + number +
                ", title='" + title + '\'' +
                ", pic='" + pic + '\'' +
                ", money=" + money +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
