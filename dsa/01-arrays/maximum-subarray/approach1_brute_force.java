/**
 * Brute Force Approach - Maximum Subarray
 * 
 * Logic:
 * - Try every possible subarray (start to end)
 * - Calculate sum of each subarray
 * - Track maximum sum found
 * 
 * When to use: Understanding the problem, very small inputs
 * When NOT to use: Any realistic input - will TLE for n > 1000
 * 
 * Time Complexity: O(n²) - nested loops for all subarrays
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int n = nums.length;
        
        // Try every possible starting point
        for (int start = 0; start < n; start++) {
            int currentSum = 0;
            
            // Try every possible ending point
            for (int end = start; end < n; end++) {
                currentSum += nums[end];
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        
        return maxSum;
    }
}

/*
Example Walkthrough:
nums = [-2,1,-3,4,-1,2,1,-5,4]

All subarrays and their sums:
Start at 0:
  [-2]: -2
  [-2,1]: -1
  [-2,1,-3]: -4
  [-2,1,-3,4]: 0
  [-2,1,-3,4,-1]: -1
  [-2,1,-3,4,-1,2]: 1
  [-2,1,-3,4,-1,2,1]: 2
  [-2,1,-3,4,-1,2,1,-5]: -3
  [-2,1,-3,4,-1,2,1,-5,4]: 1

Start at 1:
  [1]: 1
  [1,-3]: -2
  [1,-3,4]: 2
  [1,-3,4,-1]: 1
  [1,-3,4,-1,2]: 3
  [1,-3,4,-1,2,1]: 4
  [1,-3,4,-1,2,1,-5]: -1
  [1,-3,4,-1,2,1,-5,4]: 3

Start at 2:
  [-3]: -3
  [-3,4]: 1
  [-3,4,-1]: 0
  [-3,4,-1,2]: 2
  [-3,4,-1,2,1]: 3
  [-3,4,-1,2,1,-5]: -2
  [-3,4,-1,2,1,-5,4]: 2

Start at 3:
  [4]: 4
  [4,-1]: 3
  [4,-1,2]: 5
  [4,-1,2,1]: 6 ⭐ (BEST)
  [4,-1,2,1,-5]: 1
  [4,-1,2,1,-5,4]: 5

Start at 4:
  [-1]: -1
  [-1,2]: 1
  [-1,2,1]: 2
  [-1,2,1,-5]: -3
  [-1,2,1,-5,4]: 1

... (remaining subarrays will be smaller)

Result: maxSum = 6

Why this is slow:
- For n elements, there are n*(n+1)/2 subarrays
- For n=100,000, that's ~5 billion subarrays
- Each subarray sum calculation takes O(1) with running sum
- Total operations: O(n²)

Key limitation: No optimization to skip obviously bad subarrays
*/
