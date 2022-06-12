package edu.patterns.slidingwindow;

/**
 * @author susheel
 *
 * Problem Statement: Given an array of positive numbers and a positive number ‘S’, find the length of the smallest
 * contiguous subarray whose sum is greater than or equal to ‘S’. Return 0, if no such subarray exists.
 *
 * Category easy
 * Complexity O(n)
 * The time complexity of the below algorithm will be O(N). The outer for loop runs for all elements and the inner
 * while loop processes each element only once, therefore the time complexity of the algorithm will be O(N+N)
 * which is asymptotically equivalent to O(N).
 */
public class MinSubArrayOfSumK {

    public static void main(String[] args) {
        System.out.println("Min length of subarray: " + getMinlengthOfSubarrayWithSumS(new int[] {4,72,9,2,5,8}, 73));
    }

    public static int getMinlengthOfSubarrayWithSumS(int[] arr, int s) {
        int minLen = Integer.MAX_VALUE;
        int winStart = 0;
        int winEnd = 0;
        int winSum = 0;

        for(winEnd = 0; winEnd < arr.length ; winEnd++) {
            winSum += arr[winEnd];

            while(winSum >= s) {
                minLen = Math.min(minLen, winEnd-winStart+1);
                winSum -= arr[winStart];
                winStart++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
