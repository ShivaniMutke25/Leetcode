/**
 * Linear Search Approach - Find Minimum in Rotated Sorted Array
 * 
 * Logic:
 * - Scan through array sequentially
 * - Find minimum element
 * - Return minimum value
 * 
 * When to use: Understanding problem, very small inputs
 * When NOT to use: Any realistic input - will be too slow
 * 
 * Time Complexity: O(n) - scan through all elements
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int findMin(int[] nums) {
        int min = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        
        return min;
    }
}

/*
Example Walkthrough:
nums = [3,4,5,1,2]

min = nums[0] = 3

i = 1, nums[1] = 4: 4 < 3? false
i = 2, nums[2] = 5: 5 < 3? false
i = 3, nums[3] = 1: 1 < 3? true → min = 1
i = 4, nums[4] = 2: 2 < 1? false

Result: 1

Another example:
nums = [4,5,6,7,0,1,2]

min = nums[0] = 4

i = 1, nums[1] = 5: 5 < 4? false
i = 2, nums[2] = 6: 6 < 4? false
i = 3, nums[3] = 7: 7 < 4? false
i = 4, nums[4] = 0: 0 < 4? true → min = 0
i = 5, nums[5] = 1: 1 < 0? false
i = 6, nums[6] = 2: 2 < 0? false

Result: 0

Another example (not rotated):
nums = [1,2,3,4,5]

min = nums[0] = 1

i = 1, nums[1] = 2: 2 < 1? false
i = 2, nums[2] = 3: 3 < 1? false
i = 3, nums[3] = 4: 4 < 1? false
i = 4, nums[4] = 5: 5 < 1? false

Result: 1

Why this is inefficient:
- Scans through all elements sequentially
- Time complexity is linear: O(n)
- For n=5000, this is acceptable but not optimal
- Doesn't leverage sorted/rotated property of array

Key limitation: Doesn't use binary search optimization
*/
