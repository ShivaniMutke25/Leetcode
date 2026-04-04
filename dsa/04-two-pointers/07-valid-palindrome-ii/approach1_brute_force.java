/**
 * Brute Force Approach - Valid Palindrome II
 * 
 * Logic:
 * - Try deleting each character from the string
 * - Check if the remaining string is palindrome
 * - Track the maximum palindrome length found
 * 
 * When to use: Understanding problem, very small inputs
 * When NOT to use: Any realistic input - will be too slow
 * 
 * Time Complexity: O(n³) - O(n) deletions × O(n²) palindrome checks
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int validPalindrome(String s) {
        int maxLength = 1; // Single character is always valid
        
        // Try deleting each character
        for (int i = 0; i < s.length(); i++) {
            String remaining = s.substring(0, i) + s.substring(i + 1);
            
            if (isPalindrome(remaining)) {
                maxLength = Math.max(maxLength, remaining.length());
            }
        }
        
        // Also check original string (no deletion needed)
        if (isPalindrome(s)) {
            maxLength = Math.max(maxLength, s.length());
        }
        
        return maxLength;
    }
    
    private boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
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
s = "abca"

Try deleting each character:

Delete index 0 ('a'): remaining = "bca"
  Check if "bca" is palindrome: "b" != "a" ✗

Delete index 1 ('b'): remaining = "aca"
  Check if "aca" is palindrome: "a" == "a" ✓ → maxLength = 3

Delete index 2 ('c'): remaining = "aba"
  Check if "aba" is palindrome: "a" == "a" ✓ → maxLength = 3

Delete index 3 ('a'): remaining = "abc"
  Check if "abc" is palindrome: "a" != "c" ✗

Check original: "abca"
  Check if "abca" is palindrome: "a" != "a" ✗

Result: 3

Why this is inefficient:
- For each deletion (O(n)), we check palindrome (O(n²))
- Total: O(n³) time complexity
- For n=100,000, this is completely impractical
- Redundant palindrome checking for overlapping substrings

Key limitation: Doesn't optimize palindrome checking efficiently
*/
