/**
 * Sliding Window Approach - Longest Repeating Character Replacement (OPTIMAL)
 * 
 * Logic:
 * - Use sliding window with two pointers: left and right
 * - Maintain character frequencies in current window
 * - Track most frequent character (maxFreq)
 * - If window size - maxFreq > k, shrink window
 * - Maximum window size found is the answer
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(n) - single pass through string
 * Space Complexity: O(1) - constant space (26 character frequencies)
 */
class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0, maxFreq = 0, maxLength = 0;
        
        for (int right = 0; right < s.length(); right++) {
            // Add current character to frequency
            freq[s.charAt(right) - 'A']++;
            
            // Update maximum frequency in window
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);
            
            // If window is invalid (needs more than k changes), shrink it
            if ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            
            // Update maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}

/*
Example Walkthrough:
s = "ABAB", k = 2

Initialize: freq = [0]*26, left = 0, maxFreq = 0, maxLength = 0

right = 0, s[0] = 'A':
  freq['A'] = 1
  maxFreq = max(0, 1) = 1
  window size = 1, maxFreq = 1, changes = 1-1=0 <= 2 ✓
  maxLength = max(0, 1) = 1

right = 1, s[1] = 'B':
  freq['B'] = 1
  maxFreq = max(1, 1) = 1
  window size = 2, maxFreq = 1, changes = 2-1=1 <= 2 ✓
  maxLength = max(1, 2) = 2

right = 2, s[2] = 'A':
  freq['A'] = 2
  maxFreq = max(1, 2) = 2
  window size = 3, maxFreq = 2, changes = 3-2=1 <= 2 ✓
  maxLength = max(2, 3) = 3

right = 3, s[3] = 'B':
  freq['B'] = 2
  maxFreq = max(2, 2) = 2
  window size = 4, maxFreq = 2, changes = 4-2=2 <= 2 ✓
  maxLength = max(3, 4) = 4

Result: 4

Another example:
s = "AABABBA", k = 1

Initialize: freq = [0]*26, left = 0, maxFreq = 0, maxLength = 0

right = 0, s[0] = 'A':
  freq['A'] = 1, maxFreq = 1
  window size = 1, changes = 1-1=0 <= 1 ✓
  maxLength = 1

right = 1, s[1] = 'A':
  freq['A'] = 2, maxFreq = 2
  window size = 2, changes = 2-2=0 <= 1 ✓
  maxLength = 2

right = 2, s[2] = 'B':
  freq['B'] = 1, maxFreq = 2
  window size = 3, changes = 3-2=1 <= 1 ✓
  maxLength = 3

right = 3, s[3] = 'A':
  freq['A'] = 3, maxFreq = 3
  window size = 4, changes = 4-3=1 <= 1 ✓
  maxLength = 4

right = 4, s[4] = 'B':
  freq['B'] = 2, maxFreq = 3
  window size = 5, changes = 5-3=2 > 1 ✗
  Shrink: freq['A']-- = 2, left = 1
  window size = 4, changes = 4-3=1 <= 1 ✓
  maxLength = 4

right = 5, s[5] = 'B':
  freq['B'] = 3, maxFreq = 3
  window size = 5, changes = 5-3=2 > 1 ✗
  Shrink: freq['A']-- = 1, left = 2
  window size = 4, changes = 4-3=1 <= 1 ✓
  maxLength = 4

right = 6, s[6] = 'A':
  freq['A'] = 2, maxFreq = 3
  window size = 5, changes = 5-3=2 > 1 ✗
  Shrink: freq['B']-- = 2, left = 3
  window size = 4, changes = 4-3=1 <= 1 ✓
  maxLength = 4

Result: 4

Why this works:
- window size - maxFreq represents minimum changes needed
- If changes needed > k, window is invalid, so we shrink
- We only need maxFreq, not exact character counts
- Each character is added and removed at most once
- Fixed alphabet size means O(1) space

Why this is optimal:
- Time: O(n) - single pass, optimal
- Space: O(1) - constant space due to fixed alphabet
- No redundant calculations
- Efficient window management
- Handles all cases including k = 0

Key insights:
- maxFreq can only increase or stay same
- When window is invalid, shrinking maintains maxFreq validity
- We don't need to know which character is most frequent
- Window size - maxFreq is the key condition

This is the perfect solution!
*/
