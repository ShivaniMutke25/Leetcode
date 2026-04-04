/**
 * Prefix Sum Approach - Maximum Average Subarray (OPTIMAL)
 * 
 * Logic:
 * - Use sliding window of size k with prefix sum optimization
 * - Compute sum of first k elements
 * - Slide window one element at a time, updating sum efficiently
 * - Track maximum sum found
 * - Return maxSum/k for maximum average
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(n) - single pass through array
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // Compute sum of first k elements
        int currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }
        
        int maxSum = currentSum;
        
        // Slide the window through the array
        for (int i = k; i < nums.length; i++) {
            // Add new element, remove old element
            currentSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return (double) maxSum / k;
    }
}

/*
Example Walkthrough:
nums = [1,12,-5,-6,50,3], k = 4

Initial window (indices 0-3):
currentSum = 1 + 12 + (-5) + (-6) = 2
maxSum = 2

Slide window (i = 4):
Add nums[4] = 50, remove nums[0] = 1
currentSum = 2 + 50 - 1 = 51
maxSum = max(2, 51) = 51

Slide window (i = 5):
Add nums[5] = 3, remove nums[1] = 12
currentSum = 51 + 3 - 12 = 42
maxSum = max(51, 42) = 51

Result: maxSum/k = 51/4 = 12.75

Another example:
nums = [5,5,5,5], k = 2

Initial window (indices 0-1):
currentSum = 5 + 5 = 10
maxSum = 10

Slide window (i = 2):
Add nums[2] = 5, remove nums[0] = 5
currentSum = 10 + 5 - 5 = 10
maxSum = max(10, 10) = 10

Slide window (i = 3):
Add nums[3] = 5, remove nums[1] = 5
currentSum = 10 + 5 - 5 = 10
maxSum = max(10, 10) = 10

Result: maxSum/k = 10/2 = 5.0

Why this works:
- Fixed window size k makes this a perfect sliding window problem
- currentSum + nums[i] - nums[i-k] efficiently updates window sum
- Each element is added and removed exactly once
- Maximum average corresponds to maximum sum for fixed window size

Why this is optimal:
- Time: O(n) - single pass, optimal
- Space: O(1) - constant extra space
- No redundant computations
- Efficient window updates using sliding window technique

Key insights:
- For fixed window size, maximum average = maximum sum
- Sliding window allows O(1) sum updates
- Each element processed exactly twice (added and removed)
- No need for prefix sum array, just maintain running sum

This is the perfect solution!
*/
