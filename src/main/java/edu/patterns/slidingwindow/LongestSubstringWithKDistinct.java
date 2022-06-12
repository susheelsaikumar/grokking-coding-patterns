package edu.patterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author susheel
 *
 * Problem Statement: Given a string, find the length of the longest substring in it with no more than K distinct
 * characters.
 *
 * Category : Medium
 *
 * Time Complexity #
 * The time complexity of the below algorithm will be O(N) where ‘N’ is the number of characters in the input
 * string. The outer for loop runs for all characters and the inner while loop processes each character only once,
 * therefore the time complexity of the algorithm will be O(N+N) which is asymptotically equivalent to O(N).
 *
 * Space Complexity #
 * The space complexity of the algorithm is O(K), as we will be storing a maximum of ‘K+1’ characters in the HashMap.
 *
 */
public class LongestSubstringWithKDistinct {

    public static void main(String[] args) {

        System.out.println(getLengthOfLongestSubstringKDistinct("araaci",2));
        System.out.println(getLengthOfLongestSubstringKDistinct("avhgdghhhshhsaci",2));

    }

    public static int getLengthOfLongestSubstringKDistinct(String s, int k) {
        int length = 0;
        int winStart =0;
        int winEnd = 0;
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for(winEnd = 0; winEnd < s.length(); winEnd++ ) {
            char rightChar = s.charAt(winEnd);
            frequencyMap.put(rightChar, frequencyMap.getOrDefault(rightChar, 0) + 1);

            while(frequencyMap.size() > k) {
                char leftChar = s.charAt(winStart);
                frequencyMap.put(leftChar, frequencyMap.get(leftChar) - 1);
                if(frequencyMap.get(leftChar) == 0) {
                    frequencyMap.remove(leftChar);
                }
                winStart++;
                length = Math.max(length, winEnd-winStart+1);
            }
        }

        return length;

    }
}
