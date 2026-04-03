# Handle Duplicate Keys to Map

## Problem Statement
When converting a list to a map, handle scenarios where multiple elements would map to the same key. Implement merge logic to decide what to do with duplicates.

### Input
```
List<Employee> employees = [
    Employee("Alice", "HR", 50000),
    Employee("Bob", "HR", 75000),
    Employee("Alice", "IT", 60000)  // duplicate name
]
// Convert using name as key
```

### Output
```
// Option 1: Keep first
{Alice=Employee("Alice", "HR", 50000), Bob=Employee("Bob", "HR", 75000)}

// Option 2: Keep latest
{Alice=Employee("Alice", "IT", 60000), Bob=Employee("Bob", "HR", 75000)}

// Option 3: Merge salaries
{Alice=135000, Bob=75000}
```

## Approach

### Using Java Streams - Collectors.toMap() with Merge Function
1. **Stream the list** - Create stream of elements
2. **Define key mapper** - Function to extract key from element
3. **Define value mapper** - Function to extract/transform value
4. **Define merge function** - Logic for handling duplicate keys:
   - Keep first: `(v1, v2) -> v1`
   - Keep last: `(v1, v2) -> v2`
   - Combine: `(v1, v2) -> v1 + v2`
5. **Collect to map** - Result with merge logic applied

**Step-by-step execution:**
```
Input: [Alice(HR), Bob(HR), Alice(IT)]
  ↓
Create entries: (Alice, HR), (Bob, HR), (Alice, IT)
  ↓
First entry (Alice, HR) added to map
  ↓
Second entry (Bob, HR) added to map
  ↓
Third entry (Alice, IT) - KEY ALREADY EXISTS!
  ↓
Apply merge function:
  keep first: result is HR
  keep last: result is IT
  sum: result is HR+IT
  ↓
Output based on merge logic
```

## Time Complexity
**O(n)** where n is the number of elements
- Streaming and collecting: **O(n)** (single pass)

## Space Complexity
**O(n)** for the resulting map
- In worst case: **O(d)** where d is number of distinct keys (≤ n)

## Code Implementation
See [Main.java](./Main.java)
