/**
 * Divide and Conquer Approach - Maximum Subarray
 * 
 * Logic:
 * - Divide array into two halves recursively
 * - Maximum subarray is either:
 *   1. Entirely in left half
 *   2. Entirely in right half
 *   3. Crossing the middle point
 * - For crossing case: maximum suffix of left + maximum prefix of right
 * 
 * When to use: Academic purposes, understanding divide and conquer
 * When NOT to use: Practical implementation - Kadane's is simpler
 * 
 * Time Complexity: O(n log n) - divide and conquer with O(n) combine
 * Space Complexity: O(log n) - recursion stack
 */
class Solution {
    public int maxSubArray(int[] nums) {
        return maxSubArrayHelper(nums, 0, nums.length - 1);
    }
    
    private int maxSubArrayHelper(int[] nums, int left, int right) {
        // Base case: single element
        if (left == right) {
            return nums[left];
        }
        
        int mid = left + (right - left) / 2;
        
        // Recursively find maximum in left and right halves
        int leftMax = maxSubArrayHelper(nums, left, mid);
        int rightMax = maxSubArrayHelper(nums, mid + 1, right);
        
        // Find maximum crossing subarray
        int crossingMax = maxCrossingSum(nums, left, mid, right);
        
        // Return the maximum of three cases
        return Math.max(Math.max(leftMax, rightMax), crossingMax);
    }
    
    private int maxCrossingSum(int[] nums, int left, int mid, int right) {
        // Maximum suffix sum in left half (including mid)
        int leftSuffix = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            leftSuffix = Math.max(leftSuffix, sum);
        }
        
        // Maximum prefix sum in right half (excluding mid)
        int rightPrefix = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            rightPrefix = Math.max(rightPrefix, sum);
        }
        
        // Combine left suffix and right prefix
        return leftSuffix + rightPrefix;
    }
}

/*
Example Walkthrough:
nums = [-2,1,-3,4,-1,2,1,-5,4]

Divide: [-2,1,-3,4] | [-1,2,1,-5,4]

Left side divide: [-2,1] | [-3,4]
Right side divide: [-1,2] | [1,-5,4]

Base cases:
- maxSubArray([-2,1]) = max(-2,1,-2+1) = 1
- maxSubArray([-3,4]) = max(-3,4,-3+4) = 4
- maxSubArray([-1,2]) = max(-1,2,-1+2) = 2
- maxSubArray([1]) = 1, maxSubArray([-5]) = -5, maxSubArray([4]) = 4

Combine right side [1,-5,4]:
- Left max: maxSubArray([1]) = 1
- Right max: maxSubArray([-5,4]) = 4
- Crossing: max suffix of [1] + max prefix of [-5,4] = 1 + 4 = 5
- Result: max(1,4,5) = 5

Continue combining up the tree...

Why this works:
- Any maximum subarray must be in one of three positions
- We recursively solve smaller subproblems
- Crossing case handles subarrays that span the divide

Complexity analysis:
- Each level of recursion does O(n) work (crossing sum)
- There are O(log n) levels
- Total: O(n log n)

Trade-offs vs Kadane's:
- Time: O(n log n) vs O(n) - Kadane's is better
- Space: O(log n) vs O(1) - Kadane's is better
- Complexity: Much more complex than Kadane's
- Educational value: Good for understanding divide and conquer

When this might be useful:
- Academic settings
- When you need to understand divide and conquer pattern
- Interview wants to see more advanced algorithm knowledge
*/
