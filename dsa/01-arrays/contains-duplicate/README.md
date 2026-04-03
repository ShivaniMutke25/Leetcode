# Contains Duplicate - LeetCode #217

**Link:** https://leetcode.com/problems/contains-duplicate/

## Problem Description
Given an integer array `nums`, return `true` if any value appears at least twice in the array, and return `false` if every element is distinct.

**Example:**
- Input: nums = [1,2,3,1]
- Output: true

**Constraints:**
- 1 <= nums.length <= 10^5
- -10^9 <= nums[i] <= 10^9

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Brute Force | O(n²) | O(1) | Learning, tiny inputs | Any realistic input |
| 2 | Sorting | O(n log n) | O(1)* | Space is critical | Optimal solution needed |
| 3 | HashSet (Optimal) | O(n) | O(n) | Interview standard | Memory constraints tight |
| 4 | Bit Manipulation | O(n) | O(1) | Small range of values | Large value ranges |

*Space depends on sort implementation

## 🎯 Interview Strategy

### Most Appropriate Approach: **HashSet**
**Why:** This is the optimal solution that interviewers expect. It's simple, efficient, and demonstrates knowledge of hash-based data structures.

**Interview Logic:**
1. "I'll use a HashSet to track numbers I've seen"
2. "As I iterate, if I find a number already in the set, I return true immediately"
3. "If I finish the loop without finding duplicates, return false"
4. "This gives us O(n) time with O(n) space, which is optimal"

### Alternative Approaches to Mention:
- **Sorting:** "If space is a concern, we could sort first (O(n log n)) and check adjacent elements"
- **Brute Force:** "The naive approach would be O(n²) nested loops, but that's too slow"

### Follow-up Questions to Prepare:
- "What if the array is sorted?" → Just check adjacent elements
- "What if numbers are in a small range?" → Use boolean array/bitset
- "What if we can't use extra space?" → Sort the array first

## Key Insights
- HashSet provides O(1) average lookup for duplicates
- Early termination when duplicate found
- Space-time tradeoff: O(n) space for O(n) time vs O(1) space for O(n log n) time

## Approach Details

### 1. Brute Force
Check every pair of elements for equality.

### 2. Sorting
Sort array and check adjacent elements for duplicates.

### 3. HashSet (Optimal)
Use HashSet to track seen numbers during iteration.

### 4. Bit Manipulation
Use bit array if numbers are in a small, known range.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*