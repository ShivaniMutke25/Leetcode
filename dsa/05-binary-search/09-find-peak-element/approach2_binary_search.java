/**
 * Binary Search Approach - Find Peak Element (OPTIMAL)
 * 
 * Logic:
 * - Use binary search with left and right pointers
 * - Compare mid with right neighbor
 * - If nums[mid] < nums[mid+1], peak is on the right
 * - If nums[mid] > nums[mid+1], peak is on the left
 * - When left == right, we found the peak
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(log n) - each iteration eliminates half
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] < nums[mid + 1]) {
                // Peak is on the right side
                left = mid + 1;
            } else {
                // Peak is on the left side (including mid)
                right = mid;
            }
        }
        
        return left; // left == right at this point
    }
}

/*
Example Walkthrough:
nums = [1,2,3,1]

Initialize: left = 0, right = 3

Iteration 1:
  mid = 0 + (3-0)/2 = 1
  nums[1] = 2, nums[2] = 3
  nums[1] < nums[2] (2 < 3) → peak is on right
  left = 2, right = 3

Iteration 2:
  mid = 2 + (3-2)/2 = 2
  nums[2] = 3, nums[3] = 1
  nums[2] > nums[3] (3 > 1) → peak is on left (including mid)
  right = 2

left == right (2 == 2) → return left = 2

Result: 2

Another example:
nums = [1,2,1,3,5,6,4]

Initialize: left = 0, right = 5

Iteration 1:
  mid = 0 + (5-0)/2 = 2
  nums[2] = 1, nums[3] = 3
  nums[2] < nums[3] (1 < 3) → peak is on right
  left = 3, right = 5

Iteration 2:
  mid = 3 + (5-3)/2 = 4
  nums[4] = 6, nums[5] = 4
  nums[4] > nums[5] (6 > 4) → peak is on left (including mid)
  right = 4

Iteration 3:
  mid = 3 + (4-3)/2 = 3
  nums[3] = 3, nums[4] = 6
  nums[3] < nums[4] (3 < 6) → peak is on right
  left = 4, right = 4

left == right (4 == 4) → return left = 4

Result: 4

Another example (monotonic increasing):
nums = [1,2,3,4,5]

Initialize: left = 0, right = 4

Iteration 1:
  mid = 0 + (4-0)/2 = 2
  nums[2] = 3, nums[3] = 4
  nums[2] < nums[3] (3 < 4) → peak is on right
  left = 3, right = 4

Iteration 2:
  mid = 3 + (4-3)/2 = 3
  nums[3] = 4, nums[4] = 5
  nums[3] < nums[4] (4 < 5) → peak is on right
  left = 4, right = 4

left == right (4 == 4) → return left = 4

Result: 4 (last element is peak)

Why this works:
- If nums[mid] < nums[mid+1], there must be a peak on the right side
- If nums[mid] > nums[mid+1], there must be a peak on the left side
- Each iteration eliminates half of the remaining elements
- Time complexity is logarithmic: O(log n)
- Space complexity is constant: O(1)

Why this is optimal:
- Time: O(log n) - optimal for peak finding
- Space: O(1) - constant extra space
- Each element is examined at most once
- No redundant calculations

Key insights:
- Binary search can find peak without checking all elements
- Compare mid with right neighbor to determine search direction
- When left == right, we've found a peak
- Any peak is acceptable if multiple peaks exist

This is perfect solution!
*/
