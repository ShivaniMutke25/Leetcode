# Meeting Rooms II - LeetCode #253

**Link:** https://leetcode.com/problems/meeting-rooms-ii/

## Problem Description
Given an array of meeting time intervals `intervals` where `intervals[i] = [starti, endi]`, return the minimum number of conference rooms required.

**Example:**
- Input: intervals = [[0,30],[5,10],[15,20]]
- Output: 2
- Input: intervals = [[7,10],[2,4]]
- Output: 1

**Constraints:**
- 1 <= intervals.length <= 10^4
- 0 <= starti < endi <= 10^6

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Sort + Count | O(n log n) | O(n) | Simple implementation | Large n |
| 2 | Min-Heap (Optimal) | O(n log n) | O(n) | Large n, performance critical | Memory constraints |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Min-Heap**
**Why:** This is optimal O(n log n) solution that efficiently tracks active meetings.

**Interview Logic:**
1. "I'll sort intervals by start time"
2. "I'll use min-heap to track end times of active meetings"
3. "For each meeting, I'll check if earliest ending room is available"
4. "If available, reuse room; otherwise, add new room"
5. "Heap size at any time gives minimum rooms needed"

### Alternative Approaches to Mention:
- **Sweep Line:** "We could use separate start/end arrays with two pointers"
- **Chronological Ordering:** "We could process events in order"

### Follow-up Questions to Prepare:
- "Why min-heap instead of max-heap?" → Need earliest ending room
- "What if meetings have same start/end times?" → Handle appropriately
- "Can we optimize space?" → Need O(n) for heap
- "What about empty intervals?" → Handle edge cases

## Key Insights
- Min-heap tracks end times of active meetings
- Heap size represents rooms currently in use
- Maximum heap size gives minimum rooms needed
- Time complexity is O(n log n) - sorting + heap operations
- Space complexity is O(n) - heap for end times

## Approach Details

### 1. Sort + Count
Sort by start time, count overlapping intervals.

### 2. Min-Heap (Optimal)
Use min-heap to efficiently manage room allocation.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
