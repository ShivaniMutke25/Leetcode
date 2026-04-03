# Two Sum - LeetCode #1

**Link:** https://leetcode.com/problems/two-sum/

## Problem Description
Given an array of integers `nums` and an integer `target`, return the indices of the two numbers that add up to the target. Each input has exactly one solution, and you cannot use the same element twice.

**Example:**
- Input: nums = [2,7,11,15], target = 9
- Output: [0,1]
- Explanation: nums[0] + nums[1] = 2 + 7 = 9

**Constraints:**
- 2 <= nums.length <= 10^4
- -10^9 <= nums[i] <= 10^9
- -10^9 <= target <= 10^9

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Brute Force | O(n²) | O(1) | Learning, very small inputs | Any realistic input |
| 2 | HashMap (Optimal) | O(n) | O(n) | Always - optimal solution | Memory constraints tight |

## 🎯 Interview Strategy

### Most Appropriate Approach: **HashMap**
**Why:** This is the optimal O(n) solution that demonstrates understanding of hash-based data structures and complement logic.

**Interview Logic:**
1. "I'll use a HashMap to store numbers I've seen with their indices"
2. "For each number, I calculate complement = target - num"
3. "If complement exists in HashMap, I found the pair"
4. "If not, I store current number and continue"
5. "This gives us O(n) time with O(n) space"

### Alternative Approaches to Mention:
- **Brute Force:** "The naive approach would check all pairs, but that's O(n²)"
- **Two Pointers (if sorted):** "If array was sorted, we could use two pointers"

### Follow-up Questions to Prepare:
- "Why store numbers as we go?" → To avoid using same element twice
- "What if there are multiple solutions?" → Return first one found
- "Can we optimize space?" → Only if we can modify input or it's sorted

## Key Insights
- HashMap allows O(1) lookups for complement values
- For each number, check if target - num exists in HashMap
- Store numbers seen so far to find pairs efficiently

## Approach Details

### 1. Brute Force
Check every possible pair of numbers to see if they sum to target.

### 2. HashMap (Optimal)
Use HashMap to store numbers seen and their indices, checking for complements.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*