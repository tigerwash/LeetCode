package DP;

/**
 376. Wiggle Subsequence

 */
public class Wiggle_Subsequence {
   /** O(n)
     up[] 前面往上；  down[] 前面往下
     n[i-1] < n[i] :   up[i] = down[i-1]+1
                        down[i] = down[i-1]  //因为当前的数字已经比较小了，
                                                所有后面如果有比他大的就跟新的这个小的数组成subsequence,但是长度不会变
     n[i-1] > n[i] :  down[i] = up[i-1] + 1
                        up[i] = up[i-1]

    nums:   2 4 5 7 5 5 7 1 2 3
    up:     1 2 3 4 5 6 4 4
    down:   1 1 1 1 3 3 3 5

     */

    public int wiggleMaxLength(int[] nums) {
        if(nums.length<2) return nums.length;
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];
        up[0] = 1;
        down[0] = 1;
        for(int i = 1; i<nums.length; i++){
            if(nums[i-1] < nums[i] ) {
                up[i] = down[i-1] + 1;
                down[i] = down[i-1];
            }else if(nums[i-1] > nums[i]){
                down[i] = up[i-1] +1;
                up[i] = up[i-1];
            }else{
                down[i] = down[i-1];
                up[i] = up[i-1];
            }
        }
        return Math.max(up[nums.length-1], down[nums.length-1]);
    }

    /**  O(n^2)*/
    public int wiggleMaxLength2(int[] nums) {
        // dp[前一个大于他，前一个小于他]
        int[][] dp = new int[nums.length][2];
        dp[0] = new int[]{1,1};
        int res = 0;
        for(int i = 0; i<nums.length; i++){
            int a = 0, b = 0;
            for(int j = 0; j<i; j++){
                if(nums[j] < nums[i]){
                    a = Math.max(a, dp[j][0]);
                }else if(nums[j]>nums[i]){
                    b = Math.max(b, dp[j][1]);
                }
            }
            dp[i] = new int[]{b+1, a+1};
            int curmax = Math.max(a, b);
            res = Math.max(curmax+1, res);
        }
        return res;
    }
}
