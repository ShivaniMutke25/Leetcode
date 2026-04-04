/**
 * Optimized Sliding Window Approach - Minimum Window Substring
 * 
 * Logic:
 * - Use sliding window with character frequency counting
 * - Optimize by tracking required characters more efficiently
 * - Use character array instead of HashMap for lowercase letters
 * - Early termination when window becomes too large
 * 
 * When to use: When alphabet is known to be small, performance critical
 * When NOT to use: When character set is large or unknown
 * 
 * Time Complexity: O(m+n) - single pass through both strings
 * Space Complexity: O(1) - fixed size arrays for 26 letters
 */
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }
        
        // Frequency array for characters in t
        int[] need = new int[128]; // ASCII
        for (char c : t.toCharArray()) {
            need[c]++;
        }
        
        // Sliding window variables
        int left = 0, right = 0;
        int formed = 0; // Number of characters with required frequency
        int required = 0; // Number of unique characters needed
        
        // Count unique characters in t
        for (int i = 0; i < 128; i++) {
            if (need[i] > 0) {
                required++;
            }
        }
        
        // Track best window
        int[] result = {-1, -1, -1}; // [left, right, length]
        int[] window = new int[128];
        
        while (right < s.length()) {
            char c = s.charAt(right);
            window[c]++;
            
            // Check if current character fulfills a requirement
            if (need[c] > 0 && window[c] == need[c]) {
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
                window[leftChar]--;
                
                // Check if window is no longer valid
                if (need[leftChar] > 0 && window[leftChar] < need[leftChar]) {
                    formed--;
                }
                
                left++;
            }
            
            // Early termination if remaining characters can't form valid window
            if (s.length() - left < t.length()) {
                break;
            }
            
            right++;
        }
        
        return result[2] == -1 ? "" : s.substring(result[0], result[1] + 1);
    }
}

/*
Example Walkthrough:
s = "ADOBECODEBANC", t = "ABC"

need = {A:1, B:1, C:1}, required = 3
left = 0, right = 0, formed = 0, window = {}

right = 0, c = 'A':
  window['A'] = 1
  window['A'] == need['A'] → formed = 1
  formed (1) != required (3) → don't contract

right = 1, c = 'D':
  window['D'] = 1
  'D' not in need → formed unchanged

right = 2, c = 'O':
  window['O'] = 1
  'O' not in need → formed unchanged

right = 3, c = 'B':
  window['B'] = 1
  window['B'] == need['B'] → formed = 2
  formed (2) != required (3) → don't contract

right = 4, c = 'E':
  window['E'] = 1
  'E' not in need → formed unchanged

right = 5, c = 'C':
  window['C'] = 1
  window['C'] == need['C'] → formed = 3
  formed == required → start contracting

Contract while valid:
  left = 0, window valid, result = [0,5,6] = "ADOBEC"
  
  Remove 'A': window['A'] = 0
  window['A'] < need['A'] → formed = 2
  Stop contracting (window no longer valid)

Continue expanding...
Eventually find minimum window "BANC" at positions 9-12

Why this is optimized:
- Uses arrays instead of HashMap for better performance
- Pre-computes required character count
- Early termination when not enough characters remain
- More efficient character access with array indexing

Optimizations over HashMap version:
- Array access is O(1) vs HashMap O(1) average but faster in practice
- No need for key existence checks
- Pre-computed required count avoids repeated calculations
- Early termination saves unnecessary iterations

When this is preferred:
- Character set is small and known (ASCII, lowercase)
- Performance is critical
- Memory usage needs to be minimized
- Input size is large

Trade-offs:
- Time: O(m+n) - same asymptotic, but faster in practice
- Space: O(1) - fixed size arrays
- Less flexible than HashMap approach
- Better performance for known character sets
*/
