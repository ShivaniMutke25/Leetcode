/**
 * Dutch National Flag Algorithm - Sort Colors (OPTIMAL)
 * 
 * Logic:
 * - Use three pointers: low (0 boundary), mid (current), high (2 boundary)
 * - Regions: [0..low-1] = 0s, [low..mid-1] = 1s, [mid..high] = unknown, [high+1..n-1] = 2s
 * - Process mid pointer:
 *   * If nums[mid] = 0: swap with low, move both low and mid
 *   * If nums[mid] = 1: just move mid
 *   * If nums[mid] = 2: swap with high, move only high
 * 
 * Key insight: Single pass partitioning of array into three regions
 * 
 * When to use: Always - optimal single-pass solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(n) - single pass through array
 * Space Complexity: O(1) - in-place modification
 */
class Solution {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        
        while (mid <= high) {
            if (nums[mid] == 0) {
                // Swap 0 to the left side
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // 1 is already in correct middle region
                mid++;
            } else { // nums[mid] == 2
                // Swap 2 to the right side
                swap(nums, mid, high);
                high--;
                // Don't increment mid here because we need to process the swapped element
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/*
Example Walkthrough:
nums = [2,0,2,1,1,0]

Initialize: low=0, mid=0, high=5

Regions:
[0..-1] = 0s (empty)
[0..-1] = 1s (empty)  
[0..5] = unknown: [2,0,2,1,1,0]
[6..5] = 2s (empty)

mid=0, nums[0]=2:
  - Swap nums[0] and nums[5]: [0,0,2,1,1,2]
  - high=4 (don't move mid, need to check swapped element)

mid=0, nums[0]=0:
  - Swap nums[0] and nums[0]: [0,0,2,1,1,2]
  - low=1, mid=2

mid=2, nums[2]=2:
  - Swap nums[2] and nums[4]: [0,0,1,1,2,2]
  - high=3 (don't move mid)

mid=2, nums[2]=1:
  - mid=3

mid=3, nums[3]=1:
  - mid=4

Now mid=4 > high=3, done!

Result: nums = [0,0,1,1,2,2]

Visualization of regions during algorithm:
Initial: [2,0,2,1,1,0]
          ^ ^       ^
          L M       H

After first swap: [0,0,2,1,1,2]
                 ^   ^   ^
                 L   M   H

After processing 0: [0,0,2,1,1,2]
                   ^ ^   ^
                   L M   H

Final state: [0,0,1,1,2,2]
               ^   ^   ^
               L   M   H

Why this works:
- Low pointer always points to first non-0 element
- High pointer always points to first non-2 element from right
- Mid pointer processes unknown region
- When we find 0, we know it belongs at low position
- When we find 2, we know it belongs at high position
- When we find 1, it's already in correct region

Invariant maintenance:
- Elements before low are always 0
- Elements after high are always 2
- Elements between low and mid-1 are always 1
- Elements between mid and high are being processed

Why this is optimal:
- Time: O(n) - single pass
- Space: O(1) - in-place modification
- Elegant partitioning algorithm
- Classic algorithm for three-way partitioning

This is the perfect solution!
*/
