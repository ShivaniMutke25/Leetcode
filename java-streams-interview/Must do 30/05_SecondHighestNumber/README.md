# Second Highest Number

## Problem Statement
Find the second highest (or second largest) number in a list. If no second highest exists, return null or a default value.

### Input
```
List<Integer> numbers = Arrays.asList(10, 5, 20, 15, 30);
```

### Output
```
20
```

## Approach

### Using Java Streams
1. **Get distinct elements** - Use `distinct()` to remove duplicates
2. **Sort in reverse** - Use `sorted()` with reverse order
3. **Skip first** - Skip the highest element
4. **Get second** - Use `findFirst()` to get the second highest

**Alternative approach:**
1. **Sort** - Sort in descending order
2. **Skip and get** - Skip the max, get the next element

**Step-by-step execution:**
```
Input: [10, 5, 20, 15, 30]
  ↓
Get distinct: [10, 5, 20, 15, 30]
  ↓
Sort descending: [30, 20, 15, 10, 5]
  ↓
Skip 1 (highest): [20, 15, 10, 5]
  ↓
Get first: 20
```

## Time Complexity
**O(n log n)** where n is the number of elements
- Distinct: **O(n)**
- Sorting: **O(n log n)** ← dominant
- Skip and findFirst: **O(1)**
- Total: **O(n log n)**

## Space Complexity
**O(n)** for the sorting operation
- Distinct set: **O(n)**
- Sorted stream: **O(n)**

## Code Implementation
See [Main.java](./Main.java)
