package org.sandbox.sorting;

/**
 * Created by AIKuznetsov on 09.03.2017.
 */
public class SortingMetrics implements Infrastructure {

    private long count;

    @Override
    public long operation() {
        return ++count;
    }

    @Override
    public long reset() {
        long shelf = count;
        count = 0;
        return shelf;
    }


}
