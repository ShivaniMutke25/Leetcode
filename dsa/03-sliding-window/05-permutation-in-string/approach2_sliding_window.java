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
windowCount = [1,1,0,1,1,0,...] (a:1, b:1, d:1)
Arrays.equals(s1Count, windowCount) ✗

Slide window (i=4):
Add s2[4]='a': windowCount['a'] = 2
Remove s2[2]='d': windowCount['d'] = 0
windowCount = [2,1,0,1,0,0,...] (a:2, b:1)
Arrays.equals(s1Count, windowCount) ✗

Slide window (i=5):
Add s2[5]='o': windowCount['o'] = 1
Remove s2[3]='b': windowCount['b'] = 0
windowCount = [2,0,0,1,0,1,...] (a:2, o:1)
Arrays.equals(s1Count, windowCount) ✗

Slide window (i=6):
Add s2[6]='o': windowCount['o'] = 2
Remove s2[4]='a': windowCount['a'] = 1
windowCount = [1,0,0,1,0,2,...] (a:1, o:2)
Arrays.equals(s1Count, windowCount) ✗

Slide window (i=7):
Add s2[7]='o': windowCount['o'] = 3
Remove s2[5]='o': windowCount['o'] = 2
windowCount = [1,0,0,1,0,2,...] (a:1, o:2)
Arrays.equals(s1Count, windowCount) ✗

Wait, let me trace more carefully:
s1 = "ab", s2 = "eidbaooo"

Initial window (indices 0-1): "ei"
s1Count = [1,1,0,0,...] (a:1, b:1)
windowCount = [0,1,1,0,...] (e:1, i:1)

i = 2: window = "id"
Add 'd', remove 'e': windowCount = [0,1,0,1,1,0,...] (i:1, d:1)

i = 3: window = "db"
Add 'b', remove 'i': windowCount = [1,1,0,1,0,0,...] (a:1, b:1, d:1)

i = 4: window = "ba"
Add 'a', remove 'd': windowCount = [2,1,0,0,0,0,...] (a:2, b:1)

i = 5: window = "ao"
Add 'o', remove 'b': windowCount = [2,0,0,0,1,0,...] (a:2, o:1)

i = 6: window = "oo"
Add 'o', remove 'a': windowCount = [1,0,0,0,2,0,...] (a:1, o:2)

i = 7: window = "oo" (last window)
Add 'o', remove 'o': windowCount = [1,0,0,0,2,0,...] (a:1, o:2)

I think I made an error in tracing. Let me check the actual string:
s2 = "eidbaooo"

Positions: 0:e, 1:i, 2:d, 3:b, 4:a, 5:o, 6:o, 7:o

Window at i=3 (indices 2-3): "db"
Window at i=4 (indices 3-4): "ba" ← This should match!

s1Count = [1,1,0,0,...] (a:1, b:1)
windowCount at i=4:
- Add s2[4]='a': windowCount['a']++
- Remove s2[2]='d': windowCount['d']--
- Previous windowCount (i=3): [0,1,0,1,1,0,...] (i:1, d:1, b:1)
- New windowCount: [1,1,0,1,0,0,...] (a:1, b:1, d:0) ← Wait, this should be a:1, b:1

Actually, let me recalculate:
At i=3, window = indices 2-3 = "db"
windowCount = [0,1,0,1,1,0,...] (b:1, d:1, i:0, e:0)

At i=4, window = indices 3-4 = "ba"
Add 'a': windowCount['a'] = 1
Remove 'd': windowCount['d'] = 0
windowCount = [1,1,0,1,0,0,...] (a:1, b:1, d:0)

s1Count = [1,1,0,0,...] (a:1, b:1)
Arrays.equals(s1Count, windowCount) ✓ → return true

Result: true

Why this works:
- Permutations have identical character frequency counts
- Sliding window allows O(1) frequency updates:
  * Increment count for new character
  * Decrement count for old character
- Arrays.equals() is O(26) = O(1) since alphabet size is fixed

Why this is optimal:
- Time: O(m+n) - single pass, optimal
- Space: O(1) - constant space due to fixed alphabet
- No redundant sorting or substring extraction
- Efficient frequency counting

This is the perfect solution!
*/
