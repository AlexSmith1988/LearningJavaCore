package org.sandbox.sorting;

/**
 * Created by AIKuznetsov on 09.03.2017.
 */
public class InsertionSort extends SortingMetrics {

    @Override
    public int[] sort(int[] sample) {
        for (int i = 1; i < sample.length; ++i) {
            int x = sample[i];
            int j = i - 1;
            while (j >= 0 && x < sample[j]) {
                sample[j + 1] = sample[j];
                --j;
                operation();
            }
            sample[j + 1] = x;
        }

        return sample;
    }
}
