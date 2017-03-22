package org.sandbox.sorting;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by AIKuznetsov on 09.03.2017.
 */
public interface Infrastructure {
    Random random = new Random();

    default int[] generateTestSample(int size) {
        return IntStream.range(0, size).map(l -> random.nextInt(size * 2 / 3)).toArray();
    }

    default boolean checkOrdered(int[] sample) {
        for (int i = 0; i < sample.length - 1; ++i) {
            if (sample[i] > sample[i + 1]) {
                return false;
            }
        }
        return true;
    }

    default int sortSample(int sampleSize) {
        int[] sample = generateTestSample(sampleSize);
        print(sample);
        int[] sort = sort(sample);
        print(sort);
        if (!checkOrdered(sort)) {
            throw new IllegalStateException("sort hasn't worked out");
        }
        return 0;
    }

    default void analyze() {
        int sortSampleSize = 10;
        long previous = 1;
        for (int i = 0; i < 7; ++i) {
            sortSample(sortSampleSize *= 4);
            long current = reset();
            System.out.println(sortSampleSize + " elements - " + current + " operations, times " + current / previous + " more");
            previous = current;
        }
    }

    default int[] sort(int[] sample) {
        return IntStream.of(sample).sorted().toArray();
    }

    default void print(int[] sample) {
        IntStream.of(sample).limit(100).forEach(element -> System.out.print(element + " "));
        System.out.println();
    }

    default void swap(int[] sample, int first, int second) {
        int shelf = sample[first];
        sample[first] = sample[second];
        sample[second] = shelf;
    }

    long operation();

    long reset();

}
