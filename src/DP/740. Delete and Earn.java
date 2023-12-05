class Solution {
    /*
    挪走一个数，这个list上跟他差+-1的数都需要被挪掉，不能算value。
    这个其实是一个套了马甲的house robber
    可以把这个数的数值看为 house 的index，则偷了这个index 的房子，拿他前后相邻的房子都不能偷了
    那么这个房子的value就是 nums 上这个相同index 的数值总和
     */
    public int deleteAndEarn(int[] nums) {
        int[] valueMap = new int[10002];
        for(int i = 0; i < nums.length; i++) {
            valueMap[nums[i]] += nums[i];
        }
        /* dp 写法 */
        // int[] dp = new int[10002];
        // dp[0] = valueMap[0];
        // dp[1] = Math.max(valueMap[0], valueMap[1]);
        // for(int i = 2; i<10002; i++){
        //     dp[i] = Math.max(dp[i-1], dp[i-2]+valueMap[i]);
        // }
        // return dp[10001];

        /**
         更简洁写法： 因为dp 其实只用了最后两个数，所以只要记载
         takei, take[i] = skip[i-1] + values[i];
         takei 相当于 dp[i-2]+valueMap[i]

         skipi, skip[i] = Math.max(skip[i-1], take[i-1]);
         skipi 相当于 dp[i-1]
         不过比较难理解
         */
        int take = 0, skip = 0;
        for(int i = 0; i<10002; i++) {
            int takei = skip + valueMap[i];
            int skipi = Math.max(skip, take);
            take = takei;
            skip = skipi;
        }
        return Math.max(take, skip);
    }
}