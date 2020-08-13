package cn.takeout.util;

import java.util.ArrayList;
import java.util.List;

public class MenuSortUtils {
    public static String delete(String sort, String uuid) {
        List<String> stringList = new ArrayList<>();
        int len = sort.length();
        String temp = "";
        String ret = "";
        for (int i = 0; i < len; i++) {
            char c = sort.charAt(i);
            if (c != '#') {
                temp += sort.charAt(i);
            } else {
                if (!temp.equals(uuid)) {
                    ret += temp + "#";
                    temp = "";
                } else {
                    temp = "";
                }
            }
        }
        if (!temp.equals(uuid))
            ret += temp + "#";
        if (ret.length() == 0) {
            return "";
        }
        return ret.substring(0, ret.length() - 1);
    }

    public static String add(String sort, String uuid) {
        if(sort.length() == 0){
            return uuid;
        }
        return sort + "#" + uuid;
    }

    public static String listToString(List<String> order){
        String ret = "";
        if(order.size() == 0){
            return ret;
        }
        for (String s : order) {
            ret = ret + s + "#";
        }
        return ret.substring(0, ret.length() - 1);
    }

    public static List<String> stringToList(String order){
        List<String> stringList = new ArrayList<>();
        int len = order.length();
        String temp = "";
        for(int i = 0; i < len;i++){
            char c = order.charAt(i);
            if (c != '#') {
                temp += order.charAt(i);
            } else {
                stringList.add(temp);
                temp = "";
            }
        }
        stringList.add(temp);
        return stringList;
    }

    public static void main(String[] args) {

    }
}