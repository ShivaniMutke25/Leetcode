/**
 * Sliding Window Approach - Find All Anagrams in a String (OPTIMAL)
 * 
 * Logic:
 * - Use sliding window of size m = p.length()
 * - Maintain frequency counts for current window and pattern p
 * - Slide window one character at a time, updating frequencies
 * - When frequency counts match, we found an anagram
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(n) - single pass through string
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

... continue sliding ...

Slide window (i=6):
Current window is s[4..6] = "bac"
After updates:
sCount = [1,1,1,0,0,...] (a:1, b:1, c:1)
Arrays.equals(pCount, sCount) ✓ → result = [0, 6]

Final result: [0, 6]

Why this works:
- Anagrams have identical character frequency counts
- Sliding window allows O(1) frequency updates:
  * Increment count for new character
  * Decrement count for old character
- Arrays.equals() is O(26) = O(1) since alphabet size is fixed

Optimization details:
- Space is O(1) because we use fixed-size arrays (26 lowercase letters)
- Time is O(n) because we slide through string once
- Each slide operation is O(1): just two array updates and one comparison

Why this is optimal:
- Time: O(n) - single pass, optimal
- Space: O(1) - constant space due to fixed alphabet
- No repeated sorting or substring extraction
- Efficient frequency counting

This is the perfect solution!
*/
