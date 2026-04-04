# Top K Frequent Elements - LeetCode #347

**Link:** https://leetcode.com/problems/top-k-frequent-elements/

## Problem Description
Given an integer array `nums` and an integer `k`, return the `k` most frequent elements.

**Example:**
- Input: nums = [1,1,1,2,2,3], k = 2
- Output: [1,2]
- Input: nums = [1], k = 1
- Output: [1]

**Constraints:**
- 1 <= nums.length <= 10^5
- k is in the range [1, number of unique elements in the array]
- It is guaranteed that the answer is unique.

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Sort by Frequency | O(n log n) | O(n) | Simple implementation | Large n |
| 2 | Min-Heap (Optimal) | O(n log k) | O(n) | Large n, small k | k close to n |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Min-Heap**
**Why:** This is optimal O(n log k) solution that maintains k most frequent elements.

**Interview Logic:**
1. "I'll first count frequencies using HashMap"
2. "Then I'll use min-heap of size k to maintain k most frequent"
3. "For each frequency pair, I'll add to heap and remove smallest if size exceeds k"
4. "The heap will contain k most frequent elements"
5. "This gives us O(n log k) time with O(n) space"

### Alternative Approaches to Mention:
- **Bucket Sort:** "We could use bucket sort for O(n) time, but space is O(n)"
- **QuickSelect:** "We could use QuickSelect but it's complex to implement"

### Follow-up Questions to Prepare:
- "Why min-heap instead of max-heap?" → Min-heap keeps k most frequent, root is smallest
- "What if we need exact order?" → Extract from heap and reverse
- "Can we optimize for small k?" → For k=1, just find max frequency
- "What about ties?" → Problem guarantees unique answer

## Key Insights
- Frequency counting is essential first step
- Min-heap of size k maintains k most frequent elements
- Time complexity is O(n log k) - better than sorting for small k
- Space complexity is O(n) - need to store frequencies
- Handles large arrays efficiently

## Approach Details

### 1. Sort by Frequency
Count frequencies, sort by frequency descending, return top k.

### 2. Min-Heap (Optimal)
Count frequencies, use min-heap to maintain k most frequent elements.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
