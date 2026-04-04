/**
 * Two Pointers Approach - Append Characters to String to Make Subsequence (OPTIMAL)
 * 
 * Logic:
 * - Use two pointers: i for s, j for t
 * - Find the longest prefix of t that matches a subsequence of s
 * - Move both pointers to track matching progress
 * - Return the difference in lengths
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(n) - each character examined once
 * Space Complexity: O(1) - constant extra space
 */
class Solution {
    public int appendCharacters(String s, String t) {
        int i = 0, j = 0;
        int matchCount = 0;
        
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                matchCount++;
                i++;
                j++;
            } else {
                // Character in t not found in s, move to next character in s
                i++;
            }
        }
        
        return t.length() - matchCount;
    }
}

/*
Example Walkthrough:
s = "abcde", t = "aabcbb"

Initialize: i = 0, j = 0, matchCount = 0

Iteration 1:
  s[0] = 'a', t[0] = 'a' → match → matchCount = 1, i = 1, j = 1

Iteration 2:
  s[1] = 'b', t[1] = 'a' → no match → i = 2, j = 1

Iteration 3:
  s[2] = 'c', t[1] = 'a' → no match → i = 3, j = 1

Iteration 4:
  s[3] = 'd', t[1] = 'a' → no match → i = 4, j = 1

Iteration 5:
  s[4] = 'e', t[1] = 'a' → no match → i = 5, j = 1

Iteration 6:
  i >= s.length() → stop

Longest matching prefix length = 1
Answer: t.length() - matchCount = 6 - 1 = 5

Wait, this doesn't seem right. Let me trace more carefully:

s = "abcde", t = "aabcbb"

Initialize: i = 0, j = 0, matchCount = 0

Iteration 1:
  s[0] = 'a', t[0] = 'a' → match → matchCount = 1, i = 1, j = 1

Iteration 2:
  s[1] = 'b', t[1] = 'a' → no match → i = 2, j = 1

Iteration 3:
  s[2] = 'c', t[1] = 'a' → no match → i = 3, j = 1

Iteration 4:
  s[3] = 'd', t[1] = 'a' → no match → i = 4, j = 1

Iteration 5:
  s[4] = 'e', t[1] = 'a' → no match → i = 5, j = 1

Actually, the logic should be: when characters don't match, we need to find the next occurrence of t[j] in s[i+1:].

Let me implement the correct two-pointer approach:

We need to find the longest prefix of t that is a subsequence of s.
For each character in t, we try to match it with s in order.
*/
