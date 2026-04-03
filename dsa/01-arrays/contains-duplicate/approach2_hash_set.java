/**
 * Hash Set Approach - Contains Duplicate (OPTIMAL)
 * 
 * Logic:
 * - Add each element to a set
 * - If element already in set, duplicate found
 * - If we can add all elements, no duplicate
 * 
 * When to use: Most situations - optimal for typical constraints
 * When NOT to use: Space is extremely limited and cannot use O(n) space
 * 
 * Time Complexity: O(n) - single pass through array
 * Space Complexity: O(n) - hash set stores elements
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        
        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        
        return false;
    }
}

/*
Example Walkthrough:
nums = [1,2,3,1]

num=1:
  - 1 not in seen
  - seen = {1}

num=2:
  - 2 not in seen
  - seen = {1, 2}

num=3:
  - 3 not in seen
  - seen = {1, 2, 3}

num=1:
  - 1 IS in seen ✓
  - Return true

Time Analysis:
  - Iterate: O(n)
  - Each add/contains: O(1) average
  - Total: O(n)

Space Analysis:
  - Set stores up to n elements: O(n)
*/