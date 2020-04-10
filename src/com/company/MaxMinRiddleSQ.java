package com.company;

import java.util.*;

public class MaxMinRiddleSQ {
    // Complete the riddle function below.
    static long[] riddle(long[] arr) {
        // complete this function
        HashMap<Integer, ArrayList<Long>> minMap = new HashMap<>();
        long[] result = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            minMap.put(i, new ArrayList<>());
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                minMap.get(j-i).add(getElementsBetweenPoints(arr, i, j));
            }
        }

        for (Integer integer:minMap.keySet()) {
            Iterator<Long> x =  minMap.get(integer).iterator();
            long maxOfMin = 0;
            while (x.hasNext()){
                Long next = x.next();
                if (next > maxOfMin){
                    maxOfMin = next;
                }
            }
            result[integer] = maxOfMin;
        }
        return result;



    }

    private static Long getElementsBetweenPoints(long[] arr, int i, int j) {
        Long min = null;
        for (int k = i; k <= j; k++) {
            if (min == null || arr[k] < min){
                min = arr[k];
            }
        }
        return min;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] arr = new long[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long arrItem = Long.parseLong(arrItems[i]);
            arr[i] = arrItem;
        }

        long[] res = riddle(arr);

        scanner.close();
    }
}
