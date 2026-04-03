/**
 * KMP Algorithm Approach - Implement strStr() (OPTIMAL)
 * 
 * Logic:
 * - Build LPS (Longest Prefix Suffix) array for needle pattern
 * - LPS[i] = length of longest proper prefix which is also suffix for needle[0..i]
 * - Use LPS to skip unnecessary comparisons during matching
 * - When mismatch occurs, jump to LPS[matched-1] position instead of starting over
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(m+n) - O(n) for LPS, O(m) for matching
 * Space Complexity: O(n) - LPS array
 */
class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        
        if (n == 0) return 0;
        if (m < n) return -1;
        
        // Build LPS array for needle
        int[] lps = buildLPS(needle);
        
        int i = 0, j = 0; // i for haystack, j for needle
        
        while (i < m) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                
                if (j == n) {
                    return i - j; // Found full match
                }
            } else {
                if (j != 0) {
                    // Jump using LPS instead of starting from 0
                    j = lps[j - 1];
                } else {
                    i++; // Move to next character in haystack
                }
            }
        }
        
        return -1; // No match found
    }
    
    private int[] buildLPS(String pattern) {
        int n = pattern.length();
        int[] lps = new int[n];
        int len = 0; // Length of previous longest prefix suffix
        int i = 1;
        
        while (i < n) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        return lps;
    }
}

/*
Example Walkthrough:
haystack = "hello", needle = "ll"

Build LPS for "ll":
pattern = "ll", n = 2
i = 1, len = 0:
  pattern[1] = 'l', pattern[0] = 'l' → match
  len = 1, lps[1] = 1, i = 2
LPS = [0, 1]

Matching:
i = 0, j = 0:
haystack[0] = 'h', needle[0] = 'l' → mismatch
j = 0, so i = 1

i = 1, j = 0:
haystack[1] = 'e', needle[0] = 'l' → mismatch  
j = 0, so i = 2

i = 2, j = 0:
haystack[2] = 'l', needle[0] = 'l' → match
i = 3, j = 1

i = 3, j = 1:
haystack[3] = 'l', needle[1] = 'l' → match
i = 4, j = 2 == n → return 4-2 = 2

Result: 2

Complex example:
haystack = "ababcabcababc", needle = "abcabc"

LPS for "abcabc":
[0,0,0,1,2,3]

Matching process shows how LPS helps skip comparisons:
When mismatch occurs at position where we have partial match,
we jump to LPS[matched-1] instead of starting from beginning.

Why KMP is optimal:
- LPS preprocessing: O(n) time, O(n) space
- Matching: O(m) time (no backtracking in haystack)
- Total: O(m+n) vs O(mn) for brute force
- Each character in haystack is examined at most once

Key insight:
LPS tells us how many characters we can "keep" from previous match
when a mismatch occurs, avoiding redundant comparisons.

This is the perfect solution!
*/
