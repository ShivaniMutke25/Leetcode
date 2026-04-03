# Remove Duplicate Custom Objects

## Problem Statement
Remove duplicate objects from a list of custom objects based on specific criteria (e.g., by ID or name).

### Input
```
List<Employee> employees = [
    Employee(1, "Alice"),
    Employee(2, "Bob"),
    Employee(1, "Alice"),  // duplicate
    Employee(3, "Charlie")
]
// Remove by ID
```

### Output
```
[Employee(1, "Alice"), Employee(2, "Bob"), Employee(3, "Charlie")]
```

## Approach

### Using Java Streams
1. **Collect to set** - Use `collect(Collectors.toCollection(LinkedHashSet::new))` which removes duplicates
   - Requires proper `equals()` and `hashCode()` implementation
2. **Alternative: distinct()** - Use `distinct()` with custom equality
3. **Alternative: Custom logic** - Track seen values and filter

**Methods:**
- **LinkedHashSet** - Preserves insertion order while removing duplicates
- **distinct()** - Requires `equals()` override
- **Two-pass logic** - Track IDs and filter manually

**Step-by-step execution:**
```
Input: [E(1,Alice), E(2,Bob), E(1,Alice), E(3,Charlie)]
  ↓
LinkedHashSet naturally removes duplicates (by equals/hashCode)
  ↓
Maintains insertion order
  ↓
Output: [E(1,Alice), E(2,Bob), E(3,Charlie)]
```

## Time Complexity
**O(n)** where n is the number of elements
- Single pass through elements

## Space Complexity
**O(n)** for storing unique elements

## Code Implementation
See [Main.java](./Main.java)
