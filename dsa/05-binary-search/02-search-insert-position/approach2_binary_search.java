/**
 * Binary Search Approach - Search Insert Position (OPTIMAL)
 * 
 * Logic:
 * - Use left and right pointers
 * - Calculate mid and compare with target
 * - If nums[mid] equals target, return mid
 * - If nums[mid] < target, search right half
 * - If nums[mid] > target, search left half
 * - When loop ends, left is insertion position
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(log n) - each iteration eliminates half
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return left;
    }
}

/*
Example Walkthrough:
nums = [1,3,5,6], target = 5

Initialize: left = 0, right = 3

Iteration 1:
  mid = 0 + (3-0)/2 = 1
  nums[1] = 3 < 5 → search right half
  left = 2, right = 3

Iteration 2:
  mid = 2 + (3-2)/2 = 2
  nums[2] = 5 == 5 ✓ → return 2

Result: 2

Another example:
nums = [1,3,5,6], target = 7

Initialize: left = 0, right = 3

Iteration 1:
  mid = 0 + (3-0)/2 = 1
  nums[1] = 3 < 7 → search right half
  left = 2, right = 3

Iteration 2:
  mid = 2 + (3-2)/2 = 2
  nums[2] = 5 < 7 → search right half
  left = 3, right = 3

Iteration 3:
  mid = 3 + (3-3)/2 = 3
  nums[3] = 6 < 7 → search right half
  left = 4, right = 3

Loop ends → return left = 4

Result: 4

Another example:
nums = [2,4,6,8], target = 3

Initialize: left = 0, right = 3

Iteration 1:
  mid = 0 + (3-0)/2 = 1
  nums[1] = 4 > 3 → search left half
  left = 0, right = 0

Iteration 2:
  mid = 0 + (0-0)/2 = 0
  nums[0] = 2 < 3 → search right half
  left = 1, right = 0

Loop ends → return left = 1

Result: 1

Why this works:
- Each iteration eliminates half of the remaining elements
- When loop ends, left points to correct insertion position
- Time complexity is logarithmic: O(log n)
- Leverages sorted property of array
- Space complexity is constant: O(1)

Why this is optimal:
- Time: O(log n) - optimal for search in sorted array
- Space: O(1) - constant extra space
- Each element is examined at most once
- No redundant calculations

Key insights:
- Binary search finds insertion position when target not found
- When loop ends, left will be insertion position
- Mid calculation: left + (right - left) / 2 prevents overflow
- Each comparison eliminates half search space

This is perfect solution!
*/
