# First Repeating Character

## Problem Statement
Find the first character that appears more than once in a string. Return the character, or empty/null if no character repeats.

### Input
```
String s = "abcabd"
```

### Output
```
'a'
```

## Approach

### Using Java Streams
1. **Group characters** - Use `groupingBy()` with `counting()` to count frequency
2. **Create frequency map** - Map for O(1) lookup
3. **Stream original string** - Go through characters in original order (maintains first occurrence)
4. **Find first repeating** - Return first character with count > 1

**Step-by-step execution:**
```
Input: "abcabd"
  ↓
Count frequencies:
  {a=2, b=2, c=1, d=1}
  ↓
Stream original order: ['a','b','c','a','b','d']
  ↓
Filter where frequency > 1: 'a' (first match)
  ↓
Output: 'a'
```

## Time Complexity
**O(n)** where n is the length of the string
- Grouping characters: **O(n)**
- Finding first repeating: **O(n)** (worst case)
- Total: **O(n)**

## Space Complexity
**O(k)** where k is the number of unique characters
- Frequency map: **O(k)**

## Code Implementation
See [Main.java](./Main.java)
