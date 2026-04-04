# Two Pointers Problems - DSA Master Collection

This folder contains comprehensive solutions for two-pointer problems asked in technical interviews, with multiple approaches for each problem including time/space complexity analysis and usage guidelines.

## 📋 Problem List

| # | Problem | LeetCode ID | Difficulty | Best Approach | Time | Space |
|---|---------|-------------|------------|---------------|------|-------|
| 1 | [Two Sum II](./01-two-sum-ii/) | 167 | Medium | Two Pointers | O(n) | O(1) |
| 2 | [3Sum](./02-3sum/) | 15 | Medium | Two Pointers + Sort | O(n²) | O(1) |
| 3 | [Remove Element](./03-remove-element/) | 27 | Easy | Two Pointers | O(n) | O(1) |
| 4 | [Remove Duplicates from Sorted Array II](./04-remove-duplicates-from-sorted-array-ii/) | 80 | Medium | Two Pointers | O(n) | O(1) |
| 5 | [Reverse String](./05-reverse-string/) | 344 | Easy | Two Pointers | O(n) | O(1) |
| 6 | [Reverse Vowels of a String](./06-reverse-vowels-of-a-string/) | 345 | Easy | Two Pointers | O(n) | O(1) |
| 7 | [Valid Palindrome II](./07-valid-palindrome-ii/) | 680 | Easy | Two Pointers | O(n) | O(1) |
| 8 | [Backspace String Compare](./08-backspace-string-compare/) | 844 | Medium | Two Pointers | O(n) | O(1) |
| 9 | [Append Characters to String to Make Subsequence](./09-append-characters-to-string-to-make-subsequence/) | 2486 | Medium | Two Pointers | O(n) | O(1) |
| 10 | [Squares of a Sorted Array](./10-squares-of-a-sorted-array/) | 977 | Easy | Two Pointers | O(n) | O(n) |
| 11 | [Boats to Save People](./11-boats-to-save-people/) | 881 | Medium | Two Pointers + Sort | O(n log n) | O(1) |
| 12 | [Partition Array According to Given Pivot](./12-partition-array-according-to-given-pivot/) | 2151 | Medium | Two Pointers | O(n) | O(1) |

## 🎯 Key Patterns & Techniques

### 1. **Opposite Direction Two Pointers**
- **When to use**: Finding pairs, reversing, checking palindromes
- **Problems**: Two Sum II, Reverse String, Reverse Vowels, Valid Palindrome II
- **Time**: Usually O(n), **Space**: O(1)

### 2. **Same Direction Two Pointers (Fast/Slow)**
- **When to use**: Removing elements, finding patterns, sliding windows
- **Problems**: Remove Element, Remove Duplicates, Backspace String Compare
- **Time**: Usually O(n), **Space**: O(1)

### 3. **Two Pointers with Sorting**
- **When to use**: Need to find combinations or pairs
- **Problems**: 3Sum, Boats to Save People
- **Time**: O(n log n) for sort + O(n) for two pointers, **Space**: O(1)

### 4. **Two Pointers with Constraints**
- **When to use**: Complex conditions with multiple constraints
- **Problems**: Append Characters, Partition Array
- **Time**: Usually O(n), **Space**: O(1)

## 🛠️ Core Components

### 1. **Two Pointer Initialization**
```java
int left = 0, right = nums.length - 1; // Opposite direction
int slow = 0, fast = 1; // Same direction
```

### 2. **Pointer Movement**
```java
while (left < right) {
    // Process elements
    left++;
    right--;
}
```

### 3. **Conditional Movement**
```java
if (condition) {
    left++;
} else {
    right--;
}
```

## 📚 Usage Instructions

### For Each Problem:
1. **Read the README.md** for problem description and approach comparison
2. **Study multiple approaches** from brute force to optimal
3. **Understand complexity analysis** and when to use each approach
4. **Practice interview talking points** provided in each README

### Learning Path:
1. **Start with easier problems** (Reverse String, Remove Element)
2. **Progress to medium problems** (Two Sum II, 3Sum, Backspace String)
3. **Master complex problems** (Append Characters, Boats to Save People)

## 🏆 Interview Strategy

### How to Approach Two Pointer Problems:
1. **Identify if it's a two pointer problem** - Look for pairs, patterns, or sequential processing
2. **Determine pointer direction** - Opposite (pairs) or same direction (sliding)
3. **Define movement logic** - When to move each pointer
4. **Handle edge cases** - Empty arrays, single elements
5. **Optimize for space** - Usually O(1) for two pointers

### Common Follow-up Questions:
- "Why two pointers over brute force?" → O(n) vs O(n²)
- "Can we optimize further?" → Usually not, O(n) is optimal
- "What are the edge cases?" → Empty input, single element, no solution

## 📈 Progress Tracking

- ✅ **Problems with complete solutions**: 0/12
- 🔄 **Currently working on**: Folder structure setup
- 📋 **Next steps**: Create individual problem folders with comprehensive solutions

---

## 🎯 Key Insights

- **Two pointers** is essential for O(n) solutions to many problems
- **Opposite pointers** work well for finding pairs or checking symmetry
- **Same direction pointers** work well for processing or filtering
- **Sorting combined with two pointers** solves many combination problems
- **O(1) space** is usually achievable with two pointers

Master these patterns and you'll be well-prepared for any two pointer interview question!
