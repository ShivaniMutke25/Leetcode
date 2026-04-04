/**
 * Brute Force Approach - Append Characters to String to Make Subsequence
 * 
 * Logic:
 * - For each possible prefix length, check if t prefix can be formed from s
 * - Find the longest matching prefix
 * - Return the difference in lengths
 * 
 * When to use: Understanding problem, very small inputs
 * When NOT to use: Any realistic input - will be too slow
 * 
 * Time Complexity: O(n²) - O(n) prefix lengths × O(n) checks
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int appendCharacters(String s, String t) {
        int maxMatch = 0;
        
        // Try all possible prefix lengths
        for (int len = 0; len <= Math.min(s.length(), t.length()); len++) {
            if (canFormSubsequence(s, t, len)) {
                maxMatch = len;
            }
        }
        
        return t.length() - maxMatch;
    }
    
    private boolean canFormSubsequence(String s, String t, int len) {
        String prefix = t.substring(0, len);
        int index = 0;
        
        for (char c : prefix.toCharArray()) {
            // Find character c in s starting from index
            boolean found = false;
            for (int i = index; i < s.length(); i++) {
                if (s.charAt(i) == c) {
                    index = i + 1;
                    found = true;
                    break;
                }
            }
            
            if (!found) return false;
        }
        
        return true;
    }
}

/*
Example Walkthrough:
s = "abcde", t = "aabcbb"

Try different prefix lengths:

len = 0: prefix = "" → always can form → maxMatch = 0

len = 1: prefix = "a"
  'a' in s starting from 0 → found at index 0 → can form → maxMatch = 1

len = 2: prefix = "aa"
  First 'a' in s at index 0
  Second 'a' in s starting from 1 → not found → cannot form

len = 3: prefix = "aab"
  First 'a' in s at index 0
  Second 'a' in s starting from 1 → not found → cannot form

len = 4: prefix = "aabc"
  First 'a' in s at index 0
  Second 'a' in s starting from 1 → not found → cannot form

Result: maxMatch = 1
Answer: t.length() - maxMatch = 6 - 1 = 5 (incorrect!)

This approach is inefficient and incorrect. Let me think of the correct approach.

Actually, the problem is asking for the minimum characters to append to t to make it a subsequence of s.
This means we need to find the longest prefix of t that is already a subsequence of s.

The brute force should check if t can be formed from s, and if not, try removing characters from t.
*/
