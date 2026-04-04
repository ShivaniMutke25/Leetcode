/**
 * Brute Force Approach - Two Sum
 * 
 * Logic:
 * - Use two nested loops to check all possible pairs
 * - For each pair, check if they sum to target
 * - Return indices if found
 * 
 * When to use: Small arrays, learning the problem
 * When NOT to use: Large arrays, performance critical
 * 
 * Time Complexity: O(n^2) - check all pairs
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        
        return new int[]{-1, -1}; // Should not reach here for valid input
    }
}

/*
Example Walkthrough:
nums = [2,7,11,15], target = 9

i = 0, nums[0] = 2:
  j = 1, nums[1] = 7: 2 + 7 = 9 == target ✓ → return [0,1]

Result: [0, 1]

Another example:
nums = [3,2,4], target = 6

i = 0, nums[0] = 3:
  j = 1, nums[1] = 2: 3 + 2 = 5 != 6
  j = 2, nums[2] = 4: 3 + 4 = 7 != 6

i = 1, nums[1] = 2:
  j = 2, nums[2] = 4: 2 + 4 = 6 == target ✓ → return [1,2]

Result: [1, 2]

Why this works:
- Checks all possible pairs of elements
- Simple to understand and implement
- Guaranteed to find solution if it exists
- Works for any valid input

Why this is not optimal:
- Time complexity is O(n^2) - very slow for large arrays
- For n=10^4, this is 10^8 operations
- Doesn't leverage any optimization techniques
- Not suitable for production use with large inputs

Key limitation: Checking all pairs when we can do better with hash map
*/
