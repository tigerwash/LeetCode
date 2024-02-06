class Solution {
    public int countVowelPermutation(int n) {
        // dfs will expire, need use dp
        // dp[n][char] num of ways ending in char with length n,
        // 需要反推
        //  eiu. ai  eo.  i   io
        //   a    e   i.   o   u
        //.  0.   1.  2.   3.  4
        long[][] dp = new long[n][5];
        int mod = (int)(1e9+7);
        for(int i = 0; i<5; i++){
            dp[0][i]= 1;
        }
        for(int i = 1; i<n; i++ ) {
            dp[i][0] = (dp[i-1][1] + dp[i-1][2] + dp[i-1][4]) % mod; // eiu -> a
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % mod; // ai -> e
            dp[i][2] = (dp[i-1][1] + dp[i-1][3]) % mod; // eo -> i
            dp[i][3] = dp[i-1][2] % mod;                // i -> o
            dp[i][4] = (dp[i-1][2] + dp[i-1][3]) % mod; // io -> u
        }
        long res = 0;
        for(int i = 0; i<5; i++){
            res += dp[n-1][i];
            res %= mod;
        }
        return (int)res;
    }
}