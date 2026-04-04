/**
 * Brute Force Approach - Split Array Largest Sum
 * 
 * Logic:
 * - Try all possible ways to split array into k subarrays
 * - Calculate sum of each subarray
 * - Find minimum largest sum among all splits
 * 
 * When to use: Understanding problem, very small inputs
 * When NOT to use: Any realistic input - will be too slow
 * 
 * Time Complexity: O(n^k) - try all possible splits
 * Space Complexity: O(n) - for storing subarray sums
 */
class Solution {
    public int splitArray(int[] nums, int k) {
        return splitArrayHelper(nums, 0, k);
    }
    
    private int splitArrayHelper(int[] nums, int start, int remainingK) {
        if (remainingK == 1) {
            int sum = 0;
            for (int i = start; i < nums.length; i++) {
                sum += nums[i];
            }
            return sum;
        }
        
        int minLargestSum = Integer.MAX_VALUE;
        
        for (int i = start; i < nums.length - remainingK + 1; i++) {
            int currentSum = 0;
            for (int j = start; j <= i; j++) {
                currentSum += nums[j];
            }
            
            int nextSum = splitArrayHelper(nums, i + 1, remainingK - 1);
            int largestSum = Math.max(currentSum, nextSum);
            minLargestSum = Math.min(minLargestSum, largestSum);
        }
        
        return minLargestSum;
    }
}

/*
Example Walkthrough:
nums = [7,2,5,10,8], k = 2

Try split at position 0:
  First subarray: [7], sum = 7
  Second subarray: [2,5,10,8], sum = 25
  Largest sum = max(7, 25) = 25

Try split at position 1:
  First subarray: [7,2], sum = 9
  Second subarray: [5,10,8], sum = 23
  Largest sum = max(9, 23) = 23

Try split at position 2:
  First subarray: [7,2,5], sum = 14
  Second subarray: [10,8], sum = 18
  Largest sum = max(14, 18) = 18

Try split at position 3:
  First subarray: [7,2,5,10], sum = 24
  Second subarray: [8], sum = 8
  Largest sum = max(24, 8) = 24

Minimum largest sum = min(25, 23, 18, 24) = 18

Result: 18

Why this is inefficient:
- Tries all possible split positions recursively
- Time complexity is exponential: O(n^k)
- For n=1000, k=100, this is completely impractical
- Doesn't use binary search optimization

Key limitation: Doesn't use binary search to find optimal answer
*/
