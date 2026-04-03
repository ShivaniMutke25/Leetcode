# Frequency of Elements

## Problem Statement
Find the frequency (count) of each element in a given list. Return a map where the key is the element and the value is its frequency.

### Input
```
List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
```

### Output
```
{1=1, 2=2, 3=3, 4=4}
```

## Approach

### Using Java Streams (Collectors.groupingBy + Collectors.counting)
1. **Stream the list** - Convert the list into a stream
2. **Group by element** - Use `Collectors.groupingBy()` to group elements by their value
3. **Count occurrences** - Use `Collectors.counting()` as the downstream collector to count frequency of each group
4. **Collect to Map** - The result is a `Map<Integer, Long>` where key is the element and value is its frequency

**Step-by-step execution:**
```
Input: [1, 2, 2, 3, 3, 3, 4, 4, 4, 4]
  ↓
Stream each element
  ↓
Group by identity (the element itself)
  ├─ Group 1: [1] → count = 1
  ├─ Group 2: [2, 2] → count = 2
  ├─ Group 3: [3, 3, 3] → count = 3
  └─ Group 4: [4, 4, 4, 4] → count = 4
  ↓
Output: {1=1, 2=2, 3=3, 4=4}
```

## Time Complexity
**O(n)** where n is the number of elements in the list
- Streaming through the list: **O(n)**
- Grouping and counting: **O(n)** (each element is processed once)
- Total: **O(n) + O(n) = O(n)**

## Space Complexity
**O(k)** where k is the number of unique elements
- The resulting map stores entries for each unique element: **O(k)**
- In worst case (all elements unique): **O(n)**
- In best case (all elements same): **O(1)**

## Code Implementation
See [Main.java](./Main.java)
