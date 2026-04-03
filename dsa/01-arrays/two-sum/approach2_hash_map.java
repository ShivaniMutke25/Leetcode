/**
 * HashMap Approach - Two Sum (OPTIMAL)
 * 
 * Logic:
 * - Use HashMap to store value->index mapping of numbers seen so far
 * - For each number, check if (target - number) exists in HashMap
 * - If yes, we found the pair
 * - If no, store current number and continue
 * 
 * Key insight: We only need to look backward for complements
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Memory constraints are very tight
 * 
 * Time Complexity: O(n) - single pass through array
 * Space Complexity: O(n) - HashMap stores up to n elements
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // Check if complement exists in HashMap
            if (numToIndex.containsKey(complement)) {
                return new int[]{numToIndex.get(complement), i};
            }
            
            // Store current number and its index
            numToIndex.put(nums[i], i);
        }
        
        return new int[]{};
    }
}

/*
Example Walkthrough:
nums = [2, 7, 11, 15], target = 9

Initialize: numToIndex = {}

i = 0, nums[0] = 2:
  - complement = 9 - 2 = 7
  - 7 not in numToIndex
  - Store 2: numToIndex = {2: 0}

i = 1, nums[1] = 7:
  - complement = 9 - 7 = 2
  - 2 IS in numToIndex at index 0 ✓
  - Return [0, 1]

Another example:
nums = [3, 2, 4], target = 6

Initialize: numToIndex = {}

i = 0, nums[0] = 3:
  - complement = 6 - 3 = 3
  - 3 not in numToIndex
  - Store 3: numToIndex = {3: 0}

i = 1, nums[1] = 2:
  - complement = 6 - 2 = 4
  - 4 not in numToIndex
  - Store 2: numToIndex = {3: 0, 2: 1}

i = 2, nums[2] = 4:
  - complement = 6 - 4 = 2
  - 2 IS in numToIndex at index 1 ✓
  - Return [1, 2]

Why this works:
- At each step, we've stored all previous numbers
- If complement exists, it must be from a previous index
- This ensures we don't use the same element twice
- HashMap provides O(1) average lookup time

Why this is optimal:
- Time: O(n) - single pass
- Space: O(n) - HashMap storage
- Handles all cases correctly
- Much faster than O(n²) brute force

This is the perfect solution!
*/