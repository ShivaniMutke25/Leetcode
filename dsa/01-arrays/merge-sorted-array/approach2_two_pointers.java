/**
 * Two Pointers Approach - Merge Sorted Array (OPTIMAL)
 * 
 * Logic:
 * - Use three pointers: i for nums1's valid end, j for nums2's end, k for merge position
 * - Work from the end to avoid overwriting unprocessed nums1 elements
 * - Place larger element at position k, move corresponding pointer
 * 
 * Key insight: nums1 has extra space at the end, so we can merge backwards
 * 
 * When to use: Always - optimal in-place solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(m+n) - single pass through both arrays
 * Space Complexity: O(1) - in-place merging
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;  // Last valid element in nums1
        int j = n - 1;  // Last element in nums2
        int k = m + n - 1;  // Last position in nums1 (including extra space)
        
        // Merge from the end
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        
        // If nums2 has remaining elements, copy them
        // (If nums1 has remaining, they're already in correct position)
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}

/*
Example Walkthrough:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6], n = 3

Initialize: i=2 (nums1[2]=3), j=2 (nums2[2]=6), k=5

Compare nums1[i]=3 and nums2[j]=6:
3 <= 6 ✗
nums1[5] = 6, j=1, k=4
nums1 = [1,2,3,0,0,6]

Compare nums1[i]=3 and nums2[j]=5:
3 <= 5 ✗
nums1[4] = 5, j=0, k=3
nums1 = [1,2,3,0,5,6]

Compare nums1[i]=3 and nums2[j]=2:
3 > 2 ✓
nums1[3] = 3, i=1, k=2
nums1 = [1,2,3,3,5,6]

Compare nums1[i]=2 and nums2[j]=2:
2 <= 2 ✗
nums1[2] = 2, j=-1, k=1
nums1 = [1,2,2,3,5,6]

nums2 exhausted (j=-1), done!

Final result: nums1 = [1,2,2,3,5,6]

Why this works:
- Working backwards prevents overwriting unprocessed elements
- The largest remaining element always goes to the current end position
- If nums2 has elements left after nums1 is exhausted, they must be the smallest
- If nums1 has elements left, they're already in correct position

Edge cases handled:
- nums1 empty: all nums2 elements copied
- nums2 empty: nums1 remains unchanged
- All nums1 elements larger: nums2 elements go to front
- All nums2 elements larger: nums2 elements go to back

Why this is optimal:
- Time: O(m+n) - single pass
- Space: O(1) - in-place merging
- No extra memory allocation
- Elegant and efficient

This is the perfect solution!
*/
