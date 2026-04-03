/**
 * Division Approach - Product of Array Except Self
 * 
 * Logic:
 * - Calculate total product of all elements
 * - For each element, divide total product by that element
 * - Handle zero case separately
 * 
 * When to use: When division is allowed, simpler implementation
 * When NOT to use: When division is prohibited (problem requirement)
 * 
 * Time Complexity: O(n) - two passes through array
 * Space Complexity: O(1) - excluding output array
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        
        // Count zeros and calculate total product of non-zero elements
        int zeroCount = 0;
        int totalProduct = 1;
        
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            } else {
                totalProduct *= num;
            }
        }
        
        // Handle different zero scenarios
        if (zeroCount > 1) {
            // More than one zero: all products will be zero
            Arrays.fill(answer, 0);
        } else if (zeroCount == 1) {
            // Exactly one zero: only position with zero gets non-zero product
            for (int i = 0; i < n; i++) {
                answer[i] = (nums[i] == 0) ? totalProduct : 0;
            }
        } else {
            // No zeros: use division
            for (int i = 0; i < n; i++) {
                answer[i] = totalProduct / nums[i];
            }
        }
        
        return answer;
    }
}

/*
Example Walkthrough:
nums = [1,2,3,4]

zeroCount = 0, totalProduct = 1 × 2 × 3 × 4 = 24

No zeros case:
answer[0] = 24 / 1 = 24
answer[1] = 24 / 2 = 12
answer[2] = 24 / 3 = 8
answer[3] = 24 / 4 = 6

Result: answer = [24,12,8,6]

Example with zero:
nums = [1,0,3,4]

zeroCount = 1, totalProduct = 1 × 3 × 4 = 12

Exactly one zero case:
answer[0] = 0 (nums[0] != 0)
answer[1] = 12 (nums[1] == 0) ⭐
answer[2] = 0 (nums[2] != 0)
answer[3] = 0 (nums[3] != 0)

Result: answer = [0,12,0,0]

Why this works:
- If no zeros: each answer[i] = (product of all) / nums[i]
- If one zero: only position with zero gets product of others
- If multiple zeros: all products are zero

Trade-offs:
- Time: O(n) - optimal
- Space: O(1) - optimal
- Simplicity: Very clean when division allowed
- Limitation: Violates problem constraint (no division)

When this would be acceptable:
- Problem allows division
- You want the simplest solution
- Performance is critical and division is fast

Why not used in this problem:
- Explicit requirement: "without using the division operation"
- Need to show understanding of prefix/suffix product technique
*/
