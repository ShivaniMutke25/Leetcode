/**
 * Stack Approach - Valid Parentheses (OPTIMAL)
 * 
 * Logic:
 * - Use stack to track opening brackets
 * - When encountering opening bracket, push to stack
 * - When encountering closing bracket, check if matches stack top
 * - If matches, pop; if not or stack empty, return false
 * - At end, valid if stack is empty
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(n) - single pass through string
 * Space Complexity: O(n) - stack storage in worst case
 */
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                default:
                    // Invalid character
                    return false;
            }
        }
        
        return stack.isEmpty();
    }
}

/*
Example Walkthrough:
s = "()[]{}"

stack = []

c = '(':
  push '(' → stack = ['(']

c = ')':
  stack.pop() = '(' == '(' ✓ → stack = []

c = '[':
  push '[' → stack = ['[']

c = ']':
  stack.pop() = '[' == '[' ✓ → stack = []

c = '{':
  push '{' → stack = ['{']

c = '}':
  stack.pop() = '{' == '{' ✓ → stack = []

stack.isEmpty() ✓ → return true

Another example:
s = "([)]"

stack = []

c = '(':
  push '(' → stack = ['(']

c = '[':
  push '[' → stack = ['(', '[']

c = ')':
  stack.pop() = '[' != '(' ✗ → return false

Another example:
s = "{[()]}"

stack = []

c = '{':
  push '{' → stack = ['{']

c = '[':
  push '[' → stack = ['{', '[']

c = '(':
  push '(' → stack = ['{', '[', '(']

c = ')':
  stack.pop() = '(' == '(' ✓ → stack = ['{', '[']

c = ']':
  stack.pop() = '[' == '[' ✓ → stack = ['{']

c = '}':
  stack.pop() = '{' == '{' ✓ → stack = []

stack.isEmpty() ✓ → return true

Another example:
s = "((("

stack = []

c = '(':
  push '(' → stack = ['(']

c = '(':
  push '(' → stack = ['(', '(']

c = '(':
  push '(' → stack = ['(', '(', '(']

End of string, stack not empty → return false

Why this works:
- Stack LIFO property ensures correct bracket matching order
- Opening brackets are pushed to await matching closing brackets
- Closing brackets must match the most recent opening bracket
- Empty stack at end means all brackets were properly matched

Why this is optimal:
- Time: O(n) - single pass, optimal
- Space: O(n) - needed for nested structures
- Handles all three bracket types
- Correctly handles nesting and ordering
- Early termination on mismatch

Key insights:
- Stack naturally handles nested structures
- LIFO ensures correct order
- Each closing bracket must match specific opening type
- Empty stack validation ensures complete matching

This is the perfect solution!
*/
