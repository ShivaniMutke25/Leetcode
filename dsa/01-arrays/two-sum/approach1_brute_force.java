/**
 * Brute Force Approach - Two Sum
 * 
 * Logic:
 * - Compare every pair of numbers to find if they sum to target
 * - When found, return indices
 * 
 * When to use: Understanding the problem, very small inputs
 * When NOT to use: Any realistic input - will TLE for n > 1000
 * 
 * Time Complexity: O(n²) - nested loops through array
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Compare each pair
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        // No solution found (shouldn't happen per constraints)
        return new int[]{};
    }
}

/*
Example Walkthrough:
nums = [2, 7, 11, 15], target = 9

i = 0, nums[0] = 2:
  - j = 1, nums[1] = 7: 2 + 7 = 9 ✓ → Return [0, 1]

Another example:
nums = [3, 2, 4], target = 6

i = 0, nums[0] = 3:
  - j = 1, nums[1] = 2: 3 + 2 = 5 ✗
  - j = 2, nums[2] = 4: 3 + 4 = 7 ✗

i = 1, nums[1] = 2:
  - j = 2, nums[2] = 4: 2 + 4 = 6 ✓ → Return [1, 2]

Why this is slow:
- For n elements, we check n*(n-1)/2 pairs
- For n=10,000, that's ~50 million pairs
- Each check is O(1), but the count is too high
- No optimization to skip obviously wrong pairs

Key limitation: No optimization to avoid redundant comparisons
*/