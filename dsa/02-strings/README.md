# String Problems - DSA Master Collection

This folder contains comprehensive solutions for common string problems asked in technical interviews, with multiple approaches for each problem including time/space complexity analysis and usage guidelines.

## 📋 Problem List

| # | Problem | LeetCode ID | Difficulty | Best Approach | Time | Space |
|---|---------|-------------|------------|---------------|------|-------|
| 1 | [Valid Anagram](./valid-anagram/) | 242 | Easy | Counting Array | O(n) | O(1) |
| 2 | [Valid Parentheses](./valid-parentheses/) | 20 | Easy | Stack | O(n) | O(n) |
| 3 | [Valid Palindrome](./valid-palindrome/) | 125 | Easy | Two Pointers | O(n) | O(1) |
| 4 | [String Compression](./string-compression/) | 443 | Easy | Two Pointers | O(n) | O(1) |
| 5 | [Reverse Words in a String](./reverse-words-in-a-string/) | 151 | Medium | Two Pointers | O(n) | O(1) |
| 6 | [Longest Common Prefix](./longest-common-prefix/) | 14 | Easy | Vertical Scan | O(mn) | O(1) |
| 7 | [Implement strStr()](./implement-strstr/) | 28 | Easy | KMP | O(m+n) | O(n) |
| 8 | [Isomorphic Strings](./isomorphic-strings/) | 205 | Easy | HashMap | O(n) | O(1) |
| 9 | [Longest Substring Without Repeating](./longest-substring-without-repeating-characters/) | 3 | Medium | Sliding Window | O(n) | O(min(m,n)) |
| 10 | [Group Anagrams](./group-anagrams/) | 49 | Medium | HashMap | O(nklogk) | O(nk) |
| 11 | [Permutation in String](./permutation-in-string/) | 567 | Medium | Sliding Window | O(m+n) | O(1) |
| 12 | [Find All Anagrams in a String](./find-all-anagrams-in-a-string/) | 438 | Medium | Sliding Window | O(m+n) | O(1) |
| 13 | [Decode String](./decode-string/) | 394 | Medium | Stack | O(n) | O(n) |
| 14 | [Palindromic Substrings](./palindromic-substrings/) | 647 | Medium | Center Expansion | O(n²) | O(1) |
| 15 | [Longest Palindromic Substring](./longest-palindromic-substring/) | 5 | Medium | Center Expansion | O(n²) | O(1) |
| 16 | [Minimum Window Substring](./minimum-window-substring/) | 76 | Hard | Sliding Window | O(m+n) | O(1) |

## 🎯 Key Patterns & Techniques

### 1. **Sliding Window**
- **When to use**: Finding subarrays/substrings with specific properties
- **Problems**: Longest Substring Without Repeating, Permutation in String, Find All Anagrams, Minimum Window Substring
- **Time**: Usually O(n), **Space**: O(1) or O(k) where k is alphabet size

### 2. **Two Pointers**
- **When to use**: In-place operations, palindrome checks, string reversal
- **Problems**: Valid Palindrome, Reverse Words, String Compression
- **Time**: Usually O(n), **Space**: O(1)

### 3. **Stack**
- **When to use**: Nested structures, balanced parentheses, decoding
- **Problems**: Valid Parentheses, Decode String
- **Time**: Usually O(n), **Space**: O(n)

### 4. **Hashing (HashMap/HashSet)**
- **When to use**: Pattern matching, grouping, frequency counting
- **Problems**: Group Anagrams, Isomorphic Strings, Valid Anagram
- **Time**: Usually O(n), **Space**: O(n)

### 5. **String Matching**
- **When to use**: Finding substrings, pattern matching
- **Problems**: Implement strStr(), Find All Anagrams
- **Time**: Varies from O(mn) to O(m+n), **Space**: O(n)

### 6. **Palindrome Techniques**
- **When to use**: Finding palindromes or palindromic substrings
- **Problems**: Valid Palindrome, Longest Palindromic Substring, Palindromic Substrings
- **Time**: O(n) to O(n²), **Space**: O(1) to O(n)

## 📚 Approach Categories

For each problem, you'll find multiple approaches:

| Approach Type | When to Use | Pros | Cons |
|---------------|-------------|------|------|
| **Brute Force** | Learning, small inputs | Simple to understand | Poor performance |
| **Sliding Window** | Subarray/substring problems | Optimal for many problems | Can be complex to implement |
| **Two Pointers** | In-place operations | O(1) space, efficient | Requires specific patterns |
| **Stack** | Nested structures | Handles nesting well | Extra space |
| **Hashing** | Pattern matching | Fast lookups | Extra space |
| **String Algorithms** | Pattern matching | Optimal for specific cases | Complex implementation |

## 🔍 How to Use This Repository

1. **Start with the problem README** - Understand the problem and constraints
2. **Study all approaches** - Learn different ways to solve the same problem
3. **Analyze complexities** - Understand why certain approaches are better
4. **Practice implementation** - Code each approach yourself
5. **Compare solutions** - Understand trade-offs between approaches

## 💡 Interview Tips

- **Start with brute force** - Show you can solve the problem, then optimize
- **Explain trade-offs** - Discuss time vs space complexity
- **Consider edge cases** - Empty strings, single characters, special characters
- **Think aloud** - Show your thought process to the interviewer

## 🚀 Learning Path

1. **Beginner**: Valid Anagram, Valid Parentheses, Valid Palindrome, String Compression
2. **Intermediate**: Reverse Words, Longest Common Prefix, Implement strStr(), Isomorphic Strings
3. **Advanced**: Longest Substring Without Repeating, Group Anagrams, Permutation in String, Decode String
4. **Expert**: Find All Anagrams, Palindromic Substrings, Longest Palindromic Substring, Minimum Window Substring

---

*Each problem folder contains detailed explanations, multiple approaches with code, complexity analysis, and usage guidelines.*
