/**
 * Brute Force Approach - Permutation in String
 * 
 * Logic:
 * - Generate all permutations of s1
 * - Check if any permutation exists as substring in s2
 * - Return true if found, false otherwise
 * 
 * When to use: Understanding the problem, very small inputs
 * When NOT to use: Any realistic input - factorial complexity
 * 
 * Time Complexity: O(m! * n) - m! permutations, each check O(n)
 * Space Complexity: O(m) - for generating permutations
 */
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        
        // Generate all permutations of s1
        return hasPermutation(s2, s1, 0, new boolean[s1.length()], new StringBuilder());
    }
    
    private boolean hasPermutation(String s2, String s1, int index, boolean[] used, StringBuilder current) {
        if (index == s1.length()) {
            // Check if current permutation exists in s2
            return s2.contains(current.toString());
        }
        
        for (int i = 0; i < s1.length(); i++) {
            if (!used[i]) {
                used[i] = true;
                current.append(s1.charAt(i));
                
                if (hasPermutation(s2, s1, index + 1, used, current)) {
                    return true;
                }
                
                // Backtrack
                current.deleteCharAt(current.length() - 1);
                used[i] = false;
            }
        }
        
        return false;
    }
}

/*
Example Walkthrough:
s1 = "ab", s2 = "eidbaooo"

Generate permutations of "ab":
1. "ab" → s2.contains("ab") = false
2. "ba" → s2.contains("ba") = true ✓

Return true

Why this is extremely slow:
- Number of permutations: m! where m = s1.length()
- For each permutation, substring check: O(n) where n = s2.length()
- Total: O(m! * n) time complexity
- For m=10, this is 3,628,800 * n operations
- Completely impractical for realistic inputs

Key limitation: Factorial time complexity makes this unusable
*/
