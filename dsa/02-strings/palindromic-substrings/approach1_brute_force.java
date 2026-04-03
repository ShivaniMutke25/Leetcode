/**
 * Brute Force Approach - Palindromic Substrings
 * 
 * Logic:
 * - Generate all possible substrings
 * - Check each substring if it's a palindrome
 * - Count all palindromic substrings found
 * 
 * When to use: Understanding the problem, very small inputs
 * When NOT to use: Any realistic input - will be extremely slow
 * 
 * Time Complexity: O(n³) - O(n²) substrings, each check O(n)
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        
        // Generate all possible substrings
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String substring = s.substring(i, j + 1);
                
                if (isPalindrome(substring)) {
                    count++;
                }
            }
        }
        
        return count;
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
s = "abc"

i = 0:
  j = 0: substring = "a", isPalindrome ✓, count = 1
  j = 1: substring = "ab", isPalindrome ✗
  j = 2: substring = "abc", isPalindrome ✗

i = 1:
  j = 1: substring = "b", isPalindrome ✓, count = 2
  j = 2: substring = "bc", isPalindrome ✗

i = 2:
  j = 2: substring = "c", isPalindrome ✓, count = 3

Result: 3

Another example:
s = "aaa"

i = 0:
  j = 0: "a" ✓, count = 1
  j = 1: "aa" ✓, count = 2
  j = 2: "aaa" ✓, count = 3

i = 1:
  j = 1: "a" ✓, count = 4
  j = 2: "aa" ✓, count = 5

i = 2:
  j = 2: "a" ✓, count = 6

Result: 6

Why this is extremely slow:
- Number of substrings: n*(n+1)/2 = O(n²)
- For each substring, palindrome check: O(n)
- Total: O(n³) time complexity
- For n=1000, this is ~500 million operations

Key limitation: No optimization to avoid redundant checking
*/
