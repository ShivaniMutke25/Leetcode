/**
 * Manacher's Algorithm Approach - Longest Palindromic Substring
 * 
 * Logic:
 * - Transform string to handle odd/even uniformly (insert '#')
 * - Use array to store palindrome radius at each position
 * - Use previously computed information to skip redundant checks
 * - Maintain right boundary and center of current palindrome
 * 
 * When to use: When optimal O(n) time is critical, advanced algorithm
 * When NOT to use: When simplicity is preferred, typical interview constraints
 * 
 * Time Complexity: O(n) - linear time algorithm
 * Space Complexity: O(n) - transformed string + radius array
 */
class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        
        // Transform string: insert '#' between characters and at ends
        String transformed = transformString(s);
        int n = transformed.length();
        int[] radius = new int[n];
        
        int center = 0, right = 0;
        int maxRadius = 0, maxCenter = 0;
        
        for (int i = 0; i < n; i++) {
            // Mirror position of i around center
            int mirror = 2 * center - i;
            
            // If i is within right boundary, use previously computed radius
            if (i < right) {
                radius[i] = Math.min(right - i, radius[mirror]);
            }
            
            // Try to expand palindrome centered at i
            while (i + radius[i] + 1 < n && i - radius[i] - 1 >= 0 &&
                   transformed.charAt(i + radius[i] + 1) == transformed.charAt(i - radius[i] - 1)) {
                radius[i]++;
            }
            
            // Update center and right boundary if expanded past right
            if (i + radius[i] > right) {
                center = i;
                right = i + radius[i];
            }
            
            // Track maximum palindrome
            if (radius[i] > maxRadius) {
                maxRadius = radius[i];
                maxCenter = i;
            }
        }
        
        // Extract longest palindrome from original string
        int start = (maxCenter - maxRadius) / 2;
        return s.substring(start, start + maxRadius);
    }
    
    private String transformString(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append('#');
        for (char c : s.toCharArray()) {
            sb.append(c);
            sb.append('#');
        }
        return sb.toString();
    }
}

/*
Example Walkthrough:
s = "babad"

Transformed: "#b#a#b#a#d#"
n = 11, radius = [0]*11

i = 0:
  center = 0, right = 0
  Expand: radius[0] = 0
  Update: center = 0, right = 0

i = 1:
  mirror = -1 (invalid)
  Expand: radius[1] = 1 ("#b#")
  Update: center = 1, right = 2

i = 2:
  mirror = 0, radius[0] = 0
  radius[2] = min(2-2=0, 0) = 0
  Expand: radius[2] = 3 ("#b#a#b#")
  Update: center = 2, right = 5

i = 3:
  mirror = 1, radius[1] = 1
  radius[3] = min(5-3=2, 1) = 1
  Expand: radius[3] = 1 (already optimal)
  No update to center/right

i = 4:
  mirror = 0, radius[0] = 0
  radius[4] = min(5-4=1, 0) = 0
  Expand: radius[4] = 3 ("#a#b#a#")
  Update: center = 4, right = 7

... continue for all positions

Max radius found = 3 at center = 2 or 4
Extract from original string:
start = (2 - 3) / 2 = 0
length = 3
Result: s.substring(0, 3) = "bab"

Why Manacher's algorithm is O(n):
- Each character is processed at most twice
- Uses previously computed palindrome information
- Skips redundant character comparisons
- Linear time despite nested loops appearance

Key insights:
- Transform handles odd/even uniformly
- Mirror property allows skipping redundant work
- Right boundary optimization prevents unnecessary expansion

Trade-offs:
- Time: O(n) - optimal possible
- Space: O(n) - needs extra arrays
- Complex implementation
- Hard to debug and understand
- Usually overkill for interview constraints

This is academically optimal but practically complex.
*/
