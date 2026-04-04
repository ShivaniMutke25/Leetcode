/**
 * Brute Force Approach - Find All Anagrams in String
 * 
 * Logic:
 * - For each possible starting position in s
 * - Extract substring of length p.length()
 * - Check if substring is anagram of p by comparing sorted versions
 * - Add starting index to result if anagram found
 * 
 * When to use: Understanding the problem, very small inputs
 * When NOT to use: Any realistic input - will TLE for large inputs
 * 
 * Time Complexity: O(n²m) - n substrings, each sorting O(m log m)
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int n = s.length(), m = p.length();
        
        if (m > n) return result;
        
        String sortedP = sortString(p);
        
        for (int i = 0; i <= n - m; i++) {
            String substring = s.substring(i, i + m);
            String sortedSubstring = sortString(substring);
            
            if (sortedP.equals(sortedSubstring)) {
                result.add(i);
            }
        }
        
        return result;
    }
    
    private String sortString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}

/*
Example Walkthrough:
s = "cbaebabacd", p = "abc"

sortedP = "abc"

i = 0: substring = "cba", sortedSubstring = "abc"
  "abc" == "abc" ✓ → result = [0]

i = 1: substring = "bae", sortedSubstring = "abe"
  "abc" != "abe"

i = 2: substring = "aeb", sortedSubstring = "abe"
  "abc" != "abe"

i = 3: substring = "eba", sortedSubstring = "abe"
  "abc" != "abe"

i = 4: substring = "bab", sortedSubstring = "abb"
  "abc" != "abb"

i = 5: substring = "aba", sortedSubstring = "aab"
  "abc" != "aab"

i = 6: substring = "bac", sortedSubstring = "abc"
  "abc" == "abc" ✓ → result = [0, 6]

Result: [0, 6]

Why this is slow:
- For each of (n-m+1) positions, we extract substring (O(m))
- Then sort the substring (O(m log m))
- Total: O((n-m+1) * m * log m) ≈ O(nm log m)
- For n=10^4, m=10^4, this is very slow

Key limitation: No optimization to avoid redundant sorting
*/
