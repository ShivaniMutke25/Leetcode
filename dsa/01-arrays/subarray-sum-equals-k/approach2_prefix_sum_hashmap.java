/**
 * Prefix Sum + HashMap Approach - Subarray Sum Equals K (OPTIMAL)
 * 
 * Logic:
 * - Use prefix sums: prefix[i] = sum of nums[0..i]
 * - Subarray sum from i to j = prefix[j] - prefix[i-1]
 * - For each prefix[j], we need prefix[i-1] = prefix[j] - k
 * - Store prefix sums in HashMap with their frequencies
 * 
 * Key insight: If current prefix - k exists in map, we found valid subarrays
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Memory constraints are very tight
 * 
 * Time Complexity: O(n) - single pass through array
 * Space Complexity: O(n) - HashMap to store prefix sums
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);  // Base case: empty prefix
        
        int currentSum = 0;
        int count = 0;
        
        for (int num : nums) {
            currentSum += num;
            
            // Check if (currentSum - k) exists in prefix sums
            // If yes, there are prefixCount.get(currentSum - k) subarrays ending here
            if (prefixCount.containsKey(currentSum - k)) {
                count += prefixCount.get(currentSum - k);
            }
            
            // Update prefix sum count
            prefixCount.put(currentSum, prefixCount.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }
}

/*
Example Walkthrough:
nums = [1,1,1], k = 2

Initialize: prefixCount = {0:1}, currentSum = 0, count = 0

num = 1:
  - currentSum = 1
  - Check if (1 - 2 = -1) exists: No
  - Update prefixCount: {0:1, 1:1}

num = 1:
  - currentSum = 2
  - Check if (2 - 2 = 0) exists: Yes, count += 1 → count = 1
  - Update prefixCount: {0:1, 1:1, 2:1}

num = 1:
  - currentSum = 3
  - Check if (3 - 2 = 1) exists: Yes, count += 1 → count = 2
  - Update prefixCount: {0:1, 1:1, 2:1, 3:1}

Result: count = 2

Another example:
nums = [1,2,3], k = 3

Initialize: prefixCount = {0:1}, currentSum = 0, count = 0

num = 1:
  - currentSum = 1
  - Check if (1 - 3 = -2) exists: No
  - prefixCount: {0:1, 1:1}

num = 2:
  - currentSum = 3
  - Check if (3 - 3 = 0) exists: Yes, count += 1 → count = 1
  - prefixCount: {0:1, 1:1, 3:1}

num = 3:
  - currentSum = 6
  - Check if (6 - 3 = 3) exists: Yes, count += 1 → count = 2
  - prefixCount: {0:1, 1:1, 3:1, 6:1}

Result: count = 2

Why this works:
- prefixCount stores how many times each prefix sum has occurred
- When we see currentSum, any previous prefix of (currentSum - k) forms valid subarray
- Example: prefix[j] - prefix[i] = k → prefix[i] = prefix[j] - k
- We're essentially asking: "How many previous positions had sum = currentSum - k?"

Mathematical proof:
Let sum[i] = prefix sum up to index i
Subarray from i+1 to j has sum = sum[j] - sum[i]
We want sum[j] - sum[i] = k → sum[i] = sum[j] - k
So for each j, count how many i have sum[i] = sum[j] - k

Why base case {0:1}:
- Represents empty prefix before first element
- Allows subarrays starting from index 0 to be counted
- If currentSum = k, then currentSum - k = 0, so we count this subarray

Why this is optimal:
- Time: O(n) - single pass
- Space: O(n) - HashMap for prefix sums
- Handles negative numbers correctly
- Counts all overlapping subarrays

This is the perfect solution!
*/
