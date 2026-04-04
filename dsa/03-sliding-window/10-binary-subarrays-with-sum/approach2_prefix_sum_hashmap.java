/**
 * Prefix Sum + HashMap Approach - Binary Subarrays with Sum (OPTIMAL)
 * 
 * Logic:
 * - Use prefix sum with HashMap to count subarrays with sum = goal
 * - Maintain running prefix sum as we iterate
 * - For each prefix sum, check if (prefixSum - goal) exists in map
 * - Add frequency to result if found
 * - Update map with current prefix sum frequency
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(n) - single pass through array
 * Space Complexity: O(n) - HashMap for prefix sum frequencies
 */
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // Empty subarray
        
        int currentSum = 0;
        int result = 0;
        
        for (int num : nums) {
            currentSum += num;
            
            // Check if (currentSum - goal) exists
            if (prefixSumCount.containsKey(currentSum - goal)) {
                result += prefixSumCount.get(currentSum - goal);
            }
            
            // Update frequency of current prefix sum
            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        }
        
        return result;
    }
}

/*
Example Walkthrough:
nums = [1,0,1,0,1], goal = 2

Initialize: prefixSumCount = {0:1}, currentSum = 0, result = 0

i = 0, num = 1:
  currentSum = 0 + 1 = 1
  Check if (1 - 2) = -1 exists → No
  Update prefixSumCount = {0:1, 1:1}

i = 1, num = 0:
  currentSum = 1 + 0 = 1
  Check if (1 - 2) = -1 exists → No
  Update prefixSumCount = {0:1, 1:2}

i = 2, num = 1:
  currentSum = 1 + 1 = 2
  Check if (2 - 2) = 0 exists → Yes, count = 1
  result = 0 + 1 = 1
  Update prefixSumCount = {0:1, 1:2, 2:1}

i = 3, num = 0:
  currentSum = 2 + 0 = 2
  Check if (2 - 2) = 0 exists → Yes, count = 1
  result = 1 + 1 = 2
  Update prefixSumCount = {0:1, 1:2, 2:2}

i = 4, num = 1:
  currentSum = 2 + 1 = 3
  Check if (3 - 2) = 1 exists → Yes, count = 2
  result = 2 + 2 = 4
  Update prefixSumCount = {0:1, 1:2, 2:2, 3:1}

Result: 4

Another example with goal = 0:
nums = [0,0,0], goal = 0

Initialize: prefixSumCount = {0:1}, currentSum = 0, result = 0

i = 0, num = 0:
  currentSum = 0 + 0 = 0
  Check if (0 - 0) = 0 exists → Yes, count = 1
  result = 0 + 1 = 1
  Update prefixSumCount = {0:2}

i = 1, num = 0:
  currentSum = 0 + 0 = 0
  Check if (0 - 0) = 0 exists → Yes, count = 2
  result = 1 + 2 = 3
  Update prefixSumCount = {0:3}

i = 2, num = 0:
  currentSum = 0 + 0 = 0
  Check if (0 - 0) = 0 exists → Yes, count = 3
  result = 3 + 3 = 6
  Update prefixSumCount = {0:4}

Result: 6 (all possible subarrays: [0], [0], [0], [0,0], [0,0], [0,0,0])

Why this works:
- Prefix sum represents sum of elements from start to current position
- Subarray sum from i to j = prefixSum[j] - prefixSum[i-1]
- We want prefixSum[j] - prefixSum[i-1] = goal
- So prefixSum[i-1] = prefixSum[j] - goal
- HashMap tracks how many times each prefix sum has occurred

Why this is optimal:
- Time: O(n) - single pass, optimal
- Space: O(n) - HashMap for prefix sum frequencies
- Handles all cases including goal = 0
- No redundant calculations
- Efficient frequency counting

Key insights:
- prefixSumCount.put(0, 1) handles subarrays starting at index 0
- Each prefix sum can form multiple valid subarrays
- HashMap allows O(1) lookup of previous prefix sums
- Works for any goal value, including 0

This is the perfect solution!
*/
