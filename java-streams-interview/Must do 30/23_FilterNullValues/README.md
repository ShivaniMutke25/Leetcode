# Filter Null Values

## Problem Statement
Remove all null values from a list, keeping only non-null elements.

### Input
```
List<String> items = ["apple", null, "banana", null, "cherry", null]
```

### Output
```
["apple", "banana", "cherry"]
```

## Approach

### Using Java Streams
1. **Filter null check** - Use `filter()` with null check predicate
2. **Collect non-null** - Collect all non-null elements into a list

**Null check methods:**
- `Objects::nonNull` - Returns true if element is not null
- Direct lambda: `e -> e != null`

**Step-by-step execution:**
```
Input: ["apple", null, "banana", null, "cherry", null]
  ↓
Stream elements
  ↓
Filter Objects::nonNull (keep only non-null)
  "apple" ✓, null ✗, "banana" ✓, null ✗, "cherry" ✓, null ✗
  ↓
Collect to list
  ↓
Output: ["apple", "banana", "cherry"]
```

## Time Complexity
**O(n)** where n is the number of elements
- Single pass through all elements

## Space Complexity
**O(k)** where k is the number of non-null elements (≤ n)

## Code Implementation
See [Main.java](./Main.java)
