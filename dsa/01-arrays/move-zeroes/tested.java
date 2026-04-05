🚀 ALL APPROACHES
1️⃣ Brute Force (Extra Array)
// Time: O(n), Space: O(n)
// When: Simple understanding
// Why NOT: Uses extra space
public static void moveZeroesBrute(int[] nums) {
    int[] temp = new int[nums.length];
    int index = 0;

    // store non-zero
    for (int num : nums) {
        if (num != 0) {
            temp[index++] = num;
        }
    }

    // copy back (rest are already 0)
    for (int i = 0; i < nums.length; i++) {
        nums[i] = temp[i];
    }
}
2️⃣ Two Pass (Overwrite + Fill Zero)
// Time: O(n), Space: O(1)
// When: Clean & beginner-friendly
public static void moveZeroesTwoPass(int[] nums) {
    int index = 0;

    // move non-zero forward
    for (int num : nums) {
        if (num != 0) {
            nums[index++] = num;
        }
    }

    // fill remaining with zero
    while (index < nums.length) {
        nums[index++] = 0;
    }
}
3️⃣ 🔥 Optimal (Two Pointer Swap)
// Time: O(n), Space: O(1)
// When: BEST solution (expected in interviews)
public static void moveZeroesOptimal(int[] nums) {

    int slow = 0;

    for (int fast = 0; fast < nums.length; fast++) {

        if (nums[fast] != 0) {
            int temp = nums[slow];
            nums[slow] = nums[fast];
            nums[fast] = temp;
            slow++;
        }
    }
}
🧠 YOUR APPROACH (FINAL DEBUG + CLEAN VERSION) 🔥

👉 Your code is already correct — just polishing it to production-level

class Solution {
    public void moveZeroes(int[] nums) {

        int slow = 0; // next position for non-zero

        for (int fast = 0; fast < nums.length; fast++) {

            // if current is non-zero
            if (nums[fast] != 0) {

                // 🔥 avoid unnecessary swap
                if (slow != fast) {
                    int temp = nums[slow];
                    nums[slow] = nums[fast];
                    nums[fast] = temp;
                }

                slow++; // move position forward
            }
        }
    }
}
🔍 Why this version is BETTER
✅ Avoids unnecessary swaps
if (slow != fast)

👉 Example:

[1,2,3] → no swapping needed
✅ Cleaner logic
Fast = scan
Slow = placement
🧠 CORE IDEA (LOCK THIS)
Non-zero → move to front
Zero → automatically pushed back
⚡ Complexity
Approach	Time	Space
Brute	O(n)	O(n)
Two-pass	O(n)	O(1)
Optimal	O(n)	O(1) 🔥
