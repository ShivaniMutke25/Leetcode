/**
 * Stack Approach - Decode String (OPTIMAL)
 * 
 * Logic:
 * - Use two stacks: numStack for multipliers, strStack for previous strings
 * - Maintain currentNum and currentStr for building
 * - When encountering digit: build currentNum
 * - When encountering '[': push currentNum and currentStr to stacks, reset them
 * - When encountering ']': pop and build repeated string
 * - When encountering letter: append to currentStr
 * 
 * When to use: Always - optimal iterative solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(n) - single pass through string
 * Space Complexity: O(n) - stacks for nested structures
 */
class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        
        StringBuilder currentStr = new StringBuilder();
        int currentNum = 0;
        
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // Build the number (handle multi-digit)
                currentNum = currentNum * 10 + (c - '0');
            } else if (c == '[') {
                // Push current state to stacks
                numStack.push(currentNum);
                strStack.push(currentStr);
                
                // Reset for new level
                currentStr = new StringBuilder();
                currentNum = 0;
            } else if (c == ']') {
                // Pop and build repeated string
                int repeatTimes = numStack.pop();
                StringBuilder prevStr = strStack.pop();
                
                StringBuilder repeatedStr = new StringBuilder();
                for (int i = 0; i < repeatTimes; i++) {
                    repeatedStr.append(currentStr);
                }
                
                // Set current string for previous level
                currentStr = prevStr.append(repeatedStr);
            } else {
                // Regular character
                currentStr.append(c);
            }
        }
        
        return currentStr.toString();
    }
}

/*
Example Walkthrough:
s = "3[a]2[bc]"

Initialize: numStack=[], strStack=[], currentStr="", currentNum=0

c = '3': currentNum = 3
c = '[': 
  numStack=[3], strStack=[""]
  currentStr="", currentNum=0

c = 'a': currentStr = "a"
c = ']':
  repeatTimes = 3, prevStr = ""
  repeatedStr = "aaa"
  currentStr = "" + "aaa" = "aaa"

c = '2': currentNum = 2
c = '[':
  numStack=[3,2], strStack=["", "aaa"]
  currentStr="", currentNum=0

c = 'b': currentStr = "b"
c = 'c': currentStr = "bc"
c = ']':
  repeatTimes = 2, prevStr = "aaa"
  repeatedStr = "bcbc"
  currentStr = "aaa" + "bcbc" = "aaabcbc"

Result: "aaabcbc"

Another example with nesting:
s = "3[a2[c]]"

c = '3': currentNum = 3
c = '[': numStack=[3], strStack=[""], currentStr="", currentNum=0

c = 'a': currentStr = "a"
c = '2': currentNum = 2
c = '[': numStack=[3,2], strStack=["", "a"], currentStr="", currentNum=0

c = 'c': currentStr = "c"
c = ']':
  repeatTimes = 2, prevStr = "a"
  repeatedStr = "cc"
  currentStr = "a" + "cc" = "acc"

c = ']':
  repeatTimes = 3, prevStr = ""
  repeatedStr = "accaccacc"
  currentStr = "" + "accaccacc" = "accaccacc"

Result: "accaccacc"

Why this works:
- Stacks naturally handle nested structures
- numStack tracks multipliers at each level
- strStack tracks strings at each level
- When ']' encountered, we build the repeated string and return to previous level

Why this is optimal:
- Time: O(n) - single pass
- Space: O(n) - stacks for nesting
- Iterative: No recursion stack overflow risk
- Handles any level of nesting
- Clean separation of concerns

This is the perfect solution!
*/
