# Sort Strings by Length

## Problem Statement
Sort a list of strings by their length in ascending order (shortest to longest).

### Input
```
List<String> strings = Arrays.asList("apple", "kiwi", "banana", "a");
```

### Output
```
["a", "kiwi", "apple", "banana"]
```

## Approach

### Using Java Streams
1. **Create comparator** - Use `Comparator.comparingInt(String::length)` to compare by length
2. **Sort stream** - Apply `sorted()` with the comparator
3. **Collect results** - Collect into a list

**For descending order:**
- Use `.reversed()` on the comparator
- Or use `Comparator.comparingInt(String::length).reversed()`

**Step-by-step execution:**
```
Input: ["apple", "kiwi", "banana", "a"]
       [5, 4, 6, 1]
  ↓
Create length comparator
  ↓
Sort ascending by length
  ↓
Output: ["a", "kiwi", "apple", "banana"]
        [1, 4, 5, 6]
```

## Time Complexity
**O(n log n)** where n is the number of strings
- Sorting: **O(n log n)** ← dominant
- String length comparison: **O(1)** per comparison

## Space Complexity
**O(n)** for the sorted list

## Code Implementation
See [Main.java](./Main.java)
