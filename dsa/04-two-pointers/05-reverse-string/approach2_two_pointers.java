/**
 * Two Pointers Approach - Reverse String (OPTIMAL)
 * 
 * Logic:
 * - Use two pointers: left at start, right at end
 * - Swap characters at left and right positions
 * - Move left pointer right and right pointer left
 * - Continue until pointers meet or cross
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(n) - each element swapped at most once
 * Space Complexity: O(1) - constant extra space
 */
class Solution {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        
        while (left < right) {
            // Swap characters
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            
            // Move pointers
            left++;
            right--;
        }
    }
}

/*
Example Walkthrough:
s = ['h','e','l','l','o']

Initialize: left = 0, right = 4

Iteration 1:
  Swap s[0] and s[4]:
  temp = 'h'
  s[0] = 'o'
  s[4] = 'h'
  s = ['o','e','l','l','h']
  left = 1, right = 3

Iteration 2:
  Swap s[1] and s[3]:
  temp = 'e'
  s[1] = 'l'
  s[3] = 'e'
  s = ['o','l','l','e','h']
  left = 2, right = 2

Iteration 3:
  left >= right → stop

Result: ['o','l','l','e','h']

Another example (odd length):
s = ['h','e','l','l','o','!']

Initialize: left = 0, right = 5

Iteration 1:
  Swap s[0] and s[5]:
  temp = 'h'
  s[0] = '!'
  s[5] = 'h'
  s = ['!','e','l','l','o','h']
  left = 1, right = 4

Iteration 2:
  Swap s[1] and s[4]:
  temp = 'e'
  s[1] = 'o'
  s[4] = 'e'
  s = ['!','o','l','l','e','h']
  left = 2, right = 3

Iteration 3:
  Swap s[2] and s[3]:
  temp = 'l'
  s[2] = 'l'
  s[3] = 'l'
  s = ['!','o','l','l','e','h']
  left = 3, right = 2

Iteration 4:
  left >= right → stop

Result: ['!','o','l','l','e','h']

Why this works:
- Two pointers approach from opposite ends
- Each swap moves two elements to correct positions
- Middle element stays in place for odd lengths
- Each element participates in at most one swap

Why this is optimal:
- Time: O(n) - each element touched at most once
- Space: O(1) - constant extra space
- Truly in-place solution
- No unnecessary copying

Key insights:
- Opposite direction pointers are perfect for reversal
- In-place swapping avoids extra space
- Middle element doesn't need to move in odd-length arrays
- Each iteration fixes two elements

This is the perfect solution!
*/
