/**
 * Brute Force Approach - Product of Array Except Self
 * 
 * Logic:
 * - For each element, multiply all other elements
 * - Store result in answer array
 * 
 * When to use: Understanding the problem, very small inputs
 * When NOT to use: Any realistic input - will TLE for n > 1000
 * 
 * Time Complexity: O(n²) - nested loops for each element
 * Space Complexity: O(1) - excluding output array
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        
        // For each element, calculate product of all other elements
        for (int i = 0; i < n; i++) {
            int product = 1;
            
            // Multiply all elements except nums[i]
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    product *= nums[j];
                }
            }
            
            answer[i] = product;
        }
        
        return answer;
    }
}

/*
Example Walkthrough:
nums = [1,2,3,4]

i = 0 (exclude nums[0] = 1):
  - Multiply: 2 × 3 × 4 = 24
  - answer[0] = 24

i = 1 (exclude nums[1] = 2):
  - Multiply: 1 × 3 × 4 = 12
  - answer[1] = 12

i = 2 (exclude nums[2] = 3):
  - Multiply: 1 × 2 × 4 = 8
  - answer[2] = 8

i = 3 (exclude nums[3] = 4):
  - Multiply: 1 × 2 × 3 = 6
  - answer[3] = 6

Result: answer = [24,12,8,6]

Why this is slow:
- For each element, we scan the entire array
- For n=100,000, that's ~10 billion operations
- We're doing the same multiplications repeatedly
- No optimization to reuse computed products

Key limitation: No optimization to avoid redundant calculations
*/
