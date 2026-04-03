/**
 * Rabin-Karp Approach - Implement strStr()
 * 
 * Logic:
 * - Use rolling hash technique to compare substrings efficiently
 * - Compute hash of needle and rolling hash of current window in haystack
 * - When hashes match, do character-by-character comparison
 * - Update rolling hash in O(1) when sliding window
 * 
 * When to use: Hash-based approach, average case optimization
 * When NOT to use: When worst-case guarantee needed (hash collisions)
 * 
 * Time Complexity: O(m+n) average, O(mn) worst case
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        
        if (n == 0) return 0;
        if (m < n) return -1;
        
        // Use large prime to reduce collisions
        int base = 256;
        int mod = 101; // Prime number for hash
        
        // Precompute base^(n-1) % mod for rolling hash
        int power = 1;
        for (int i = 0; i < n - 1; i++) {
            power = (power * base) % mod;
        }
        
        // Compute hash for needle and first window
        int needleHash = 0, haystackHash = 0;
        for (int i = 0; i < n; i++) {
            needleHash = (needleHash * base + needle.charAt(i)) % mod;
            haystackHash = (haystackHash * base + haystack.charAt(i)) % mod;
        }
        
        // Slide through haystack
        for (int i = 0; i <= m - n; i++) {
            // If hashes match, verify character by character
            if (needleHash == haystackHash) {
                if (haystack.substring(i, i + n).equals(needle)) {
                    return i;
                }
            }
            
            // Compute hash for next window
            if (i < m - n) {
                haystackHash = (haystackHash - haystack.charAt(i) * power) % mod;
                haystackHash = (haystackHash * base + haystack.charAt(i + n)) % mod;
                
                // Handle negative hash
                if (haystackHash < 0) {
                    haystackHash += mod;
                }
            }
        }
        
        return -1;
    }
}

/*
Example Walkthrough:
haystack = "hello", needle = "ll"

base = 256, mod = 101, n = 2
power = 256^(2-1) % 101 = 256 % 101 = 54

Initial hashes:
needleHash = ('l' * 256 + 'l') % 101 = (108*256 + 108) % 101 = 27756 % 101 = 40
haystackHash = ('h' * 256 + 'e') % 101 = (104*256 + 101) % 101 = 26725 % 101 = 34

i = 0:
needleHash(40) != haystackHash(34)

Update haystackHash for next window:
haystackHash = (34 - 'h'*54) % 101 = (34 - 104*54) % 101 = -5582 % 101 = 43
haystackHash = (43*256 + 'l') % 101 = (11008 + 108) % 101 = 11116 % 101 = 40

i = 1:
needleHash(40) == haystackHash(40)
Verify: haystack.substring(1,3) = "el" != "ll" (hash collision!)

Update haystackHash:
haystackHash = (40 - 'e'*54) % 101 = (40 - 101*54) % 101 = -5414 % 101 = 62
haystackHash = (62*256 + 'l') % 101 = (15872 + 108) % 101 = 15980 % 101 = 40

i = 2:
needleHash(40) == haystackHash(40)
Verify: haystack.substring(2,4) = "ll" == "ll" ✓ → return 2

Why Rabin-Karp works:
- Rolling hash allows O(1) hash updates when sliding window
- Hash comparison is O(1) vs O(n) string comparison
- Character verification handles hash collisions
- Average case: O(m+n), worst case: O(mn) due to collisions

Trade-offs:
- Time: Average O(m+n), worst O(mn) due to collisions
- Space: O(1) - constant space
- Implementation: More complex than brute force
- Practical: Often faster than KMP in practice due to simplicity

When this is useful:
- Average case performance is important
- Hash collisions are acceptable risk
- Implementation simplicity is valued
*/
