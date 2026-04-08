import java.util.*;

/*
 * LeetCode 88 - Merge Sorted Array
 *
 * ============================================================
 * APPROACHES COVERED:
 * ============================================================
 *
 * 1) Brute Force using extra array
 *    TC: O(m + n)
 *    SC: O(m + n)
 *
 * 2) Copy nums2 into nums1 and sort
 *    TC: O((m + n) log(m + n))
 *    SC: O(1) extra (ignoring sort internals)
 *
 * 3) Optimal Two Pointer from Back
 *    TC: O(m + n)
 *    SC: O(1)
 *
 * ============================================================
 * NOTE:
 * In LeetCode, only the final optimal approach inside Solution class
 * is needed. But here all approaches are included for learning.
 * ============================================================
 */

public class Main {

    public static void main(String[] args) {

        // =========================
        // TEST CASE 1
        // =========================
        int[] nums1A = {1, 2, 3, 0, 0, 0};
        int[] nums2A = {2, 5, 6};
        int m1 = 3, n1 = 3;

        int[] nums1B = {1, 2, 3, 0, 0, 0};
        int[] nums2B = {2, 5, 6};

        int[] nums1C = {1, 2, 3, 0, 0, 0};
        int[] nums2C = {2, 5, 6};

        mergeBruteForce(nums1A, m1, nums2A, n1);
        mergeSortApproach(nums1B, m1, nums2B, n1);
        mergeOptimal(nums1C, m1, nums2C, n1);

        System.out.println("===== TEST CASE 1 =====");
        System.out.println("Brute Force:   " + Arrays.toString(nums1A)); // [1, 2, 2, 3, 5, 6]
        System.out.println("Sort Approach: " + Arrays.toString(nums1B)); // [1, 2, 2, 3, 5, 6]
        System.out.println("Optimal:       " + Arrays.toString(nums1C)); // [1, 2, 2, 3, 5, 6]

        // =========================
        // TEST CASE 2
        // =========================
        int[] nums1D = {1};
        int[] nums2D = {};
        mergeOptimal(nums1D, 1, nums2D, 0);

        System.out.println("\n===== TEST CASE 2 =====");
        System.out.println("Optimal:       " + Arrays.toString(nums1D)); // [1]

        // =========================
        // TEST CASE 3
        // =========================
        int[] nums1E = {0};
        int[] nums2E = {1};
        mergeOptimal(nums1E, 0, nums2E, 1);

        System.out.println("\n===== TEST CASE 3 =====");
        System.out.println("Optimal:       " + Arrays.toString(nums1E)); // [1]

        // =========================
        // TEST CASE 4
        // =========================
        int[] nums1F = {4, 5, 6, 0, 0, 0};
        int[] nums2F = {1, 2, 3};
        mergeOptimal(nums1F, 3, nums2F, 3);

        System.out.println("\n===== TEST CASE 4 =====");
        System.out.println("Optimal:       " + Arrays.toString(nums1F)); // [1, 2, 3, 4, 5, 6]
    }

    // ============================================================
    // APPROACH 1: BRUTE FORCE USING EXTRA ARRAY
    // ============================================================
    /*
     * IDEA:
     * - Use a new temp array to merge both sorted arrays
     * - Then copy result back to nums1
     *
     * WHY IT WORKS:
     * This is same as merge step in merge sort.
     *
     * TC: O(m + n)
     * SC: O(m + n)
     */
    public static void mergeBruteForce(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m + n];

        int i = 0; // pointer for nums1 valid elements
        int j = 0; // pointer for nums2
        int k = 0; // pointer for temp

        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                temp[k++] = nums1[i++];
            } else {
                temp[k++] = nums2[j++];
            }
        }

        while (i < m) {
            temp[k++] = nums1[i++];
        }

        while (j < n) {
            temp[k++] = nums2[j++];
        }

        // Copy back to nums1
        for (int x = 0; x < m + n; x++) {
            nums1[x] = temp[x];
        }
    }

    // ============================================================
    // APPROACH 2: COPY nums2 INTO nums1 AND SORT
    // ============================================================
    /*
     * IDEA:
     * - Put nums2 elements at end of nums1
     * - Sort nums1
     *
     * WHY IT WORKS:
     * After placing all elements in nums1, sorting gives final answer.
     *
     * TC: O((m + n) log(m + n))
     * SC: O(1) extra (ignoring sort internals)
     *
     * INTERVIEW NOTE:
     * Correct but not optimal.
     */
    public static void mergeSortApproach(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }

        Arrays.sort(nums1);
    }

    // ============================================================
    // APPROACH 3: OPTIMAL TWO POINTER FROM BACK
    // ============================================================
    /*
     * IDEA:
     * Start from the end because nums1 has extra space at the back.
     *
     * POINTERS:
     * i = last valid element in nums1 -> m - 1
     * j = last element in nums2       -> n - 1
     * k = last position in nums1      -> m + n - 1
     *
     * WHY IT WORKS:
     * We place the largest element first at the back.
     * This avoids overwriting useful values in nums1.
     *
     * TC: O(m + n)
     * SC: O(1)
     *
     * THIS IS THE BEST / INTERVIEW EXPECTED SOLUTION.
     */
    public static void mergeOptimal(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;         // last valid element in nums1
        int j = n - 1;         // last element in nums2
        int k = m + n - 1;     // last index in nums1

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        /*
         * If nums2 still has elements left, copy them.
         * No need to copy remaining nums1 elements,
         * because they are already in correct place.
         */
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}

/*
============================================================
LEETCODE SUBMISSION VERSION
============================================================

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
*/
