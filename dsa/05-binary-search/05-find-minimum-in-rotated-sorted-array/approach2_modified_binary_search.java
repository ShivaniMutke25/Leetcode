/**
 * Modified Binary Search Approach - Find Minimum in Rotated Sorted Array (OPTIMAL)
 * 
 * Logic:
 * - Use modified binary search with left and right pointers
 * - Compare mid with right element
 * - If nums[mid] > nums[right], minimum is on right
 * - If nums[mid] <= nums[right], minimum is on left
 * - When left == right, we found minimum
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(log n) - each iteration eliminates half
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > nums[right]) {
                // Minimum is on the right side
                left = mid + 1;
            } else {
                // Minimum is on the left side (including mid)
                right = mid;
            }
        }
        
        return nums[left];
    }
}

/*
Example Walkthrough:
nums = [3,4,5,1,2]

Initialize: left = 0, right = 4

Iteration 1:
  mid = 0 + (4-0)/2 = 2
  nums[2] = 5, nums[4] = 2
  nums[2] > nums[4] (5 > 2) → minimum is on right
  left = 3, right = 4

Iteration 2:
  mid = 3 + (4-3)/2 = 3
  nums[3] = 1, nums[4] = 2
  nums[3] <= nums[4] (1 <= 2) → minimum is on left (including mid)
  right = 3

left == right (3 == 3) → return nums[3] = 1

Result: 1

Another example:
nums = [4,5,6,7,0,1,2]

Initialize: left = 0, right = 6

Iteration 1:
  mid = 0 + (6-0)/2 = 3
  nums[3] = 7, nums[6] = 2
  nums[3] > nums[6] (7 > 2) → minimum is on right
  left = 4, right = 6

Iteration 2:
  mid = 4 + (6-4)/2 = 5
  nums[5] = 1, nums[6] = 2
  nums[5] <= nums[6] (1 <= 2) → minimum is on left (including mid)
  right = 5

Iteration 3:
  mid = 4 + (5-4)/2 = 4
  nums[4] = 0, nums[5] = 1
  nums[4] <= nums[5] (0 <= 1) → minimum is on left (including mid)
  right = 4

left == right (4 == 4) → return nums[4] = 0

Result: 0

Another example (not rotated):
nums = [1,2,3,4,5]

Initialize: left = 0, right = 4

Iteration 1:
  mid = 0 + (4-0)/2 = 2
  nums[2] = 3, nums[4] = 5
  nums[2] <= nums[4] (3 <= 5) → minimum is on left (including mid)
  right = 2

Iteration 2:
  mid = 0 + (2-0)/2 = 1
  nums[1] = 2, nums[2] = 3
  nums[1] <= nums[2] (2 <= 3) → minimum is on left (including mid)
  right = 1

Iteration 3:
  mid = 0 + (1-0)/2 = 0
  nums[0] = 1, nums[1] = 2
  nums[0] <= nums[1] (1 <= 2) → minimum is on left (including mid)
  right = 0

left == right (0 == 0) → return nums[0] = 1

Result: 1

Why this works:
- If nums[mid] > nums[right], minimum must be on right side
- If nums[mid] <= nums[right], minimum is on left side (including mid)
- Each iteration eliminates half of remaining elements
- Time complexity is logarithmic: O(log n)
- Space complexity is constant: O(1)

Why this is optimal:
- Time: O(log n) - optimal for search in sorted array
- Space: O(1) - constant extra space
- Each element is examined at most once
- No redundant calculations

Key insights:
- Compare mid with right element, not left
- When nums[mid] <= nums[right], minimum is in left half
- When nums[mid] > nums[right], minimum is in right half
- When left == right, we've found the minimum
- Works for both rotated and non-rotated arrays

This is perfect solution!
*/
