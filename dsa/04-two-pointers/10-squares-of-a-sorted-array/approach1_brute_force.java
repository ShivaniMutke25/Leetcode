/**
 * Brute Force Approach - Squares of a Sorted Array
 * 
 * Logic:
 * - Square all elements in the array
 * - Sort the squared array
 * - Return sorted result
 * 
 * When to use: Understanding problem, very small inputs
 * When NOT to use: Any realistic input - will be too slow
 * 
 * Time Complexity: O(n log n) - O(n) to square + O(n log n) to sort
 * Space Complexity: O(n) - for storing squared array
 */
class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] squared = new int[nums.length];
        
        // Square all elements
        for (int i = 0; i < nums.length; i++) {
            squared[i] = nums[i] * nums[i];
        }
        
        // Sort the squared array
        Arrays.sort(squared);
        
        return squared;
    }
}

/*
Example Walkthrough:
nums = [-4,-1,0,3,10]

Square all elements:
squared[0] = (-4)² = 16
squared[1] = (-1)² = 1
squared[2] = 0² = 0
squared[3] = 3² = 9
squared = [16,1,0,9]

Sort squared array:
Arrays.sort([16,1,0,9]) → [0,1,9,16]

Result: [0,1,9,16]

Why this is inefficient:
- Squaring is O(n), which is optimal
- Sorting is O(n log n), which is the bottleneck
- Doesn't leverage the fact that original array is already sorted
- Could be done in O(n) with two pointers

Key limitation: Doesn't leverage sorted property of input array
*/
