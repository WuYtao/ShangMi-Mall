package com.hp.utils;

import java.util.ArrayList;
import java.util.List;

public class ArrayListData {
    public static ArrayList listData(List list) {
        ArrayList<Object> objects = new ArrayList<>();
        long getId1 = list.size() / 5;
        getId1 = list.size() % 5 != 0 ? getId1 + 1 : getId1;
        ArrayList<Object> object = null;
        for (int i = 0; i < getId1; i++) {
            object = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                if ((i * 5 + j) > list.size() - 1)
                    break;
                object.add(list.get(i * 5 + j));
            }
            objects.add(object);
        }
        return objects;
    }
}
