/**
 * Brute Force Approach - Contains Duplicate
 * 
 * Logic:
 * - Compare every pair of elements to find duplicates
 * - Return true if any pair matches
 * 
 * When to use: Understanding the problem, very small inputs
 * When NOT to use: Any realistic input - will TLE for n > 1000
 * 
 * Time Complexity: O(n²) - nested loops
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Compare every pair of elements
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}

/*
Example Walkthrough:
nums = [1,2,3,1]

i = 0, nums[0] = 1:
  - j = 1, nums[1] = 2: 1 != 2
  - j = 2, nums[2] = 3: 1 != 3
  - j = 3, nums[3] = 1: 1 == 1 ✓ → Return true

Why this is slow:
- For n elements, we check n*(n-1)/2 pairs
- For n=100,000, that's ~5 billion pairs
- No optimization to skip obviously different elements
*/
