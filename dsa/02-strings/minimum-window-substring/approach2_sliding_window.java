/**
 * Sliding Window Approach - Minimum Window Substring (OPTIMAL)
 * 
 * Logic:
 * - Use sliding window with two pointers: left and right
 * - Maintain frequency counts of characters needed from t
 * - Expand window to include all required characters
 * - Contract window to find minimum valid window
 * - Track best window found
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(m+n) - single pass through both strings
 * Space Complexity: O(1) - constant space (fixed character set)
 */
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }
        
        // Frequency map for characters in t
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        
        // Sliding window variables
        int left = 0, right = 0;
        int formed = 0; // Number of unique characters with required frequency
        int required = need.size(); // Number of unique characters needed
        
        // Track best window
        int[] result = {-1, -1, -1}; // [left, right, length]
        Map<Character, Integer> window = new HashMap<>();
        
        while (right < s.length()) {
            char c = s.charAt(right);
            
            // Add current character to window
            window.put(c, window.getOrDefault(c, 0) + 1);
            
            // Check if current character fulfills a requirement
            if (need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue()) {
                formed++;
            }
            
            // Contract window as much as possible while it's still valid
            while (left <= right && formed == required) {
                // Update best window
                if (result[2] == -1 || (right - left + 1) < result[2]) {
                    result[0] = left;
                    result[1] = right;
                    result[2] = right - left + 1;
                }
                
                // Remove leftmost character from window
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                
                // Check if window is no longer valid
                if (need.containsKey(leftChar) && window.get(leftChar).intValue() < need.get(leftChar).intValue()) {
                    formed--;
                }
                
                left++;
            }
            
            right++;
        }
        
        return result[2] == -1 ? "" : s.substring(result[0], result[1] + 1);
    }
}

/*
Example Walkthrough:
s = "ADOBECODEBANC", t = "ABC"

need = {'A':1, 'B':1, 'C':1}, required = 3
left = 0, right = 0, formed = 0, window = {}

right = 0, c = 'A':
  window = {'A':1}
  window.get('A') == need.get('A') → formed = 1
  formed (1) != required (3) → don't contract

right = 1, c = 'D':
  window = {'A':1, 'D':1}
  'D' not in need → formed unchanged

right = 2, c = 'O':
  window = {'A':1, 'D':1, 'O':1}
  'O' not in need → formed unchanged

right = 3, c = 'B':
  window = {'A':1, 'D':1, 'O':1, 'B':1}
  window.get('B') == need.get('B') → formed = 2
  formed (2) != required (3) → don't contract

right = 4, c = 'E':
  window = {'A':1, 'D':1, 'O':1, 'B':1, 'E':1}
  'E' not in need → formed unchanged

right = 5, c = 'C':
  window = {'A':1, 'D':1, 'O':1, 'B':1, 'E':1, 'C':1}
  window.get('C') == need.get('C') → formed = 3
  formed == required → start contracting

Contract while valid:
  left = 0, window valid, result = [0,5,6] = "ADOBEC"
  
  Remove 'A': window = {'A':0, 'D':1, 'O':1, 'B':1, 'E':1, 'C':1}
  window.get('A') < need.get('A') → formed = 2
  Stop contracting (window no longer valid)

Continue expanding...
Eventually find minimum window "BANC" at positions 9-12

Why this works:
- Sliding window maintains current substring
- need map tracks required character frequencies
- formed tracks how many requirements are met
- When formed == required, window contains all needed characters
- Contract to find minimum valid window
- Expand to find next valid window

Key insights:
- formed allows O(1) check if window is valid
- Contract while valid ensures minimum window for each right position
- Each character processed at most twice (entering and leaving window)

Why this is optimal:
- Time: O(m+n) - single pass through both strings
- Space: O(1) - constant space due to fixed character set
- No redundant checking
- Efficient frequency tracking

This is the perfect solution!
*/
