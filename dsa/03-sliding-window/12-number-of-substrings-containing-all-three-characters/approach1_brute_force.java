/**
 * Brute Force Approach - Number of Substrings Containing All Three Characters
 * 
 * Logic:
 * - Check all possible substrings
 * - For each substring, verify it contains 'a', 'b', and 'c'
 * - Count valid substrings
 * 
 * When to use: Understanding the problem, very small inputs
 * When NOT to use: Any realistic input - will be too slow
 * 
 * Time Complexity: O(n³) - O(n²) substrings, each check O(n)
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int numberOfSubstrings(String s) {
        int count = 0;
        
        // Check all possible starting positions
        for (int i = 0; i < s.length(); i++) {
            // Check all possible ending positions
            for (int j = i; j < s.length(); j++) {
                String substring = s.substring(i, j + 1);
                
                if (containsAllThree(substring)) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private boolean containsAllThree(String s) {
        boolean hasA = false, hasB = false, hasC = false;
        
        for (char c : s.toCharArray()) {
            if (c == 'a') hasA = true;
            else if (c == 'b') hasB = true;
            else if (c == 'c') hasC = true;
        }
        
        return hasA && hasB && hasC;
    }
}

/*
Example Walkthrough:
s = "abcabc"

i = 0:
  j = 0: substring = "a" → {a} ✗
  j = 1: substring = "ab" → {a,b} ✗
  j = 2: substring = "abc" → {a,b,c} ✓ → count = 1
  j = 3: substring = "abca" → {a,b,c} ✓ → count = 2
  j = 4: substring = "abcab" → {a,b,c} ✓ → count = 3
  j = 5: substring = "abcabc" → {a,b,c} ✓ → count = 4

i = 1:
  j = 1: substring = "b" → {b} ✗
  j = 2: substring = "bc" → {b,c} ✗
  j = 3: substring = "bca" → {a,b,c} ✓ → count = 5
  j = 4: substring = "bcab" → {a,b,c} ✓ → count = 6
  j = 5: substring = "bcabc" → {a,b,c} ✓ → count = 7

i = 2:
  j = 2: substring = "c" → {c} ✗
  j = 3: substring = "ca" → {a,c} ✗
  j = 4: substring = "cab" → {a,b,c} ✓ → count = 8
  j = 5: substring = "cabc" → {a,b,c} ✓ → count = 9

i = 3:
  j = 3: substring = "a" → {a} ✗
  j = 4: substring = "ab" → {a,b} ✗
  j = 5: substring = "abc" → {a,b,c} ✓ → count = 10

i = 4:
  j = 4: substring = "b" → {b} ✗
  j = 5: substring = "bc" → {b,c} ✗

i = 5:
  j = 5: substring = "c" → {c} ✗

Result: 10

Why this is inefficient:
- Number of substrings: n*(n+1)/2 = O(n²)
- For each substring, character check: O(n)
- Total: O(n³) time complexity
- For n=50,000, this is completely impractical

Key limitation: No optimization to avoid redundant checking of overlapping substrings
*/
