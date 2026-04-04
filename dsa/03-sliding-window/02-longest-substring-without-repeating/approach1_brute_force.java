/**
 * Brute Force Approach - Longest Substring Without Repeating Characters
 * 
 * Logic:
 * - Generate all possible substrings
 * - Check each substring for unique characters
 * - Keep track of longest unique substring
 * 
 * When to use: Understanding the problem, very small inputs
 * When NOT to use: Any realistic input - will be extremely slow
 * 
 * Time Complexity: O(n³) - O(n²) substrings, each uniqueness check O(n)
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        
        // Generate all possible substrings
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String substring = s.substring(i, j + 1);
                
                if (hasUniqueCharacters(substring)) {
                    maxLength = Math.max(maxLength, substring.length());
                }
            }
        }
        
        return maxLength;
    }
    
    private boolean hasUniqueCharacters(String s) {
        Set<Character> seen = new HashSet<>();
        
        for (char c : s.toCharArray()) {
            if (seen.contains(c)) {
                return false;
            }
            seen.add(c);
        }
        
        return true;
    }
}

/*
Example Walkthrough:
s = "abcabcbb"

i = 0:
  j = 0: substring = "a", unique ✓, maxLength = 1
  j = 1: substring = "ab", unique ✓, maxLength = 2
  j = 2: substring = "abc", unique ✓, maxLength = 3
  j = 3: substring = "abca", 'a' repeats ✗
  j = 4: substring = "abcab", 'a' repeats ✗
  j = 5: substring = "abcabc", 'a' repeats ✗
  j = 6: substring = "abcabcb", 'a' repeats ✗
  j = 7: substring = "abcabcbb", 'a' repeats ✗

i = 1:
  j = 1: substring = "b", unique ✓, maxLength = 3
  j = 2: substring = "bc", unique ✓, maxLength = 3
  j = 3: substring = "bca", unique ✓, maxLength = 3
  j = 4: substring = "bcab", 'b' repeats ✗
  ...

Continue for all i,j combinations...

Result: 3

Why this is extremely slow:
- Number of substrings: n*(n+1)/2 = O(n²)
- For each substring, uniqueness check: O(n)
- Total: O(n³) time complexity
- For n=50,000, this is completely impractical

Key limitation: No optimization to avoid redundant checking
*/
