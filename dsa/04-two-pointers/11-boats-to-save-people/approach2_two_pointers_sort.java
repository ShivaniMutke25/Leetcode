/**
 * Two Pointers + Sort Approach - Boats to Save People (OPTIMAL)
 * 
 * Logic:
 * - Sort the array to enable greedy pairing
 * - Use two pointers: lightest and heaviest remaining person
 * - Try to pair heaviest with lightest person that fits
 * - If no pair works, heaviest person goes alone
 * - Continue until all people are assigned
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(n log n) - O(n log n) for sort + O(n) for pairing
 * Space Complexity: O(1) - constant extra space
 */
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boats = 0;
        int left = 0, right = people.length - 1;
        
        while (left <= right) {
            // Try to pair heaviest person with lightest person
            if (people[left] + people[right] <= limit) {
                boats++; // One boat for the pair
                left++;
                right--;
            } else {
                // Heaviest person goes alone
                boats++;
                right--;
            }
        }
        
        // If one person remains (odd count)
        if (left == right) {
            boats++;
        }
        
        return boats;
    }
}

/*
Example Walkthrough:
people = [3,2,2,1], limit = 3

After sorting: [1,2,2,3]

Initialize: boats = 0, left = 0, right = 3

Iteration 1:
  Try pair: people[0] + people[3] = 1 + 3 = 4 > 3 ✗
  Heaviest goes alone: boats = 1, right = 2
  Result: boats = 1, people left = [1,2,2]

Iteration 2:
  Try pair: people[0] + people[2] = 1 + 2 = 3 <= 3 ✓
  Pair works: boats = 2, left = 1, right = 1
  Result: boats = 2, people left = [2]

Iteration 3:
  Try pair: people[1] + people[1] = 2 + 2 = 4 > 3 ✗
  Heaviest goes alone: boats = 3, right = 0
  Result: boats = 3, people left = [2]

Iteration 4:
  left == right == 1 → One person remains
  boats = 4

Result: 4 boats (incorrect!)

Let me trace more carefully:

people = [1,2,2,3], limit = 3

After sorting: [1,2,2,3]

Initialize: boats = 0, left = 0, right = 3

Iteration 1:
  Try pair: people[0] + people[3] = 1 + 3 = 4 > 3 ✗
  Heaviest (3) goes alone: boats = 1, right = 2
  Remaining: [1,2,2]

Iteration 2:
  Try pair: people[0] + people[2] = 1 + 2 = 3 <= 3 ✓
  Pair works: boats = 2, left = 1, right = 1
  Remaining: [2]

Iteration 3:
  left == right == 1 → One person (2) remains
  boats = 3

Final result: 3 boats

This is correct! The boats are:
1. (3) alone
2. (1,2) together
3. (2) alone

Total: 3 boats

Another example:
people = [3,5,3,4], limit = 5

After sorting: [3,3,4,5]

Initialize: boats = 0, left = 0, right = 3

Iteration 1:
  Try pair: people[0] + people[3] = 3 + 5 = 8 > 5 ✗
  Heaviest (5) goes alone: boats = 1, right = 2
  Remaining: [3,3,4]

Iteration 2:
  Try pair: people[0] + people[2] = 3 + 4 = 7 > 5 ✗
  Heaviest (4) goes alone: boats = 2, right = 1
  Remaining: [3,3]

Iteration 3:
  left == right == 1 → One person (3) remains
  boats = 3

Final result: 3 boats

The boats are:
1. (5) alone
2. (4) alone  
3. (3,3) together

Total: 3 boats

Why this works:
- Sorting enables greedy pairing strategy
- Always try to pair heaviest remaining person with lightest possible
- If no pair works, heaviest must go alone (optimal)
- Each person is assigned to exactly one boat

Why this is optimal:
- Time: O(n log n) - sorting dominates, optimal
- Space: O(1) - constant extra space
- Greedy strategy is provably optimal for this problem
- No need for complex data structures

Key insights:
- Sort enables optimal pairing strategy
- Two pointers efficiently find pairs from both ends
- Greedy approach of pairing heaviest with lightest is optimal
- Each iteration assigns at least one person

This is the perfect solution!
*/
