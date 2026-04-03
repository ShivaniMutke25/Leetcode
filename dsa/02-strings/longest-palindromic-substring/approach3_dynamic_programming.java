/**
 * Dynamic Programming Approach - Longest Palindromic Substring
 * 
 * Logic:
 * - Use DP table dp[i][j] = true if s[i..j] is palindrome
 * - Base cases: dp[i][i] = true (single character)
 * - dp[i][j] = (s[i] == s[j]) && (j-i <= 2 || dp[i+1][j-1])
 * - Fill table by increasing substring length
 * 
 * When to use: When DP pattern is preferred, educational purposes
 * When NOT to use: Memory constraints tight, simpler solutions preferred
 * 
 * Time Complexity: O(n²) - filling n×n DP table
 * Space Complexity: O(n²) - DP table storage
 */
class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        
        String longest = "";
        int maxLength = 0;
        
        // All substrings of length 1 are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            longest = s.substring(i, i + 1);
            maxLength = 1;
        }
        
        // Check substrings of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                longest = s.substring(i, i + 2);
                maxLength = 2;
            }
        }
        
        // Check substrings of length 3 and more
        for (int length = 3; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                
                // s[i..j] is palindrome if:
                // 1. End characters match
                // 2. Inner substring s[i+1..j-1] is palindrome
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    
                    if (length > maxLength) {
                        longest = s.substring(i, j + 1);
                        maxLength = length;
                    }
                }
            }
        }
        
        return longest;
    }
}

/*
Example Walkthrough:
s = "babad", n = 5

Initialize dp[5][5] = false

Base cases (length 1):
dp[0][0] = true, dp[1][1] = true, dp[2][2] = true, dp[3][3] = true, dp[4][4] = true
longest = "b", maxLength = 1

Length 2:
i=0, j=1: s[0]='b', s[1]='a' → dp[0][1] = false
i=1, j=2: s[1]='a', s[2]='b' → dp[1][2] = false
i=2, j=3: s[2]='b', s[3]='a' → dp[2][3] = false
i=3, j=4: s[3]='a', s[4]='d' → dp[3][4] = false

Length 3:
i=0, j=2: s[0]='b', s[2]='b' && dp[1][1]=true → dp[0][2] = true
  longest = "bab", maxLength = 3
i=1, j=3: s[1]='a', s[3]='a' && dp[2][2]=true → dp[1][3] = true
  length=3 == maxLength, keep "bab"
i=2, j=4: s[2]='b', s[4]='d' → dp[2][4] = false

Length 4:
i=0, j=3: s[0]='b', s[3]='a' → dp[0][3] = false
i=1, j=4: s[1]='a', s[4]='d' → dp[1][4] = false

Length 5:
i=0, j=4: s[0]='b', s[4]='d' → dp[0][4] = false

Result: "bab"

DP recurrence explained:
dp[i][j] = true if:
1. s[i] == s[j] (end characters match)
2. AND (j-i <= 2 OR dp[i+1][j-1] == true)
   - j-i <= 2 handles base cases (length 1 or 2)
   - dp[i+1][j-1] checks inner substring

Why this works:
- Builds solution from smaller subproblems
- Each substring result depends on smaller substring
- Systematic filling by increasing length ensures dependencies are ready

Trade-offs:
- Time: O(n²) - same as center expansion
- Space: O(n²) - much higher than center expansion's O(1)
- Clear DP pattern
- Easier to understand for some
- Good for demonstrating DP concepts

When this is useful:
- Learning dynamic programming
- When DP table is needed for other queries
- Educational purposes
*/
