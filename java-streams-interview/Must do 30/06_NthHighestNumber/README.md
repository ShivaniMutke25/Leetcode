# Nth Highest Number

## Problem Statement
Find the Nth highest (largest) number in a list, where N is a given parameter.

### Input
```
List<Integer> numbers = Arrays.asList(10, 5, 20, 15, 30);
int n = 3;
```

### Output
```
15
```

## Approach

### Using Java Streams
1. **Get distinct elements** - Remove duplicates to ensure unique values
2. **Sort in reverse** - Sort in descending order
3. **Skip N-1 elements** - Skip all elements before the Nth
4. **Get first** - Use `findFirst()` to get the Nth highest

**Step-by-step execution:**
```
Input: [10, 5, 20, 15, 30], N=3
  ↓
Distinct: [10, 5, 20, 15, 30]
  ↓
Sort descending: [30, 20, 15, 10, 5]
  ↓
Skip 2 positions: [15, 10, 5]
  ↓
Get first: 15
```

## Time Complexity
**O(n log n)** where n is the number of elements
- Distinct: **O(n)**
- Sorting: **O(n log n)** ← dominant
- Skip and findFirst: **O(1)**

## Space Complexity
**O(n)** for storing distinct elements and sorted stream

## Code Implementation
See [Main.java](./Main.java)
