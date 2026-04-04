# Partition Array According to Given Pivot - LeetCode #2151

**Link:** https://leetcode.com/problems/partition-array-according-to-given-pivot/

## Problem Description
Given an integer array `nums` and an integer `pivot`, partition the array into two parts such that every element less than `pivot` appears before every element greater than `pivot`.

Return the array after partitioning.

**Example:**
- Input: nums = [9,12,5,10,14,3,10], pivot = 10
- Output: [9,5,3,10,10,12,14]
- Explanation: The array is partitioned as [9,5,3,10,10,12,14].

**Constraints:**
- 1 <= nums.length <= 10^5
- 1 <= nums[i] <= 10^9
- 1 <= pivot <= 10^9

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Brute Force | O(n²) | O(1) | Learning, tiny inputs | Any realistic input |
| 2 | Two Pointers (Optimal) | O(n) | O(1) | Always - optimal solution | Never |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Two Pointers**
**Why:** This is the optimal O(n) solution that uses two pointers to partition in-place.

**Interview Logic:**
1. "I'll use two pointers: left for building result, right for scanning"
2. "I'll move elements < pivot to the left side"
3. "I'll move elements >= pivot to the right side"
4. "I'll continue until all elements are processed"
5. "This gives us O(n) time with O(1) space"

### Alternative Approaches to Mention:
- **Brute Force:** "We could create new array and partition, but that uses O(n) space"
- **Counting Sort:** "We could count elements and rebuild, but two pointers is more efficient"

### Follow-up Questions to Prepare:
- "Why two pointers?" → Enables in-place partitioning without extra space
- "What about equal elements?" → Can go either side, consistency is key
- "Can we optimize further?" → No, O(n) is optimal since we need to examine each element

## Key Insights
- Two pointers can partition array in-place without extra space
- Left pointer builds the less-than-pivot section
- Right pointer fills the greater-or-equal section
- Each element is examined exactly once

## Approach Details

### 1. Brute Force
Create new array with elements < pivot first, then >= pivot.

### 2. Two Pointers (Optimal)
Use two pointers to partition array in-place.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
