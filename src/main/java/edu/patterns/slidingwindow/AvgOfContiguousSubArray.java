package edu.patterns.slidingwindow;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Susheel
 *
 * Problem Statement : Given an array, find the average of all contiguous subarrays of size ‘K’ in it.
 * Category easy
 * Complexity O(N)
 *
 */
public class AvgOfContiguousSubArray {

    public static void main(String[] args) {
        int arr[] = new int[] {1,2,6,3,7,2,-1,8,9};
        System.out.println(Arrays.toString(getAvgContiguousSubArray(arr, 4)));
    }

    public static double[] getAvgContiguousSubArray(int[] arr, int k) {
        double[] result = new double[arr.length-k+1];
        int winStart = 0;
        int winEnd = 0;
        double winSum = 0;

        for(winEnd = 0; winEnd<= arr.length -1 ; winEnd++) {
            winSum +=  arr[winEnd];

            if(winEnd >= k-1) {
                result[winStart] = winSum/k;
                winSum -= arr[winStart];
                winStart++;
            }
        }

        return result;
    }

}
