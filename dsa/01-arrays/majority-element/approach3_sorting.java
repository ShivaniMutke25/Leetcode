/**
 * Sorting Approach - Majority Element
 * 
 * Logic:
 * - Sort the array
 * - Return the middle element at index n/2
 * 
 * Key insight: Majority element appears more than half the time,
 * so it must occupy the middle position after sorting
 * 
 * When to use: When O(1) space is needed, O(n log n) time acceptable
 * When NOT to use: When O(n) time is strictly required
 * 
 * Time Complexity: O(n log n) - sorting dominates
 * Space Complexity: O(1) or O(n) - depends on sort implementation
 */
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}

/*
Example Walkthrough:
nums = [3,2,3]

After sorting: [2,3,3]
Middle index = 3/2 = 1
nums[1] = 3 ✓

Another example:
nums = [2,2,1,1,1,2,2]

After sorting: [1,1,1,2,2,2,2]
Middle index = 7/2 = 3
nums[3] = 2 ✓

Why this works:
- Majority element appears > n/2 times
- In sorted array, these positions must include the middle
- Example: n=7, majority appears 4+ times
  * Positions 0,1,2,3,4,5,6
  * 4+ positions means it must include position 3 (middle)
  * Even if it starts at position 0: [M,M,M,M,...] - middle is M
  * Even if it ends at position 6: [...,M,M,M,M] - middle is M

Mathematical proof:
- Let M be majority element, count > n/2
- In sorted array, M occupies count consecutive positions
- The middle position is at index floor(n/2)
- Since count > n/2, M's range must include floor(n/2)
- Therefore nums[floor(n/2)] = M

Why this is useful:
- Very simple implementation
- O(1) extra space (in-place sort)
- No complex logic

Trade-offs:
- Time: O(n log n) - not optimal but good
- Space: O(1) - better than HashMap
- Code simplicity: Excellent

When this is preferred:
- O(1) space is required
- O(n log n) time is acceptable
- You want the simplest possible solution
*/
