/**
 * Greedy with Array Approach - Reorganize String
 * 
 * Logic:
 * - Count character frequencies
 * - Use greedy selection with frequency array
 * - Find most frequent character that's not previous
 * 
 * When to use: Simple implementation, moderate input size
 * When NOT to use: Very large n, multiple queries
 * 
 * Time Complexity: O(n) - linear scan
 * Space Complexity: O(1) - fixed alphabet size
 */
class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        // Check if impossible
        int maxFreq = 0;
        for (int count : freq) {
            maxFreq = Math.max(maxFreq, count);
        }
        if (maxFreq > (s.length() + 1) / 2) {
            return "";
        }
        
        StringBuilder result = new StringBuilder();
        char prevChar = '#';
        
        for (int i = 0; i < s.length(); i++) {
            int maxCount = 0;
            char nextChar = '#';
            
            // Find most frequent character that's not previous
            for (int j = 0; j < 26; j++) {
                if (freq[j] > maxCount && j != (prevChar - 'a')) {
                    maxCount = freq[j];
                    nextChar = (char) (j + 'a');
                }
            }
            
            if (nextChar == '#') {
                return ""; // Should not happen due to earlier check
            }
            
            result.append(nextChar);
            freq[nextChar - 'a']--;
            prevChar = nextChar;
        }
        
        return result.toString();
    }
}

/*
Example Walkthrough:
s = "aab"

Count frequencies: a=2, b=1
Initialize: result = "", prevChar = '#'

Iteration 1:
  Find most frequent not '#': a (count=2)
  result = "a", freq[a]=1, prevChar = 'a'

Iteration 2:
  Find most frequent not 'a': b (count=1)
  result = "ab", freq[b]=0, prevChar = 'b'

Iteration 3:
  Find most frequent not 'b': a (count=1)
  result = "aba", freq[a]=0, prevChar = 'a'

Result: "aba"

Why this works:
- Greedy selection picks most frequent valid character
- Previous character check prevents adjacency
- Linear scan for most frequent each time
- Works for any valid input

Why this is not optimal:
- Time complexity is actually O(n * 26) = O(n)
- More expensive than heap approach in practice
- Less efficient selection process

Key limitation: Linear scan for selection instead of heap
*/
