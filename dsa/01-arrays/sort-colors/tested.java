🟥 SORT COLORS — COMPLETE GUIDE
🔴 Problem

Given array with only 0,1,2, sort in-place:

[2,0,2,1,1,0] → [0,0,1,1,2,2]
🧠 APPROACH 1 — Brute Force (Sorting)
💡 Idea:

Just sort normally.

✅ Code:
import java.util.Arrays;

class Solution {
    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }
}
⏱ Complexity:
Time: O(n log n)
Space: O(1)
❌ Why not good?
Interviewer expects linear time
🧠 APPROACH 2 — Counting Sort (Better)
💡 Idea:

Count number of 0s, 1s, 2s, then overwrite array.

✅ Code:
class Solution {
    public void sortColors(int[] nums) {
        int count0 = 0, count1 = 0, count2 = 0;

        for (int num : nums) {
            if (num == 0) count0++;
            else if (num == 1) count1++;
            else count2++;
        }

        int index = 0;

        // fill 0s
        for (int i = 0; i < count0; i++) {
            nums[index++] = 0;
        }

        // fill 1s
        for (int i = 0; i < count1; i++) {
            nums[index++] = 1;
        }

        // fill 2s
        for (int i = 0; i < count2; i++) {
            nums[index++] = 2;
        }
    }
}
⏱ Complexity:
Time: O(n)
Space: O(1)
⚠️ Drawback:
2 passes (count + rewrite)
Not “one-pass” optimal
🧠 APPROACH 3 — Two Pass Partition
💡 Idea:
First pass → move all 0s to front
Second pass → move all 2s to end
✅ Code:
class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int index = 0;

        // move all 0s
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                index++;
            }
        }

        // move all 2s
        int high = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}
⏱ Complexity:
Time: O(n)
Space: O(1)
⚠️ Drawback:
Still 2 passes
🧠 APPROACH 4 — 🔥 BEST (Dutch National Flag — ONE PASS)
💡 Idea:

Use 3 pointers:

low  → next 0 position
mid  → current
high → next 2 position
✅ Code (MOST IMPORTANT)
class Solution {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                // swap low and mid
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;

                low++;
                mid++;
            } 
            else if (nums[mid] == 1) {
                mid++;
            } 
            else { // nums[mid] == 2
                // swap mid and high
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;

                high--;
            }
        }
    }
}
🔥 DRY RUN
Input: [2,0,2,1,1,0]

Step:
[2,0,2,1,1,0]
 swap(mid,high)

→ [0,0,2,1,1,2]

Continue...

Final → [0,0,1,1,2,2]
⏱ Complexity:
Time:  O(n)  ✅ best
Space: O(1)  ✅ best
🧠 APPROACH 5 — Using Extra Array (Not Allowed Usually)
💡 Idea:

Create new array and copy values

❌ Code:
class Solution {
    public void sortColors(int[] nums) {
        int[] temp = new int[nums.length];
        int index = 0;

        for (int num : nums)
            if (num == 0) temp[index++] = 0;

        for (int num : nums)
            if (num == 1) temp[index++] = 1;

        for (int num : nums)
            if (num == 2) temp[index++] = 2;

        for (int i = 0; i < nums.length; i++)
            nums[i] = temp[i];
    }
}
⏱ Complexity:
Time: O(n)
Space: O(n) ❌
🎯 FINAL INTERVIEW SUMMARY
Approach	Passes	Time	Space	Use?
Sorting	1	O(n log n)	O(1)	❌
Counting	2	O(n)	O(1)	👍
2-pass partition	2	O(n)	O(1)	👍
🔥 Dutch Flag	1	O(n)	O(1)	✅ BEST
Extra array	2	O(n)	O(n)	❌
💡 GOLDEN INTERVIEW LINE

If they say:

"One pass + constant space"

👉 Say immediately:
"Use Dutch National Flag with 3 pointers (low, mid, high)"
