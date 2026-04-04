/**
 * Brute Force Approach - Longest Repeating Character Replacement
 * 
 * Logic:
 * - Check all possible substrings
 * - For each substring, calculate minimum changes needed
 * - Track longest valid substring
 * 
 * When to use: Understanding the problem, very small inputs
 * When NOT to use: Any realistic input - will be too slow
 * 
 * Time Complexity: O(n²) - O(n²) substrings, each check O(26)
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int characterReplacement(String s, int k) {
        int maxLength = 0;
        
        // Check all possible substrings
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String substring = s.substring(i, j + 1);
                
                if (canMakeRepeating(substring, k)) {
                    maxLength = Math.max(maxLength, substring.length());
                }
            }
        }
        
        return maxLength;
    }
    
    private boolean canMakeRepeating(String s, int k) {
        int[] freq = new int[26];
        int maxFreq = 0;
        
        // Count character frequencies
        for (char c : s.toCharArray()) {
            freq[c - 'A']++;
            maxFreq = Math.max(maxFreq, freq[c - 'A']);
        }
        
        // Minimum changes needed = length - max frequency
        return s.length() - maxFreq <= k;
    }
}

/*
Example Walkthrough:
s = "ABAB", k = 2

i = 0:
  j = 0: substring = "A", changes = 1-1=0 <= 2 ✓, maxLength = 1
  j = 1: substring = "AB", changes = 2-1=1 <= 2 ✓, maxLength = 2
  j = 2: substring = "ABA", changes = 3-2=1 <= 2 ✓, maxLength = 3
  j = 3: substring = "ABAB", changes = 4-2=2 <= 2 ✓, maxLength = 4

i = 1:
  j = 1: substring = "B", changes = 1-1=0 <= 2 ✓, maxLength = 4
  j = 2: substring = "BA", changes = 2-1=1 <= 2 ✓, maxLength = 4
  j = 3: substring = "BAB", changes = 3-2=1 <= 2 ✓, maxLength = 4

i = 2:
  j = 2: substring = "A", changes = 1-1=0 <= 2 ✓, maxLength = 4
  j = 3: substring = "AB", changes = 2-1=1 <= 2 ✓, maxLength = 4

i = 3:
  j = 3: substring = "B", changes = 1-1=0 <= 2 ✓, maxLength = 4

Result: 4

Why this is inefficient:
- Number of substrings: n*(n+1)/2 = O(n²)
- For each substring, frequency counting: O(26) = O(1)
- Total: O(n²) time complexity
- For n=100,000, this is completely impractical

Key limitation: No optimization to avoid redundant checking of overlapping substrings
*/
