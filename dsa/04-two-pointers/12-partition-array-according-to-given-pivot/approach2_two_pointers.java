/**
 * Two Pointers Approach - Partition Array According to Given Pivot (OPTIMAL)
 * 
 * Logic:
 * - Use two pointers: left for building result, right for scanning
 * - Move elements < pivot to the left side
 * - Move elements >= pivot to the right side
 * - Continue until all elements are processed
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(n) - each element examined once
 * Space Complexity: O(1) - constant extra space
 */
class Solution {
    public int[] partition(int[] nums, int pivot) {
        int left = 0;
        
        // Move elements < pivot to the left
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] < pivot) {
                nums[left++] = nums[right];
            }
        }
        
        // Move elements >= pivot to the right
        for (int right = left; right < nums.length; right++) {
            nums[right] = nums[right];
        }
        
        return nums;
    }
}

/*
Example Walkthrough:
nums = [9,12,5,10,14,3,10], pivot = 10

Initialize: left = 0

First pass (elements < 10):
right = 0, nums[0] = 9 < 10 → nums[0] = 9, left = 1
right = 1, nums[1] = 12 < 10? No
right = 2, nums[2] = 5 < 10 → nums[1] = 5, left = 2
right = 3, nums[3] = 10 < 10? No
right = 4, nums[4] = 14 < 10? No
right = 5, nums[5] = 3 < 10 → nums[2] = 3, left = 3
right = 6, nums[6] = 10 < 10? No

After first pass: nums = [9,5,3,10,14,3,10], left = 3

Second pass (elements >= 10):
right = 3, nums[3] = 10 >= 10 → nums[3] = 10
right = 4, nums[4] = 14 >= 10 → nums[4] = 14
right = 5, nums[5] = 3 >= 10? No
right = 6, nums[6] = 10 >= 10 → nums[6] = 10

Final result: [9,5,3,10,14,10]

Another example:
nums = [3,2,1,4,5,6], pivot = 4

Initialize: left = 0

First pass (elements < 4):
right = 0, nums[0] = 3 < 4 → nums[0] = 3, left = 1
right = 1, nums[1] = 2 < 4 → nums[1] = 2, left = 2
right = 2, nums[2] = 1 < 4 → nums[2] = 1, left = 3
right = 3, nums[3] = 4 < 4? No
right = 4, nums[4] = 5 < 4? No
right = 5, nums[5] = 6 < 4? No

After first pass: nums = [3,2,1,4,5,6], left = 3

Second pass (elements >= 4):
right = 3, nums[3] = 4 >= 4 → nums[3] = 4
right = 4, nums[4] = 5 >= 4 → nums[4] = 5
right = 5, nums[5] = 6 >= 4 → nums[5] = 6

Final result: [3,2,1,4,5,6]

Why this works:
- Two pointers enable in-place partitioning
- Left pointer builds the less-than-pivot section
- Right pointer fills the greater-or-equal section
- Each element is examined exactly once
- No extra space needed

Why this is optimal:
- Time: O(n) - single pass, optimal
- Space: O(1) - constant extra space
- Truly in-place solution
- Efficient partitioning algorithm

Key insights:
- Two pointers can partition array in-place without extra space
- First pass moves all elements < pivot to the front
- Second pass fills remaining positions with elements >= pivot
- Each element is processed exactly once
- Order of equal elements can be either side (consistency is key)

This is the perfect solution!
*/
