/**
 * Sorting Approach - Valid Anagram
 * 
 * Logic:
 * - Sort both strings
 * - Compare sorted strings character by character
 * - Return true if identical, false otherwise
 * 
 * When to use: Simpler implementation, when sorting is acceptable
 * When NOT to use: When O(n) time is required, large inputs
 * 
 * Time Complexity: O(n log n) - sorting dominates
 * Space Complexity: O(n) - for sorted arrays
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        // Early termination if lengths differ
        if (s.length() != t.length()) {
            return false;
        }
        
        // Convert to char arrays and sort
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        
        // Compare sorted arrays
        return Arrays.equals(sChars, tChars);
    }
}

/*
Example Walkthrough:
s = "anagram", t = "nagaram"

s.length() = 7, t.length() = 7 ✓

sChars = ['a','n','a','g','r','a','m']
tChars = ['n','a','g','a','r','a','m']

After sorting:
sChars = ['a','a','a','g','m','n','r']
tChars = ['a','a','a','g','m','n','r']

Arrays.equals(sChars, tChars) ✓ → return true

Another example:
s = "rat", t = "car"

s.length() = 3, t.length() = 3 ✓

After sorting:
sChars = ['a','r','t']
tChars = ['a','c','r']

Arrays.equals(sChars, tChars) ✗ → return false

Why this works:
- Anagrams have identical character sets
- Sorting groups identical characters together
- Sorted anagrams will be identical strings
- Early length check handles obvious non-anagrams

Trade-offs:
- Time: O(n log n) - sorting overhead
- Space: O(n) - needs space for sorted arrays
- Simple and intuitive
- Language-agnostic approach
- Works for any character set

When this is good:
- Code simplicity is prioritized
- Sorting overhead is acceptable
- Character set is unknown or variable
- Quick implementation needed
*/
