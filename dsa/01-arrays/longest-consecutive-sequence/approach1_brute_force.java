/**
 * Brute Force Approach - Longest Consecutive Sequence
 * 
 * Logic:
 * - For each number, treat it as potential sequence start
 * - Count consecutive numbers by checking num+1, num+2, etc.
 * - Track maximum sequence length found
 * 
 * When to use: Understanding the problem, very small inputs
 * When NOT to use: Any realistic input - will TLE for n > 1000
 * 
 * Time Complexity: O(n²) - nested loops for each sequence search
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        
        int maxLength = 1;
        
        // Try each number as sequence start
        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            int currentLength = 1;
            
            // Count consecutive numbers
            while (contains(nums, currentNum + 1)) {
                currentNum++;
                currentLength++;
            }
            
            maxLength = Math.max(maxLength, currentLength);
        }
        
        return maxLength;
    }
    
    // Helper method to check if array contains the target
    private boolean contains(int[] nums, int target) {
        for (int num : nums) {
            if (num == target) return true;
        }
        return false;
    }
}

/*
Example Walkthrough:
nums = [100,4,200,1,3,2]

Starting with nums[0] = 100:
  - Check 101: not found
  - Sequence: [100], length = 1

Starting with nums[1] = 4:
  - Check 5: not found
  - Sequence: [4], length = 1

Starting with nums[2] = 200:
  - Check 201: not found
  - Sequence: [200], length = 1

Starting with nums[3] = 1:
  - Check 2: found ✓
  - Check 3: found ✓
  - Check 4: found ✓
  - Check 5: not found
  - Sequence: [1,2,3,4], length = 4 ⭐ (BEST)

Starting with nums[4] = 3:
  - Check 4: found ✓
  - Check 5: not found
  - Sequence: [3,4], length = 2

Starting with nums[5] = 2:
  - Check 3: found ✓
  - Check 4: found ✓
  - Check 5: not found
  - Sequence: [2,3,4], length = 3

Result: maxLength = 4

Why this is slow:
- For each number, we potentially scan the entire array
- For n=100,000, worst case is ~10 billion operations
- We're doing the same work repeatedly (e.g., sequences starting at 2,3,4)

Key limitation: No optimization to avoid redundant work
*/
