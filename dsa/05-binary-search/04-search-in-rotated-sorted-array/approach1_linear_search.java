/**
 * Linear Search Approach - Search in Rotated Sorted Array
 * 
 * Logic:
 * - Scan through array sequentially
 * - Compare each element with target
 * - Return index if found, -1 otherwise
 * 
 * When to use: Understanding problem, very small inputs
 * When NOT to use: Any realistic input - will be too slow
 * 
 * Time Complexity: O(n) - scan through all elements
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        
        return -1;
    }
}

/*
Example Walkthrough:
nums = [4,5,6,7,0,1,2], target = 0

i = 0, nums[0] = 4: 4 != 0
i = 1, nums[1] = 5: 5 != 0
i = 2, nums[2] = 6: 6 != 0
i = 3, nums[3] = 7: 7 != 0
i = 4, nums[4] = 0: 0 == 0 ✓ → return 4

Result: 4

Another example:
nums = [4,5,6,7,0,1,2], target = 3

i = 0, nums[0] = 4: 4 != 3
i = 1, nums[1] = 5: 5 != 3
i = 2, nums[2] = 6: 6 != 3
i = 3, nums[3] = 7: 7 != 3
i = 4, nums[4] = 0: 0 != 3
i = 5, nums[5] = 2: 2 != 3

Result: -1

Another example:
nums = [1], target = 1

i = 0, nums[0] = 1: 1 == 1 ✓ → return 0

Result: 0

Why this is inefficient:
- Scans through all elements sequentially
- Time complexity is linear: O(n)
- For n=10,000, this is impractical
- Doesn't leverage sorted/rotated property of array

Key limitation: Doesn't use fact that array is rotated sorted
*/
