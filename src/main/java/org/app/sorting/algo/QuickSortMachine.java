package org.app.sorting.algo;

import org.app.sorting.timed.TimedSort;

public class QuickSortMachine implements TimedSort {

    private void quickSort(int[] items, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(items, begin, end);

            quickSort(items, begin, partitionIndex-1);
            quickSort(items, partitionIndex+1, end);
        }
    }

    private int partition(int[] items, int begin, int end) {
        int pivot = items[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (items[j] <= pivot) {
                i++;

                int swapTemp = items[i];
                items[i] = items[j];
                items[j] = swapTemp;
            }
        }

        int swapTemp = items[i+1];
        items[i+1] = items[end];
        items[end] = swapTemp;

        return i+1;
    }

    @Override
    public int[] doSort(int[] items) {
        quickSort(items, 0, items.length-1);
        return items;
    }

    @Override
    public SortingAlgo getSortType() {
        return SortingAlgo.QUICK_SORT;
    }

}
