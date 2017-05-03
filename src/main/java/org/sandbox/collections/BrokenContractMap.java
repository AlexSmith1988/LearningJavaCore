package org.sandbox.collections;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AIKuznetsov on 28.04.2017.
 */
public class BrokenContractMap {

    public static void main(String[] args) {
        Map<Foo, String> testSubject = new HashMap<>();
        Foo key = new Foo(1, 2);
        testSubject.put(key, "42");
        testSubject.put(new Foo(2, 2), "4242");
        Foo key1 = new Foo(1, 2);
        testSubject.put(key1, "424242");

        System.out.println(testSubject.get(key));
        System.out.println(testSubject.get(key1));
    }
}

class Foo {
    int x, y;

    public Foo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Foo)) {
            return false;
        }
        Foo objF = (Foo) obj;
        return x == objF.x && y == objF.y;
    }
}