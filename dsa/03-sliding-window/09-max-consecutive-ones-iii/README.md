# Max Consecutive Ones III - LeetCode #1004

**Link:** https://leetcode.com/problems/max-consecutive-ones-iii/

## Problem Description
Given a binary array `nums` and an integer `k`, return the maximum number of consecutive `1`'s in the array if you can flip at most `k` `0`'s.

**Example:**
- Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
- Output: 6
- Explanation: [1,1,1,0,0,1,1,1,1,1,1]
- Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

**Constraints:**
- 1 <= nums.length <= 10^5
- nums[i] is either 0 or 1.
- 0 <= k <= nums.length

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Brute Force | O(n²) | O(1) | Learning, tiny inputs | Any realistic input |
| 2 | Sliding Window (Optimal) | O(n) | O(1) | Always - optimal solution | Never |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Sliding Window**
**Why:** This is the optimal O(n) solution that demonstrates understanding of sliding window with constraint tracking.

**Interview Logic:**
1. "I'll use a sliding window with two pointers: left and right"
2. "I'll maintain the count of zeros in the current window"
3. "When zeros count exceeds k, I'll shrink the window from left"
4. "The maximum window size found is the answer"
5. "This gives us O(n) time with O(1) space"

### Alternative Approaches to Mention:
- **Brute Force:** "The naive approach would try all possible subarrays, but that's O(n²)"
- **Prefix Sum + Binary Search:** "We could use prefix sum with binary search, but sliding window is simpler"

### Follow-up Questions to Prepare:
- "Why track zeros count?" → We can flip at most k zeros to ones
- "What if k = 0?" → Just find longest consecutive ones
- "Can we optimize further?" → No, O(n) is optimal since we need to examine each element

## Key Insights
- Window can contain at most k zeros (the ones we'll flip)
- When zeros > k, window is invalid, so shrink from left
- Maximum window size equals maximum consecutive ones after k flips
- Binary array property makes sliding window efficient

## Approach Details

### 1. Brute Force
Check all possible subarrays and count zeros.

### 2. Sliding Window (Optimal)
Use sliding window with zero counting to find longest subarray with at most k zeros.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
