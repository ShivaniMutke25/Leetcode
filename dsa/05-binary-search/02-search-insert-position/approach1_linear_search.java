/**
 * Linear Search Approach - Search Insert Position
 * 
 * Logic:
 * - Scan through array sequentially
 * - Find target or insertion position
 * - Return appropriate index
 * 
 * When to use: Understanding problem, very small inputs
 * When NOT to use: Any realistic input - will be too slow
 * 
 * Time Complexity: O(n) - scan through all elements
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }
}

/*
Example Walkthrough:
nums = [1,3,5,6], target = 5

i = 0, nums[0] = 1: 1 < 5
i = 1, nums[1] = 3: 3 < 5
i = 2, nums[2] = 5: 5 >= 5 ✓ → return 2

Result: 2

Another example:
nums = [1,3,5,6], target = 7

i = 0, nums[0] = 1: 1 < 7
i = 1, nums[1] = 3: 3 < 7
i = 2, nums[2] = 5: 5 < 7
i = 3, nums[3] = 6: 6 < 7

Loop ends → return nums.length = 4

Result: 4

Another example:
nums = [2,4,6,8], target = 3

i = 0, nums[0] = 2: 2 < 3
i = 1, nums[1] = 4: 4 >= 3 ✓ → return 1

Result: 1

Why this is inefficient:
- Scans through all elements sequentially
- Time complexity is linear: O(n)
- For n=10,000, this is impractical
- Doesn't leverage sorted property of array

Key limitation: Doesn't use fact that array is sorted
*/
