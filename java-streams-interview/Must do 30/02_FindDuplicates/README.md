# Find Duplicates

## Problem Statement
Find all duplicate elements in a list. An element is a duplicate if it appears more than once.

### Input
```
List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 3, 3, 4);
```

### Output
```
[2, 3]
```

## Approach

### Using Java Streams
1. **Group elements** - Use `groupingBy()` with `counting()` to find frequency of each element
2. **Filter duplicates** - Filter entries where count > 1
3. **Extract keys** - Map to get only the duplicate elements
4. **Collect to List** - Collect results into a list

**Step-by-step execution:**
```
Input: [1, 2, 2, 3, 3, 3, 4]
  ↓
Group by element and count:
  {1=1, 2=2, 3=3, 4=1}
  ↓
Filter where count > 1:
  {2=2, 3=3}
  ↓
Extract keys:
  [2, 3]
```

## Time Complexity
**O(n)** where n is the number of elements
- Streaming and grouping: **O(n)**
- Filtering: **O(k)** where k is unique elements (≤ n)
- Total: **O(n)**

## Space Complexity
**O(k)** where k is number of unique elements
- Map to store frequencies: **O(k)**
- Result list: **O(d)** where d is number of duplicates (≤ k)

## Code Implementation
See [Main.java](./Main.java)
