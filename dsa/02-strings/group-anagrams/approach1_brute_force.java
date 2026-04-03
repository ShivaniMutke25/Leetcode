/**
 * Brute Force Approach - Group Anagrams
 * 
 * Logic:
 * - Compare every pair of strings to check if they're anagrams
 * - Use Union-Find or visited array to avoid duplicate comparisons
 * - Group strings that are anagrams of each other
 * 
 * When to use: Understanding the problem, very small inputs
 * When NOT to use: Any realistic input - will TLE for n > 100
 * 
 * Time Complexity: O(n²m log m) - n² pairs, each comparison needs sorting
 * Space Complexity: O(nm) - for storing groups
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        boolean[] visited = new boolean[strs.length];
        
        for (int i = 0; i < strs.length; i++) {
            if (visited[i]) continue;
            
            List<String> group = new ArrayList<>();
            group.add(strs[i]);
            visited[i] = true;
            
            // Find all anagrams of strs[i]
            for (int j = i + 1; j < strs.length; j++) {
                if (!visited[j] && areAnagrams(strs[i], strs[j])) {
                    group.add(strs[j]);
                    visited[j] = true;
                }
            }
            
            result.add(group);
        }
        
        return result;
    }
    
    private boolean areAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        
        return Arrays.equals(chars1, chars2);
    }
}

/*
Example Walkthrough:
strs = ["eat","tea","tan","ate","nat","bat"]

i = 0, strs[0] = "eat":
  group = ["eat"]
  Check j = 1..5:
    j=1: "tea" vs "eat" → anagrams ✓ → group = ["eat","tea"], visited[1]=true
    j=2: "tan" vs "eat" → not anagrams
    j=3: "ate" vs "eat" → anagrams ✓ → group = ["eat","tea","ate"], visited[3]=true
    j=4: "nat" vs "eat" → not anagrams
    j=5: "bat" vs "eat" → not anagrams
  result = [["eat","tea","ate"]]

i = 1: visited[1] = true → skip

i = 2, strs[2] = "tan":
  group = ["tan"]
  Check j = 3..5:
    j=3: visited[3] = true → skip
    j=4: "nat" vs "tan" → anagrams ✓ → group = ["tan","nat"], visited[4]=true
    j=5: "bat" vs "tan" → not anagrams
  result = [["eat","tea","ate"], ["tan","nat"]]

i = 3: visited[3] = true → skip
i = 4: visited[4] = true → skip

i = 5, strs[5] = "bat":
  group = ["bat"]
  No more strings to check
  result = [["eat","tea","ate"], ["tan","nat"], ["bat"]]

Why this is slow:
- For each string, we compare with all remaining strings
- Each anagram check requires sorting both strings
- Total comparisons: n*(n-1)/2
- For n=10^4, this is ~50 million comparisons

Key limitation: No optimization to avoid redundant sorting
*/
