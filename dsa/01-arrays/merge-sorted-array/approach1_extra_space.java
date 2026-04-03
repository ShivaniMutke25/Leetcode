/**
 * Extra Space Approach - Merge Sorted Array
 * 
 * Logic:
 * - Create a temporary array to store merged result
 * - Use two pointers to merge nums1 and nums2 into temp array
 * - Copy temp array back to nums1
 * 
 * When to use: When simplicity is preferred over space optimization
 * When NOT to use: When in-place merging is required
 * 
 * Time Complexity: O(m+n) - single pass through both arrays
 * Space Complexity: O(m+n) - temporary array for merged result
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] merged = new int[m + n];
        int i = 0, j = 0, k = 0;
        
        // Merge both arrays into merged array
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }
        
        // Copy remaining elements from nums1
        while (i < m) {
            merged[k++] = nums1[i++];
        }
        
        // Copy remaining elements from nums2
        while (j < n) {
            merged[k++] = nums2[j++];
        }
        
        // Copy merged array back to nums1
        for (int idx = 0; idx < m + n; idx++) {
            nums1[idx] = merged[idx];
        }
    }
}

/*
Example Walkthrough:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6], n = 3

Initialize: merged = [0,0,0,0,0,0], i=0, j=0, k=0

Compare nums1[0]=1 and nums2[0]=2:
1 <= 2 ✓
merged[0] = 1, i=1, k=1

Compare nums1[1]=2 and nums2[0]=2:
2 <= 2 ✓
merged[1] = 2, i=2, k=2

Compare nums1[2]=3 and nums2[0]=2:
3 > 2 ✗
merged[2] = 2, j=1, k=3

Compare nums1[2]=3 and nums2[1]=5:
3 <= 5 ✓
merged[3] = 3, i=3, k=4

nums1 exhausted (i=3, m=3), copy remaining nums2:
merged[4] = 5, j=2, k=5
merged[5] = 6, j=3, k=6

merged = [1,2,2,3,5,6]
Copy back to nums1:
nums1 = [1,2,2,3,5,6]

Result: nums1 is now merged and sorted

Why this works:
- Standard merge algorithm from merge sort
- Maintains sorted order by always picking smaller element
- Handles remaining elements after one array is exhausted

Trade-offs:
- Time: O(m+n) - optimal
- Space: O(m+n) - uses extra memory
- Simplicity: Very straightforward implementation

When this is acceptable:
- Memory constraints are not tight
- Code clarity is prioritized
- You want the most intuitive solution
*/
