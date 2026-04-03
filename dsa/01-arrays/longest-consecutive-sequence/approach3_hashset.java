/**
 * HashSet Approach - Longest Consecutive Sequence (OPTIMAL)
 * 
 * Logic:
 * - Add all numbers to HashSet for O(1) lookups
 * - For each number, only start sequence if num-1 doesn't exist
 * - This ensures we only count each sequence once
 * - Count consecutive numbers using HashSet lookups
 * 
 * Key insight: Only start counting from sequence beginnings
 * 
 * When to use: Always - meets O(n) time requirement
 * When NOT to use: Memory constraints are very tight
 * 
 * Time Complexity: O(n) - each number processed at most twice
 * Space Complexity: O(n) - HashSet to store all numbers
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        
        Set<Integer> numSet = new HashSet<>();
        int maxLength = 0;
        
        // Add all numbers to HashSet
        for (int num : nums) {
            numSet.add(num);
        }
        
        // Check each number as potential sequence start
        for (int num : nums) {
            // Only start counting if num is the beginning of a sequence
            // (i.e., num-1 doesn't exist in the set)
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;
                
                // Count consecutive numbers
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }
                
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        
        return maxLength;
    }
}

/*
Example Walkthrough:
nums = [100,4,200,1,3,2]

HashSet: {1,2,3,4,100,200}

Check each number:

num = 100:
  - Check if 99 exists: No ✓ (sequence start)
  - Count: 100,101(no) → length = 1
  - maxLength = 1

num = 4:
  - Check if 3 exists: Yes ✗ (not sequence start, skip)

num = 200:
  - Check if 199 exists: No ✓ (sequence start)
  - Count: 200,201(no) → length = 1
  - maxLength = 1

num = 1:
  - Check if 0 exists: No ✓ (sequence start)
  - Count: 1,2(yes),3(yes),4(yes),5(no) → length = 4
  - maxLength = 4 ⭐

num = 3:
  - Check if 2 exists: Yes ✗ (not sequence start, skip)

num = 2:
  - Check if 1 exists: Yes ✗ (not sequence start, skip)

Result: maxLength = 4

Why this is optimal:
- Each number is processed at most twice:
  * Once when adding to HashSet
  * Once when checking if it's a sequence start
- HashSet lookups are O(1) on average
- We avoid redundant work by only starting at sequence beginnings

Time complexity breakdown:
- Building HashSet: O(n)
- Checking sequence starts: O(n) (each number checked once)
- Counting sequences: O(n) total (each number counted at most once)
- Total: O(n)

Space complexity:
- HashSet stores n numbers: O(n)

This perfectly meets the problem requirements!
*/
