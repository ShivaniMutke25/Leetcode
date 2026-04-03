/**
 * Two Pointers Approach - Move Zeroes (OPTIMAL)
 * 
 * Logic:
 * - Use two pointers: i for current position, j for next non-zero position
 * - When nums[i] is non-zero, swap with nums[j] if i != j
 * - Increment j after placing each non-zero
 * 
 * Key insight: j always points to where the next non-zero should go
 * 
 * When to use: Always - optimal in-place solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(n) - single pass through array
 * Space Complexity: O(1) - in-place modification
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;  // Position for next non-zero element
        
        // Move all non-zero elements to the front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // Swap only if i != j (avoid unnecessary swaps)
                if (i != j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}

/*
Example Walkthrough:
nums = [0,1,0,3,12]

Initialize: j = 0

i = 0, nums[0] = 0:
  - Skip (zero)
  - j remains 0

i = 1, nums[1] = 1:
  - nums[1] != 0 ✓
  - i != j (1 != 0) ✓
  - Swap: nums[0] = 1, nums[1] = 0
  - nums = [1,0,0,3,12]
  - j = 1

i = 2, nums[2] = 0:
  - Skip (zero)
  - j remains 1

i = 3, nums[3] = 3:
  - nums[3] != 0 ✓
  - i != j (3 != 1) ✓
  - Swap: nums[1] = 3, nums[3] = 0
  - nums = [1,3,0,0,12]
  - j = 2

i = 4, nums[4] = 12:
  - nums[4] != 0 ✓
  - i != j (4 != 2) ✓
  - Swap: nums[2] = 12, nums[4] = 0
  - nums = [1,3,12,0,0]
  - j = 3

Result: nums = [1,3,12,0,0]

Alternative visualization:
Original: [0,1,0,3,12]
Step 1:   [1,0,0,3,12] (moved 1 to position 0)
Step 2:   [1,3,0,0,12] (moved 3 to position 1)
Step 3:   [1,3,12,0,0] (moved 12 to position 2)

Why this works:
- j always points to the next available position for non-zero
- When we find a non-zero at i, we place it at position j
- If i > j, we're essentially "filling gaps" left by zeros
- The swap ensures the original position becomes zero
- Maintains relative order of non-zero elements

Optimization details:
- The check "if (i != j)" avoids unnecessary swaps when element is already in correct position
- Each element is processed exactly once
- No extra memory allocation

Edge cases handled:
- No zeros: array remains unchanged
- All zeros: array remains unchanged (all positions already have zeros)
- Single element: handled correctly
- Zeros at beginning, middle, or end

Why this is optimal:
- Time: O(n) - single pass
- Space: O(1) - in-place modification
- Maintains order requirement
- Minimal swaps (only when necessary)

This is the perfect solution!
*/
