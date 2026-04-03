# Group Anagrams

## Problem Statement
Group anagrams from a list of strings. Two strings are anagrams if they contain the same characters in different orders. Return a map where the key is the sorted characters (signature) and value is a list of anagrams.

### Input
```
List<String> words = ["listen", "silent", "hello", "world", "act", "cat"]
```

### Output
```
{
    "eilnst": ["listen", "silent"],
    "elllhow": ["hello"],  // Note: "hello" has different char set
    "dlorw": ["world"],
    "act": ["act", "cat"]
}
```

## Approach

### Using Java Streams
1. **Group by signature** - For each word, create a signature by sorting its characters
2. **Use sorted chars as key** - Use `Collectors.groupingBy()` with key as sorted characters
3. **Collect words** - Collect all anagrams with same signature into a list
4. **Return map** - Result is a map of signature -> list of anagrams

**Signature creation:**
- Convert word to char array
- Sort the array
- Convert back to string (this is the signature)
- Two words with same signature are anagrams

**Step-by-step execution:**
```
Input: ["listen", "silent", "hello", "world", "act", "cat"]
  ↓
Create signatures:
  "listen" -> "eilnst"
  "silent" -> "eilnst"
  "hello" -> "ehllo"
  "world" -> "dlorw"
  "act" -> "act"
  "cat" -> "act"
  ↓
Group by signature
  "eilnst": ["listen", "silent"]
  "ehllo": ["hello"]
  "dlorw": ["world"]
  "act": ["act", "cat"]
```

## Time Complexity
**O(n * k log k)** where n is number of words, k is average length of a word
- For each word: sort characters: **O(k log k)**
- Group all words: **O(n * k log k)**
- Total: **O(n * k log k)**

## Space Complexity
**O(n)** for storing all words in the map

## Code Implementation
See [Main.java](./Main.java)
