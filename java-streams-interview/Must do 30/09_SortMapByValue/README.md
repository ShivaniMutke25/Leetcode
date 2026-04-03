# Sort Map by Value

## Problem Statement
Sort a HashMap by its values and return the result as a sorted map (typically LinkedHashMap to maintain order).

### Input
```
Map<String, Integer> map = {
    "apple": 5,
    "banana": 2,
    "kiwi": 9
}
```

### Output
```
{banana=2, apple=5, kiwi=9}  // sorted by value ascending
```

## Approach

### Using Java Streams
1. **Convert to stream** - Stream the map entries
2. **Sort by value** - Use `sorted()` with `comparingByValue()`
3. **Collect to LinkedHashMap** - Use `toMap()` with LinkedHashMap to preserve insertion order
4. **Return result** - The sorted map

**For descending order:**
- Use `.reversed()` on the comparator

**Step-by-step execution:**
```
Input: {apple=5, banana=2, kiwi=9}
  ↓
Stream entries
  ↓
Sort by value ascending
  banana=2, apple=5, kiwi=9
  ↓
Collect to LinkedHashMap (preserves order)
  ↓
Output: {banana=2, apple=5, kiwi=9}
```

## Time Complexity
**O(n log n)** where n is the number of entries
- Sorting: **O(n log n)** ← dominant
- Streaming and collecting: **O(n)**

## Space Complexity
**O(n)** for the sorted map

## Code Implementation
See [Main.java](./Main.java)
