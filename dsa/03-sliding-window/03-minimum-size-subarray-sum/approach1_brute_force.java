/**
 * Brute Force Approach - Minimum Size Subarray Sum
 * 
 * Logic:
 * - Check all possible subarrays
 * - For each subarray, calculate sum
 * - Track minimum length where sum >= target
 * 
 * When to use: Understanding the problem, very small inputs
 * When NOT to use: Any realistic input - will be too slow
 * 
 * Time Complexity: O(n²) - O(n²) subarrays, each sum calculation O(n)
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        
        // Check all possible starting positions
        for (int i = 0; i < nums.length; i++) {
            int currentSum = 0;
            
            // Expand subarray from i
            for (int j = i; j < nums.length; j++) {
                currentSum += nums[j];
                
                if (currentSum >= target) {
                    minLength = Math.min(minLength, j - i + 1);
                    break; // No need to expand further from this i
                }
            }
        }
        
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}

/*
Example Walkthrough:
nums = [2,3,1,2,4,3], target = 7

i = 0:
  j = 0: sum = 2 < 7
  j = 1: sum = 2 + 3 = 5 < 7
  j = 2: sum = 5 + 1 = 6 < 7
  j = 3: sum = 6 + 2 = 8 >= 7 → minLength = 4 (subarray [2,3,1,2])

i = 1:
  j = 1: sum = 3 < 7
  j = 2: sum = 3 + 1 = 4 < 7
  j = 3: sum = 4 + 2 = 6 < 7
  j = 4: sum = 6 + 4 = 10 >= 7 → minLength = 4 (subarray [3,1,2,4])

i = 2:
  j = 2: sum = 1 < 7
  j = 3: sum = 1 + 2 = 3 < 7
  j = 4: sum = 3 + 4 = 7 >= 7 → minLength = 3 (subarray [1,2,4])

i = 3:
  j = 3: sum = 2 < 7
  j = 4: sum = 2 + 4 = 6 < 7
  j = 5: sum = 6 + 3 = 9 >= 7 → minLength = 3 (subarray [2,4,3])

i = 4:
  j = 4: sum = 4 < 7
  j = 5: sum = 4 + 3 = 7 >= 7 → minLength = 2 (subarray [4,3])

i = 5:
  j = 5: sum = 3 < 7 → no valid subarray

Result: 2

Why this is inefficient:
- Number of subarrays: n*(n+1)/2 = O(n²)
- For each subarray, sum calculation: O(n) in worst case
- Total: O(n³) time complexity
- For n=10^5, this is completely impractical

Key limitation: No optimization to reuse computations from overlapping subarrays
*/
