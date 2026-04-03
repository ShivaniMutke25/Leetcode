/**
 * Manacher's Algorithm Approach - Palindromic Substrings
 * 
 * Logic:
 * - Transform string to handle odd/even uniformly (insert '#')
 * - Use array to store palindrome radius at each position
 * - Use previously computed information to skip redundant checks
 * - Maintain right boundary and center of current palindrome
 * - Sum up all palindrome radii to get total count
 * 
 * When to use: When optimal O(n) time is critical, advanced algorithm
 * When NOT to use: When simplicity is preferred, typical interview constraints
 * 
 * Time Complexity: O(n) - linear time algorithm
 * Space Complexity: O(n) - transformed string + radius array
 */
class Solution {
    public int countSubstrings(String s) {
        if (s.length() <= 1) return s.length();
        
        // Transform string: insert '#' between characters and at ends
        String transformed = transformString(s);
        int n = transformed.length();
        int[] radius = new int[n];
        
        int center = 0, right = 0;
        int totalPalindromes = 0;
        
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
            
            // Each position contributes (radius[i] + 1) // 2 palindromes in original string
            totalPalindromes += (radius[i] + 1) / 2;
        }
        
        return totalPalindromes;
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
s = "abc"

Transformed: "#a#b#c#"
n = 7, radius = [0]*7

i = 0:
  center = 0, right = 0
  Expand: radius[0] = 0
  Update: center = 0, right = 0
  totalPalindromes += (0 + 1) / 2 = 0

i = 1:
  mirror = -1 (invalid)
  Expand: radius[1] = 1 ("#a#")
  Update: center = 1, right = 2
  totalPalindromes += (1 + 1) / 2 = 1

i = 2:
  mirror = 0, radius[0] = 0
  radius[2] = min(2-2=0, 0) = 0
  Expand: radius[2] = 1 ("#b#")
  Update: center = 2, right = 3
  totalPalindromes += (1 + 1) / 2 = 2

i = 3:
  mirror = 1, radius[1] = 1
  radius[3] = min(3-3=0, 1) = 0
  Expand: radius[3] = 0
  No update to center/right
  totalPalindromes += (0 + 1) / 2 = 2

i = 4:
  mirror = 2, radius[2] = 1
  radius[4] = min(3-4=-1, 1) = 0
  Expand: radius[4] = 1 ("#c#")
  Update: center = 4, right = 5
  totalPalindromes += (1 + 1) / 2 = 3

i = 5,6: Similar process, no additional palindromes

Result: 3

Why (radius[i] + 1) / 2:
- radius[i] represents palindrome radius in transformed string
- Each palindrome in transformed string corresponds to (radius + 1) / 2 palindromes in original
- Example: radius=1 ("#a#") corresponds to 1 palindrome ("a")
- radius=3 ("#a#b#a#") corresponds to 2 palindromes ("a", "aba")

Why Manacher's algorithm is O(n):
- Each character is processed at most twice
- Uses previously computed palindrome information
- Skips redundant character comparisons
- Linear time despite nested loops appearance

Key insights:
- Transform handles odd/even uniformly
- Mirror property allows skipping redundant work
- Right boundary optimization prevents unnecessary expansion
- Sum of radii gives total palindrome count

Trade-offs:
- Time: O(n) - optimal possible
- Space: O(n) - needs extra arrays
- Complex implementation
- Hard to debug and understand
- Usually overkill for interview constraints

This is academically optimal but practically complex.
*/
