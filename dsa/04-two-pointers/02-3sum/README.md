# 3Sum - LeetCode #15

**Link:** https://leetcode.com/problems/3sum/

## Problem Description
Given an integer array `nums`, return all the triplets `[nums[i], nums[j], nums[k]]` such that `i != j`, `i != k`, and `j != k`, and `nums[i] + nums[j] + nums[k] == 0`.

Notice that the solution set must not contain duplicate triplets.

**Example:**
- Input: nums = [-1,0,1,2,-1,-4]
- Output: [[-1,-1,2],[-1,0,1]]
- Explanation: The solution set contains two unique triplets.

**Constraints:**
- 0 <= nums.length <= 3000
- -10^5 <= nums[i] <= 10^5

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Brute Force | O(n³) | O(1) | Learning, tiny inputs | Any realistic input |
| 2 | Two Pointers + Sort (Optimal) | O(n²) | O(1) | Always - optimal solution | Never |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Two Pointers + Sort**
**Why:** This is the optimal O(n²) solution that leverages sorting to avoid O(n³) complexity.

**Interview Logic:**
1. "I'll first sort the array to enable two-pointer technique"
2. "For each element, I'll use two pointers to find pairs that sum to its negative"
3. "I'll skip duplicates to avoid duplicate triplets"
4. "I'll collect all unique triplets"
5. "This gives us O(n²) time with O(1) extra space"

### Alternative Approaches to Mention:
- **Brute Force:** "The naive approach would check all triplets, but that's O(n³)"
- **HashSet:** "We could use HashSet for O(n²) but sorting approach is cleaner"

### Follow-up Questions to Prepare:
- "Why sort first?" → Enables two-pointer technique and easy duplicate handling
- "How do we handle duplicates?" → Skip same values during iteration
- "Can we optimize further?" → No, O(n²) is optimal for this problem

## Key Insights
- Sorting enables two-pointer technique for 2-sum subproblem
- Need to handle duplicates carefully to avoid duplicate triplets
- Each element becomes target for finding complementary pairs
- Two pointers find all pairs in linear time for each target

## Approach Details

### 1. Brute Force
Check all possible triplets and collect those with sum = 0.

### 2. Two Pointers + Sort (Optimal)
Sort array, then for each element use two pointers to find complementary pairs.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
