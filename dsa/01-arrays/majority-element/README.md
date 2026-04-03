# Majority Element - LeetCode #169

**Link:** https://leetcode.com/problems/majority-element/

## Problem Description
Given an array `nums` of size `n`, return the majority element. The majority element is the element that appears more than `⌊n/2⌋` times. You may assume that the majority element always exists in the array.

**Example:**
- Input: nums = [3,2,3]
- Output: 3
- Explanation: 3 appears 2 times, which is > 3/2 = 1.5

**Constraints:**
- n == nums.length
- 1 <= n <= 5 * 10^4
- -10^9 <= nums[i] <= 10^9

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Brute Force | O(n²) | O(1) | Learning, tiny inputs | Any realistic input |
| 2 | HashMap | O(n) | O(n) | When extra space is available | Memory constraints tight |
| 3 | Sorting | O(n log n) | O(1) | When O(1) space is needed | O(n) time required |
| 4 | Boyer-Moore Voting (Optimal) | O(n) | O(1) | Always - optimal solution | Never |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Boyer-Moore Voting**
**Why:** This is the optimal O(n) time and O(1) space solution that demonstrates advanced algorithmic knowledge.

**Interview Logic:**
1. "I'll use the Boyer-Moore voting algorithm with candidate and count variables"
2. "When count is 0, I set current element as candidate"
3. "If current element equals candidate, I increment count, otherwise decrement"
4. "Since majority element appears > n/2 times, it will win the 'vote'"
5. "This gives us O(n) time with O(1) space"

### Alternative Approaches to Mention:
- **HashMap:** "We could count frequencies with a HashMap, but that uses O(n) space"
- **Sorting:** "If we sort, the middle element is guaranteed to be the majority, but that's O(n log n)"
- **Brute Force:** "The naive approach would count each element's occurrences"

### Follow-up Questions to Prepare:
- "Why does Boyer-Moore work?" → Majority element can cancel out all others
- "What if there's no majority element?" → Need to verify the candidate
- "Can we find the top K frequent elements?" → Use HashMap or QuickSelect

## Key Insights
- Majority element appears more than half the time, so it has special properties
- Boyer-Moore works because majority element can "cancel out" all other elements
- The middle element after sorting is always the majority element

## Approach Details

### 1. Brute Force
Count occurrences of each element by scanning the array.

### 2. HashMap
Use HashMap to count frequencies of each element.

### 3. Sorting
Sort and return the middle element (at index n/2).

### 4. Boyer-Moore Voting
Maintain a candidate and count, canceling out different elements.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
