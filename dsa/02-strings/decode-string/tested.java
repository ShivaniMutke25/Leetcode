import java.util.*;

/*
 * LeetCode 394 - Decode String
 *
 * ============================================================
 * APPROACHES:
 *
 * 1) Recursive Parsing
 *    TC: O(n * k) depending on output size
 *    SC: O(n) recursion + output
 *
 * 2) Stack Iterative (Interview Expected)
 *    TC: O(n * k) depending on output size
 *    SC: O(n)
 *
 * ============================================================
 */

public class Main {

    public static void main(String[] args) {

        String s1 = "3[a]2[bc]";
        String s2 = "3[a2[c]]";
        String s3 = "2[abc]3[cd]ef";
        String s4 = "10[a]";
        String s5 = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";

        System.out.println("===== TEST CASE 1 =====");
        testAll(s1); // aaabcbc

        System.out.println("\n===== TEST CASE 2 =====");
        testAll(s2); // accaccacc

        System.out.println("\n===== TEST CASE 3 =====");
        testAll(s3); // abcabccdcdcdef

        System.out.println("\n===== TEST CASE 4 =====");
        testAll(s4); // aaaaaaaaaa

        System.out.println("\n===== TEST CASE 5 =====");
        testAll(s5);
    }

    public static void testAll(String s) {
        System.out.println("Input:     " + s);
        System.out.println("Recursive: " + decodeStringRecursive(s));
        System.out.println("Stack:     " + decodeStringStack(s));
    }

    // ============================================================
    // APPROACH 1: RECURSIVE PARSING
    // ============================================================
    /*
     * IDEA:
     * Use recursion when '[' starts a nested block.
     * Decode inner block first, then repeat.
     *
     * WHY IT WORKS:
     * Nested expressions naturally fit recursion.
     *
     * TC:
     * Roughly O(output length)
     * Often written as O(n * k) depending on repetition size
     *
     * SC:
     * O(n) recursion stack + output
     */
    static int index = 0;

    public static String decodeStringRecursive(String s) {
        index = 0;
        return helper(s);
    }

    private static String helper(String s) {
        StringBuilder result = new StringBuilder();
        int num = 0;

        while (index < s.length()) {
            char ch = s.charAt(index);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
                index++;
            }
            else if (ch == '[') {
                index++; // skip '['
                String inner = helper(s);

                for (int i = 0; i < num; i++) {
                    result.append(inner);
                }

                num = 0;
            }
            else if (ch == ']') {
                index++; // skip ']'
                return result.toString();
            }
            else {
                result.append(ch);
                index++;
            }
        }

        return result.toString();
    }

    // ============================================================
    // APPROACH 2: STACK ITERATIVE
    // ============================================================
    /*
     * IDEA:
     * Use:
     * - stack for counts
     * - stack for previous strings
     *
     * When '[' appears:
     * - push current number
     * - push current built string
     * - reset both
     *
     * When ']' appears:
     * - pop repeat count
     * - pop previous string
     * - append current repeated block
     *
     * WHY IT WORKS:
     * Stack stores previous outer context while solving inner context.
     *
     * THIS IS THE BEST / INTERVIEW EXPECTED SOLUTION.
     *
     * TC:
     * O(output length)
     *
     * SC:
     * O(n)
     */
    public static String decodeStringStack(String s) {

        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        StringBuilder currentString = new StringBuilder();
        int currentNum = 0;

        for (char ch : s.toCharArray()) {

            if (Character.isDigit(ch)) {
                currentNum = currentNum * 10 + (ch - '0');
            }
            else if (ch == '[') {
                countStack.push(currentNum);
                stringStack.push(currentString);

                currentNum = 0;
                currentString = new StringBuilder();
            }
            else if (ch == ']') {
                int repeatTimes = countStack.pop();
                StringBuilder previousString = stringStack.pop();

                for (int i = 0; i < repeatTimes; i++) {
                    previousString.append(currentString);
                }

                currentString = previousString;
            }
            else {
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }
}

/*
============================================================
LEETCODE VERSION
============================================================

class Solution {
    public String decodeString(String s) {

        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        StringBuilder currentString = new StringBuilder();
        int currentNum = 0;

        for (char ch : s.toCharArray()) {

            if (Character.isDigit(ch)) {
                currentNum = currentNum * 10 + (ch - '0');
            }
            else if (ch == '[') {
                countStack.push(currentNum);
                stringStack.push(currentString);

                currentNum = 0;
                currentString = new StringBuilder();
            }
            else if (ch == ']') {
                int repeatTimes = countStack.pop();
                StringBuilder previousString = stringStack.pop();

                for (int i = 0; i < repeatTimes; i++) {
                    previousString.append(currentString);
                }

                currentString = previousString;
            }
            else {
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }
}
*/
