class Solution {
    public int knightDialer(int n) {
        // buttom up 算法，dp(n,j)： 在第n步结尾为j时，有多少种方法
        int mod = (int)(1e9+7);
        Map<Integer, int[]> map = new HashMap();
        map.put(0, new int[]{4,6});
        map.put(1, new int[]{8,6});
        map.put(2, new int[]{7,9});
        map.put(3, new int[]{4,8});
        map.put(4, new int[]{3,9,0});
        map.put(5, new int[]{});
        map.put(6, new int[]{1,7,0});
        map.put(7, new int[]{2,6});
        map.put(8, new int[]{1,3});
        map.put(9, new int[]{4,2});

        // dp[n][j] = num of ways to reach j in n steps
        long[][] dp = new long[n][10];
        dp[0] = new long[]{1,1,1,1,1,1,1,1,1,1};
        if(n==1) return 10;
        for(int i = 1; i<n; i++) {
            for(int j =0; j<10; j++){
                int[] pre = map.get(j); // 上一层
                for(int p : pre) {
                    dp[i][j] += dp[i-1][p];
                    dp[i][j] %= mod;
                }
            }
        }

        int res = 0;
        for(int i = 0; i<10; i++){
            res += dp[n-1][i];
            res %= mod;
        }
        return res;
    }
}