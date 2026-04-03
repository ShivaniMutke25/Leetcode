# Top K Frequent Elements

## Problem Statement
Find the K most frequent elements in a list. Return top K elements sorted by frequency (highest first).

### Input
```
List<Integer> nums = [1,1,1,2,2,3];
int k = 2;
```

### Output
```
[1, 2]  // 1 appears 3 times, 2 appears 2 times
```

## Approach

### Using Java Streams
1. **Count frequency** - Group by element and count occurrences
2. **Sort by frequency** - Sort entries by count in descending order
3. **Limit to K** - Take top K elements
4. **Extract keys** - Get only the element values
5. **Collect** - Collect into a list

**Step-by-step execution:**
```
Input: [1,1,1,2,2,3], K=2
  ↓
Count frequencies:
  {1=3, 2=2, 3=1}
  ↓
Sort by frequency descending:
  1→3, 2→2, 3→1
  ↓
Limit to K=2:
  1→3, 2→2
  ↓
Extract keys:
  [1, 2]
```

## Time Complexity
**O(n log n)** where n is the number of unique elements
- Grouping and counting: **O(n)** where n is total elements
- Sorting: **O(k log k)** where k is unique elements
- Total: **O(n log k)** to **O(n log n)** depending on implementation

## Space Complexity
**O(n)** for the frequency map

## Code Implementation
See [Main.java](./Main.java)
