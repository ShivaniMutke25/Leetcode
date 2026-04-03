/**
 * Center Expansion Approach - Longest Palindromic Substring (OPTIMAL)
 * 
 * Logic:
 * - Every palindrome has a center (character or between characters)
 * - For each center, expand left and right while characters match
 * - Track the longest palindrome found
 * - Handle both odd and even length palindromes
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(n²) - n centers, each expansion O(n)
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        
        String longest = "";
        
        for (int i = 0; i < s.length(); i++) {
            // Odd length palindrome (center at i)
            String oddPalindrome = expandAroundCenter(s, i, i);
            if (oddPalindrome.length() > longest.length()) {
                longest = oddPalindrome;
            }
            
            // Even length palindrome (center between i and i+1)
            String evenPalindrome = expandAroundCenter(s, i, i + 1);
            if (evenPalindrome.length() > longest.length()) {
                longest = evenPalindrome;
            }
        }
        
        return longest;
    }
    
    private String expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        
        // Return the palindrome substring
        return s.substring(left + 1, right);
    }
}

/*
Example Walkthrough:
s = "babad"

i = 0:
  Odd palindrome (center at 0):
    expandAroundCenter(s, 0, 0):
      left=0, right=0: s[0]='b', s[0]='b' → match
      left=-1, right=1: left < 0 → stop
    Return s.substring(0, 1) = "b"
  
  Even palindrome (center between 0 and 1):
    expandAroundCenter(s, 0, 1):
      left=0, right=1: s[0]='b', s[1]='a' → mismatch
    Return s.substring(1, 1) = ""
  
  longest = "b"

i = 1:
  Odd palindrome (center at 1):
    expandAroundCenter(s, 1, 1):
      left=1, right=1: s[1]='a', s[1]='a' → match
      left=0, right=2: s[0]='b', s[2]='b' → match
      left=-1, right=3: left < 0 → stop
    Return s.substring(1, 3) = "bab"
  
  Even palindrome (center between 1 and 2):
    expandAroundCenter(s, 1, 2):
      left=1, right=2: s[1]='a', s[2]='b' → mismatch
    Return s.substring(2, 2) = ""
  
  longest = "bab"

i = 2:
  Odd palindrome (center at 2):
    expandAroundCenter(s, 2, 2):
      left=2, right=2: s[2]='b', s[2]='b' → match
      left=1, right=3: s[1]='a', s[3]='a' → match
      left=0, right=4: s[0]='b', s[4]='d' → mismatch
    Return s.substring(1, 4) = "aba"
  
  Even palindrome (center between 2 and 3):
    expandAroundCenter(s, 2, 3):
      left=2, right=3: s[2]='b', s[3]='a' → mismatch
    Return s.substring(3, 3) = ""
  
  longest = "bab" (length 3)

i = 3, 4: Similar process, no longer palindrome found

Result: "bab"

Why this works:
- Every palindrome has a center (character for odd length, between characters for even)
- Expanding from center finds maximal palindrome for that center
- Checking all 2n-1 possible centers guarantees finding longest palindrome
- Each expansion is O(n) in worst case, but total is O(n²)

Why this is optimal:
- Time: O(n²) - optimal for this problem without complex algorithms
- Space: O(1) - constant extra space
- Simple and intuitive logic
- Handles both odd and even length palindromes
- Easy to implement and debug

This is the perfect solution!
*/
