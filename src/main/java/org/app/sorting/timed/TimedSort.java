package org.app.sorting.timed;

public interface TimedSort extends Sort {
    default TimedSortResult doMeasuredSort(int[] items) {

        int[] sortedItems = items.clone();

        long before = System.nanoTime();
        int[] sorted = doSort(sortedItems);
        long after = System.nanoTime();

//        System.err.println("Input: "+Arrays.toString(items));
//        System.err.println("Output: "+Arrays.toString(sorted));

        return new TimedSortResult(
                sorted,
                (after-before),
                getSortType()
        );
    }

}
