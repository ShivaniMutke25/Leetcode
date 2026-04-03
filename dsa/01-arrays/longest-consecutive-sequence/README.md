# Longest Consecutive Sequence - LeetCode #128

**Link:** https://leetcode.com/problems/longest-consecutive-sequence/

## Problem Description
Given an unsorted array of integers `nums`, find the length of the longest consecutive elements sequence. You must write an algorithm with O(n) time complexity.

**Example:**
- Input: nums = [100,4,200,1,3,2]
- Output: 4
- Explanation: The longest consecutive sequence is [1,2,3,4], length = 4

**Constraints:**
- 0 <= nums.length <= 10^5
- -10^9 <= nums[i] <= 10^9

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Brute Force | O(n²) | O(1) | Learning, very small inputs | Any realistic input |
| 2 | Sorting | O(n log n) | O(1) | Simpler code acceptable | O(n) required |
| 3 | HashSet (Optimal) | O(n) | O(n) | Always - meets requirements | Memory constraints tight |

## 🎯 Interview Strategy

### Most Appropriate Approach: **HashSet**
**Why:** This meets the O(n) time requirement and is the expected optimal solution.

**Interview Logic:**
1. "I'll add all numbers to a HashSet for O(1) lookups"
2. "For each number, I only start counting if it's the beginning of a sequence (num-1 doesn't exist)"
3. "I count consecutive numbers using HashSet lookups"
4. "This ensures each sequence is only counted once"
5. "This gives us O(n) time with O(n) space"

### Alternative Approaches to Mention:
- **Sorting:** "If O(n log n) was acceptable, we could sort and scan for consecutive sequences"
- **Union Find:** "We could use Union Find, but it's overkill and less efficient"

### Follow-up Questions to Prepare:
- "Why do we check if num-1 exists?" → To only start sequences at the beginning
- "What if we need to return the actual sequence?" → Keep track of start and length
- "Can we optimize space?" → Use bitset if numbers are in a small range

## Key Insights
- HashSet allows O(1) lookups to check if numbers exist
- Only start counting from numbers that are the beginning of a sequence
- A number is a sequence start if num-1 doesn't exist in the set

## Approach Details

### 1. Brute Force
For each number, search for consecutive numbers incrementally.

### 2. Sorting
Sort the array and count consecutive sequences.

### 3. HashSet (Optimal)
Use HashSet for O(1) lookups and only start sequences at valid beginnings.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
