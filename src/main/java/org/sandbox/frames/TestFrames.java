package org.sandbox.frames;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by AIKuznetsov on 03.05.2017.
 */
public class TestFrames {

    static Runnable r = new Runnable() {
        @Override
        public void run() {

        }
    };

    public static void main(String[] args) {

        List<Integer> object = new ArrayList<>();

        byte[] test = new byte[100];
        new TestFrames().new Rnd().nextBytes(test);

        Arrays.sort(test);

        System.out.println(Arrays.toString(test));
    }

    class Rnd {

        void nextBytes(byte[] bytes) {
            new Random().nextBytes(bytes);
        }

    }

    static void consume(List<? extends Foo> producer) {
        Foo foo = producer.get(0);

    }

    static void produce(List<? super Boo> consumer) {
        Boo boo = new Boo(10, "test2");
        consumer.add(boo);
    }
}

class Foo {
    private final int value;

    public Foo(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "value=" + value +
                '}';
    }
}

class Boo extends Foo {
    private final String message;

    public Boo(int value, String message) {
        super(value);
        this.message = message;
    }

    @Override
    public String toString() {
        return "Boo{" +
                "message='" + message + '\'' +
                '}';
    }
}

