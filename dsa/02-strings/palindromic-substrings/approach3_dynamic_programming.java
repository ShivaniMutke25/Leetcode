/**
 * Dynamic Programming Approach - Palindromic Substrings
 * 
 * Logic:
 * - Use DP table dp[i][j] = true if s[i..j] is palindrome
 * - Base cases: dp[i][i] = true (single character)
 * - dp[i][j] = (s[i] == s[j]) && (j-i <= 2 || dp[i+1][j-1])
 * - Fill table by increasing substring length
 * - Count all true entries in dp table
 * 
 * When to use: When DP pattern is preferred, educational purposes
 * When NOT to use: Memory constraints tight, simpler solutions preferred
 * 
 * Time Complexity: O(n²) - filling n×n DP table
 * Space Complexity: O(n²) - DP table storage
 */
class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;
        
        // All substrings of length 1 are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            count++;
        }
        
        // Check substrings of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                count++;
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
                    count++;
                }
            }
        }
        
        return count;
    }
}

/*
Example Walkthrough:
s = "abc", n = 3

Initialize dp[3][3] = false, count = 0

Base cases (length 1):
dp[0][0] = true, count = 1
dp[1][1] = true, count = 2
dp[2][2] = true, count = 3

Length 2:
i=0, j=1: s[0]='a', s[1]='b' → dp[0][1] = false
i=1, j=2: s[1]='b', s[2]='c' → dp[1][2] = false

Length 3:
i=0, j=2: s[0]='a', s[2]='c' → dp[0][2] = false

Result: count = 3

Another example:
s = "aaa", n = 3

Initialize dp[3][3] = false, count = 0

Base cases (length 1):
dp[0][0] = true, count = 1
dp[1][1] = true, count = 2
dp[2][2] = true, count = 3

Length 2:
i=0, j=1: s[0]='a', s[1]='a' → dp[0][1] = true, count = 4
i=1, j=2: s[1]='a', s[2]='a' → dp[1][2] = true, count = 5

Length 3:
i=0, j=2: s[0]='a', s[2]='a' && dp[1][1]=true → dp[0][2] = true, count = 6

Result: count = 6

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
- Count all true entries in DP table

Trade-offs:
- Time: O(n²) - same as center expansion
- Space: O(n²) - much higher than center expansion's O(1)
- Clear DP pattern
- Easy to understand for some
- Good for demonstrating DP concepts

When this is useful:
- Learning dynamic programming
- When DP table is needed for other queries
- Educational purposes
- When memory is not a constraint
*/
