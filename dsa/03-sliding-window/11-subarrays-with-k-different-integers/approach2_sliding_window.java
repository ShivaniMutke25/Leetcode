/**
 * Sliding Window Approach - Subarrays with K Different Integers (OPTIMAL)
 * 
 * Logic:
 * - Use inclusion-exclusion: exactly K = at most K - at most (K-1)
 * - Implement helper function to count subarrays with at most K distinct
 * - Use sliding window with frequency map to track distinct elements
 * - When distinct count > K, shrink window from left
 * - Count all valid subarrays ending at each position
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(n) - single pass through array
 * Space Complexity: O(k) - frequency map size
 */
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostKDistinct(nums, k) - atMostKDistinct(nums, k - 1);
    }
    
    private int atMostKDistinct(int[] nums, int k) {
        if (k < 0) return 0;
        
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0, count = 0, distinct = 0;
        
        for (int right = 0; right < nums.length; right++) {
            // Add current element to window
            if (freq.getOrDefault(nums[right], 0) == 0) {
                distinct++;
            }
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);
            
            // Shrink window while we have more than k distinct elements
            while (distinct > k) {
                int leftNum = nums[left];
                freq.put(leftNum, freq.get(leftNum) - 1);
                
                if (freq.get(leftNum) == 0) {
                    distinct--;
                }
                
                left++;
            }
            
            // All subarrays ending at right with at most k distinct elements
            // are valid, so add their count
            count += right - left + 1;
        }
        
        return count;
    }
}

/*
Example Walkthrough:
nums = [1,2,1,2,3], k = 2

First, calculate atMostKDistinct(nums, 2):

Initialize: freq = {}, left = 0, count = 0, distinct = 0

right = 0, nums[0] = 1:
  freq = {1:1}, distinct = 1 <= 2 ✓
  count += 0-0+1 = 1

right = 1, nums[1] = 2:
  freq = {1:1, 2:1}, distinct = 2 <= 2 ✓
  count += 1-0+1 = 2 → count = 3

right = 2, nums[2] = 1:
  freq = {1:2, 2:1}, distinct = 2 <= 2 ✓
  count += 2-0+1 = 3 → count = 6

right = 3, nums[3] = 2:
  freq = {1:2, 2:2}, distinct = 2 <= 2 ✓
  count += 3-0+1 = 4 → count = 10

right = 4, nums[4] = 3:
  freq = {1:2, 2:2, 3:1}, distinct = 3 > 2 → shrink
  
  leftNum = nums[0] = 1, freq = {1:1, 2:2, 3:1}, distinct = 3 > 2
  left = 1
  
  leftNum = nums[1] = 2, freq = {1:1, 2:1, 3:1}, distinct = 3 > 2
  left = 2
  
  leftNum = nums[2] = 1, freq = {1:0, 2:1, 3:1}, distinct = 2 <= 2
  left = 3
  
  count += 4-3+1 = 2 → count = 12

atMostKDistinct(nums, 2) = 12

Now, calculate atMostKDistinct(nums, 1):

Initialize: freq = {}, left = 0, count = 0, distinct = 0

right = 0, nums[0] = 1:
  freq = {1:1}, distinct = 1 <= 1 ✓
  count += 0-0+1 = 1

right = 1, nums[1] = 2:
  freq = {1:1, 2:1}, distinct = 2 > 1 → shrink
  
  leftNum = nums[0] = 1, freq = {1:0, 2:1}, distinct = 1 <= 1
  left = 1
  
  count += 1-1+1 = 1 → count = 2

right = 2, nums[2] = 1:
  freq = {2:1, 1:1}, distinct = 2 > 1 → shrink
  
  leftNum = nums[1] = 2, freq = {2:0, 1:1}, distinct = 1 <= 1
  left = 2
  
  count += 2-2+1 = 1 → count = 3

right = 3, nums[3] = 2:
  freq = {1:1, 2:1}, distinct = 2 > 1 → shrink
  
  leftNum = nums[2] = 1, freq = {1:0, 2:1}, distinct = 1 <= 1
  left = 3
  
  count += 3-3+1 = 1 → count = 4

right = 4, nums[4] = 3:
  freq = {2:1, 3:1}, distinct = 2 > 1 → shrink
  
  leftNum = nums[3] = 2, freq = {2:0, 3:1}, distinct = 1 <= 1
  left = 4
  
  count += 4-4+1 = 1 → count = 5

atMostKDistinct(nums, 1) = 5

Final result: 12 - 5 = 7

Why this works:
- atMostKDistinct counts all subarrays with ≤ K distinct elements
- exactly K = at most K - at most (K-1) by inclusion-exclusion
- Sliding window efficiently maintains at most K distinct constraint
- For each right position, all subarrays ending at right are counted

Why this is optimal:
- Time: O(n) - single pass for each atMostK call, total O(n)
- Space: O(k) - frequency map size limited by K
- Avoids O(n²) brute force
- Efficient window management

Key insights:
- Counting "at most K" is easier than "exactly K"
- Each position contributes to multiple valid subarrays
- Sliding window maintains the constraint efficiently
- Inclusion-exclusion principle simplifies the problem

This is the perfect solution!
*/
