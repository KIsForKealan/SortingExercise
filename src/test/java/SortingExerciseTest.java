import org.app.sorting.SortingMachine;
import org.app.sorting.algo.SortingAlgo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.app.sorting.SortingUtils.*;
import static org.app.sorting.algo.SortingAlgo.*;

public class SortingExerciseTest {

    private final SortingMachine sortingMachine = new SortingMachine();

    private final int numberOfRuns = 100;
    private final int[] inputLengths = { 10, 100, 1000 };

    @Test
    public void testSorts() {
        testBubbleSort();
        testMergeSort();
        testQuickSort();
    }

    private void testBubbleSort() {
        for (int inputLength : inputLengths) {
            testBubbleSortRandomInts(inputLength);
            testBubbleSortSortedInts(inputLength);
            testBubbleSortReverseInts(inputLength);
        }
    }

    private void testMergeSort() {
        for (int inputLength : inputLengths) {
            testMergeSortRandomInts(inputLength);
            testMergeSortSortedInts(inputLength);
            testMergeSortReverseInts(inputLength);
        }
    }

    private void testQuickSort() {
        for (int inputLength : inputLengths) {
            testQuickSortRandomInts(inputLength);
            testQuickSortSortedInts(inputLength);
            testQuickSortReverseInts(inputLength);
        }
    }

    private void testBubbleSortRandomInts(int length) {
        final long[] results = doManySorts(getRandomArray(length), numberOfRuns, BUBBLE_SORT);
        Assertions.assertNotNull(results);
        outputResult(results, BUBBLE_SORT, "random", length);
    }

    private void testBubbleSortSortedInts(int length) {
        final long[] results = doManySorts(getSortedArray(length), numberOfRuns, BUBBLE_SORT);
        Assertions.assertNotNull(results);
        outputResult(results, BUBBLE_SORT, "sorted", length);
    }

    private void testBubbleSortReverseInts(int length) {
        final long[] results = doManySorts(getReverseArray(length), numberOfRuns, BUBBLE_SORT);
        Assertions.assertNotNull(results);
        outputResult(results, BUBBLE_SORT, "reverse", length);
    }

    private void testMergeSortRandomInts(int length) {
        final long[] results = doManySorts(getRandomArray(length), numberOfRuns, MERGE_SORT);
        Assertions.assertNotNull(results);
        outputResult(results, MERGE_SORT, "random", length);
    }

    private void testMergeSortSortedInts(int length) {
        final long[] results = doManySorts(getSortedArray(length), numberOfRuns, MERGE_SORT);
        Assertions.assertNotNull(results);
        outputResult(results, MERGE_SORT, "sorted", length);
    }

    private void testMergeSortReverseInts(int length) {
        final long[] results = doManySorts(getReverseArray(length), numberOfRuns, MERGE_SORT);
        Assertions.assertNotNull(results);
        outputResult(results, MERGE_SORT, "reverse", length);
    }

    private void testQuickSortRandomInts(int length) {
        final long[] results = doManySorts(getRandomArray(length), numberOfRuns, QUICK_SORT);
        Assertions.assertNotNull(results);
        outputResult(results, QUICK_SORT, "random", length);
    }

    private void testQuickSortSortedInts(int length) {
        final long[] results = doManySorts(getSortedArray(length), numberOfRuns, QUICK_SORT);
        Assertions.assertNotNull(results);
        outputResult(results, QUICK_SORT, "sorted", length);
    }

    private void testQuickSortReverseInts(int length) {
        final long[] results = doManySorts(getReverseArray(length), numberOfRuns, QUICK_SORT);
        Assertions.assertNotNull(results);
        outputResult(results, QUICK_SORT, "reverse", length);
    }
    private long[] doManySorts(int[] items, int numberOfRuns, SortingAlgo algo) {
        long[] resultsTimes = new long[numberOfRuns];
        for (int i=0; i<numberOfRuns; i++) {
            resultsTimes[i] = (sortingMachine.doMeasuredSort(items, algo)).getTimeTaken();
        }
        return resultsTimes;
    }

}
