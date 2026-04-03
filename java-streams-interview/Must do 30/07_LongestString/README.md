# Longest String

## Problem Statement
Find the string with the maximum length (longest string) from a list of strings.

### Input
```
List<String> strings = Arrays.asList("apple", "banana", "kiwi", "watermelon");
```

### Output
```
"watermelon"
```

## Approach

### Using Java Streams
1. **Max by length** - Use `max()` with `Comparator.comparingInt(String::length)`
2. **Return result** - Return the Optional, or use `orElse()` for null safety

**Alternative approaches:**
1. Sort strings by length in descending order and get first
2. Use `reduce()` to find maximum

**Step-by-step execution:**
```
Input: ["apple", "banana", "kiwi", "watermelon"]
       [5 chars, 6 chars, 4 chars, 10 chars]
  ↓
Compare lengths and find max
  ↓
Output: "watermelon" (10 chars)
```

## Time Complexity
**O(n)** where n is the number of strings
- Stream through all strings: **O(n)**
- Max operation: **O(n)** (single pass comparison)
- Total: **O(n)**

## Space Complexity
**O(1)** - Only storing the result

## Code Implementation
See [Main.java](./Main.java)
