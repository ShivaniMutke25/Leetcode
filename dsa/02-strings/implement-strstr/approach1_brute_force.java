/**
 * Brute Force Approach - Implement strStr()
 * 
 * Logic:
 * - For each possible starting position in haystack
 * - Check if needle matches starting from that position
 * - Return first position where full match found
 * 
 * When to use: Understanding the problem, simple implementation
 * When NOT to use: Large inputs - will be too slow
 * 
 * Time Complexity: O(mn) - m positions, each comparison up to n characters
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        
        if (n == 0) return 0;
        if (m < n) return -1;
        
        for (int i = 0; i <= m - n; i++) {
            int j = 0;
            
            // Check if needle matches starting at position i
            while (j < n && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            
            if (j == n) {
                return i; // Found full match
            }
        }
        
        return -1; // No match found
    }
}

/*
Example Walkthrough:
haystack = "hello", needle = "ll"

m = 5, n = 2

i = 0:
  j = 0: haystack[0] = 'h', needle[0] = 'l' → mismatch, j = 0

i = 1:
  j = 0: haystack[1] = 'e', needle[0] = 'l' → mismatch, j = 0

i = 2:
  j = 0: haystack[2] = 'l', needle[0] = 'l' → match, j = 1
  j = 1: haystack[3] = 'l', needle[1] = 'l' → match, j = 2
  j = 2 == n → return 2

Result: 2

Another example:
haystack = "mississippi", needle = "issi"

i = 0: 'm' vs 'i' → mismatch
i = 1: 'i' vs 'i' → match, j=1
        's' vs 's' → match, j=2  
        's' vs 's' → match, j=3
        'i' vs 'i' → match, j=4 == n → return 1

Why this is slow:
- For each of (m-n+1) positions, we may compare up to n characters
- Worst case: O(mn) comparisons
- Example: haystack = "aaaaaa...ab", needle = "aaab"
  * We compare many characters before finding mismatch

Key limitation: No optimization to avoid re-examining previously matched characters
*/
