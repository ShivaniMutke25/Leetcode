/**
 * Merge and Find Approach - Median of Two Sorted Arrays
 * 
 * Logic:
 * - Merge both sorted arrays into one sorted array
 * - Find middle element(s) of merged array
 * - Return median based on total length parity
 * 
 * When to use: Understanding problem, small inputs
 * When NOT to use: Any realistic input - will be too slow
 * 
 * Time Complexity: O(m+n) - merge both arrays
 * Space Complexity: O(m+n) - for merged array
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] merged = new int[m + n];
        
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }
        
        while (i < m) {
            merged[k++] = nums1[i++];
        }
        
        while (j < n) {
            merged[k++] = nums2[j++];
        }
        
        int total = m + n;
        if (total % 2 == 1) {
            return merged[total / 2];
        } else {
            return (merged[total / 2 - 1] + merged[total / 2]) / 2.0;
        }
    }
}

/*
Example Walkthrough:
nums1 = [1,3], nums2 = [2]

m = 3, n = 2, total = 5

Merge process:
i = 0, j = 0, k = 0:
  nums1[0] = 1 <= nums2[0] = 2 → merged[0] = 1, i = 1

i = 1, j = 0, k = 1:
  nums1[1] = 3 > nums2[0] = 2 → merged[1] = 2, j = 1

i = 1, j = 1, k = 2:
  nums1[1] = 3 > nums2[1] = 2 → merged[2] = 2, j = 2

i = 1, j = 2 (j >= n), k = 3:
  merged[3] = nums1[1] = 3, i = 2
  merged[4] = nums1[2] = 5, i = 3

Merged array: [1,2,2,3,5]
Total length = 5 (odd)
Median = merged[5/2] = merged[2] = 2

Result: 2.0

Another example:
nums1 = [1,2], nums2 = [3,4]

m = 2, n = 2, total = 4

Merge process:
i = 0, j = 0, k = 0:
  nums1[0] = 1 <= nums2[0] = 3 → merged[0] = 1, i = 1

i = 1, j = 0, k = 1:
  nums1[1] = 2 <= nums2[0] = 3 → merged[1] = 2, i = 2

i = 2 (i >= m), j = 0, k = 2:
  merged[2] = nums2[0] = 3, j = 1
  merged[3] = nums2[1] = 4, j = 2

Merged array: [1,2,3,4]
Total length = 4 (even)
Median = (merged[4/2-1] + merged[4/2]) / 2.0 = (merged[1] + merged[2]) / 2.0 = (2 + 3) / 2.0 = 2.5

Result: 2.5

Why this is inefficient:
- Merges both arrays completely - O(m+n) time
- Creates new array of size m+n - O(m+n) space
- For m=n=10^6, this uses too much memory and time
- Doesn't use binary search optimization

Key limitation: Doesn't use binary search to find median directly
*/
