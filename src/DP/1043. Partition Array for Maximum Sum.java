class Solution {

    // dp[i] = max{dp[i-n] + curmax * n}  where 1<=n<=k
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length+1];
        for(int i = 1; i<=arr.length; ++i) {
            int curmax = 0;
            int maxsum = 0;
            for(int n = 1; n<=k && i-n>=0; ++n) {
                curmax = Math.max(curmax, arr[i-n]);
                maxsum = Math.max(maxsum, dp[i-n] + curmax * n);
            }
            dp[i] = maxsum;
        }
        return dp[arr.length];

    }
}