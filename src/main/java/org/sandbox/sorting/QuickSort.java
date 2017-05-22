package org.sandbox.sorting;

import com.google.common.truth.Truth;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by AIKuznetsov on 22.05.2017.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] input = new Random().ints(2000, -5000, 5000).toArray();
//        int[] input = {23, 20, -48, 5, -16, 22, 47, -46, 24, -3, -21, 16, 2, 37, -21, -8, 46, 44, 23, -20};


        int[] expected = new int[input.length];
        System.arraycopy(input, 0, expected, 0, input.length);
        Arrays.sort(expected);

//        System.out.println("Qsort input:");
//        System.out.println(Arrays.toString(input));
//        System.out.println("Qsort iterations:");
        quickSort(input, 0, input.length - 1);

        Truth.assertThat(input).isEqualTo(expected);
        System.out.println(IntStream.of(input).boxed().collect(Collectors.toList()));

    }

    private static void quickSort(int[] elements, int from, int to) {
        if (from < to) {
            int pivot = elements[to];

            int g = from;
            for (int j = from ; j < to; ++j) {
                int element = elements[j];
                if (element < pivot) {
                    swap(elements, g++, j);
                }
            }
            swap(elements, g, to);
//            System.out.println("From: " + from + " To: " + to + " Pivot: " + pivot + " Left: " + g);
//            System.out.println(Arrays.toString(elements));

            quickSort(elements, from, g - 1);
            quickSort(elements, g + 1, to);
        }
    }

    private static void swap(int[] elements, int first, int second) {
        int value = elements[first];
        elements[first] = elements[second];
        elements[second] = value;
    }
}
