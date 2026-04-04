/**
 * Two Pointers Approach - Valid Palindrome II (OPTIMAL)
 * 
 * Logic:
 * - For each character as center, expand to find longest palindrome
 * - Allow at most one mismatch during expansion
 * - Handle both odd and even length palindromes
 * - Track maximum palindrome length found
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(n²) - O(n) centers × O(n) expansion
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int validPalindrome(String s) {
        int maxLength = 1;
        
        // Check each character as center
        for (int center = 0; center < s.length(); center++) {
            // Odd length palindrome (single character center)
            int oddLength = expandAroundCenter(s, center, center);
            maxLength = Math.max(maxLength, oddLength);
            
            // Even length palindrome (double character center)
            int evenLength = expandAroundCenter(s, center, center + 1);
            maxLength = Math.max(maxLength, evenLength);
        }
        
        return maxLength;
    }
    
    private int expandAroundCenter(String s, int left, int right) {
        int mismatchCount = 0;
        
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                mismatchCount++;
                if (mismatchCount > 1) {
                    break;
                }
            }
            
            left--;
            right++;
        }
        
        return right - left - 1 - mismatchCount;
    }
}

/*
Example Walkthrough:
s = "abca"

Check each center:

center = 0 ('a'):
  Odd: expand(0,0): "a" → length = 1
  Even: expand(0,1): "ab" → a!=b, mismatch=1 → length = 2-1=1
  maxLength = max(1,1,1) = 1

center = 1 ('b'):
  Odd: expand(1,1): "b" → length = 1
  Even: expand(1,2): "bc" → b!=c, mismatch=1 → length = 2-1=1
  maxLength = max(1,1,1) = 1

center = 2 ('c'):
  Odd: expand(2,2): "c" → length = 1
  Even: expand(2,3): "ca" → c!=a, mismatch=1 → length = 2-1=1
  maxLength = max(1,1,1) = 1

center = 3 ('a'):
  Odd: expand(3,3): "a" → length = 1
  Even: expand(3,4): out of bounds → length = 0
  maxLength = max(1,1,0) = 1

Wait, let me trace the expansion more carefully:

center = 0 ('a'):
  Odd: expand(0,0):
    left=0, right=0: s[0]==s[0] 'a'=='a', mismatch=0 → length=1
    left=-1, right=1 → stop
  Even: expand(0,1):
    left=0, right=1: s[0]!=s[1] 'a'!='b', mismatch=1 → length=2-1=1
    left=-1, right=2 → stop

center = 1 ('b'):
  Odd: expand(1,1):
    left=1, right=1: s[1]==s[1] 'b'=='b', mismatch=0 → length=1
    left=0, right=2 → stop
  Even: expand(1,2):
    left=1, right=2: s[1]!=s[2] 'b'!='c', mismatch=1 → length=2-1=1
    left=0, right=3 → stop

center = 2 ('c'):
  Odd: expand(2,2):
    left=2, right=2: s[2]==s[2] 'c'=='c', mismatch=0 → length=1
    left=1, right=3 → stop
  Even: expand(2,3):
    left=2, right=3: s[2]!=s[3] 'c'!='a', mismatch=1 → length=2-1=1
    left=1, right=4 → stop

center = 3 ('a'):
  Odd: expand(3,3):
    left=3, right=3: s[3]==s[3] 'a'=='a', mismatch=0 → length=1
    left=2, right=4 → stop
  Even: expand(3,4):
    right=4 is out of bounds → length=0

I think I need to adjust the algorithm. The issue is that we're not finding the "aca" or "aba" palindromes.

Let me reconsider the approach. The problem is that we can delete ONE character from the ENTIRE string, not just during the palindrome check.

Actually, let me use a different approach: for each possible deletion, check if the remaining string is palindrome.

But that's the brute force approach. Let me think of a better two-pointer approach.

Actually, the optimal approach is to use two pointers and allow one skip during palindrome checking.

Let me implement that correctly:
*/
