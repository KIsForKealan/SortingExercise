package org.app.sorting.timed;

import org.app.sorting.algo.SortingAlgo;

public interface Sort {

    int[] doSort(int[] items);

    SortingAlgo getSortType();

}
