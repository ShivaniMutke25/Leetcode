/**
 * Sliding Window Approach - Max Consecutive Ones III (OPTIMAL)
 * 
 * Logic:
 * - Use sliding window with two pointers: left and right
 * - Maintain count of zeros in current window
 * - When zeros count exceeds k, shrink window from left
 * - Maximum window size found is the answer
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(n) - single pass through array
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, zeroCount = 0, maxLength = 0;
        
        for (int right = 0; right < nums.length; right++) {
            // Add current element to window
            if (nums[right] == 0) {
                zeroCount++;
            }
            
            // Shrink window while we have more than k zeros
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            
            // Update maximum window size
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}

/*
Example Walkthrough:
nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2

Initialize: left = 0, zeroCount = 0, maxLength = 0

right = 0, nums[0] = 1:
  zeroCount = 0 <= 2 ✓
  maxLength = max(0, 0-0+1) = 1

right = 1, nums[1] = 1:
  zeroCount = 0 <= 2 ✓
  maxLength = max(1, 1-0+1) = 2

right = 2, nums[2] = 1:
  zeroCount = 0 <= 2 ✓
  maxLength = max(2, 2-0+1) = 3

right = 3, nums[3] = 0:
  zeroCount = 1 <= 2 ✓
  maxLength = max(3, 3-0+1) = 4

right = 4, nums[4] = 0:
  zeroCount = 2 <= 2 ✓
  maxLength = max(4, 4-0+1) = 5

right = 5, nums[5] = 0:
  zeroCount = 3 > 2 → shrink window
  
  nums[left] = nums[0] = 1, left = 1
  zeroCount = 3 > 2 → shrink window
  
  nums[left] = nums[1] = 1, left = 2
  zeroCount = 3 > 2 → shrink window
  
  nums[left] = nums[2] = 1, left = 3
  zeroCount = 3 > 2 → shrink window
  
  nums[left] = nums[3] = 0, zeroCount = 2, left = 4
  zeroCount = 2 <= 2 ✓
  maxLength = max(5, 5-4+1) = 2

right = 6, nums[6] = 1:
  zeroCount = 2 <= 2 ✓
  maxLength = max(2, 6-4+1) = 3

right = 7, nums[7] = 1:
  zeroCount = 2 <= 2 ✓
  maxLength = max(3, 7-4+1) = 4

right = 8, nums[8] = 1:
  zeroCount = 2 <= 2 ✓
  maxLength = max(4, 8-4+1) = 5

right = 9, nums[9] = 1:
  zeroCount = 2 <= 2 ✓
  maxLength = max(5, 9-4+1) = 6

right = 10, nums[10] = 0:
  zeroCount = 3 > 2 → shrink window
  
  nums[left] = nums[4] = 0, zeroCount = 2, left = 5
  zeroCount = 2 <= 2 ✓
  maxLength = max(6, 10-5+1) = 6

Result: 6

The optimal window is [1,1,1,1,1,1] (indices 5-10) after flipping zeros at indices 5 and 10.

Another example:
nums = [0,0,1,1,1,0,0], k = 2

Initialize: left = 0, zeroCount = 0, maxLength = 0

right = 0, nums[0] = 0:
  zeroCount = 1 <= 2 ✓
  maxLength = 1

right = 1, nums[1] = 0:
  zeroCount = 2 <= 2 ✓
  maxLength = 2

right = 2, nums[2] = 1:
  zeroCount = 2 <= 2 ✓
  maxLength = 3

right = 3, nums[3] = 1:
  zeroCount = 2 <= 2 ✓
  maxLength = 4

right = 4, nums[4] = 1:
  zeroCount = 2 <= 2 ✓
  maxLength = 5

right = 5, nums[5] = 0:
  zeroCount = 3 > 2 → shrink window
  
  nums[left] = nums[0] = 0, zeroCount = 2, left = 1
  zeroCount = 2 <= 2 ✓
  maxLength = max(5, 5-1+1) = 5

right = 6, nums[6] = 0:
  zeroCount = 3 > 2 → shrink window
  
  nums[left] = nums[1] = 0, zeroCount = 2, left = 2
  zeroCount = 2 <= 2 ✓
  maxLength = max(5, 6-2+1) = 5

Result: 5

Why this works:
- Sliding window maintains at most k zeros (the ones we'll flip)
- When zeros > k, window is invalid, so shrink from left
- Each element is added and removed at most once
- Maximum window size equals maximum consecutive ones after k flips

Why this is optimal:
- Time: O(n) - single pass, optimal
- Space: O(1) - constant extra space
- No redundant calculations
- Efficient window management
- Handles all edge cases including k = 0

Key insights:
- Binary array property makes zero counting efficient
- Window constraint is based on zeros count, not window size
- Shrinking while invalid ensures window always has ≤k zeros
- Each element processed exactly twice (added and removed)

This is the perfect solution!
*/
