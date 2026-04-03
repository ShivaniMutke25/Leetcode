# Employee HashMap Equals HashCode

## Problem Statement
Understand the importance of properly implementing `equals()` and `hashCode()` methods in custom objects, especially when using them in HashMap, HashSet, and other collections.

## Why This Matters

When using custom objects as HashMap keys or in HashSets, the `equals()` and `hashCode()` methods are critical:

**hashCode():**
- Determines which bucket the object goes into
- Must be consistent with equality

**equals():**
- Determines if two objects are truly equal
- Must be transitive, reflexive, and symmetric

**The Contract:**
- If `a.equals(b)` then `a.hashCode() == b.hashCode()`
- If `a.hashCode() != b.hashCode()` then `a.equals(b)` must return false

## Common Issues

**Problem 1: No equals() and hashCode() override**
- HashMap can't find duplicates
- Multiple entries for same logical object

**Problem 2: Broken equals()**
- Inconsistent behavior
- Lost values in HashMap

**Problem 3: equals() but no hashCode()**
- HashMap won't recognize duplicates
- Set contains duplicates

## Code Implementation
See [Main.java](./Main.java)
