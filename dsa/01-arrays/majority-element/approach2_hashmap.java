/**
 * HashMap Approach - Majority Element
 * 
 * Logic:
 * - Use HashMap to count frequencies of each element
 * - Iterate through HashMap to find element with count > n/2
 * 
 * When to use: When extra space is acceptable, clean implementation
 * When NOT to use: Memory constraints are tight, O(1) space required
 * 
 * Time Complexity: O(n) - single pass to build HashMap, single pass to find majority
 * Space Complexity: O(n) - HashMap stores up to n unique elements
 */
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int n = nums.length;
        
        // Count frequencies of each element
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            
            // Early exit if we find majority element
            if (countMap.get(num) > n / 2) {
                return num;
            }
        }
        
        // This line should never be reached given problem constraints
        return -1;
    }
}

/*
Example Walkthrough:
nums = [3,2,3]

Building HashMap:
num = 3: countMap = {3:1}
num = 2: countMap = {3:1, 2:1}
num = 3: countMap = {3:2, 2:1}

Check for majority:
3 has count = 2 > 3/2 = 1.5 ✓
Return 3

Another example:
nums = [2,2,1,1,1,2,2]

Building HashMap:
num = 2: {2:1}
num = 2: {2:2}
num = 1: {2:2, 1:1}
num = 1: {2:2, 1:2}
num = 1: {2:2, 1:3}
num = 2: {2:3, 1:3}
num = 2: {2:4, 1:3}

Check for majority:
2 has count = 4 > 7/2 = 3.5 ✓
Return 2

Why this is better than brute force:
- Single pass to count all frequencies
- HashMap lookup/insertion is O(1) on average
- Early exit possible when majority found
- Total operations: O(n) vs O(n²)

Trade-offs:
- Time: O(n) - optimal
- Space: O(n) - uses extra memory
- Clean, readable code

When this is preferred:
- Memory is not a constraint
- Code clarity is important
- You want early exit optimization
*/
