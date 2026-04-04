# Task Scheduler - LeetCode #621

**Link:** https://leetcode.com/problems/task-scheduler/

## Problem Description
Given a character array `tasks` where each letter represents a different task. Each task takes one unit of time to complete. For each task, there must be a cooling period `n` between two same tasks.

Return the minimum number of units of time required to complete all tasks.

**Example:**
- Input: tasks = ["A","A","A","B","B","B"], n = 2
- Output: 8

**Constraints:**
- 1 <= tasks.length <= 10^4
- tasks[i] is an uppercase English letter
- 0 <= n <= 100

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Simulation | O(n log n) | O(1) | Simple implementation | Large n |
| 2 | Max-Heap (Optimal) | O(n log n) | O(1) | Large n, performance critical | Memory constraints |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Max-Heap**
**Why:** This is optimal O(n log n) solution that efficiently schedules tasks.

**Interview Logic:**
1. "I'll count task frequencies and use max-heap for priority"
2. "I'll schedule tasks while respecting cooling period"
3. "I'll use queue to track cooling tasks"
4. "I'll process until all tasks are completed"
5. "This gives us O(n log n) time with O(1) space"

### Alternative Approaches to Mention:
- **Mathematical Formula:** "We could calculate based on most frequent task"
- **Greedy with Array:** "We could use array instead of heap"

### Follow-up Questions to Prepare:
- "Why max-heap instead of min-heap?" → Need most frequent task first
- "What if n = 0?" → Just return task count
- "Can we optimize further?" → O(n) formula exists but complex
- "What about idle time?" → Handled automatically by algorithm

## Key Insights
- Max-heap prioritizes most frequent tasks
- Queue tracks tasks in cooling period
- Schedule ensures cooling period compliance
- Time complexity is O(n log n) - optimal for this problem
- Space complexity is O(1) - fixed alphabet size

## Approach Details

### 1. Simulation
Simulate task execution with cooling period.

### 2. Max-Heap (Optimal)
Use max-heap and queue for efficient scheduling.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
