package org.sandbox.collections;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.TreeMap;

/**
 * Created by AIKuznetsov on 21.03.2017.
 */
public class NullTreeMap {

    public static void main(String[] args) {
        TreeMap<String, String> map = new TreeMap<>();
        map.put("Test", "42");
        System.out.println(map.get("Test"));
//        map.put(null, "24");
//        System.out.println(map.get(null));
        TreeMap<NullTreeMap, String> mapNull = new TreeMap<>();
        NullTreeMap key = new NullTreeMap();
        mapNull.put(key, "42");
        System.out.println(mapNull.get(key));
    }

    <T> void doSome(T s) {
        @SuppressWarnings("unchecked")
        T[] ts = (T[]) Array.newInstance(s.getClass(), 10);
    }

}
