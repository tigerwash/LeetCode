package Array;

public class Minimum_Size_Subarray_Sum {
    /**
     209. Minimum Size Subarray Sum

     sliding window , 一块一慢， 保证window正好大等于 target
     * */
    public int minSubArrayLen(int target, int[] nums) {
        // two pointer
        int left = 0;
        int right = 0;
        int resLen = Integer.MAX_VALUE;
        int curSum = 0;
        while(right < nums.length){
            curSum += nums[right];
            int leftPre = left;
            if(curSum >= target){
                while( curSum >= target){
                    resLen = Math.min(resLen, right-left+1);
                    curSum -=nums[left];
                    left++;
                }
            }
            right++;
        }
        return resLen == Integer.MAX_VALUE? 0 : resLen;
    }
}
