package org.app.sorting;

import org.app.sorting.algo.SortingAlgo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class SortingUtils {

    public static int[] getRandomArray(int length) {
        Random random = new Random();
        int[] randomArray = new int[length];
        for (int i = 0; i < length; i++) {
            randomArray[i] = random.nextInt(length);
        }
        return  randomArray;
    }

    public static int[] getSortedArray(int length) {
        int[] sortedArray = new int[length];
        for (int i = 0; i < length; i++) {
            sortedArray[i] = i;
        }
        return  sortedArray;
    }

    public static int[] getReverseArray(int length) {
        int[] sortedArray = new int[length];
        for (int i = length-1; i >= 0; i--) {
            sortedArray[i] = i;
        }
        return  sortedArray;
    }

    public static void outputResult(long[] results, SortingAlgo algo, String itemType, int numberOfItems) {
        System.out.println("Sorting type : " + algo);
        System.out.println("Item type : " + itemType);
        for (int i = 0; i < results.length; i++) {
            long result = results[i];
//            System.out.println("Run " + (i+1) + " time taken : " + result);
            System.out.println(result);
        }
        System.out.println(algo + " average for " + results.length + " runs of " + numberOfItems + " " + itemType + " items : " + getAverage(results) + "ns\n");

        writeToFile(results, algo, itemType, numberOfItems);
    }

    public static void writeToFile(long[] results, SortingAlgo algo, String itemType, int numberOfItems) {

        try {

            String fileName = algo + "-" + itemType + "-" + numberOfItems + ".csv";
            FileWriter fileWriter = new FileWriter(fileName);

            for (long result : results) {
                fileWriter.append(String.valueOf(result));
                fileWriter.append("\n");
            }
            fileWriter.close();

        } catch (IOException e) {
            System.err.println("Error writing to file : " + e.getMessage());
        }

    }

    public static long getAverage(long[] results) {
        if (results.length < 1) { return 0L; }
        long average = 0L;
        for (long result : results) {
            average += result;
        }
        average /= results.length;
        return average;
    }
}

