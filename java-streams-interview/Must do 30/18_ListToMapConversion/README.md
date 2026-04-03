# List to Map Conversion

## Problem Statement
Convert a list of objects to a map using a key selector function. Build a map where each element's position or property becomes the key, and the element itself is the value.

### Input
```
List<String> fruits = ["apple", "banana", "kiwi"];
```

### Output
```
{1=apple, 2=banana, 3=kiwi}  // using 1-based index as key
```

## Approach

### Using Java Streams - Collectors.toMap()
1. **Stream the list** - Convert list to stream
2. **Map to entries** - Create key-value pairs with custom logic
3. **Collect to map** - Use `toMap(keyMapper, valueMapper)`

**For indexed keys:**
- Use `IntStream` with `range()` to get indices
- Map indices to values

**For property-based keys:**
- Use object property as key
- Use whole object as value

**Step-by-step execution:**
```
Input: ["apple", "banana", "kiwi"]
  ↓
Index stream with elements
  (0, "apple"), (1, "banana"), (2, "kiwi")
  ↓
Transform to 1-based indices
  (1, "apple"), (2, "banana"), (3, "kiwi")
  ↓
Collect to map
  ↓
Output: {1=apple, 2=banana, 3=kiwi}
```

## Time Complexity
**O(n)** where n is the number of elements
- Streaming and mapping: **O(n)**
- Collecting: **O(n)**

## Space Complexity
**O(n)** for the resulting map

## Code Implementation
See [Main.java](./Main.java)
