# Array Problems - DSA Master Collection

This folder contains comprehensive solutions for common array problems asked in technical interviews, with multiple approaches for each problem including time/space complexity analysis and usage guidelines.

## 📋 Problem List

| # | Problem | LeetCode ID | Difficulty | Best Approach | Time | Space |
|---|---------|-------------|------------|---------------|------|-------|
| 1 | [Two Sum](./two-sum/) | 1 | Easy | HashMap | O(n) | O(n) |
| 2 | [Best Time to Buy and Sell Stock](./best-time-to-buy-and-sell-stock/) | 121 | Easy | One Pass | O(n) | O(1) |
| 3 | [Contains Duplicate](./contains-duplicate/) | 217 | Easy | HashSet | O(n) | O(n) |
| 4 | [Maximum Subarray](./maximum-subarray/) | 53 | Medium | Kadane's | O(n) | O(1) |
| 5 | [Move Zeroes](./move-zeroes/) | 283 | Easy | Two Pointers | O(n) | O(1) |
| 6 | [Majority Element](./majority-element/) | 169 | Easy | Boyer-Moore | O(n) | O(1) |
| 7 | [Sort Colors](./sort-colors/) | 75 | Medium | Dutch National | O(n) | O(1) |
| 8 | [Merge Sorted Array](./merge-sorted-array/) | 88 | Medium | Two Pointers | O(m+n) | O(1) |
| 9 | [Product of Array Except Self](./product-of-array-except-self/) | 238 | Medium | Prefix/Suffix | O(n) | O(n) |
| 10 | [Container With Most Water](./container-with-most-water/) | 11 | Medium | Two Pointers | O(n) | O(1) |
| 11 | [Longest Consecutive Sequence](./longest-consecutive-sequence/) | 128 | Medium | HashSet | O(n) | O(n) |
| 12 | [Subarray Sum Equals K](./subarray-sum-equals-k/) | 560 | Medium | Prefix Sum | O(n) | O(n) |

## 🎯 Key Patterns & Techniques

### 1. **Two Pointers Technique**
- **When to use**: Sorted arrays, finding pairs, in-place operations
- **Problems**: Two Sum (sorted), Merge Sorted Array, Move Zeroes, Container With Most Water
- **Time**: Usually O(n), **Space**: O(1)

### 2. **Hashing (HashSet/HashMap)**
- **When to use**: Fast lookups, counting, checking existence
- **Problems**: Two Sum, Contains Duplicate, Longest Consecutive Sequence, Subarray Sum Equals K
- **Time**: Usually O(n), **Space**: O(n)

### 3. **Kadane's Algorithm**
- **When to use**: Maximum subarray problems
- **Problems**: Maximum Subarray
- **Time**: O(n), **Space**: O(1)

### 4. **Dutch National Flag**
- **When to use**: Three-way partitioning
- **Problems**: Sort Colors
- **Time**: O(n), **Space**: O(1)

### 5. **Boyer-Moore Voting**
- **When to use**: Finding majority element
- **Problems**: Majority Element
- **Time**: O(n), **Space**: O(1)

### 6. **Prefix Sum/Suffix Product**
- **When to use**: Range queries, product calculations
- **Problems**: Product of Array Except Self, Subarray Sum Equals K
- **Time**: O(n), **Space**: O(n)

## 📚 Approach Categories

For each problem, you'll find multiple approaches:

| Approach Type | When to Use | Pros | Cons |
|---------------|-------------|------|------|
| **Brute Force** | Learning, small inputs | Simple to understand | Poor performance |
| **Hashing** | Fast lookups needed | O(1) average lookup | Extra space |
| **Two Pointers** | Sorted data, in-place | O(1) space, efficient | Requires sorting/order |
| **Greedy** | Local optimal = global | Simple, efficient | Not always optimal |
| **Dynamic Programming** | Overlapping subproblems | Optimal solution | Complex, extra space |

## 🔍 How to Use This Repository

1. **Start with the problem README** - Understand the problem and constraints
2. **Study all approaches** - Learn different ways to solve the same problem
3. **Analyze complexities** - Understand why certain approaches are better
4. **Practice implementation** - Code each approach yourself
5. **Compare solutions** - Understand trade-offs between approaches

## 💡 Interview Tips

- **Start with brute force** - Show you can solve the problem, then optimize
- **Explain trade-offs** - Discuss time vs space complexity
- **Consider edge cases** - Empty arrays, single elements, duplicates
- **Think aloud** - Show your thought process to the interviewer

## 🚀 Learning Path

1. **Beginner**: Two Sum, Contains Duplicate, Move Zeroes
2. **Intermediate**: Best Time to Buy and Sell Stock, Maximum Subarray, Majority Element
3. **Advanced**: Product of Array Except Self, Container With Most Water, Subarray Sum Equals K

---

*Each problem folder contains detailed explanations, multiple approaches with code, complexity analysis, and usage guidelines.*
