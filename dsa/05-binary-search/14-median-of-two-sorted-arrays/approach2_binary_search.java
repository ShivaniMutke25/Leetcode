/**
 * Binary Search Approach - Median of Two Sorted Arrays (OPTIMAL)
 * 
 * Logic:
 * - Use binary search on the smaller array
 * - Partition both arrays such that left half has same elements as right half
 * - Find correct partition where max(left) <= min(right)
 * - Return median based on total length parity
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(log (m+n)) - binary search on smaller array
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        
        int m = nums1.length, n = nums2.length;
        int left = 0, right = m;
        
        while (left <= right) {
            int partitionX = left + (right - left) / 2;
            int partitionY = (m + n + 1) / 2 - partitionX;
            
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];
            
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];
            
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // Found correct partition
                if ((m + n) % 2 == 1) {
                    return Math.max(maxLeftX, maxLeftY);
                } else {
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                }
            } else if (maxLeftX > minRightY) {
                // partitionX is too far right, go left
                right = partitionX - 1;
            } else {
                // partitionX is too far left, go right
                left = partitionX + 1;
            }
        }
        
        return 0.0;
    }
}

/*
Example Walkthrough:
nums1 = [1,3], nums2 = [2]

m = 3, n = 2, nums1 is smaller
left = 0, right = 3

Iteration 1:
  partitionX = 0 + (3-0)/2 = 1
  partitionY = (3+2+1)/2 - 1 = 2
  
  maxLeftX = nums1[0] = 1
  minRightX = nums1[1] = 3
  maxLeftY = nums2[1] = 2
  minRightY = nums2[2] = Integer.MAX_VALUE (partitionY == n)
  
  Check: maxLeftX(1) <= minRightY(∞) ✓ AND maxLeftY(2) <= minRightX(3) ✓
  Total length = 5 (odd)
  Median = Math.max(maxLeftX, maxLeftY) = Math.max(1, 2) = 2

Result: 2.0

Another example:
nums1 = [1,2], nums2 = [3,4]

m = 2, n = 2, nums1 is smaller (or equal)
left = 0, right = 2

Iteration 1:
  partitionX = 0 + (2-0)/2 = 1
  partitionY = (2+2+1)/2 - 1 = 2
  
  maxLeftX = nums1[0] = 1
  minRightX = nums1[1] = 2
  maxLeftY = nums2[1] = 3
  minRightY = nums2[2] = 4
  
  Check: maxLeftX(1) <= minRightY(4) ✓ AND maxLeftY(3) <= minRightX(2) ✓
  Total length = 4 (even)
  Median = (Math.max(1,3) + Math.min(2,4)) / 2.0 = (3 + 2) / 2.0 = 2.5

Result: 2.5

Why this works:
- Binary search on partition point, not on values
- Correct partition ensures max(left) <= min(right)
- When partition is correct, median is at the boundary
- Each iteration eliminates half of remaining partition points
- Time complexity is O(log (m+n)) - optimal for this problem
- Space complexity is O(1) - constant extra space

Why this is optimal:
- Time: O(log (m+n)) - optimal for median finding
- Space: O(1) - constant extra space
- No need to merge arrays completely
- Each partition is checked at most once

Key insights:
- Binary search on partition point is key insight
- Always binary search on smaller array for efficiency
- Need to handle edge cases (empty arrays, Integer.MIN/MAX)
- Median calculation differs for even/odd total length

This is perfect solution!
*/
