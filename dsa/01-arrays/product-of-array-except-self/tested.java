import java.util.*;

public class Main {

    // =========================================================
    // APPROACH 1: BRUTE FORCE
    // Time: O(n^2)
    // Space: O(1)
    // Logic:
    // For each index, multiply all elements except itself
    // =========================================================
    public static int[] productExceptSelfBrute(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int product = 1;

            for (int j = 0; j < n; j++) {
                if (i != j) {
                    product *= nums[j];
                }
            }

            result[i] = product;
        }

        return result;
    }


    // =========================================================
    // APPROACH 2: USING DIVISION (NOT RECOMMENDED)
    // Time: O(n)
    // Space: O(1)
    // Logic:
    // Multiply all elements, then divide by nums[i]
    // ⚠️ Problem: fails when zero is present
    // =========================================================
    public static int[] productExceptSelfDivision(int[] nums) {
        int totalProduct = 1;

        for (int num : nums) {
            totalProduct *= num;
        }

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[i] = totalProduct / nums[i];
        }

        return result;
    }


    // =========================================================
    // APPROACH 3: PREFIX + SUFFIX ARRAYS
    // Time: O(n)
    // Space: O(n)
    // Logic:
    // result[i] = product of elements before i * product after i
    // =========================================================
    public static int[] productExceptSelfBetter(int[] nums) {
        int n = nums.length;

        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] result = new int[n];

        // prefix[i] = product of all elements before i
        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        // suffix[i] = product of all elements after i
        suffix[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        // result = prefix * suffix
        for (int i = 0; i < n; i++) {
            result[i] = prefix[i] * suffix[i];
        }

        return result;
    }


    // =========================================================
    // APPROACH 4: 🔥 OPTIMAL (NO EXTRA SPACE)
    // Time: O(n)
    // Space: O(1) (excluding output array)
    // Logic:
    // 1. Store prefix product in result[]
    // 2. Traverse from right and multiply suffix on the fly
    // =========================================================
    public static int[] productExceptSelfOptimal(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Step 1: store prefix products
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Step 2: multiply suffix product
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * suffix;
            suffix *= nums[i];
        }

        return result;
    }


    // =========================================================
    // MAIN METHOD (TEST)
    // =========================================================
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};

        System.out.println("Brute: " + Arrays.toString(productExceptSelfBrute(nums)));
        System.out.println("Division: " + Arrays.toString(productExceptSelfDivision(nums)));
        System.out.println("Better: " + Arrays.toString(productExceptSelfBetter(nums)));
        System.out.println("Optimal: " + Arrays.toString(productExceptSelfOptimal(nums)));
    }
}
