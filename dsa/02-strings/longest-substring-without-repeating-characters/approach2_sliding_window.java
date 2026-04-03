/**
 * Sliding Window Approach - Longest Substring Without Repeating Characters (OPTIMAL)
 * 
 * Logic:
 * - Use sliding window with two pointers: left and right
 * - Use HashMap to track last seen position of each character
 * - When repeating character found, move left pointer past previous occurrence
 * - Keep track of maximum window size
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(n) - single pass through string
 * Space Complexity: O(min(m,n)) - HashMap stores at most min(character set, string length)
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        int left = 0, maxLength = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            // If character seen before and is within current window
            if (lastSeen.containsKey(currentChar) && lastSeen.get(currentChar) >= left) {
                // Move left pointer past previous occurrence
                left = lastSeen.get(currentChar) + 1;
            }
            
            // Update last seen position
            lastSeen.put(currentChar, right);
            
            // Update maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}

/*
Example Walkthrough:
s = "abcabcbb"

Initialize: lastSeen = {}, left = 0, maxLength = 0

right = 0, currentChar = 'a':
  'a' not in lastSeen
  lastSeen = {'a':0}
  maxLength = max(0, 0-0+1) = 1

right = 1, currentChar = 'b':
  'b' not in lastSeen
  lastSeen = {'a':0, 'b':1}
  maxLength = max(1, 1-0+1) = 2

right = 2, currentChar = 'c':
  'c' not in lastSeen
  lastSeen = {'a':0, 'b':1, 'c':2}
  maxLength = max(2, 2-0+1) = 3

right = 3, currentChar = 'a':
  'a' in lastSeen at position 0, and 0 >= left(0)
  left = 0 + 1 = 1
  lastSeen = {'a':3, 'b':1, 'c':2}
  maxLength = max(3, 3-1+1) = 3

right = 4, currentChar = 'b':
  'b' in lastSeen at position 1, and 1 >= left(1)
  left = 1 + 1 = 2
  lastSeen = {'a':3, 'b':4, 'c':2}
  maxLength = max(3, 4-2+1) = 3

right = 5, currentChar = 'c':
  'c' in lastSeen at position 2, and 2 >= left(2)
  left = 2 + 1 = 3
  lastSeen = {'a':3, 'b':4, 'c':5}
  maxLength = max(3, 5-3+1) = 3

right = 6, currentChar = 'b':
  'b' in lastSeen at position 4, and 4 >= left(3)
  left = 4 + 1 = 5
  lastSeen = {'a':3, 'b':6, 'c':5}
  maxLength = max(3, 6-5+1) = 2

right = 7, currentChar = 'b':
  'b' in lastSeen at position 6, and 6 >= left(5)
  left = 6 + 1 = 7
  lastSeen = {'a':3, 'b':7, 'c':5}
  maxLength = max(3, 7-7+1) = 1

Result: 3

Why this works:
- Sliding window [left, right] always contains unique characters
- When duplicate found, slide left past previous occurrence
- HashMap provides O(1) lookup of last seen position
- Each character processed at most twice (once by right, once by left)

Why we check lastSeen.get(currentChar) >= left:
- Previous occurrence might be outside current window
- If outside, no need to move left pointer
- Only move left if duplicate is within current window

Why this is optimal:
- Time: O(n) - single pass, optimal
- Space: O(min(m,n)) - at most one entry per unique character
- Handles all character types (not just lowercase)
- Clean, intuitive logic

This is the perfect solution!
*/
