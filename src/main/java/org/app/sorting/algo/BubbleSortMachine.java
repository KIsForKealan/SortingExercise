package org.app.sorting.algo;

import org.app.sorting.timed.TimedSort;

public class BubbleSortMachine implements TimedSort {

    @Override
    public int[] doSort(int[] items) {
        int i = 0, n = items.length;
        while (i < n - 1) {
            for (int j = 1; j < n - i; j++) {
                if (items[j - 1] > items[j]) {
                    int temp = items[j - 1];
                    items[j - 1] = items[j];
                    items[j] = temp;
                }
            }
            i++;
        }
        return items;
    }

    @Override
    public SortingAlgo getSortType() {
        return SortingAlgo.BUBBLE_SORT;
    }


}
