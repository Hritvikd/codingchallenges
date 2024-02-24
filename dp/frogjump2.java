public class Solution {
    public static int minimizeCost(int n, int k, int []height){
        // Write your code here.
        return memoizationTechnique(n, k , height)
        return tabulationTechnique(n, k, height);
    }

    public static int tabulationTechnique(int n, int k, int[] height) {
        int dp[] = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int minSteps = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jumpE = dp[i - j] + Math.abs(height[i] - height[i - j]);
                    minSteps = Math.min(jumpE, minSteps);
                }
            }
            dp[i] = minSteps;

        }
        return dp[n - 1];
    }

    public static int memoizationTechnique(int n, int k, int[] height) {
        int dp[] = new int[n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        return minimizeCostHelper(n - 1, k, height, Integer.MAX_VALUE, dp);
    }

    public static int minimizeCostHelper(int index, int k, int[] height, int minSteps, int[] dp) {
        if (index == 0)
            return 0;
        minSteps = Integer.MAX_VALUE;
        if (dp[index] != -1)
            return dp[index];
        for (int i = 1; i <= k; i++) {
            if (index - i >= 0) {
                int jumpE = minimizeCostHelper(index - i, k, height, minSteps, dp)
                        + Math.abs(height[index] - height[index - i]);
                minSteps = Math.min(minSteps, jumpE);
            }
        }

        return dp[index] = minSteps;
    }
}