# Partition Even Odd

## Problem Statement
Partition a list of numbers into two separate lists: one containing even numbers and one containing odd numbers.

### Input
```
List<Integer> numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
```

### Output
```
{
    "even": [2, 4, 6, 8, 10],
    "odd": [1, 3, 5, 7, 9]
}
```

## Approach

### Using Java Streams
1. **Collect by partition** - Use `Collectors.partitioningBy()` with a predicate
2. **Predicate logic** - `n -> n % 2 == 0` for even/odd
3. **Create partition map** - Returns a LinkedHashMap with 2 entries (true/false keys)
4. **Extract results** - Get the two lists from the partition map

**How partitioningBy works:**
- Partitions stream into exactly 2 groups (true/false)
- More efficient than groupingBy when you know there are only 2 groups

**Step-by-step execution:**
```
Input: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
  ↓
Partition by even check (n % 2 == 0)
  ↓
True group (even): [2, 4, 6, 8, 10]
False group (odd): [1, 3, 5, 7, 9]
  ↓
Output: {true: [2, 4, 6, 8, 10], false: [1, 3, 5, 7, 9]}
```

## Time Complexity
**O(n)** where n is the number of elements
- Single pass through elements

## Space Complexity
**O(n)** for storing both partitions

## Code Implementation
See [Main.java](./Main.java)
