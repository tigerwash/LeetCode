package Math;

/**
 * 2400. Number of Ways to Reach a Position After Exactly k Steps
 给定 起始点 和终点， 每次 +1 或者 -1， 求 k 步之后能到达终点的 ways
  本质上其实是个数学题
 假设 a 次-1 ， b 次 +1，
 则 a + b = k
    a - b = abs(end - start)
 可得出
 int a = (k + target) / 2;
 int b = (k - target) / 2;

 这个题就是求 k 步里面 有a 个-1， b 个 +1， 有多少种排列方式 即 C(k, a)

 数学上 求他有两种方法
 C(k, a) = k! / (a! * b!)  （这个会有数字太大超界的问题， 很难在计算过程中同时还除以mod）
 C(k, a) = C(k-1, a-1) + C(k-1, a)   这个方法适合 dp， 可用

 * **/
public class Number_of_Ways_to_Reach_a_Position_After_Exactly_k_Steps {
    int mod = (int)(1e9 + 7);
    public int numberOfWays(int startPos, int endPos, int k) {
        int target = Math.abs(endPos - startPos);
        if(target > k) return 0;
        if( (k+target)%2 != 0 ) return 0;
        int a = (k + target) / 2;
        int b = (k - target) / 2;
        // k = a + b
        // res = C(k, a)
        // C(k, a) = k! / (a! * b!)
        // C(k, a) = C(k-1, a-1) + C(k-1, a)
        return C(k, a);

    }
    private int C(int k, int a) {
        int[] dp = new int[k+1];
        dp[0] = 1;
        for(int i =1; i<=k; i++) {
            for(int j = a; j> 0; j--)
                dp[j] = (dp[j]%mod + dp[j-1]%mod)%mod;
        }
        return dp[a];
    }
}
