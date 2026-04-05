import java.util.*;

public class Main {

    // =========================================================
    // APPROACH 1: BRUTE FORCE (Extra Array)
    // Time: O(m+n), Space: O(m+n)
    // When: Simple implementation
    // Why NOT: Uses extra space
    // =========================================================
    public static void mergeBrute(int[] nums1, int m, int[] nums2, int n) {

        int[] result = new int[m + n];
        int i = 0, j = 0, k = 0;

        // merge both arrays
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                result[k++] = nums1[i++];
            } else {
                result[k++] = nums2[j++];
            }
        }

        // remaining elements
        while (i < m) result[k++] = nums1[i++];
        while (j < n) result[k++] = nums2[j++];

        // copy back
        for (int x = 0; x < m + n; x++) {
            nums1[x] = result[x];
        }
    }


    // =========================================================
    // APPROACH 2: INSERT + SHIFT (Naive)
    // Time: O(m * n), Space: O(1)
    // When: Almost never
    // Why NOT: Very slow
    // =========================================================
    public static void mergeInsertShift(int[] nums1, int m, int[] nums2, int n) {

        int i = 0, j = 0;

        while (i < m && j < n) {
            if (nums1[i] > nums2[j]) {

                // shift right
                for (int k = m; k > i; k--) {
                    nums1[k] = nums1[k - 1];
                }

                nums1[i] = nums2[j];
                j++;
                m++;
            }
            i++;
        }

        // copy remaining nums2
        while (j < n) {
            nums1[m++] = nums2[j++];
        }
    }


    // =========================================================
    // APPROACH 3: MERGE + SORT
    // Time: O((m+n) log (m+n)), Space: O(1)
    // When: Quick coding
    // Why NOT: Not optimal
    // =========================================================
    public static void mergeSortMethod(int[] nums1, int m, int[] nums2, int n) {

        // copy nums2 into nums1
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }

        Arrays.sort(nums1);
    }


    // =========================================================
    // APPROACH 4: 🔥 OPTIMAL (Two Pointer from END)
    // Time: O(m+n), Space: O(1)
    // When: BEST solution (interview expected)
    // Why: Avoid overwriting by filling from back
    // =========================================================
    public static void mergeOptimal(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;        // last valid element in nums1
        int j = n - 1;        // last element in nums2
        int k = m + n - 1;    // last position in nums1

        while (i >= 0 && j >= 0) {

            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // if nums2 still has elements
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }


    // =========================================================
    // MAIN METHOD
    // =========================================================
    public static void main(String[] args) {

        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};

        mergeOptimal(nums1, 3, nums2, 3);

        System.out.println(Arrays.toString(nums1));
    }
}
