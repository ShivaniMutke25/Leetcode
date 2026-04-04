/**
 * Brute Force Approach - Minimum Window Substring
 * 
 * Logic:
 * - Generate all possible windows in s
 * - For each window, check if it contains all characters from t
 * - Keep track of smallest valid window
 * 
 * When to use: Understanding the problem, very small inputs
 * When NOT to use: Any realistic input - will be extremely slow
 * 
 * Time Complexity: O(m²n) - O(m²) windows, each check O(n)
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }
        
        String result = "";
        int minLength = Integer.MAX_VALUE;
        
        // Generate all possible windows
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String window = s.substring(i, j + 1);
                
                if (containsAllChars(window, t) && window.length() < minLength) {
                    result = window;
                    minLength = window.length();
                }
            }
        }
        
        return result;
    }
    
    private boolean containsAllChars(String window, String t) {
        int[] count = new int[128]; // ASCII
        
        // Count characters in t
        for (char c : t.toCharArray()) {
            count[c]++;
        }
        
        // Subtract characters found in window
        for (char c : window.toCharArray()) {
            count[c]--;
        }
        
        // Check if all counts are <= 0 (all required chars found)
        for (char c : t.toCharArray()) {
            if (count[c] > 0) {
                return false;
            }
        }
        
        return true;
    }
}

/*
Example Walkthrough:
s = "ADOBECODEBANC", t = "ABC"

i = 0:
  j = 0..13: Check all windows starting at 0
  "A", "AD", ..., "ADOBECODEBA" - none contain all chars
  "ADOBECODEBAN" - contains A,B,N but not C
  "ADOBECODEBANC" - contains A,B,C ✓, minLength = 13, result = "ADOBECODEBANC"

i = 1:
  j = 1..13: Check all windows starting at 1
  "D", "DO", ..., "DOBECODEBAN" - none contain all chars
  "DOBECODEBANC" - contains A,B,C ✓, length = 12, result = "DOBECODEBANC"

i = 2:
  j = 2..13: Check all windows starting at 2
  ...
  "OBECODEBANC" - contains A,B,C ✓, length = 11, result = "OBECODEBANC"

i = 3:
  j = 3..13: Check all windows starting at 3
  ...
  "BECODEBANC" - contains A,B,C ✓, length = 10, result = "BECODEBANC"

i = 4:
  j = 4..13: Check all windows starting at 4
  ...
  "ECODEBANC" - contains A,B,C ✓, length = 9, result = "ECODEBANC"

i = 5:
  j = 5..13: Check all windows starting at 5
  ...
  "CODEBANC" - contains A,B,C ✓, length = 8, result = "CODEBANC"

i = 6:
  j = 6..13: Check all windows starting at 6
  ...
  "ODEBANC" - contains A,B,C ✓, length = 7, result = "ODEBANC"

i = 7:
  j = 7..13: Check all windows starting at 7
  ...
  "DEBANC" - contains A,B,C ✓, length = 6, result = "DEBANC"

i = 8:
  j = 8..13: Check all windows starting at 8
  ...
  "EBANC" - contains A,B,C ✓, length = 5, result = "EBANC"

i = 9:
  j = 9..13: Check all windows starting at 9
  ...
  "BANC" - contains A,B,C ✓, length = 4, result = "BANC"

i = 10,11,12: No shorter valid windows found

Result: "BANC"

Why this is extremely slow:
- Number of windows: m*(m+1)/2 = O(m²)
- For each window, character check: O(n)
- Total: O(m²n) time complexity
- For m=50,000, n=50,000, this is completely impractical

Key limitation: No optimization to avoid redundant checking
*/
