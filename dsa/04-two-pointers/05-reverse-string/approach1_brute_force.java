/**
 * Brute Force Approach - Reverse String
 * 
 * Logic:
 * - Create new array of same size
 * - Copy elements from original array in reverse order
 * - Return new array
 * 
 * When to use: Understanding problem, very small inputs
 * When NOT to use: Any realistic input - uses extra space
 * 
 * Time Complexity: O(n) - O(n) to copy elements
 * Space Complexity: O(n) - new array
 */
class Solution {
    public void reverseString(char[] s) {
        char[] reversed = new char[s.length];
        
        // Copy elements in reverse order
        for (int i = 0; i < s.length; i++) {
            reversed[i] = s[s.length - 1 - i];
        }
        
        // Copy back to original array
        for (int i = 0; i < s.length; i++) {
            s[i] = reversed[i];
        }
    }
}

/*
Example Walkthrough:
s = ['h','e','l','l','o']

reversed = [0,0,0,0,0]

i = 0:
  reversed[0] = s[4] = 'h'
i = 1:
  reversed[1] = s[3] = 'l'
i = 2:
  reversed[2] = s[2] = 'l'
i = 3:
  reversed[3] = s[1] = 'e'
i = 4:
  reversed[4] = s[0] = 'o'

Copy back:
s[0] = 'o'
s[1] = 'l'
s[2] = 'l'
s[3] = 'e'
s[4] = 'h'

Result: ['o','l','l','e','h']

Why this violates optimal solution:
- Uses O(n) extra space for new array
- Not truly in-place
- Extra copying step is inefficient
- Could be done in-place with two pointers

Key limitation: Doesn't leverage in-place swapping capability
*/
