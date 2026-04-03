# Join Strings

## Problem Statement
Join multiple strings from a list into a single string, optionally with a delimiter, prefix, and suffix.

### Input
```
List<String> words = ["apple", "banana", "cherry"]
```

### Output
```
"apple,banana,cherry"  // with comma delimiter
"[apple-banana-cherry]"  // with delimiter, prefix, suffix
```

## Approach

### Using Java Streams
1. **Use Collectors.joining()** - Built-in collector for string joining
2. **Parameters:**
   - `delimiter` - String to place between elements
   - `prefix` - String to place before all elements
   - `suffix` - String to place after all elements
3. **Collect** - Collect stream to joined string

**Without streams (traditional):**
- `String.join(delimiter, list)`

**With streams:**
- `stream.collect(Collectors.joining(delimiter))`

**Step-by-step execution:**
```
Input: ["apple", "banana", "cherry"]
  ↓
Stream strings
  ↓
Joining with delimiter ","
  ↓
Result: "apple,banana,cherry"

With prefix "[" and suffix "]":
  Result: "[apple,banana,cherry]"
```

## Time Complexity
**O(n)** where n is the number of strings
- Joining is single pass through all elements

## Space Complexity
**O(m)** where m is the total length of all strings combined

## Code Implementation
See [Main.java](./Main.java)
