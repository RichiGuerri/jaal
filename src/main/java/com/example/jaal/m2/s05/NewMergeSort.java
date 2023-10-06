package com.example.jaal.m2.s05;

import java.util.ArrayList;
import java.util.Arrays;

public class NewMergeSort {

    // Divide function: divides an array into N arrays of 1 element each
    public static ArrayList<ArrayList<Integer>> divide(int[] array) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            res.add(new ArrayList<>(Arrays.asList(array[i])));
        }
        return res;
    }

    // Merge function: merges two ordered array into an ordered one
    public static ArrayList<ArrayList<Integer>> merge(ArrayList<ArrayList<Integer>> array) {
        // Add an empty last array if the list is odd
        if (array.size() % 2 != 0) {
            array.add(new ArrayList<Integer>());
        }

        // Main loop, it takes two ordered arrays every cycle and merges them
        for (int i = 0; i < array.size(); i++) {
            int first = 0, second = 0;
            ArrayList<Integer> tmp = new ArrayList<>();

            // If the last array is empty, copy only the first array
            if (array.get(i + 1).isEmpty()) {
                tmp = array.get(i);
                first = array.get(i).size();
            }

            // Add the lower value scanning the two arrays
            while (first != array.get(i).size() && second != array.get(i + 1).size()) {
                if (array.get(i).get(first) >= array.get(i + 1).get(second)) {
                    tmp.add(array.get(i + 1).get(second));
                    second++;
                } else {
                    tmp.add(array.get(i).get(first));
                    first++;
                }
            }

            // Add remaining queue
            if (first != array.get(i).size()) {
                tmp.addAll(array.get(i).subList(first, array.get(i).size()));
            } else if (second != array.get(i + 1).size()) {
                tmp.addAll(array.get(i + 1).subList(second, array.get(i + 1).size()));
            }

            /*
             * Add the temporary array into the original list and remove the second one to
             * not leave blank entries
             */
            array.set(i, tmp);
            array.remove(i + 1);
        }

        return array;
    }

    // Function plain to run tests
    public static void plain(int[] data) {
        ArrayList<ArrayList<Integer>> res = divide(data);

        while (res.size() > 1) {
            res = merge(res);
        }

        for (int i = 0; i < data.length; i++) {
            data[i] = res.get(0).get(i);
        }
    }

    public static void main(String[] args) {
        int[] array = { 52, 84, -14, 98, -36, 102, 61, -24, 77, 0, 56 };
        ArrayList<ArrayList<Integer>> res = divide(array);

        while (res.size() > 1) {
            res = merge(res);
        }

        System.out.println("The resulting array is: " + res.get(0).toString());

    }
}