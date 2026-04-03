/**
 * Brute Force Approach - Longest Palindromic Substring
 * 
 * Logic:
 * - Generate all possible substrings
 * - Check each substring if it's a palindrome
 * - Keep track of longest palindrome found
 * 
 * When to use: Understanding the problem, very small inputs
 * When NOT to use: Any realistic input - will be extremely slow
 * 
 * Time Complexity: O(n³) - O(n²) substrings, each check O(n)
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        
        String longest = "";
        
        // Generate all possible substrings
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String substring = s.substring(i, j + 1);
                
                // Check if substring is palindrome and longer than current longest
                if (isPalindrome(substring) && substring.length() > longest.length()) {
                    longest = substring;
                }
            }
        }
        
        return longest;
    }
    
    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}

/*
Example Walkthrough:
s = "babad"

i = 0:
  j = 0: substring = "b", isPalindrome ✓, longest = "b"
  j = 1: substring = "ba", isPalindrome ✗
  j = 2: substring = "bab", isPalindrome ✓, longest = "bab"
  j = 3: substring = "baba", isPalindrome ✗
  j = 4: substring = "babad", isPalindrome ✗

i = 1:
  j = 1: substring = "a", isPalindrome ✓, length=1 < 3
  j = 2: substring = "ab", isPalindrome ✗
  j = 3: substring = "aba", isPalindrome ✓, length=3 == 3
  j = 4: substring = "abad", isPalindrome ✗

i = 2:
  j = 2: substring = "b", isPalindrome ✓, length=1 < 3
  j = 3: substring = "ba", isPalindrome ✗
  j = 4: substring = "bad", isPalindrome ✗

i = 3:
  j = 3: substring = "a", isPalindrome ✓, length=1 < 3
  j = 4: substring = "ad", isPalindrome ✗

i = 4:
  j = 4: substring = "d", isPalindrome ✓, length=1 < 3

Result: "bab"

Why this is extremely slow:
- Number of substrings: n*(n+1)/2 = O(n²)
- For each substring, palindrome check: O(n)
- Total: O(n³) time complexity
- For n=1000, this is ~500 million operations

Key limitation: No optimization to avoid redundant checking
*/
