# Collect vs Reduce

## Problem Statement
Understand the difference between `collect()` and `reduce()` in Java streams, and when to use each one.

## Key Differences

| Aspect | `collect()` | `reduce()` |
|--------|-----------|----------|
| **Purpose** | Accumulate into mutable container | Combine stream elements into single value |
| **Return type** | Container (List, Map, Set, etc.) | Optional<T> or T |
| **Intermediate** | Can produce intermediate results | Single final result |
| **State** | Uses mutable state | Can be stateless |
| **Parallelization** | More efficient in parallel | Less efficient in parallel |
| **Memory** | Can be memory intensive | Memory efficient |

## Collect Use Cases
- Creating collections (List, Set, Map)
- Grouping, partitioning data
- Joining strings
- Complex accumulations

## Reduce Use Cases
- Summing numbers
- Finding min/max
- Concatenating strings (simple)
- Any single-value operations

## Code Implementation
See [Main.java](./Main.java)
