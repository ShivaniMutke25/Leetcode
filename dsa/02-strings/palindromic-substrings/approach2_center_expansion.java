/**
 * Center Expansion Approach - Palindromic Substrings (OPTIMAL)
 * 
 * Logic:
 * - Every palindrome has a center (character or between characters)
 * - For each center, expand left and right while characters match
 * - Each successful expansion represents one palindromic substring
 * - Handle both odd and even length palindromes
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(n²) - n centers, each expansion O(n)
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // Odd length palindromes (center at i)
            count += expandAroundCenter(s, i, i);
            
            // Even length palindromes (center between i and i+1)
            count += expandAroundCenter(s, i, i + 1);
        }
        
        return count;
    }
    
    private int expandAroundCenter(String s, int left, int right) {
        int palindromeCount = 0;
        
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            palindromeCount++;
            left--;
            right++;
        }
        
        return palindromeCount;
    }
}

/*
Example Walkthrough:
s = "abc"

i = 0:
  Odd palindrome (center at 0):
    expandAroundCenter(s, 0, 0):
      left=0, right=0: s[0]='a', s[0]='a' → match, count=1
      left=-1, right=1: left < 0 → stop
    Returns 1
  
  Even palindrome (center between 0 and 1):
    expandAroundCenter(s, 0, 1):
      left=0, right=1: s[0]='a', s[1]='b' → mismatch
    Returns 0
  
  count = 1

i = 1:
  Odd palindrome (center at 1):
    expandAroundCenter(s, 1, 1):
      left=1, right=1: s[1]='b', s[1]='b' → match, count=1
      left=0, right=2: s[0]='a', s[2]='c' → mismatch
    Returns 1
  
  Even palindrome (center between 1 and 2):
    expandAroundCenter(s, 1, 2):
      left=1, right=2: s[1]='b', s[2]='c' → mismatch
    Returns 0
  
  count = 1 + 1 + 1 = 3

i = 2:
  Odd palindrome (center at 2):
    expandAroundCenter(s, 2, 2):
      left=2, right=2: s[2]='c', s[2]='c' → match, count=1
      left=1, right=3: right >= length → stop
    Returns 1
  
  Even palindrome (center between 2 and 3):
    expandAroundCenter(s, 2, 3):
      left=2, right=3: right >= length → stop
    Returns 0
  
  count = 3 + 1 + 1 = 5

Wait, let me recalculate:
i = 0: count = 1 + 0 = 1
i = 1: count = 1 + (1 + 0) = 2
i = 2: count = 2 + (1 + 0) = 3

Result: 3

Another example:
s = "aaa"

i = 0:
  Odd: expandAroundCenter(s, 0, 0):
    left=0, right=0: match, count=1
    left=-1, right=1: stop
  Even: expandAroundCenter(s, 0, 1):
    left=0, right=1: match, count=1
    left=-1, right=2: stop
  count = 2

i = 1:
  Odd: expandAroundCenter(s, 1, 1):
    left=1, right=1: match, count=1
    left=0, right=2: match, count=2
    left=-1, right=3: stop
  Even: expandAroundCenter(s, 1, 2):
    left=1, right=2: match, count=1
    left=0, right=3: stop
  count = 2 + 3 = 5

i = 2:
  Odd: expandAroundCenter(s, 2, 2):
    left=2, right=2: match, count=1
    left=1, right=3: stop
  Even: expandAroundCenter(s, 2, 3):
    left=2, right=3: right >= length → stop
  count = 5 + 1 = 6

Result: 6

Why this works:
- Every palindrome has a center (character for odd length, between characters for even)
- Expanding from center finds all palindromes with that center
- Each successful expansion represents one palindrome
- Checking all 2n-1 possible centers guarantees counting all palindromes
- Each expansion is O(n) in worst case, but total is O(n²)

Why this is optimal:
- Time: O(n²) - optimal for this problem without complex algorithms
- Space: O(1) - constant extra space
- Simple and intuitive logic
- Handles both odd and even length palindromes
- Counts all palindromes efficiently

This is the perfect solution!
*/
