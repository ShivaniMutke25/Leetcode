import java.util.*;

/*
 * LeetCode 76 - Minimum Window Substring
 *
 * ============================================================
 * APPROACHES:
 *
 * 1) Brute Force
 *    TC: O(n^3)
 *    SC: O(128)
 *
 * 2) Better Frequency Check
 *    TC: O(n^2 * 128)
 *    SC: O(128)
 *
 * 3) Optimal Sliding Window
 *    TC: O(n + m)
 *    SC: O(128)
 *
 * ============================================================
 */

public class Main {

    public static void main(String[] args) {

        testAll("ADOBECODEBANC", "ABC"); // BANC
        System.out.println();

        testAll("a", "a"); // a
        System.out.println();

        testAll("a", "aa"); // ""
        System.out.println();

        testAll("ab", "b"); // b
        System.out.println();

        testAll("aa", "aa"); // aa
    }

    public static void testAll(String s, String t) {
        System.out.println("s = \"" + s + "\", t = \"" + t + "\"");
        System.out.println("Brute Force: " + minWindowBrute(s, t));
        System.out.println("Better:      " + minWindowBetter(s, t));
        System.out.println("Optimal:     " + minWindowOptimal(s, t));
    }

    // ============================================================
    // 1) BRUTE FORCE
    // ============================================================
    /*
     * IDEA:
     * Generate all substrings
     * Check if substring contains all chars of t
     *
     * TC: O(n^3)
     * SC: O(128)
     */
    public static String minWindowBrute(String s, String t) {
        String ans = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);

                if (containsAll(sub, t)) {
                    if (ans.isEmpty() || sub.length() < ans.length()) {
                        ans = sub;
                    }
                }
            }
        }

        return ans;
    }

    private static boolean containsAll(String sub, String t) {
        int[] freq = new int[128];

        for (char ch : sub.toCharArray()) {
            freq[ch]++;
        }

        for (char ch : t.toCharArray()) {
            if (freq[ch] == 0) return false;
            freq[ch]--;
        }

        return true;
    }

    // ============================================================
    // 2) BETTER - FREQUENCY CHECK WHILE EXPANDING
    // ============================================================
    /*
     * IDEA:
     * For each start i, expand j and keep freq count
     * Stop when valid
     *
     * TC: O(n^2 * 128)
     * SC: O(128)
     */
    public static String minWindowBetter(String s, String t) {
        int n = s.length();
        String ans = "";

        int[] target = new int[128];
        for (char ch : t.toCharArray()) target[ch]++;

        for (int i = 0; i < n; i++) {
            int[] window = new int[128];

            for (int j = i; j < n; j++) {
                window[s.charAt(j)]++;

                if (isValid(window, target)) {
                    String sub = s.substring(i, j + 1);
                    if (ans.isEmpty() || sub.length() < ans.length()) {
                        ans = sub;
                    }
                    break; // smallest for this i
                }
            }
        }

        return ans;
    }

    private static boolean isValid(int[] window, int[] target) {
        for (int i = 0; i < 128; i++) {
            if (window[i] < target[i]) return false;
        }
        return true;
    }

    // ============================================================
    // 3) OPTIMAL - SLIDING WINDOW
    // ============================================================
    /*
     * IDEA:
     * Expand right until window becomes valid.
     * Then shrink left while still valid.
     *
     * KEY VARIABLES:
     * need[ch] = required count
     * count = how many chars from t are currently satisfied
     *
     * When count == t.length(), window is valid.
     *
     * TC: O(n + m)
     * SC: O(128)
     *
     * THIS IS THE INTERVIEW EXPECTED SOLUTION.
     */
    public static String minWindowOptimal(String s, String t) {

        if (s.length() < t.length()) return "";

        int[] need = new int[128];
        for (char ch : t.toCharArray()) {
            need[ch]++;
        }

        int left = 0;
        int count = 0;

        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);

            // if current char is needed
            if (need[current] > 0) {
                count++;
            }

            need[current]--;

            // when window becomes valid
            while (count == t.length()) {

                // update answer
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);

                need[leftChar]++;

                // if removing leftChar makes window invalid
                if (need[leftChar] > 0) {
                    count--;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
    }
}

/*
============================================================
LEETCODE VERSION
============================================================

class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) return "";

        int[] need = new int[128];
        for (char ch : t.toCharArray()) {
            need[ch]++;
        }

        int left = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);

            if (need[current] > 0) {
                count++;
            }

            need[current]--;

            while (count == t.length()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);
                need[leftChar]++;

                if (need[leftChar] > 0) {
                    count--;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
    }
}
*/
