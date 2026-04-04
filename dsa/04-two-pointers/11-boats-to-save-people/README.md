# Boats to Save People - LeetCode #881

**Link:** https://leetcode.com/problems/boats-to-save-people/

## Problem Description
The i-th person has weight `people[i]`, and each boat can carry a maximum weight of `limit`. Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most `limit`.

Return the minimum number of boats to carry every given person.

**Example:**
- Input: people = [3,2,2,1], limit = 3
- Output: 3
- Explanation: 3 boats: (1,2), (2), and (1,3)

**Constraints:**
- 1 <= people.length <= 5 * 10^4
- 1 <= people[i] <= limit <= 10^9

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Brute Force | O(n²) | O(1) | Learning, tiny inputs | Any realistic input |
| 2 | Two Pointers + Sort (Optimal) | O(n log n) | O(1) | Always - optimal solution | Never |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Two Pointers + Sort**
**Why:** This is the optimal O(n log n) solution that sorts first, then uses two pointers to pair people efficiently.

**Interview Logic:**
1. "I'll sort the array to enable greedy pairing"
2. "I'll use two pointers: lightest and heaviest remaining person"
3. "I'll try to pair heaviest with lightest person that fits"
4. "If no pair works, heaviest person goes alone"
5. "This gives us O(n log n) time with O(1) space"

### Alternative Approaches to Mention:
- **Brute Force:** "We could try all possible pairings, but that's O(n²)"
- **Greedy without Sort:** "We could use a multiset, but sorting is simpler"

### Follow-up Questions to Prepare:
- "Why sort first?" → Enables greedy approach of pairing heaviest with lightest
- "Why two pointers?" → One for lightest, one for heaviest, enables efficient pairing
- "Can we optimize further?" → No, O(n log n) is optimal due to sorting requirement

## Key Insights
- Sorting enables greedy pairing strategy
- Always try to pair heaviest person with lightest possible
- Two pointers efficiently find optimal pairs from both ends
- Each person is assigned to exactly one boat

## Approach Details

### 1. Brute Force
Try all possible pairings and count minimum boats needed.

### 2. Two Pointers + Sort (Optimal)
Sort array, then use two pointers to greedily pair people.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
