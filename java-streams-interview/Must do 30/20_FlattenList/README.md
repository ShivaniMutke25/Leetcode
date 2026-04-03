# Flatten List

## Problem Statement
Convert a list of lists into a single flat list containing all elements from all inner lists.

### Input
```
List<List<Integer>> nestedList = [
    [1, 2, 3],
    [4, 5],
    [6, 7, 8, 9]
]
```

### Output
```
[1, 2, 3, 4, 5, 6, 7, 8, 9]
```

## Approach

### Using Java Streams - flatMap()
1. **Stream outer list** - Create stream of inner lists
2. **Flatten** - Use `flatMap()` to convert each inner list into a stream
3. **Collect** - Collect all individual elements into a single list

**How flatMap() works:**
- `map()` transforms each element to a value
- `flatMap()` transforms each element to a Stream and flattens all streams into one

**Step-by-step execution:**
```
Input: [[1,2,3], [4,5], [6,7,8,9]]
  ↓
Stream outer list: [1,2,3], [4,5], [6,7,8,9]
  ↓
flatMap: convert each list to stream
  Stream: 1,2,3
  Stream: 4,5
  Stream: 6,7,8,9
  ↓
Flatten all streams
  1,2,3,4,5,6,7,8,9
  ↓
Collect to list
  ↓
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9]
```

## Time Complexity
**O(n)** where n is the total number of elements across all lists
- Flattening: **O(n)** (visit each element once)

## Space Complexity
**O(n)** for the resulting flattened list

## Code Implementation
See [Main.java](./Main.java)
