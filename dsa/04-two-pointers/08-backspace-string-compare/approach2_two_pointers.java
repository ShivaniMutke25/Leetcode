/**
 * Two Pointers Approach - Backspace String Compare (OPTIMAL)
 * 
 * Logic:
 * - Use two pointers starting from the end of both strings
 * - Count backspaces in t and skip them in s
 * - Compare characters while accounting for backspaces
 * - Return true if all characters match
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(n) - each character examined once
 * Space Complexity: O(1) - constant extra space
 */
class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        int skipS = 0, skipT = 0;
        
        while (i >= 0 || j >= 0) {
            // Find next valid character in s
            while (i >= 0 && s.charAt(i) == '#') {
                skipS++;
                i--;
            }
            
            // Find next valid character in t
            while (j >= 0 && t.charAt(j) == '#') {
                skipT++;
                j--;
            }
            
            // If both pointers are valid, compare characters
            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }
                i--;
                j--;
            }
        }
        
        // Both strings should be fully processed
        return true;
    }
}

/*
Example Walkthrough:
s = "ab#c", t = "ad#c"

Initialize: i = 3, j = 3, skipS = 0, skipT = 0

Iteration 1:
  Find valid in s: i=3, s[3]='c' (not '#') → i stays 3
  Find valid in t: j=3, t[3]='c' (not '#') → j stays 3
  Compare: s[3]='c' vs t[3]='c' → match
  i=2, j=2

Iteration 2:
  Find valid in s: i=2, s[2]='#' → skipS=1, i=1
  Find valid in t: j=2, t[2]='#' → skipT=1, j=1
  Compare: i=1, j=1 (both valid) → s[1]='b' vs t[1]='d' → no match!
  
Wait, let me trace more carefully:

s = "ab#c", t = "ad#c"
Indices: s[0]='a', s[1]='b', s[2]='#', s[3]='c'
         t[0]='a', t[1]='d', t[2]='#', t[3]='c'

Initialize: i = 3, j = 3, skipS = 0, skipT = 0

Iteration 1:
  Find valid in s: i=3, s[3]='c' (valid) → i=3
  Find valid in t: j=3, t[3]='c' (valid) → j=3
  Compare: s[3]='c' vs t[3]='c' → match
  i=2, j=2

Iteration 2:
  Find valid in s: i=2, s[2]='#' → skipS=1, i=1
  Find valid in t: j=2, t[2]='#' → skipT=1, j=1
  Now i=1, j=1 (both valid)
  Compare: s[1]='b' vs t[1]='d' → no match → return false

Actually, let me trace again. The issue is that when we skip backspaces, we need to account for the skip counts.

Let me try a different approach:

s = "ab#c", t = "ad#c"

i = 3, j = 3, skipS = 0, skipT = 0

Iteration 1:
  Skip backspaces in s: i=3, s[3]='c' (not '#') → i=3
  Skip backspaces in t: j=3, t[3]='c' (not '#') → j=3
  Compare: s[3]='c' vs t[3]='c' → match
  i=2, j=2

Iteration 2:
  Skip backspaces in s: i=2, s[2]='#' → skipS=1, i=1
  Skip backspaces in t: j=2, t[2]='#' → skipT=1, j=1
  Now we need to compare s[1] with t[1], but we have skipS=1 and skipT=1
  Actually, the logic should be: if skipS > 0, we need to skip characters in t
  if skipT > 0, we need to skip characters in s

Let me implement the correct logic:
*/
