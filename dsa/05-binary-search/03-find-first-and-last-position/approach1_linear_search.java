/**
 * Linear Search Approach - Find First and Last Position
 * 
 * Logic:
 * - Scan through array sequentially
 * - Find first and last occurrence of target
 * - Return positions or [-1,-1] if not found
 * 
 * When to use: Understanding problem, very small inputs
 * When NOT to use: Any realistic input - will be too slow
 * 
 * Time Complexity: O(n) - scan through all elements
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = -1, last = -1;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (first == -1) {
                    first = i;
                }
                last = i;
            }
        }
        
        return new int[]{first, last};
    }
}

/*
Example Walkthrough:
nums = [5,7,7,8,8,10], target = 8

i = 0, nums[0] = 5: 5 != 8
i = 1, nums[1] = 7: 7 != 8
i = 2, nums[2] = 7: 7 != 8
i = 3, nums[3] = 8: 8 == 8 ✓ → first = 3, last = 3
i = 4, nums[4] = 8: 8 == 8 ✓ → last = 4
i = 5, nums[5] = 10: 10 != 8

Result: [3,4]

Another example:
nums = [5,7,7,8,8,10], target = 6

i = 0, nums[0] = 5: 5 != 6
i = 1, nums[1] = 7: 7 != 6
i = 2, nums[2] = 7: 7 != 6
i = 3, nums[3] = 8: 8 != 6
i = 4, nums[4] = 8: 8 != 6
i = 5, nums[5] = 10: 10 != 6

Result: [-1,-1]

Another example:
nums = [2,2,2,2], target = 2

i = 0, nums[0] = 2: 2 == 2 ✓ → first = 0, last = 0
i = 1, nums[1] = 2: 2 == 2 ✓ → last = 1
i = 2, nums[2] = 2: 2 == 2 ✓ → last = 2
i = 3, nums[3] = 2: 2 == 2 ✓ → last = 3

Result: [0,3]

Why this is inefficient:
- Scans through all elements sequentially
- Time complexity is linear: O(n)
- For n=100,000, this is impractical
- Doesn't leverage sorted property of array

Key limitation: Doesn't use fact that array is sorted
*/
