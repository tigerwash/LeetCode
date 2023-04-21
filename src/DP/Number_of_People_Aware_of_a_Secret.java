package DP;

/**
 2327. Number of People Aware of a Secret

  dp[i] means in i-th day dp[i] people discover the seceret
  in i-th day: dp[i-delay] realized the seceret and tell  dp[i-delay] people
  in i-th day: dp[i-forget] people forget the people
 * * */
public class Number_of_People_Aware_of_a_Secret {
    public int peopleAwareOfSecret(int n, int delay, int forget) {


        long[] dp = new long[n+1];
        long mod = (long)(1e9 + 7);
        long sharing = 0; // nums of people sharing the seceret
        dp[1] = 1;
        long res = 0;
        for(int i = 2; i<= n; i++){
            sharing += dp[Math.max(0, i-delay)];
            sharing -= dp[Math.max(0, i-forget)];
            dp[i] = sharing % mod;
        }
        // sum all, start from people who not forget
        for(int i = n-forget+1; i<=n; i++){
            res = (res + dp[i])%mod;
        }
        return (int)res;
    }
}
