/**
 * Prefix/Suffix Products Approach - Product of Array Except Self (OPTIMAL)
 * 
 * Logic:
 * - First pass: compute prefix products (product of all elements to the left)
 * - Second pass: compute suffix products and combine with prefix
 * - answer[i] = prefix[i] * suffix[i]
 * 
 * Key insight: answer[i] = (product of elements before i) × (product of elements after i)
 * 
 * When to use: Always - meets O(n) time without division requirement
 * When NOT to use: Never, this is the optimal solution
 * 
 * Time Complexity: O(n) - two passes through array
 * Space Complexity: O(n) - output array + one auxiliary array
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        
        // First pass: compute prefix products
        // answer[i] will store product of all elements to the left of i
        answer[0] = 1;  // No elements to the left of first element
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        
        // Second pass: compute suffix products and combine
        // suffix will store product of all elements to the right of current position
        int suffix = 1;  // No elements to the right of last element
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= suffix;
            suffix *= nums[i];
        }
        
        return answer;
    }
}

/*
Example Walkthrough:
nums = [1,2,3,4]

First pass - Prefix products:
answer[0] = 1 (no elements to left)
answer[1] = answer[0] * nums[0] = 1 * 1 = 1
answer[2] = answer[1] * nums[1] = 1 * 2 = 2
answer[3] = answer[2] * nums[2] = 2 * 3 = 6

answer = [1,1,2,6] (prefix products)

Second pass - Suffix products:
Initialize suffix = 1

i = 3 (rightmost):
  answer[3] *= suffix → 6 * 1 = 6
  suffix *= nums[3] → 1 * 4 = 4

i = 2:
  answer[2] *= suffix → 2 * 4 = 8
  suffix *= nums[2] → 4 * 3 = 12

i = 1:
  answer[1] *= suffix → 1 * 12 = 12
  suffix *= nums[1] → 12 * 2 = 24

i = 0:
  answer[0] *= suffix → 1 * 24 = 24
  suffix *= nums[0] → 24 * 1 = 24

Final answer = [24,12,8,6]

Verification:
answer[0] = 24 = 2×3×4 (product of elements to right of index 0)
answer[1] = 12 = 1×3×4 (product of elements except index 1)
answer[2] = 8 = 1×2×4 (product of elements except index 2)
answer[3] = 6 = 1×2×3 (product of elements to left of index 3)

Why this works:
- First pass builds prefix products: answer[i] = product of nums[0..i-1]
- Second pass multiplies by suffix products: answer[i] *= product of nums[i+1..n-1]
- Final answer[i] = product of all elements except nums[i]

Space optimization:
- We use answer array to store prefix products
- Only one extra variable (suffix) needed for right-to-left pass
- Overall space: O(n) for output array (required anyway)

Why this is optimal:
- Time: O(n) - two linear passes
- Space: O(n) - output array only (optimal for this problem)
- No division used
- Handles zeros naturally
- Elegant and efficient

This is the perfect solution that meets all requirements!
*/
