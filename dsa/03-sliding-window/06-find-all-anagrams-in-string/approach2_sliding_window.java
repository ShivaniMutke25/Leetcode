/**
 * Sliding Window Approach - Find All Anagrams in String (OPTIMAL)
 * 
 * Logic:
 * - Use sliding window of size m = p.length() over string s
 * - Maintain frequency counts for current window and pattern p
 * - Slide window one character at a time, updating frequencies
 * - When frequencies match, add starting index to result
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(n+m) - single pass through string
 * Space Complexity: O(1) - fixed size arrays for 26 letters
 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int n = s.length(), m = p.length();
        
        if (m > n) return result;
        
        // Frequency arrays for pattern and current window
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        
        // Initialize frequency counts for pattern and first window
        for (int i = 0; i < m; i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }
        
        // Check first window
        if (Arrays.equals(pCount, sCount)) {
            result.add(0);
        }
        
        // Slide the window through the string
        for (int i = m; i < n; i++) {
            // Add new character to window
            sCount[s.charAt(i) - 'a']++;
            
            // Remove old character from window
            sCount[s.charAt(i - m) - 'a']--;
            
            // Check if current window matches pattern
            if (Arrays.equals(pCount, sCount)) {
                result.add(i - m + 1);
            }
        }
        
        return result;
    }
}

/*
Example Walkthrough:
s = "cbaebabacd", p = "abc", m = 3

Initialize:
pCount = [1,1,1,0,0,...] (a:1, b:1, c:1)
sCount = [1,1,1,0,0,...] (c:1, b:1, a:1)

Check first window (i=0 to 2):
Arrays.equals(pCount, sCount) ✓ → result = [0]

Slide window (i=3):
Add s[3]='e': sCount['e'] = 1
Remove s[0]='c': sCount['c'] = 0
sCount = [1,1,0,0,1,0,...] (a:1, b:1, e:1)
Arrays.equals(pCount, sCount) ✗

Slide window (i=4):
Add s[4]='b': sCount['b'] = 2
Remove s[1]='b': sCount['b'] = 1
sCount = [1,1,0,0,1,0,...] (a:1, b:1, e:1)
Arrays.equals(pCount, sCount) ✗

Slide window (i=5):
Add s[5]='a': sCount['a'] = 2
Remove s[2]='a': sCount['a'] = 1
sCount = [1,1,0,0,1,0,...] (a:1, b:1, e:1)
Arrays.equals(pCount, sCount) ✗

Slide window (i=6):
Add s[6]='b': sCount['b'] = 2
Remove s[3]='e': sCount['e'] = 0
sCount = [1,2,0,0,0,0,...] (a:1, b:2)
Arrays.equals(pCount, sCount) ✗

Wait, let me trace more carefully:
s = "cbaebabacd"
Positions: 0:c, 1:b, 2:a, 3:e, 4:b, 5:a, 6:b, 7:a, 8:c, 9:d

i = 3: window = indices 1-3 = "bae"
Add 'e', remove 'c': sCount = [1,1,0,0,1,0,...] (a:1, b:1, e:1)

i = 4: window = indices 2-4 = "aeb"
Add 'b', remove 'b': sCount = [1,1,0,0,1,0,...] (a:1, b:1, e:1)

i = 5: window = indices 3-5 = "eba"
Add 'a', remove 'a': sCount = [1,1,0,0,1,0,...] (a:1, b:1, e:1)

i = 6: window = indices 4-6 = "bab"
Add 'b', remove 'e': sCount = [1,2,0,0,0,0,...] (a:1, b:2)

i = 7: window = indices 5-7 = "aba"
Add 'a', remove 'b': sCount = [2,1,0,0,0,0,...] (a:2, b:1)

i = 8: window = indices 6-8 = "bac"
Add 'c', remove 'a': sCount = [1,1,1,0,0,0,...] (a:1, b:1, c:1)
Arrays.equals(pCount, sCount) ✓ → result = [0, 6]

Result: [0, 6]

Why this works:
- Anagrams have identical sorted character sequences
- Frequency arrays provide O(1) character counting
- Sliding window allows O(1) frequency updates:
  * Increment count for new character
  * Decrement count for old character
- Arrays.equals() is O(26) = O(1) since alphabet size is fixed

Why this is optimal:
- Time: O(n+m) - single pass, optimal
- Space: O(1) - constant space due to fixed alphabet
- No redundant sorting or substring extraction
- Efficient frequency counting

This is the perfect solution!
*/
