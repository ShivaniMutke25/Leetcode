/**
 * Sort Approach - Kth Largest Element in an Array
 * 
 * Logic:
 * - Sort array in descending order
 * - Return element at index k-1
 * 
 * When to use: Simple implementation, one-time query
 * When NOT to use: Multiple queries, streaming data
 * 
 * Time Complexity: O(n log n) - sorting
 * Space Complexity: O(1) - in-place sorting
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Sort in descending order
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

/*
Example Walkthrough:
nums = [3,2,1,5,6,4], k = 2

Sort: [1,2,3,4,5,6]
kth largest = nums[6-2] = nums[4] = 5

Result: 5

Another example:
nums = [3,2,3,1,2,4,5,5,6], k = 4

Sort: [1,2,2,3,3,4,5,5,6]
kth largest = nums[9-4] = nums[5] = 4

Result: 4

Why this works:
- Sorting puts elements in order
- kth largest is at position n-k from start
- Simple and easy to implement
- Works for any valid input

Why this is not optimal:
- Time complexity is O(n log n) - sorting entire array
- For multiple queries, we sort every time
- Doesn't leverage that we only need kth element
- Space complexity is O(1) but time is high

Key limitation: Sorting entire array when we only need kth element
*/
