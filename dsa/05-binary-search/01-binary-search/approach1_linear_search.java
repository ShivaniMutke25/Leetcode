/**
 * Linear Search Approach - Binary Search
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
nums = [-1,0,3,5,9,12], target = 9

i = 0, nums[0] = -1: -1 != 9
i = 1, nums[1] = 0: 0 != 9
i = 2, nums[2] = 3: 3 != 9
i = 3, nums[3] = 5: 5 != 9
i = 4, nums[4] = 9: 9 == 9 ✓ → return 4

Result: 4

Another example:
nums = [2,5,8,12,16], target = 10

i = 0, nums[0] = 2: 2 != 10
i = 1, nums[1] = 5: 5 != 10
i = 2, nums[2] = 8: 8 != 10
i = 3, nums[3] = 12: 12 != 10
i = 4, nums[4] = 16: 16 != 10

Result: -1

Why this is inefficient:
- Scans through all elements sequentially
- Time complexity is linear: O(n)
- For n=10,000, this is impractical
- Doesn't leverage the sorted property of the array

Key limitation: Doesn't use the fact that array is sorted
*/
