/**
 * Sliding Window Approach - Minimum Size Subarray Sum (OPTIMAL)
 * 
 * Logic:
 * - Use sliding window with two pointers: left and right
 * - Maintain sum of current window
 * - Expand window by moving right pointer until sum >= target
 * - Contract window from left to find minimum size
 * - Track minimum window size found
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(n) - single pass through array
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, currentSum = 0;
        int minLength = Integer.MAX_VALUE;
        
        for (int right = 0; right < nums.length; right++) {
            // Add current element to window sum
            currentSum += nums[right];
            
            // Contract window from left while sum >= target
            while (currentSum >= target) {
                // Update minimum length
                minLength = Math.min(minLength, right - left + 1);
                
                // Remove leftmost element and shrink window
                currentSum -= nums[left];
                left++;
            }
        }
        
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}

/*
Example Walkthrough:
nums = [2,3,1,2,4,3], target = 7

Initialize: left = 0, currentSum = 0, minLength = MAX

right = 0, nums[0] = 2:
  currentSum = 2
  currentSum < 7 → don't contract

right = 1, nums[1] = 3:
  currentSum = 2 + 3 = 5
  currentSum < 7 → don't contract

right = 2, nums[2] = 1:
  currentSum = 5 + 1 = 6
  currentSum < 7 → don't contract

right = 3, nums[3] = 2:
  currentSum = 6 + 2 = 8
  currentSum >= 7 → start contracting
  
  minLength = min(MAX, 3-0+1) = 4
  currentSum -= nums[0] = 8 - 2 = 6
  left = 1
  currentSum < 7 → stop contracting

right = 4, nums[4] = 4:
  currentSum = 6 + 4 = 10
  currentSum >= 7 → start contracting
  
  minLength = min(4, 4-1+1) = 4
  currentSum -= nums[1] = 10 - 3 = 7
  left = 2
  currentSum >= 7 → continue contracting
  
  minLength = min(4, 4-2+1) = 3
  currentSum -= nums[2] = 7 - 1 = 6
  left = 3
  currentSum < 7 → stop contracting

right = 5, nums[5] = 3:
  currentSum = 6 + 3 = 9
  currentSum >= 7 → start contracting
  
  minLength = min(3, 5-3+1) = 3
  currentSum -= nums[3] = 9 - 2 = 7
  left = 4
  currentSum >= 7 → continue contracting
  
  minLength = min(3, 5-4+1) = 2
  currentSum -= nums[4] = 7 - 4 = 3
  left = 5
  currentSum < 7 → stop contracting

Result: 2

Another example:
nums = [1,4,4], target = 4

right = 0, nums[0] = 1:
  currentSum = 1
  currentSum < 4 → don't contract

right = 1, nums[1] = 4:
  currentSum = 1 + 4 = 5
  currentSum >= 4 → start contracting
  
  minLength = min(MAX, 1-0+1) = 2
  currentSum -= nums[0] = 5 - 1 = 4
  left = 1
  currentSum >= 4 → continue contracting
  
  minLength = min(2, 1-1+1) = 1
  currentSum -= nums[1] = 4 - 4 = 0
  left = 2
  currentSum < 4 → stop contracting

right = 2, nums[2] = 4:
  currentSum = 0 + 4 = 4
  currentSum >= 4 → start contracting
  
  minLength = min(1, 2-2+1) = 1
  currentSum -= nums[2] = 4 - 4 = 0
  left = 3
  currentSum < 4 → stop contracting

Result: 1

Why this works:
- All numbers are positive, so expanding window always increases sum
- Once sum >= target, we can try to shrink window to find minimum size
- Each element is added and removed at most once
- Contracting while sum >= target ensures we find minimum size for each right

Why this is optimal:
- Time: O(n) - single pass, optimal
- Space: O(1) - constant extra space
- No redundant calculations
- Efficient window management

Key insights:
- Positive numbers guarantee monotonic sum behavior
- Contracting while valid ensures minimum window size
- Each element processed exactly twice (added and removed)
- No need for prefix sum array, just maintain running sum

This is the perfect solution!
*/
