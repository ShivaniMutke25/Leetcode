import java.util.*;

/*
 * LeetCode 3 - Longest Substring Without Repeating Characters
 *
 * ============================================================
 * APPROACHES COVERED:
 * ============================================================
 *
 * 1) Brute Force (Generate all substrings)
 *    TC: O(n^3)
 *    SC: O(n)
 *
 * 2) Better Sliding Window using HashSet
 *    TC: O(2n) -> O(n)
 *    SC: O(n)
 *
 * 3) Optimal Sliding Window using HashMap (Last Seen Index)
 *    TC: O(n)
 *    SC: O(n)
 *
 * 4) ASCII Optimized using int[] lastSeen
 *    TC: O(n)
 *    SC: O(1) for fixed charset
 *
 * ============================================================
 * NOTE:
 * For interviews, Approach 2 and 3 are most important.
 * Approach 3 is the strongest explanation.
 * ============================================================
 */

public class Main {

    public static void main(String[] args) {

        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        String s4 = "";
        String s5 = "dvdf";
        String s6 = "abba";

        System.out.println("===== TEST CASE 1 =====");
        testAllApproaches(s1); // Expected: 3

        System.out.println("\n===== TEST CASE 2 =====");
        testAllApproaches(s2); // Expected: 1

        System.out.println("\n===== TEST CASE 3 =====");
        testAllApproaches(s3); // Expected: 3

        System.out.println("\n===== TEST CASE 4 =====");
        testAllApproaches(s4); // Expected: 0

        System.out.println("\n===== TEST CASE 5 =====");
        testAllApproaches(s5); // Expected: 3

        System.out.println("\n===== TEST CASE 6 =====");
        testAllApproaches(s6); // Expected: 2
    }

    public static void testAllApproaches(String s) {
        System.out.println("Input String: \"" + s + "\"");
        System.out.println("Brute Force:         " + lengthOfLongestSubstringBrute(s));
        System.out.println("HashSet Window:      " + lengthOfLongestSubstringSet(s));
        System.out.println("HashMap Optimal:     " + lengthOfLongestSubstringMap(s));
        System.out.println("ASCII Optimized:     " + lengthOfLongestSubstringArray(s));
    }

    // ============================================================
    // APPROACH 1: BRUTE FORCE
    // ============================================================
    /*
     * IDEA:
     * Generate every possible substring and check if it has all unique chars.
     *
     * WHY IT WORKS:
     * It checks all substrings, so the longest valid one will be found.
     *
     * TC:
     *   - O(n^2) substrings
     *   - O(n) to check uniqueness
     *   => O(n^3)
     *
     * SC: O(n)
     *
     * INTERVIEW NOTE:
     * Correct but too slow.
     */
    public static int lengthOfLongestSubstringBrute(String s) {
        int n = s.length();
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String sub = s.substring(i, j + 1);

                if (allUnique(sub)) {
                    maxLen = Math.max(maxLen, sub.length());
                }
            }
        }

        return maxLen;
    }

    private static boolean allUnique(String str) {
        Set<Character> set = new HashSet<>();

        for (char ch : str.toCharArray()) {
            if (set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }

        return true;
    }

    // ============================================================
    // APPROACH 2: SLIDING WINDOW USING HASHSET
    // ============================================================
    /*
     * IDEA:
     * Use two pointers:
     * - left
     * - right
     *
     * Expand right pointer.
     * If duplicate appears, shrink from left until duplicate is removed.
     *
     * WHY IT WORKS:
     * Window always maintains unique characters.
     *
     * TC: O(2n) -> O(n)
     * SC: O(n)
     *
     * VERY IMPORTANT BEGINNER SLIDING WINDOW APPROACH.
     */
    public static int lengthOfLongestSubstringSet(String s) {
        Set<Character> window = new HashSet<>();

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);

            while (window.contains(current)) {
                window.remove(s.charAt(left));
                left++;
            }

            window.add(current);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    // ============================================================
    // APPROACH 3: OPTIMAL SLIDING WINDOW USING HASHMAP
    // ============================================================
    /*
     * IDEA:
     * Instead of removing one by one, directly jump left pointer
     * using last seen index of duplicate character.
     *
     * Example:
     * s = "abba"
     *
     * When we see second 'b', instead of shrinking step by step,
     * directly move left to after previous 'b'.
     *
     * WHY IT WORKS:
     * HashMap stores last index of each character.
     *
     * KEY FORMULA:
     * left = Math.max(left, lastSeen[ch] + 1)
     *
     * IMPORTANT:
     * We use Math.max to avoid moving left backward.
     *
     * TC: O(n)
     * SC: O(n)
     *
     * THIS IS THE BEST / INTERVIEW EXPECTED SOLUTION.
     */
    public static int lengthOfLongestSubstringMap(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);

            if (lastSeen.containsKey(current)) {
                left = Math.max(left, lastSeen.get(current) + 1);
            }

            lastSeen.put(current, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    // ============================================================
    // APPROACH 4: ASCII OPTIMIZED USING ARRAY
    // ============================================================
    /*
     * IDEA:
     * Same as HashMap approach, but faster if charset is fixed (ASCII).
     *
     * Instead of HashMap<Character, Integer>,
     * use int[128] or int[256].
     *
     * WHY?
     * Array access is faster than HashMap.
     *
     * TC: O(n)
     * SC: O(1) for fixed charset
     *
     * INTERVIEW NOTE:
     * Mention this only if interviewer asks for optimization.
     */
    public static int lengthOfLongestSubstringArray(String s) {
        int[] lastSeen = new int[128];
        Arrays.fill(lastSeen, -1);

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);

            left = Math.max(left, lastSeen[current] + 1);

            lastSeen[current] = right;
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}

/*
============================================================
LEETCODE SUBMISSION VERSION
============================================================

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);

            if (lastSeen.containsKey(current)) {
                left = Math.max(left, lastSeen.get(current) + 1);
            }

            lastSeen.put(current, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
*/
