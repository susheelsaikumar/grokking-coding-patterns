package edu.patterns.slidingwindow;

import java.util.Arrays;

/**
 * @author susheel
 * <p>
 * Problem Statement: Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any
 * contiguous subarray of size ‘k’.
 *
 * Category : Easy
 * Complexity : o(N)
 */
public class MaxSumSubArrayOfK {

    public static void main(String[] args) {
        int arr[] = new int[] {1,2,6,3,7,2,-1,8,9};
        System.out.println(getMaxSumOfContiguousSubArray(arr, 4));
    }

    public static int getMaxSumOfContiguousSubArray(int[] arr, int k) {
        int max = Integer.MIN_VALUE;
        int winSum = 0;
        int winStart = 0;
        int winEnd = 0;

        for(winEnd = 0; winEnd <arr.length ; winEnd++) {
            winSum += arr[winEnd];

            if(winEnd >= k-1) {
                if(max < winSum) {
                    max = winSum;
                }
                winSum -= arr[winStart];
                winStart++;
            }
        }

        return  max;
    }
}
