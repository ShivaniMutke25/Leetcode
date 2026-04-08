import java.util.*;

/*
 * LeetCode 11 - Container With Most Water
 *
 * ============================================================
 * APPROACHES:
 *
 * 1) Brute Force
 *    TC: O(n^2)
 *    SC: O(1)
 *
 * 2) Optimal Two Pointer
 *    TC: O(n)
 *    SC: O(1)
 *
 * ============================================================
 */

public class Main {

    public static void main(String[] args) {

        int[] h1 = {1,8,6,2,5,4,8,3,7};
        int[] h2 = {1,1};
        int[] h3 = {4,3,2,1,4};
        int[] h4 = {1,2,1};

        System.out.println("===== TEST CASE 1 =====");
        testAll(h1); // 49

        System.out.println("\n===== TEST CASE 2 =====");
        testAll(h2); // 1

        System.out.println("\n===== TEST CASE 3 =====");
        testAll(h3); // 16

        System.out.println("\n===== TEST CASE 4 =====");
        testAll(h4); // 2
    }

    public static void testAll(int[] height) {
        System.out.println("Input: " + Arrays.toString(height));
        System.out.println("Brute Force: " + maxAreaBrute(height));
        System.out.println("Optimal:     " + maxAreaOptimal(height));
    }

    // ============================================================
    // APPROACH 1: BRUTE FORCE
    // ============================================================
    /*
     * IDEA:
     * Try all pairs (i, j)
     * Compute area for each
     *
     * TC: O(n^2)
     * SC: O(1)
     */
    public static int maxAreaBrute(int[] height) {
        int maxArea = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {

                int h = Math.min(height[i], height[j]);
                int w = j - i;

                int area = h * w;
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

    // ============================================================
    // APPROACH 2: OPTIMAL TWO POINTER
    // ============================================================
    /*
     * IDEA:
     * Start with left = 0, right = n-1
     *
     * Compute area
     * Move the pointer with smaller height
     *
     * WHY?
     * Because area depends on:
     * min(height[left], height[right])
     *
     * If we move taller pointer:
     * height won't increase → area decreases
     *
     * If we move smaller pointer:
     * we might find a taller line → area may increase
     *
     * TC: O(n)
     * SC: O(1)
     *
     * THIS IS INTERVIEW EXPECTED SOLUTION
     */
    public static int maxAreaOptimal(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int maxArea = 0;

        while (left < right) {

            int h = Math.min(height[left], height[right]);
            int w = right - left;

            int area = h * w;
            maxArea = Math.max(maxArea, area);

            // move smaller pointer
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}

/*
============================================================
LEETCODE VERSION
============================================================

class Solution {
    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {

            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, area);

            if (height[left] < height[right]) left++;
            else right--;
        }

        return maxArea;
    }
}
*/
