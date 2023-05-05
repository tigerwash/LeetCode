package DP;

/**
 2369. Check if There is a Valid Partition For The Array

 * */
public class Check_if_There_is_a_Valid_Partition_For_The_Array {

    /**
     dp[i] = dp[i-2] && (n[i-1]==n[i])
     ||  dp[i-3] && (n[i-2]==n[i-1]&& n[i-1]==n[i])
     ||  dp[i-3] && (n[i-2]==n[i]-2 && n[i-1]=n[i]-1)

     */

    public boolean validPartition(int[] nums) {
        if(nums.length == 2) return nums[0]==nums[1];
        boolean[] dp = new boolean[nums.length+1];
        dp[0] = true;
        dp[1] = false;
        dp[2] = nums[0] == nums[1];
        for(int i = 3; i<= nums.length; i++) {
            dp[i] = (dp[i-2] && (nums[i-2]==nums[i-1]) )
                    || (dp[i-3] && ( nums[i-3]==nums[i-2] && nums[i-2]==nums[i-1]))
                    || (dp[i-3] && (nums[i-3]==nums[i-2]-1 && nums[i-2]==nums[i-1]-1));
        }
        return dp[nums.length];
    }
}
