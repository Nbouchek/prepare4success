package com.codility.nacer.collections;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapDemo {
    public static void main(String[] args) {
        Map<String, String> partList = new TreeMap<>();
        partList.put("s001", "Blue Polo Shirt");
        partList.put("s002", "Black Polo Shirt");
        partList.put("h001", "Duke Hat");
        partList.put("s002", "Black t-shirt");

        Set<String> keys = partList.keySet();
        System.out.println("----- Part List -----");

        for (String key: keys) {
            System.out.println("Part # " + key + ",  " + partList.get(key));
        }
    }
}
