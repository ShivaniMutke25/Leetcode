/**
 * Sliding Window Approach - Binary Subarrays with Sum (for goal > 0)
 * 
 * Logic:
 * - Use sliding window with two pointers: left and right
 * - Maintain sum of current window
 * - When sum > goal, shrink window from left
 * - When sum == goal, count subarrays and shrink to find all possibilities
 * - Works only when goal > 0 due to binary array properties
 * 
 * When to use: Goal > 0, memory critical, binary array
 * When NOT to use: Goal = 0, non-binary array, need general solution
 * 
 * Time Complexity: O(n) - single pass through array
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        // This approach only works when goal > 0
        if (goal == 0) {
            return countZeroGoal(nums);
        }
        
        int left = 0, currentSum = 0;
        int result = 0;
        
        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];
            
            // Shrink window while sum > goal
            while (currentSum > goal && left <= right) {
                currentSum -= nums[left];
                left++;
            }
            
            // Count subarrays ending at right with sum == goal
            if (currentSum == goal) {
                // Count how many zeros we can include from the left
                int tempLeft = left;
                while (tempLeft <= right && nums[tempLeft] == 0) {
                    result++;
                    tempLeft++;
                }
                result++; // Include the subarray without leading zeros
            }
        }
        
        return result;
    }
    
    private int countZeroGoal(int[] nums) {
        int result = 0;
        int zeroCount = 0;
        
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
                result += zeroCount; // All subarrays ending here
            } else {
                zeroCount = 0;
            }
        }
        
        return result;
    }
}

/*
Example Walkthrough:
nums = [1,0,1,0,1], goal = 2

Initialize: left = 0, currentSum = 0, result = 0

right = 0, nums[0] = 1:
  currentSum = 1
  currentSum < 2 → don't shrink
  currentSum != 2 → no count

right = 1, nums[1] = 0:
  currentSum = 1 + 0 = 1
  currentSum < 2 → don't shrink
  currentSum != 2 → no count

right = 2, nums[2] = 1:
  currentSum = 1 + 1 = 2
  currentSum == 2 → count subarrays
  tempLeft = left = 0, nums[0] = 1 != 0 → result += 1 (subarray [1,0,1])
  result = 1

right = 3, nums[3] = 0:
  currentSum = 2 + 0 = 2
  currentSum == 2 → count subarrays
  tempLeft = left = 0, nums[0] = 1 != 0 → result += 1 (subarray [1,0,1,0])
  result = 2

right = 4, nums[4] = 1:
  currentSum = 2 + 1 = 3
  currentSum > 2 → shrink window
  currentSum -= nums[0] = 3 - 1 = 2, left = 1
  currentSum == 2 → count subarrays
  tempLeft = left = 1, nums[1] = 0 → result += 1 (subarray [0,1,0,1])
  tempLeft = 2, nums[2] = 1 != 0 → result += 1 (subarray [1,0,1])
  result = 4

Result: 4

Why this works for goal > 0:
- Binary array elements are 0 or 1, so sum only increases
- When sum > goal, we can safely shrink from left
- When sum == goal, we can include leading zeros to form multiple subarrays
- Each zero at the beginning creates an additional valid subarray

Why this is limited:
- Only works when goal > 0
- Requires binary array (0/1 values)
- More complex logic than prefix sum approach
- Need special handling for goal = 0

When this is preferred:
- Memory constraints are tight (O(1) vs O(n) space)
- Goal is known to be > 0
- Binary array is guaranteed
- Performance is critical

Trade-offs:
- Time: O(n) - same as prefix sum
- Space: O(1) - better than prefix sum O(n)
- More complex implementation
- Limited applicability (goal > 0, binary array)

For general cases, prefix sum approach is preferred due to simplicity and universal applicability.
*/
