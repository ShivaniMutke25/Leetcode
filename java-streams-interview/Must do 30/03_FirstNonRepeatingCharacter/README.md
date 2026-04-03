# First Non-Repeating Character

## Problem Statement
Find the first character that appears only once in a string. Return the character, or empty/null if no such character exists.

### Input
```
String s = "leetcode"
```

### Output
```
'l'
```

## Approach

### Using Java Streams
1. **Group characters** - Use `groupingBy()` with `counting()` to count frequency of each character
2. **Create frequency map** - Convert to a map for lookup
3. **Stream original string** - Go through characters in original order
4. **Find first non-repeating** - Return first character with count 1

**Step-by-step execution:**
```
Input: "leetcode"
  ↓
Count frequencies:
  {l=1, e=3, t=1, c=1, o=1, d=1}
  ↓
Stream original string in order: ['l','e','e','t','c','o','d','e']
  ↓
Filter where frequency == 1: 'l' (first match)
  ↓
Output: 'l'
```

## Time Complexity
**O(n)** where n is the length of the string
- Grouping characters: **O(n)**
- Finding first non-repeating: **O(n)** (worst case check all characters)
- Total: **O(n)**

## Space Complexity
**O(k)** where k is the number of unique characters (≤ 26 for English letters)
- Frequency map: **O(k)**

## Code Implementation
See [Main.java](./Main.java)
