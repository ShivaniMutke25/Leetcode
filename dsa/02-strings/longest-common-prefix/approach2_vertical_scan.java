/**
 * Vertical Scan Approach - Longest Common Prefix (OPTIMAL)
 * 
 * Logic:
 * - Scan character by character vertically across all strings
 * - For each position, check if all strings have same character
 * - Stop when any string is too short or character differs
 * - Return prefix up to that point
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(mn) - m = min string length, n = number of strings
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        
        // Find the minimum string length
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }
        
        // Scan character by character
        for (int i = 0; i < minLength; i++) {
            char current = strs[0].charAt(i);
            
            // Check if all strings have same character at position i
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != current) {
                    return strs[0].substring(0, i);
                }
            }
        }
        
        // All characters up to minLength match
        return strs[0].substring(0, minLength);
    }
}

/*
Example Walkthrough:
strs = ["flower","flow","flight"]

minLength = min(6,4,6) = 4

i = 0: current = 'f'
  Check all strings at position 0:
    strs[1].charAt(0) = 'f' == 'f' ✓
    strs[2].charAt(0) = 'f' == 'f' ✓
  Continue

i = 1: current = 'l'
  Check all strings at position 1:
    strs[1].charAt(1) = 'l' == 'l' ✓
    strs[2].charAt(1) = 'l' == 'l' ✓
  Continue

i = 2: current = 'o'
  Check all strings at position 2:
    strs[1].charAt(2) = 'o' == 'o' ✓
    strs[2].charAt(2) = 'i' != 'o' ✗
  Return strs[0].substring(0, 2) = "fl"

Result: "fl"

Another example:
strs = ["dog","racecar","car"]

minLength = min(3,7,3) = 3

i = 0: current = 'd'
  Check all strings at position 0:
    strs[1].charAt(0) = 'r' != 'd' ✗
  Return strs[0].substring(0, 0) = ""

Result: ""

Why this works:
- Common prefix can't be longer than shortest string
- Vertical scan checks each position systematically
- Early termination when mismatch found
- Each character examined at most once per string

Why this is optimal:
- Time: O(mn) where m = min string length, n = number of strings
- Space: O(1) - no extra space needed
- Early termination reduces work in practice
- Simple and intuitive logic

Optimization details:
- minLength ensures we never go out of bounds
- Single pass through characters
- No redundant checking of already verified positions

This is the perfect solution!
*/
