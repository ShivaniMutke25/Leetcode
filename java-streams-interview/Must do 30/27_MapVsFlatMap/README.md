# Map vs FlatMap

## Problem Statement
Understand the difference between `map()` and `flatMap()` in Java streams, and when to use each one.

### Input & Output Examples

**map() example:**
```
Input: [1, 2, 3]
Operation: x -> x * 2
Output: [2, 4, 6]
Result stream: Stream<Integer>
```

**flatMap() example:**
```
Input: [1, 2, 3]
Operation: x -> Arrays.asList(x, x*2, x*3).stream()
Output: [1, 2, 3, 2, 4, 6, 3, 6, 9]
Result stream: Stream<Integer> (flattened)
```

## Key Differences

| Aspect | `map()` | `flatMap()` |
|--------|---------|-----------|
| **Transforms** | Each element to a value | Each element to a stream, then flattens |
| **Return type** | `Function<T, R>` | `Function<T, Stream<R>>` |
| **Result stream** | `Stream<R>` | `Stream<R>` (flattened) |
| **Use case** | 1-to-1 transformations | 1-to-many transformations |

## When to Use

**Use `map()`:**
- Converting elements (String to Integer, Object to property)
- Single transformation per element
- E.g., `list.stream().map(String::length)`

**Use `flatMap()`:**
- Flattening nested structures
- 1-to-many transformations
- Combining multiple streams
- E.g., `list.stream().flatMap(word -> word.chars().boxed())`

## Code Implementation
See [Main.java](./Main.java)
