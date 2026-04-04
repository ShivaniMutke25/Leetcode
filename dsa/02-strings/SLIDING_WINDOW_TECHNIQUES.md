# Sliding Window Techniques - String Problems

## 🎯 Overview
Sliding window is a powerful technique for solving substring/subarray problems efficiently. It maintains a window of elements that slides through the data structure, allowing us to process elements in linear time.

## 📋 Sliding Window Problems in String Folder

| # | Problem | LeetCode ID | Difficulty | Window Type | Time | Space |
|---|---------|-------------|------------|-------------|------|-------|
| 1 | [Longest Substring Without Repeating](./longest-substring-without-repeating-characters/) | 3 | Medium | Variable Size | O(n) | O(min(m,n)) |
| 2 | [Permutation in String](./permutation-in-string/) | 567 | Medium | Fixed Size | O(m+n) | O(1) |
| 3 | [Find All Anagrams in a String](./find-all-anagrams-in-a-string/) | 438 | Medium | Fixed Size | O(m+n) | O(1) |
| 4 | [Minimum Window Substring](./minimum-window-substring/) | 76 | Hard | Variable Size | O(m+n) | O(1) |

## 🔄 Sliding Window Types

### 1. **Fixed Size Window**
- **When to use**: Looking for substrings of specific length
- **Examples**: Permutation in String, Find All Anagrams
- **Pattern**: Window size = pattern length, slide by 1 each time

### 2. **Variable Size Window**
- **When to use**: Looking for substrings meeting certain conditions
- **Examples**: Longest Substring Without Repeating, Minimum Window Substring
- **Pattern**: Expand/shrink window based on conditions

## 🛠️ Core Components

### 1. **Window Boundaries**
```java
int left = 0, right = 0; // Window boundaries
```

### 2. **Frequency Tracking**
```java
int[] count = new int[26]; // For lowercase letters
Map<Character, Integer> freq = new HashMap<>(); // For any character set
```

### 3. **Window Validation**
```java
while (right < s.length()) {
    // Add current character to window
    // Check if window is valid
    // If valid, update result
    // If invalid, shrink window
}
```

## 📊 Sliding Window Patterns

### Pattern 1: Maximum/Minimum Window
```java
int left = 0, maxLength = 0;
for (int right = 0; right < s.length(); right++) {
    // Add s[right] to window
    
    // Shrink window while invalid
    while (!isValid()) {
        // Remove s[left] from window
        left++;
    }
    
    // Update result
    maxLength = Math.max(maxLength, right - left + 1);
}
```

### Pattern 2: Fixed Window Sliding
```java
int windowSize = pattern.length();
for (int right = 0; right < s.length(); right++) {
    // Add s[right] to window
    
    if (right >= windowSize - 1) {
        // Check if window is valid
        if (isValid()) {
            // Add to result
        }
        // Remove s[left] from window
        left++;
    }
}
```

### Pattern 3: Counting with Frequency Maps
```java
Map<Character, Integer> need = new HashMap<>();
Map<Character, Integer> window = new HashMap<>();
int formed = 0, required = need.size();

for (int right = 0; right < s.length(); right++) {
    char c = s.charAt(right);
    window.put(c, window.getOrDefault(c, 0) + 1);
    
    if (need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue()) {
        formed++;
    }
    
    // Shrink window while all requirements met
    while (left <= right && formed == required) {
        // Update result
        // Remove s[left] from window
        // Update formed if needed
        left++;
    }
}
```

## 🎯 Key Insights

### 1. **When to Use Sliding Window**
- Looking for contiguous substrings
- Need to process elements in order
- Want O(n) time complexity
- Window can be defined by clear boundaries

### 2. **Common Mistakes to Avoid**
- Forgetting to remove leftmost character when shrinking
- Not handling edge cases (empty strings, single characters)
- Incorrect window boundary updates
- Not resetting frequency counts properly

### 3. **Optimization Techniques**
- Use arrays instead of HashMap for fixed character sets
- Pre-compute requirements when possible
- Early termination when optimal solution found
- Avoid redundant calculations inside loops

## 🔍 Problem-Specific Strategies

### Longest Substring Without Repeating
- **Key**: Track last seen positions of characters
- **Trick**: Move left to max(left, lastSeen[char] + 1)
- **Space**: O(min(m,n)) where m is alphabet size

### Permutation in String / Find All Anagrams
- **Key**: Fixed window size = pattern length
- **Trick**: Use frequency arrays for O(1) space
- **Space**: O(1) for fixed alphabet

### Minimum Window Substring
- **Key**: Track formed vs required characters
- **Trick**: Contract window while still valid
- **Space**: O(1) for fixed alphabet

## 📚 Interview Strategy

### How to Explain Sliding Window Solution:
1. "I'll use a sliding window approach to efficiently find substrings"
2. "The window will be defined by left and right pointers"
3. "I'll maintain character frequencies to track window validity"
4. "I'll expand the window by moving right pointer"
5. "When the window becomes invalid, I'll shrink it by moving left pointer"
6. "This gives us O(n) time with O(1) space"

### Follow-up Questions to Prepare:
- "Why sliding window over brute force?" → O(n) vs O(n²)
- "How do you handle the window boundaries?" → Clear left/right pointers
- "What's the space complexity?" → O(1) for fixed alphabet, O(n) otherwise
- "Can you optimize further?" → Usually not, O(n) is optimal

## 🏆 Summary

Sliding window is essential for substring problems and provides:
- ✅ **Linear time complexity** (O(n))
- ✅ **Constant space** for fixed alphabets (O(1))
- ✅ **Intuitive approach** for contiguous problems
- ✅ **Versatile patterns** for different requirements

Master these patterns and you'll be well-prepared for any sliding window interview question!
