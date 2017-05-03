package org.sandbox.basic;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by AIKuznetsov on 04.04.2017.
 */
public class Sandbox1<T> {

    int field = 42;

    int field2 = -10;

    float field3 = 0.2f;

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        System.out.println(Integer.valueOf('\uDBFF'));

        long start = System.currentTimeMillis();
        System.out.println(IntStream.range(0, 50000).parallel().mapToObj(String::valueOf).reduce(String::concat).get().substring(1, 10));
        System.out.println("Elapsed: " + (System.currentTimeMillis() - start));

        System.out.println("Test");

        ArrayList<String> strings = new ArrayList<>();
        strings.add("asdas");
        strings.add("asdasdas");
        System.out.println(strings);

        int a = 300;

        System.out.println(a);

        System.out.println(0.3 + 0.2);

        System.out.println(Sandbox1.class.getConstructor().newInstance().hashCode());
        System.out.println(Sandbox1.class.getMethod("hashCode").invoke(new Sandbox1()));

        System.out.println(Runtime.getRuntime().freeMemory());

        List<? super Integer> list = new ArrayList<>();

        list.add(Integer.getInteger("10"));

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sandbox1 sandbox1 = (Sandbox1) o;

        if (field != sandbox1.field) return false;
        if (field2 != sandbox1.field2) return false;
        return Float.compare(sandbox1.field3, field3) == 0;

    }

    @Override
    public int hashCode() {
        int result = field;
        result = 31 * result + field2;
        result = 31 * result + (field3 != +0.0f ? Float.floatToIntBits(field3) : 0);
        return result;
    }
}

class Foo extends Cool implements Bar, Rod {

    @Override
    public void doSome() {
        System.out.println("Foo");
    }

}

abstract class Cool {
    private void doSome() {
        System.out.println("Cool");
    }
}

interface Bar {
    default void doSome() {
        System.out.println("Bar");
    }

}

interface Rod {
    default void doSome() {
        System.out.println("Rod");
    }
}
