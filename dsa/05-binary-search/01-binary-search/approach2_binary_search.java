/**
 * Binary Search Approach - Binary Search (OPTIMAL)
 * 
 * Logic:
 * - Use left and right pointers
 * - Calculate mid and compare with target
 * - If nums[mid] equals target, return mid
 * - If nums[mid] < target, search right half
 * - If nums[mid] > target, search left half
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(log n) - each iteration eliminates half
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int search(int[] nums, int target) {
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
        
        return -1;
    }
}

/*
Example Walkthrough:
nums = [-1,0,3,5,9,12], target = 9

Initialize: left = 0, right = 5

Iteration 1:
  mid = 0 + (5-0)/2 = 2
  nums[2] = 3 < 9 → search right half
  left = 3, right = 5

Iteration 2:
  mid = 3 + (5-3)/2 = 4
  nums[4] = 9 == 9 ✓ → return 4

Result: 4

Another example:
nums = [2,5,8,12,16], target = 10

Initialize: left = 0, right = 4

Iteration 1:
  mid = 0 + (4-0)/2 = 2
  nums[2] = 8 < 10 → search right half
  left = 3, right = 4

Iteration 2:
  mid = 3 + (4-3)/2 = 3
  nums[3] = 12 > 10 → search left half
  left = 3, right = 2

Iteration 3:
  mid = 3 + (2-3)/2 = 2
  nums[2] = 8 < 10 → search right half
  left = 3, right = 2

Iteration 4:
  mid = 3 + (2-3)/2 = 3
  nums[3] = 12 > 10 → search left half
  left = 3, right = 2

left > right → stop, return -1

Result: -1

Another example (target found):
nums = [1,3,5,7,9,11], target = 7

Initialize: left = 0, right = 5

Iteration 1:
  mid = 0 + (5-0)/2 = 2
  nums[2] = 5 < 7 → search right half
  left = 3, right = 5

Iteration 2:
  mid = 3 + (5-3)/2 = 4
  nums[4] = 9 > 7 → search left half
  left = 3, right = 3

Iteration 3:
  mid = 3 + (3-3)/2 = 3
  nums[3] = 7 == 7 ✓ → return 3

Result: 3

Why this works:
- Each iteration eliminates half of the remaining elements
- Time complexity is logarithmic: O(log n)
- Leverages the sorted property of the array
- Constant space usage

Why this is optimal:
- Time: O(log n) - optimal for search in sorted array
- Space: O(1) - constant extra space
- Each element is examined at most once
- No redundant calculations

Key insights:
- Binary search requires sorted array
- Mid calculation: left + (right - left) / 2 prevents overflow
- Each comparison eliminates half the search space
- Termination condition: left > right means element not found

This is the perfect solution!
*/
