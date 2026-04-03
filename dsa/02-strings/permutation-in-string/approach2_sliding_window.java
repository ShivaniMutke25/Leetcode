/**
 * Sliding Window Approach - Permutation in String (OPTIMAL)
 * 
 * Logic:
 * - Use sliding window of size m = s1.length() over s2
 * - Maintain frequency counts for current window and s1
 * - Slide window one character at a time, updating frequencies
 * - When frequency counts match, we found a permutation
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(m+n) - single pass through both strings
 * Space Complexity: O(1) - fixed size arrays for 26 letters
 */
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        
        if (m > n) return false;
        
        // Frequency arrays for s1 and current window
        int[] s1Count = new int[26];
        int[] windowCount = new int[26];
        
        // Initialize frequency counts for s1 and first window
        for (int i = 0; i < m; i++) {
            s1Count[s1.charAt(i) - 'a']++;
            windowCount[s2.charAt(i) - 'a']++;
        }
        
        // Check first window
        if (Arrays.equals(s1Count, windowCount)) {
            return true;
        }
        
        // Slide the window through s2
        for (int i = m; i < n; i++) {
            // Add new character to window
            windowCount[s2.charAt(i) - 'a']++;
            
            // Remove old character from window
            windowCount[s2.charAt(i - m) - 'a']--;
            
            // Check if current window matches s1
            if (Arrays.equals(s1Count, windowCount)) {
                return true;
            }
        }
        
        return false;
    }
}

/*
Example Walkthrough:
s1 = "ab", s2 = "eidbaooo", m = 2, n = 8

Initialize:
s1Count = [1,1,0,0,...] (a:1, b:1)
windowCount = [1,0,0,1,0,...] (e:1, i:1)

Check first window "ei":
Arrays.equals(s1Count, windowCount) ✗

Slide window (i=2):
Add s2[2]='d': windowCount['d'] = 1
Remove s2[0]='e': windowCount['e'] = 0
windowCount = [1,0,0,1,1,0,...] (i:1, d:1)
Arrays.equals(s1Count, windowCount) ✗

Slide window (i=3):
Add s2[3]='b': windowCount['b'] = 1
Remove s2[1]='i': windowCount['i'] = 0
windowCount = [1,1,0,0,1,0,...] (a:1, b:1)
Arrays.equals(s1Count, windowCount) ✓ → return true

Another example:
s1 = "abc", s2 = "eidbacooo"

Initialize:
s1Count = [1,1,1,0,0,...] (a:1, b:1, c:1)
windowCount = [1,0,0,1,0,...] (e:1, i:1)

Slide through windows until we find "bac":
windowCount becomes [1,1,1,0,0,...] which matches s1Count ✓

Why this works:
- Permutations have identical character frequency counts
- Sliding window allows O(1) frequency updates:
  * Increment count for new character
  * Decrement count for old character
- Arrays.equals() is O(26) = O(1) since alphabet size is fixed

Optimization details:
- Space is O(1) because we use fixed-size arrays (26 lowercase letters)
- Time is O(m+n) because we slide through string once
- Each slide operation is O(1): just two array updates and one comparison

Why this is optimal:
- Time: O(m+n) - single pass, optimal
- Space: O(1) - constant space due to fixed alphabet
- No repeated sorting or substring extraction
- Efficient frequency counting

This is the perfect solution!
*/
