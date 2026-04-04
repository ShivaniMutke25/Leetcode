/**
 * Max-Heap Approach - Reorganize String (OPTIMAL)
 * 
 * Logic:
 * - Count character frequencies
 * - Use max-heap to prioritize most frequent characters
 * - Repeatedly pick most frequent character that's not previous
 * - Store previous character to reuse later
 * 
 * When to use: Large n, performance critical, optimal solution
 * When NOT to use: Very small n, memory constraints
 * 
 * Time Complexity: O(n log n) - heap operations
 * Space Complexity: O(1) - fixed alphabet size
 */
class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        // Check if impossible
        int maxFreq = 0;
        for (int count : freq) {
            maxFreq = Math.max(maxFreq, count);
        }
        if (maxFreq > (s.length() + 1) / 2) {
            return "";
        }
        
        // Max-heap for most frequent characters
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxHeap.offer(new int[]{i, freq[i]});
            }
        }
        
        StringBuilder result = new StringBuilder();
        int[] prev = {-1, 0}; // [char, count]
        
        while (!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            result.append((char) (curr[0] + 'a'));
            curr[1]--;
            
            if (prev[1] > 0) {
                maxHeap.offer(prev);
            }
            
            prev = curr;
        }
        
        return result.toString();
    }
}

/*
Example Walkthrough:
s = "aab"

Count frequencies: a=2, b=1
Max-heap: [a:2, b:1]

Initialize: result = "", prev = [-1,0]

Iteration 1:
  curr = [a:2], result = "a", curr = [a:1]
  prev[1] = 0 → no offer
  prev = [a:1]

Iteration 2:
  curr = [b:1], result = "ab", curr = [b:0]
  prev[1] = 1 > 0 → offer [a:1]
  prev = [b:0]

Iteration 3:
  curr = [a:1], result = "aba", curr = [a:0]
  prev[1] = 0 → no offer
  prev = [a:0]

Result: "aba"

Another example:
s = "aaab"

Count frequencies: a=3, b=1
maxFreq = 3 > (4+1)/2 = 2 → impossible

Result: ""

Why this works:
- Max-heap always picks most frequent available character
- Previous character stored to avoid adjacency
- Impossible check prevents invalid inputs
- Heap ensures optimal character selection

Why this is optimal:
- Time: O(n log n) - optimal for this problem
- Space: O(1) - fixed alphabet size
- Handles all cases correctly
- Produces valid rearrangement when possible

Key insights:
- Most frequent characters should be spaced out
- Previous character must be stored temporarily
- Impossible when one character dominates
- Heap ensures optimal selection order

This is perfect solution!
*/
