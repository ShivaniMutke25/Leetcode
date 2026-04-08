import java.util.*;

/*
 * LeetCode 567 - Permutation in String
 *
 * ============================================================
 * APPROACHES:
 *
 * 1) Brute Force (sort & compare)
 *    TC: O(n * k log k)
 *
 * 2) Frequency comparison for each window
 *    TC: O(n * 26)
 *
 * 3) Optimal Sliding Window with match count
 *    TC: O(n)
 *
 * ============================================================
 */

public class Main {

    public static void main(String[] args) {

        String s1 = "ab";
        String s2 = "eidbaooo";

        System.out.println("Brute Force: " + checkInclusionBrute(s1, s2)); // true
        System.out.println("Better:      " + checkInclusionBetter(s1, s2)); // true
        System.out.println("Optimal:     " + checkInclusionOptimal(s1, s2));// true

        System.out.println();

        System.out.println(checkInclusionOptimal("ab", "eidboaoo")); // false
    }

    // ============================================================
    // 1) BRUTE FORCE
    // ============================================================
    /*
     * IDEA:
     * For each substring of size k:
     * - sort substring
     * - compare with sorted s1
     *
     * TC: O(n * k log k)
     */
    public static boolean checkInclusionBrute(String s1, String s2) {
        int k = s1.length();

        char[] s1Arr = s1.toCharArray();
        Arrays.sort(s1Arr);

        for (int i = 0; i <= s2.length() - k; i++) {
            char[] sub = s2.substring(i, i + k).toCharArray();
            Arrays.sort(sub);

            if (Arrays.equals(s1Arr, sub)) return true;
        }

        return false;
    }

    // ============================================================
    // 2) BETTER - FREQUENCY MATCH EACH WINDOW
    // ============================================================
    /*
     * IDEA:
     * Compare frequency arrays for each window
     *
     * TC: O(n * 26) ~ O(n)
     */
    public static boolean checkInclusionBetter(String s1, String s2) {
        int[] s1Freq = new int[26];
        int[] window = new int[26];

        for (char c : s1.toCharArray()) {
            s1Freq[c - 'a']++;
        }

        int k = s1.length();

        for (int i = 0; i < s2.length(); i++) {
            window[s2.charAt(i) - 'a']++;

            if (i >= k) {
                window[s2.charAt(i - k) - 'a']--;
            }

            if (Arrays.equals(s1Freq, window)) return true;
        }

        return false;
    }

    // ============================================================
    // 3) OPTIMAL - SLIDING WINDOW WITH MATCH COUNT
    // ============================================================
    /*
     * IDEA:
     * Instead of comparing full arrays every time,
     * track how many characters match.
     *
     * matches = number of characters whose freq matches
     *
     * When matches == 26 → valid permutation
     *
     * TC: O(n)
     * SC: O(1)
     *
     * THIS IS INTERVIEW LEVEL OPTIMAL SOLUTION
     */
    public static boolean checkInclusionOptimal(String s1, String s2) {

        if (s1.length() > s2.length()) return false;

        int[] s1Freq = new int[26];
        int[] window = new int[26];

        for (char c : s1.toCharArray()) {
            s1Freq[c - 'a']++;
        }

        int matches = 0;

        // initial window
        for (int i = 0; i < s1.length(); i++) {
            window[s2.charAt(i) - 'a']++;
        }

        // count initial matches
        for (int i = 0; i < 26; i++) {
            if (s1Freq[i] == window[i]) matches++;
        }

        int left = 0;

        for (int right = s1.length(); right < s2.length(); right++) {

            if (matches == 26) return true;

            int r = s2.charAt(right) - 'a';
            window[r]++;

            if (window[r] == s1Freq[r]) {
                matches++;
            } else if (window[r] == s1Freq[r] + 1) {
                matches--;
            }

            int l = s2.charAt(left) - 'a';
            window[l]--;

            if (window[l] == s1Freq[l]) {
                matches++;
            } else if (window[l] == s1Freq[l] - 1) {
                matches--;
            }

            left++;
        }

        return matches == 26;
    }
}

/*
============================================================
LEETCODE VERSION
============================================================

class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) return false;

        int[] s1Freq = new int[26];
        int[] window = new int[26];

        for (char c : s1.toCharArray()) {
            s1Freq[c - 'a']++;
        }

        int matches = 0;

        for (int i = 0; i < s1.length(); i++) {
            window[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (s1Freq[i] == window[i]) matches++;
        }

        int left = 0;

        for (int right = s1.length(); right < s2.length(); right++) {

            if (matches == 26) return true;

            int r = s2.charAt(right) - 'a';
            window[r]++;

            if (window[r] == s1Freq[r]) matches++;
            else if (window[r] == s1Freq[r] + 1) matches--;

            int l = s2.charAt(left) - 'a';
            window[l]--;

            if (window[l] == s1Freq[l]) matches++;
            else if (window[l] == s1Freq[l] - 1) matches--;

            left++;
        }

        return matches == 26;
    }
}
*/
