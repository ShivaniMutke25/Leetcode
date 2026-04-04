/**
 * Two Pointers Approach - Reverse Vowels of a String (OPTIMAL)
 * 
 * Logic:
 * - Use two pointers: left at start, right at end
 * - Move left forward until finding a vowel
 * - Move right backward until finding a vowel
 * - Swap the vowels and continue until pointers meet
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(n) - each character examined at most once
 * Space Complexity: O(1) - constant extra space
 */
class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        
        while (left < right) {
            // Move left pointer to next vowel
            while (left < right && !isVowel(chars[left])) {
                left++;
            }
            
            // Move right pointer to previous vowel
            while (left < right && !isVowel(chars[right])) {
                right--;
            }
            
            // Swap vowels
            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        
        return new String(chars);
    }
    
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
               c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}

/*
Example Walkthrough:
s = "hello"

chars = ['h','e','l','l','o']
left = 0, right = 4

Iteration 1:
  Move left to vowel: chars[0] = 'h' (not vowel), chars[1] = 'e' (vowel) → left = 1
  Move right to vowel: chars[4] = 'o' (vowel) → right = 4
  left < right (1 < 4) → swap chars[1] and chars[4]
  chars = ['h','o','l','l','e']
  left = 2, right = 3

Iteration 2:
  Move left to vowel: chars[2] = 'l' (not vowel), chars[3] = 'l' (not vowel) → left = 4
  Move right to vowel: chars[3] = 'l' (not vowel), chars[2] = 'l' (not vowel) → right = 2
  left >= right → stop

Result: "holle"

Another example:
s = "leetcode"

chars = ['l','e','e','t','c','o','d','e']
left = 0, right = 7

Iteration 1:
  Move left to vowel: chars[0] = 'l' (not vowel), chars[1] = 'e' (vowel) → left = 1
  Move right to vowel: chars[7] = 'e' (vowel) → right = 7
  left < right (1 < 7) → swap chars[1] and chars[7]
  chars = ['l','e','e','t','c','o','d','e']
  left = 2, right = 6

Iteration 2:
  Move left to vowel: chars[2] = 'e' (vowel) → left = 2
  Move right to vowel: chars[6] = 'd' (not vowel), chars[5] = 'o' (vowel) → right = 5
  left < right (2 < 5) → swap chars[2] and chars[5]
  chars = ['l','o','e','t','c','e','d','e']
  left = 3, right = 4

Iteration 3:
  Move left to vowel: chars[3] = 't' (not vowel), chars[4] = 'c' (not vowel) → left = 5
  Move right to vowel: chars[4] = 'c' (not vowel), chars[3] = 't' (not vowel) → right = 3
  left >= right → stop

Result: "leotcede"

Wait, let me trace again more carefully:

s = "leetcode"
chars = ['l','e','e','t','c','o','d','e']
left = 0, right = 7

Iteration 1:
  left moves to position 1 (first vowel 'e')
  right moves to position 7 (last vowel 'e')
  swap positions 1 and 7: ['l','e','e','t','c','o','d','e']
  left = 2, right = 6

Iteration 2:
  left moves to position 2 (next vowel 'e')
  right moves to position 6 (next vowel 'd' is not vowel, so 5 'o')
  swap positions 2 and 5: ['l','o','e','t','c','e','d','e']
  left = 3, right = 4

Iteration 3:
  left moves to position 5 (next vowel 'o')
  right moves to position 4 (no vowel between 3 and 4)
  swap positions 5 and 4: ['l','o','e','t','o','e','d','e']
  left = 6, right = 3

Result: "leotcede"

Actually, the correct result should be "leotcede" with vowels "e,e,o,e" reversed to "e,o,e".

Why this works:
- Two pointers find vowels from both ends
- Swapping reverses vowels in-place
- Non-vowel characters remain in their original positions
- Each vowel is swapped exactly once

Why this is optimal:
- Time: O(n) - each character examined at most once
- Space: O(1) - constant extra space
- Truly in-place solution
- No unnecessary string reconstruction

Key insights:
- Two pointers work perfectly for reversing subsets of characters
- Need to identify vowels efficiently during traversal
- Non-vowel characters act as barriers for pointer movement
- Each iteration fixes two vowel positions

This is the perfect solution!
*/
