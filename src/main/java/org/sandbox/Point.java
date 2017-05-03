package org.sandbox;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by AIKuznetsov on 13.10.2016.
 */
public class Point {
    private int x;
    private int y;

    public static void main(String[] args) {
        Map<Test, String> test = new TreeMap<>();
        System.out.println("Test enum" + " " + Test.t1.hashCode() + " " + Test.t2.hashCode() + " " + Test.t1.hashCode() + " " + Test.t2.hashCode());
        System.out.println("Test enum " + Test.t1.equals(Test.t2) + " " + Test.t1.equals(Test.t1));

        Point a = new Point(5, 5);
        Set set = new HashSet();
        set.add(a);
        a.setX(8);
        System.out.println(set.contains(a));
        set.add(a);
        System.out.println(set.size());
        set.remove(a);
        System.out.println(set.size());
        set.remove(a);
        System.out.println(set.size());
    }

    enum Test {
        t1, t2
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Point other = (Point) obj;
        return (other.x == this.x) && (other.y == this.y);
    }

    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.x;
        hash = 31 * hash + this.y;
        return hash;
    }
}