import java.util.*;

import java.io.*;
import java.util.*;

public class Solution {
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        // Write your code here.
        int n = nums.size();
        if (n == 0)
            return 0;
        if (n < 2)
            return nums.get(0);
        // return memoizationTechnique(nums, n);
        return tabulationTechnique(nums, n);

    }

    public static int tabulationTechnique(ArrayList<Integer> a, int n) {
        int dp[] = new int[n + 1];
        dp[0] = a.get(0);
        dp[1] = a.get(1);

        for (int i = 2; i < n; i++) {
            int max1 = a.get(i);
            int max2 = a.get(i);
            if (i - 2 >= 0) {
                max1 = dp[i - 2] + max1;
            }
            if (i - 3 >= 0) {
                max2 = dp[i - 3] + max2;
            }
            // System.out.print(dp[i]);
            dp[i] = Math.max(max1, max2);
        }
        return Math.max(dp[n - 1], dp[n - 2]);
    }

    public static int memoizationTechnique(ArrayList<Integer> nums, int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        return Math.max(helper(nums, n - 1, dp), helper(nums, n - 2, dp));
    }

    public static int helper(ArrayList<Integer> a, int idx, int[] dp) {

        if (idx == 0)
            return a.get(0);
        int max1 = a.get(idx);
        int max2 = a.get(idx);
        if (dp[idx] != -1)
            return dp[idx];
        if (idx - 2 >= 0) {
            max1 += helper(a, idx - 2, dp);
        }
        if (idx - 3 >= 0) {
            max2 += helper(a, idx - 3, dp);
        }

        return dp[idx] = Math.max(max1, max2);

    }
}