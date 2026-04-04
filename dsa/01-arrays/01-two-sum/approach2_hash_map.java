/**
 * Hash Map Approach - Two Sum (OPTIMAL)
 * 
 * Logic:
 * - Use hash map to store number -> index mapping
 * - For each number, check if complement exists in map
 * - If found, return indices
 * - Otherwise, add current number to map
 * 
 * When to use: Large arrays, performance critical, production use
 * When NOT to use: Very small arrays, memory constraints
 * 
 * Time Complexity: O(n) - single pass
 * Space Complexity: O(n) - hash map storage
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            if (numToIndex.containsKey(complement)) {
                return new int[]{numToIndex.get(complement), i};
            }
            
            numToIndex.put(nums[i], i);
        }
        
        return new int[]{-1, -1}; // Should not reach here for valid input
    }
}

/*
Example Walkthrough:
nums = [2,7,11,15], target = 9

Initialize: numToIndex = {}

i = 0, nums[0] = 2:
  complement = 9 - 2 = 7
  7 not in numToIndex
  numToIndex.put(2, 0) → {2:0}

i = 1, nums[1] = 7:
  complement = 9 - 7 = 2
  2 is in numToIndex → return [numToIndex.get(2), 1] = [0,1]

Result: [0, 1]

Another example:
nums = [3,2,4], target = 6

Initialize: numToIndex = {}

i = 0, nums[0] = 3:
  complement = 6 - 3 = 3
  3 not in numToIndex
  numToIndex.put(3, 0) → {3:0}

i = 1, nums[1] = 2:
  complement = 6 - 2 = 4
  4 not in numToIndex
  numToIndex.put(2, 1) → {3:0, 2:1}

i = 2, nums[2] = 4:
  complement = 6 - 4 = 2
  2 is in numToIndex → return [numToIndex.get(2), 2] = [1,2]

Result: [1, 2]

Why this works:
- Hash map provides O(1) lookup for complements
- Single pass through array
- Each element is processed exactly once
- Guarantees to find solution if it exists

Why this is optimal:
- Time: O(n) - optimal for this problem
- Space: O(n) - necessary for hash map
- Much faster than O(n^2) brute force
- Perfect for production use with large arrays

Key insights:
- Complement = target - current number
- Check if complement exists before adding current number
- Hash map provides constant time lookups
- Single pass algorithm is optimal

This is perfect solution!
*/
