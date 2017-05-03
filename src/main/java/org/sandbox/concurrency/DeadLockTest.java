package org.sandbox.concurrency;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by AIKuznetsov on 17.10.2016.
 */
public class DeadLockTest {
    public static String padRight(String s, int n) {
        return String.format("%1$-" + n + "s", s);
    }

    public static String padLeft(String s, int n) {
        return String.format("%1$" + n + "s", s);
    }


    static Map<String, String> test = new TreeMap<>();

    public static void main(String args[]) throws Exception {
//        System.out.println("*" + padRight("Howto", 2) + "*");
//        System.out.println("*" + padLeft("Howto", 2) + "*");

        test.put(null, "TestAbstract");
        System.out.println(test.get(null));

    }
}

interface Foo {
    String test = "asd";
}
