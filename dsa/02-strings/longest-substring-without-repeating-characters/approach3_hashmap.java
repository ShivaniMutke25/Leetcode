/**
 * Sliding Window with HashMap Approach - Longest Substring Without Repeating Characters
 * 
 * Logic:
 * - Use sliding window with two pointers: left and right
 * - Use HashMap to track last seen positions of characters
 * - When duplicate found, move left pointer past previous occurrence
 * - Track maximum window size found
 * 
 * When to use: When character set is large or unknown (Unicode)
 * When NOT to use: When character set is small and fixed (use array instead)
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

Why HashMap approach works:
- HashMap stores last seen position of each character
- When duplicate found, we can jump left pointer directly
- No need to scan through window to find duplicate
- Handles any character set (Unicode, etc.)

Why use HashMap over array:
- Works for any character set, not just lowercase
- More flexible for different input types
- Same time complexity O(n)
- Space depends on unique characters in string

Trade-offs:
- Time: O(n) - optimal
- Space: O(min(m,n)) - depends on character set
- More flexible than array approach
- Slightly slower due to HashMap overhead

When this is preferred:
- Character set is large or unknown
- Working with Unicode characters
- Need flexibility for different alphabets
- Memory is not a major constraint
*/
