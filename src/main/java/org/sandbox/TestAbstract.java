package org.sandbox;

/**
 * Created by AIKuznetsov on 27.03.2017.
 */
public class TestAbstract extends A {

    public static void main(String[] args) {
        new TestAbstract().doSome();
    }


}

abstract class A {

    void doSome() {
        System.out.println("It's alive");
    }

}

abstract class B {

    void doSome() {
        System.out.println("It's alive");
    }


}
