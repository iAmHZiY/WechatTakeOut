package cn.takeout.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class Family implements Serializable {
    String uuid;
    int shopId;
    String familyName;
    Date addTime;

    public Family(int shopId, String familyName) {
        this.shopId = shopId;
        this.familyName = familyName;
        this.setUuid(UUID.randomUUID().toString());
    }
    public Family() { }

    @Override
    public String toString() {
        return "Family{" +
                "uuid='" + uuid + '\'' +
                ", shopId=" + shopId +
                ", familyName='" + familyName + '\'' +
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

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}
