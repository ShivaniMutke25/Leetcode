# Find First vs Find Any

## Problem Statement
Understand the difference between `findFirst()` and `findAny()` in Java streams, and when to use each one.

## Key Differences

| Aspect | `findFirst()` | `findAny()` |
|--------|-------------|----------|
| **Returns** | First element in encounter order | Any element (unspecified) |
| **Sequential** | Always first | Could be any |
| **Parallel** | Still first | More efficient (any matching) |
| **Ordering** | Respects order | No guarantee |
| **Performance** | May be slower in parallel | Faster in parallel |
| **Return type** | `Optional<T>` | `Optional<T>` |

## When to Use

**Use `findFirst()`:**
- You need the first element specifically
- Order matters
- Sequential streams primarily
- E.g., finding first even number in sorted list

**Use `findAny()`:**
- Any matching element is acceptable
- Parallel streams (better performance)
- When order doesn't matter
- E.g., checking if any element matches

## Code Implementation
See [Main.java](./Main.java)
