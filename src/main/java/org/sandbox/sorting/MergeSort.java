package org.sandbox.sorting;

import com.google.common.truth.Truth;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by AIKuznetsov on 03.05.2017.
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] input = new Random().ints(20, -50, 50).toArray();

        int[] expected = new int[input.length];
        System.arraycopy(input, 0, expected, 0, input.length);
        Arrays.sort(expected);

        mergeSort(input);

        Truth.assertThat(input).isEqualTo(expected);
        System.out.println(IntStream.of(input).boxed().collect(Collectors.toList()));
    }

    // O(n) memory complexity
    private static int[] mergeBuf;

    private static void mergeSort(int[] input) {
        int length = input.length;
        if (mergeBuf == null || mergeBuf.length < length)
            mergeBuf = new int[length];

        mergeSort(input, 0, length - 1);
    }

    private static void mergeSort(int[] input, int from, int to) {
        if (from < to) {
            // O(1)
            int center = (from + to) >> 1;
            mergeSort(input, from, center);
            mergeSort(input, center + 1, to);

            // O(n) for each level of Divide and Conquer, log n levels => O(n log n)
            merge(input, from, center, to);
        }
    }

    private static void merge(int[] input, int from, int center, int to) {
        System.arraycopy(input, from, mergeBuf, from, center - from + 1);
        System.arraycopy(input, center + 1, mergeBuf, center + 1, to - center);

        int r = from, l = from, h = center + 1;
        while (l <= center && h <= to) {
            if (mergeBuf[l] < mergeBuf[h]) {
                input[r++] = mergeBuf[l++];
            } else {
                input[r++] = mergeBuf[h++];
            }
        }
        while (l <= center) {
            input[r++] = mergeBuf[l++];
        }
        while (h <= to) {
            input[r++] = mergeBuf[h++];
        }
    }
}
