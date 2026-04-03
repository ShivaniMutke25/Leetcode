/**
 * Boyer-Moore Voting Algorithm - Majority Element (OPTIMAL)
 * 
 * Logic:
 * - Maintain a candidate and a count
 * - If count is 0, set current element as candidate
 * - If current element equals candidate, increment count
 * - Otherwise, decrement count
 * - At the end, candidate is the majority element
 * 
 * Key insight: Majority element can "cancel out" all other elements
 * since it appears more than half the time
 * 
 * When to use: Always - optimal solution with O(1) space
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(n) - single pass through array
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;
        
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        
        return candidate;
    }
}

/*
Example Walkthrough:
nums = [2,2,1,1,1,2,2]

num = 2:
  - count = 0, so candidate = 2, count = 1

num = 2:
  - num == candidate (2 == 2), so count = 2

num = 1:
  - num != candidate (1 != 2), so count = 1

num = 1:
  - num != candidate (1 != 2), so count = 0

num = 1:
  - count = 0, so candidate = 1, count = 1

num = 2:
  - num != candidate (2 != 1), so count = 0

num = 2:
  - count = 0, so candidate = 2, count = 1

Result: candidate = 2 ✓

Why this works:
- Think of it as votes: each occurrence of candidate is +1 vote
- Each occurrence of other elements is -1 vote
- Since majority element appears > n/2 times, it has more votes
- All other elements combined appear < n/2 times
- Net votes for majority element: > n/2 - < n/2 = positive
- So majority element "wins" the election

Mathematical proof:
- Let M be majority element, count(M) > n/2
- Let O be all other elements combined, count(O) < n/2
- Each M contributes +1, each O contributes -1
- Final count = count(M) - count(O) > n/2 - n/2 = 0
- Therefore, candidate must be M

Why this is optimal:
- Single pass: O(n) time
- Constant space: O(1) memory
- No sorting, no extra data structures
- Elegant and efficient

This is the perfect solution!
*/
