/**
 * Sliding Window with Array Approach - Longest Substring Without Repeating Characters (OPTIMAL)
 * 
 * Logic:
 * - Use sliding window with two pointers: left and right
 * - Use array to track last seen positions of characters
 * - When duplicate found, move left pointer past previous occurrence
 * - Track maximum window size found
 * 
 * When to use: Lowercase letters only, performance critical
 * When NOT to use: Large/Unicode character sets
 * 
 * Time Complexity: O(n) - single pass through string
 * Space Complexity: O(1) - constant space (fixed size array)
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastSeen = new int[128]; // ASCII
        Arrays.fill(lastSeen, -1);
        
        int left = 0, maxLength = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            // If character seen before and is within current window
            if (lastSeen[currentChar] >= left) {
                // Move left pointer past previous occurrence
                left = lastSeen[currentChar] + 1;
            }
            
            // Update last seen position
            lastSeen[currentChar] = right;
            
            // Update maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}

/*
Example Walkthrough:
s = "abcabcbb"

Initialize: lastSeen = [-1,-1,-1,...], left = 0, maxLength = 0

right = 0, currentChar = 'a':
  lastSeen['a'] = -1 < left(0) → no move
  lastSeen['a'] = 0
  maxLength = max(0, 0-0+1) = 1

right = 1, currentChar = 'b':
  lastSeen['b'] = -1 < left(0) → no move
  lastSeen['b'] = 1
  maxLength = max(1, 1-0+1) = 2

right = 2, currentChar = 'c':
  lastSeen['c'] = -1 < left(0) → no move
  lastSeen['c'] = 2
  maxLength = max(2, 2-0+1) = 3

right = 3, currentChar = 'a':
  lastSeen['a'] = 0 >= left(0) → left = 0 + 1 = 1
  lastSeen['a'] = 3
  maxLength = max(3, 3-1+1) = 3

right = 4, currentChar = 'b':
  lastSeen['b'] = 1 >= left(1) → left = 1 + 1 = 2
  lastSeen['b'] = 4
  maxLength = max(3, 4-2+1) = 3

right = 5, currentChar = 'c':
  lastSeen['c'] = 2 >= left(2) → left = 2 + 1 = 3
  lastSeen['c'] = 5
  maxLength = max(3, 5-3+1) = 3

right = 6, currentChar = 'b':
  lastSeen['b'] = 4 >= left(3) → left = 4 + 1 = 5
  lastSeen['b'] = 6
  maxLength = max(3, 6-5+1) = 2

right = 7, currentChar = 'b':
  lastSeen['b'] = 6 >= left(5) → left = 6 + 1 = 7
  lastSeen['b'] = 7
  maxLength = max(3, 7-7+1) = 1

Result: 3

Why this works:
- Array provides O(1) access to last seen position
- When duplicate found within window, jump left pointer directly
- No need to scan through window to find duplicate
- Each character processed at most twice

Why this is optimal:
- Time: O(n) - single pass, optimal
- Space: O(1) - constant space due to fixed array size
- Handles ASCII characters efficiently
- No redundant checking

Key insights:
- lastSeen[c] >= left ensures duplicate is within current window
- left = lastSeen[c] + 1 jumps past previous occurrence
- Array is faster than HashMap for fixed character sets
- maxLength tracks best window found

This is the perfect solution for ASCII characters!
*/
