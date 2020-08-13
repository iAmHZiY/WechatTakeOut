package cn.takeout.domain;

import java.io.Serializable;
import java.util.List;

public class MiniShowMenu implements Serializable {
    String titleId; // familyUuid
    String title; // familyName
    int foodCount;
    List<Menu> items;

    @Override
    public String toString() {
        return "MiniShowMenu{" +
                "titleId='" + titleId + '\'' +
                ", title='" + title + '\'' +
                ", foodCount=" + foodCount +
                ", items=" + items +
                '}';
    }

    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getFoodCount() {
        return foodCount;
    }

    public void setFoodCount(int foodCount) {
        this.foodCount = foodCount;
    }

    public List<Menu> getItems() {
        return items;
    }

    public void setItems(List<Menu> items) {
        this.items = items;
    }
}
