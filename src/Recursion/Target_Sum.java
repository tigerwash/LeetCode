package Recursion;
/**
 494. Target Sum
 Input: nums = [1,1,1,1,1], target = 3
 Output: 5
 Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
 -1 + 1 + 1 + 1 + 1 = 3
 +1 - 1 + 1 + 1 + 1 = 3
 +1 + 1 - 1 + 1 + 1 = 3
 +1 + 1 + 1 - 1 + 1 = 3
 +1 + 1 + 1 + 1 - 1 = 3

 **/
public class Target_Sum {
    int res = 0;
    public int findTargetSumWays(int[] nums, int target) {
        // sufix[i] = sum[i,  len-1]
        int[] sufixsum = new int[nums.length];
        int len = nums.length;
        sufixsum[len-1] = nums[len-1];
        for(int i = len-2; i>=0; i--) {
            sufixsum[i] = sufixsum[i+1] + nums[i];
        }
        dfs(nums, sufixsum, 0, 0, target);
        return res;
    }
    private void dfs(int[] nums, int[] sufix, int index, int cur, int target) {
        if(index == nums.length) {
            if(cur == target) res++;
            return;
        }
        // 剪枝， 离结果太远的过滤掉
        if(cur < target - sufix[index] || cur > target + sufix[index]) {
            return;
        }
        dfs(nums, sufix, index+1, cur+nums[index], target);
        dfs(nums, sufix, index+1, cur-nums[index], target);
    }
}
