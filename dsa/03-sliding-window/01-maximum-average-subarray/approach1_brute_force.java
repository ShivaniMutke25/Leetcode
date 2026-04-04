/**
 * Brute Force Approach - Maximum Average Subarray
 * 
 * Logic:
 * - Compute sum for every possible subarray of length k
 * - Track maximum sum found
 * - Return maxSum/k for maximum average
 * 
 * When to use: Learning the problem, very small inputs
 * When NOT to use: Any realistic input - will be too slow
 * 
 * Time Complexity: O(nk) - n positions, each sum computation O(k)
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxSum = Integer.MIN_VALUE;
        
        // Check every possible starting position
        for (int i = 0; i <= nums.length - k; i++) {
            int currentSum = 0;
            
            // Compute sum of subarray starting at i with length k
            for (int j = i; j < i + k; j++) {
                currentSum += nums[j];
            }
            
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum / k;
    }
}

/*
Example Walkthrough:
nums = [1,12,-5,-6,50,3], k = 4

i = 0: subarray = [1,12,-5,-6]
  sum = 1 + 12 + (-5) + (-6) = 2
  maxSum = 2

i = 1: subarray = [12,-5,-6,50]
  sum = 12 + (-5) + (-6) + 50 = 51
  maxSum = 51

i = 2: subarray = [-5,-6,50,3]
  sum = (-5) + (-6) + 50 + 3 = 42
  maxSum = 51 (no change)

Result: maxSum/k = 51/4 = 12.75

Why this is inefficient:
- For each of (n-k+1) positions, we compute sum of k elements
- Total: O((n-k+1) * k) ≈ O(nk) time complexity
- For n=10^5, k=10^4, this is 10^9 operations
- Redundant computation: overlapping subarrays share many elements

Key limitation: No optimization to reuse computations from overlapping windows
*/
