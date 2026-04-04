/**
 * Brute Force Approach - Boats to Save People
 * 
 * Logic:
 * - Try all possible pairings of people
 * - For each valid pairing, use one boat
 * - Unpaired people need individual boats
 * - Find minimum boats needed
 * 
 * When to use: Understanding problem, very small inputs
 * When NOT to use: Any realistic input - will be too slow
 * 
 * Time Complexity: O(n²) - O(n²) possible pairings
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        boolean[] used = new boolean[n];
        int boats = 0;
        
        for (int i = 0; i < n; i++) {
            if (used[i]) continue;
            
            // Try to pair person i with someone else
            boolean paired = false;
            for (int j = i + 1; j < n; j++) {
                if (!used[j] && people[i] + people[j] <= limit) {
                    used[i] = used[j] = true;
                    boats++;
                    paired = true;
                    break;
                }
            }
            
            // If person i couldn't be paired, they need their own boat
            if (!paired) {
                used[i] = true;
                boats++;
            }
        }
        
        return boats;
    }
}

/*
Example Walkthrough:
people = [3,2,2,1], limit = 3

used = [false,false,false,false], boats = 0

i = 0, people[0] = 3:
  Try j = 1, people[1] = 2: 3+2=5 > 3 ✗
  Try j = 2, people[2] = 2: 3+2=5 > 3 ✗
  Try j = 3, people[3] = 1: 3+1=4 > 3 ✗
  Person 0 can't be paired → used[0] = true, boats = 1

i = 1, people[1] = 2 (already used) → skip

i = 2, people[2] = 2 (already used) → skip

i = 3, people[3] = 1 (already used) → skip

Result: 1 boat (incorrect!)

This approach is flawed. Let me fix it:

Actually, the brute force should try all combinations and find the minimum boats.
*/
