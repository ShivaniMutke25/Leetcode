/**
 * Sliding Window Approach - Number of Substrings Containing All Three Characters (OPTIMAL)
 * 
 * Logic:
 * - Use sliding window with two pointers: left and right
 * - Maintain counts of 'a', 'b', 'c' in current window
 * - When window contains all three characters, all substrings from left to right are valid
 * - Add count of valid substrings and move left pointer
 * - Continue until end of string
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(n) - single pass through string
 * Space Complexity: O(1) - constant space (3 character counts)
 */
class Solution {
    public int numberOfSubstrings(String s) {
        int count = 0;
        int left = 0;
        int[] charCount = new int[3]; // 0: 'a', 1: 'b', 2: 'c'
        
        for (int right = 0; right < s.length(); right++) {
            // Add current character to window
            charCount[s.charAt(right) - 'a']++;
            
            // When window contains all three characters, count valid substrings
            while (charCount[0] > 0 && charCount[1] > 0 && charCount[2] > 0) {
                // All substrings starting from left to right are valid
                count += s.length() - right;
                
                // Move left pointer to find next valid window
                charCount[s.charAt(left) - 'a']--;
                left++;
            }
        }
        
        return count;
    }
}

/*
Example Walkthrough:
s = "abcabc"

Initialize: count = 0, left = 0, charCount = [0,0,0]

right = 0, s[0] = 'a':
  charCount = [1,0,0]
  Window doesn't contain all three characters

right = 1, s[1] = 'b':
  charCount = [1,1,0]
  Window doesn't contain all three characters

right = 2, s[2] = 'c':
  charCount = [1,1,1]
  Window contains all three characters
  count += 6-2 = 4 (substrings: "abc", "abca", "abcab", "abcabc")
  
  Move left:
  Remove s[0]='a': charCount = [0,1,1], left = 1
  Window doesn't contain all three characters

right = 3, s[3] = 'a':
  charCount = [1,1,1]
  Window contains all three characters
  count += 6-3 = 3 (substrings: "bca", "bcab", "bcabc")
  Total count = 4 + 3 = 7
  
  Move left:
  Remove s[1]='b': charCount = [1,0,1], left = 2
  Window doesn't contain all three characters

right = 4, s[4] = 'b':
  charCount = [1,1,1]
  Window contains all three characters
  count += 6-4 = 2 (substrings: "cab", "cabc")
  Total count = 7 + 2 = 9
  
  Move left:
  Remove s[2]='c': charCount = [1,1,0], left = 3
  Window doesn't contain all three characters

right = 5, s[5] = 'c':
  charCount = [1,1,1]
  Window contains all three characters
  count += 6-5 = 1 (substring: "abc")
  Total count = 9 + 1 = 10
  
  Move left:
  Remove s[3]='a': charCount = [0,1,1], left = 4
  Window doesn't contain all three characters

Result: 10

Another example:
s = "aaabc"

Initialize: count = 0, left = 0, charCount = [0,0,0]

right = 0-1: s = "aa"
  charCount = [2,0,0]
  Window doesn't contain all three characters

right = 2, s[2] = 'a':
  charCount = [3,0,0]
  Window doesn't contain all three characters

right = 3, s[3] = 'b':
  charCount = [3,1,0]
  Window doesn't contain all three characters

right = 4, s[4] = 'c':
  charCount = [3,1,1]
  Window contains all three characters
  count += 5-4 = 1 (substring: "abc")
  
  Move left:
  Remove s[0]='a': charCount = [2,1,1], left = 1
  Window still contains all three characters
  count += 5-4 = 1 (substring: "abc")
  Total count = 2
  
  Move left:
  Remove s[1]='a': charCount = [1,1,1], left = 2
  Window still contains all three characters
  count += 5-4 = 1 (substring: "abc")
  Total count = 3
  
  Move left:
  Remove s[2]='a': charCount = [0,1,1], left = 3
  Window doesn't contain all three characters

Result: 3

Why this works:
- Once window contains all three characters, expanding right keeps it valid
- All substrings starting from left and ending anywhere between left and right are valid
- We can count all valid substrings in O(1) using (n - right)
- Moving left helps find the next valid window

Why this is optimal:
- Time: O(n) - single pass, optimal
- Space: O(1) - constant space for 3 character counts
- No redundant calculations
- Efficient window management
- Handles all edge cases

Key insights:
- Fixed character set ('a', 'b', 'c') makes counting efficient
- When window is valid, all expansions remain valid
- Counting formula (n - right) efficiently counts all valid substrings
- Each character is added and removed at most once

This is the perfect solution!
*/
