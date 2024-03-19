package org.app.sorting;

import org.app.sorting.algo.*;
import org.app.sorting.timed.TimedSort;
import org.app.sorting.timed.TimedSortResult;

public class SortingMachine {

    private final BubbleSortMachine bubble = new BubbleSortMachine();
    private final MergeSortMachine merge = new MergeSortMachine();
    private final QuickSortMachine quick = new QuickSortMachine();

    private TimedSort getSortingAlgo(SortingAlgo algo) {
        switch (algo) {
            case BUBBLE_SORT:
                return bubble;
            case MERGE_SORT:
                return merge;
            case QUICK_SORT:
                return quick;
            default:
                return null;
        }
    }

    public TimedSortResult doMeasuredSort(int[] items, SortingAlgo algo) {

        final TimedSort sortingAlgo = getSortingAlgo(algo);
        if (sortingAlgo == null) {
            return null;
        }

        return sortingAlgo.doMeasuredSort(items);
    }
}

