/**
 * 2466. Count Ways To Build Good Strings
 *
 *  dp[i] = dp[i-one] + dp[i-zero];
 * **/

class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        // dp[i] = dp[i-one] + dp[i-zero];
        int[] dp = new int[high+1];
        dp[0] = 1;
        int mod = (int)(1e9+7);
        for(int i = 1; i<=high; i++) {
            if(i>=one) dp[i] += dp[i-one] ;
            if(i>=zero) dp[i] += dp[i-zero];
            dp[i] %= mod;
        }
        int res = 0;
        for(int i = low; i<=high; i++){
            res += dp[i];
            res %= mod;
        }
        return res;
    }
}