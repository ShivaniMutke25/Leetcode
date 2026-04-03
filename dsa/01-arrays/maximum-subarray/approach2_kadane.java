/**
 * Kadane's Algorithm - Maximum Subarray (OPTIMAL)
 * 
 * Logic:
 * - currentSum: maximum subarray sum ending at current position
 * - maxSum: maximum subarray sum found so far (global)
 * - If currentSum becomes negative, reset to 0 (start new subarray)
 * - Always update maxSum with currentSum
 * 
 * Key insight: Maximum subarray ending at i either:
 * 1. Extends the maximum subarray ending at i-1, OR
 * 2. Starts fresh at i (if previous sum was negative)
 * 
 * When to use: Always - this is the optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(n) - single pass through array
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        
        for (int num : nums) {
            // Either extend previous subarray or start new one
            currentSum = Math.max(num, currentSum + num);
            
            // Update global maximum
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}

/*
Example Walkthrough:
nums = [-2,1,-3,4,-1,2,1,-5,4]

Initialize: currentSum = 0, maxSum = -∞

num = -2:
  - currentSum = max(-2, 0 + (-2)) = -2
  - maxSum = max(-∞, -2) = -2

num = 1:
  - currentSum = max(1, -2 + 1) = 1
  - maxSum = max(-2, 1) = 1

num = -3:
  - currentSum = max(-3, 1 + (-3)) = -2
  - maxSum = max(1, -2) = 1

num = 4:
  - currentSum = max(4, -2 + 4) = 4
  - maxSum = max(1, 4) = 4

num = -1:
  - currentSum = max(-1, 4 + (-1)) = 3
  - maxSum = max(4, 3) = 4

num = 2:
  - currentSum = max(2, 3 + 2) = 5
  - maxSum = max(4, 5) = 5

num = 1:
  - currentSum = max(1, 5 + 1) = 6
  - maxSum = max(5, 6) = 6 ⭐

num = -5:
  - currentSum = max(-5, 6 + (-5)) = 1
  - maxSum = max(6, 1) = 6

num = 4:
  - currentSum = max(4, 1 + 4) = 5
  - maxSum = max(6, 5) = 6

Result: maxSum = 6

Why this works:
- currentSum represents the best subarray ending at current position
- If currentSum is negative, adding it to next number makes it smaller
- So we restart when currentSum becomes negative
- maxSum tracks the best overall subarray found

Mathematical proof:
Let dp[i] = maximum subarray sum ending at index i
Then: dp[i] = max(nums[i], dp[i-1] + nums[i])
This is exactly what Kadane's algorithm computes

Why this is optimal:
- Single pass: O(n) time
- Constant space: O(1) memory
- No recursion, no extra data structures
- Elegant and intuitive

This is the perfect solution for maximum subarray!
*/
