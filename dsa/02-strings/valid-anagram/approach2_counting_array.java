/**
 * Counting Array Approach - Valid Anagram (OPTIMAL)
 * 
 * Logic:
 * - Use counting array of size 26 for lowercase letters
 * - Increment counts for characters in s, decrement for t
 * - If all counts end up as 0, strings are anagrams
 * - Check lengths first for early termination
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(n) - single pass through both strings
 * Space Complexity: O(1) - fixed size array for 26 letters
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        // Early termination if lengths differ
        if (s.length() != t.length()) {
            return false;
        }
        
        int[] count = new int[26]; // For lowercase English letters
        
        // Count characters in s and t simultaneously
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        
        // Check if all counts are zero
        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }
        
        return true;
    }
}

/*
Example Walkthrough:
s = "anagram", t = "nagaram"

s.length() = 7, t.length() = 7 ✓

Initialize count = [0,0,0,...,0] (26 zeros)

i = 0: s[0]='a', t[0]='n'
  count['a']++ → count[0] = 1
  count['n']-- → count[13] = -1

i = 1: s[1]='n', t[1]='a'
  count['n']++ → count[13] = 0
  count['a']-- → count[0] = 0

i = 2: s[2]='a', t[2]='g'
  count['a']++ → count[0] = 1
  count['g']-- → count[6] = -1

i = 3: s[3]='g', t[3]='a'
  count['g']++ → count[6] = 0
  count['a']-- → count[0] = 0

i = 4: s[4]='r', t[4]='r'
  count['r']++ → count[17] = 1
  count['r']-- → count[17] = 0

i = 5: s[5]='a', t[5]='a'
  count['a']++ → count[0] = 1
  count['a']-- → count[0] = 0

i = 6: s[6]='m', t[6]='m'
  count['m']++ → count[12] = 1
  count['m']-- → count[12] = 0

Final count array: all zeros ✓ → return true

Another example:
s = "rat", t = "car"

i = 0: s[0]='r', t[0]='c'
  count['r']++ → count[17] = 1
  count['c']-- → count[2] = -1

i = 1: s[1]='a', t[1]='a'
  count['a']++ → count[0] = 1
  count['a']-- → count[0] = 0

i = 2: s[2]='t', t[2]='r'
  count['t']++ → count[19] = 1
  count['r']-- → count[17] = 0

Final count array: [0,-1,0,...,0,1,0,1,0,...]
Non-zero counts found ✗ → return false

Why this works:
- Anagrams have identical character frequencies
- Increment for s, decrement for t cancels out matching characters
- Final zero counts indicate perfect match
- Single pass through both strings

Why this is optimal:
- Time: O(n) - single pass, optimal
- Space: O(1) - constant space due to fixed alphabet
- Early length check handles obvious cases
- No sorting overhead
- Efficient memory usage

Key insights:
- Counting array faster than HashMap for known alphabet
- Simultaneous increment/decrement reduces passes
- Zero check validates anagram property
- Fixed size array ensures O(1) space

This is the perfect solution!
*/
