package org.app.sorting.timed;

import org.app.sorting.algo.SortingAlgo;

public final class TimedSortResult {

    public TimedSortResult(int[] items, long timeTaken, SortingAlgo algo) {
        this.items = items;
        this.timeTaken = timeTaken;
        this.algo = algo;
    }

    private final int[] items;
    private final long timeTaken;

    private final SortingAlgo algo;

    public int[] getItems() {
        return items;
    }

    public long getTimeTaken() {
        return timeTaken;
    }

    public SortingAlgo getAlgo() {
        return algo;
    }
}
