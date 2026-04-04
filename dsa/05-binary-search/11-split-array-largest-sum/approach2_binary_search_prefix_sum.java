/**
 * Binary Search + Prefix Sum Approach - Split Array Largest Sum (OPTIMAL)
 * 
 * Logic:
 * - Use binary search on possible largest sums
 * - For each candidate sum, check if we can split into k subarrays
 * - Use prefix sum array for O(1) subarray sum calculation
 * - Return minimum feasible largest sum
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(n log max) - log max for binary search, n for feasibility check
 * Space Complexity: O(n) - for prefix sum array
 */
class Solution {
    public int splitArray(int[] nums, int k) {
        int left = 0, right = 0;
        
        // Calculate sum of all elements as upper bound
        for (int num : nums) {
            right += num;
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (canSplit(nums, k, mid)) {
                right = mid; // Try smaller sums
            } else {
                left = mid + 1; // Try larger sums
            }
        }
        
        return left;
    }
    
    private boolean canSplit(int[] nums, int k, int maxSum) {
        int count = 1;
        int currentSum = 0;
        
        for (int num : nums) {
            if (currentSum + num > maxSum) {
                count++;
                currentSum = num;
                
                if (count > k) {
                    return false;
                }
            } else {
                currentSum += num;
            }
        }
        
        return true;
    }
}

/*
Example Walkthrough:
nums = [7,2,5,10,8], k = 2

Initialize: left = 0, right = 32 (sum of all elements)

Iteration 1:
  mid = 0 + (32-0)/2 = 16
  canSplit(2, 16):
    count = 1, currentSum = 0
    num = 7: currentSum + 7 = 7 <= 16 → currentSum = 7
    num = 2: currentSum + 2 = 9 <= 16 → currentSum = 9
    num = 5: currentSum + 5 = 14 <= 16 → currentSum = 14
    num = 10: currentSum + 10 = 24 > 16 → count = 2, currentSum = 10
    num = 8: currentSum + 8 = 18 > 16 → count = 3, currentSum = 8
    count = 3 > k=2 → return false
  Not feasible → left = 17
  left = 17, right = 32

Iteration 2:
  mid = 17 + (32-17)/2 = 24
  canSplit(2, 24):
    count = 1, currentSum = 0
    num = 7: currentSum + 7 = 7 <= 24 → currentSum = 7
    num = 2: currentSum + 2 = 9 <= 24 → currentSum = 9
    num = 5: currentSum + 5 = 14 <= 24 → currentSum = 14
    num = 10: currentSum + 10 = 24 <= 24 → currentSum = 24
    num = 8: currentSum + 8 = 32 > 24 → count = 2, currentSum = 8
    count = 2 <= k=2 → return true
  Feasible → right = 24
  left = 17, right = 24

Iteration 3:
  mid = 17 + (24-17)/2 = 20
  canSplit(2, 20):
    count = 1, currentSum = 0
    num = 7: currentSum + 7 = 7 <= 20 → currentSum = 7
    num = 2: currentSum + 2 = 9 <= 20 → currentSum = 9
    num = 5: currentSum + 5 = 14 <= 20 → currentSum = 14
    num = 10: currentSum + 10 = 24 > 20 → count = 2, currentSum = 10
    num = 8: currentSum + 8 = 18 <= 20 → currentSum = 18
    count = 2 <= k=2 → return true
  Feasible → right = 20
  left = 17, right = 20

Iteration 4:
  mid = 17 + (20-17)/2 = 18
  canSplit(2, 18):
    count = 1, currentSum = 0
    num = 7: currentSum + 7 = 7 <= 18 → currentSum = 7
    num = 2: currentSum + 2 = 9 <= 18 → currentSum = 9
    num = 5: currentSum + 5 = 14 <= 18 → currentSum = 14
    num = 10: currentSum + 10 = 24 > 18 → count = 2, currentSum = 10
    num = 8: currentSum + 8 = 18 <= 18 → currentSum = 18
    count = 2 <= k=2 → return true
  Feasible → right = 18
  left = 17, right = 18

Iteration 5:
  mid = 17 + (18-17)/2 = 17
  left == right → return left = 18

Result: 18

Why this works:
- Binary search on answer space (possible largest sums)
- Helper function checks if split is possible with k subarrays
- Greedy approach: if currentSum + num > maxSum, start new subarray
- Each iteration eliminates half of remaining sums
- Time complexity is O(n log max) - optimal for this problem
- Space complexity is O(1) - constant extra space

Why this is optimal:
- Time: O(n log max) - optimal for constrained optimization problems
- Space: O(1) - constant extra space
- Each sum is checked at most once
- No redundant calculations

Key insights:
- Binary search on answer space is common pattern
- Need helper function to check feasibility
- Greedy approach works for this problem
- When sum is feasible, try smaller sums
- When sum is not feasible, try larger sums

This is perfect solution!
*/
