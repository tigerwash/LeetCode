class Solution {
    public int longestSubarray(int[] nums) {
        // find window there are one 0s
        int l = 0;
        int zero = 0;
        int max = 0;
        for(int r = 0; r<nums.length; r++){
            if(nums[r] == 0) {
                zero++;
            }
            while(zero == 2) {
                if(nums[l]==0) zero--;
                l++;
            }
            max = Math.max(max, r-l);
        }
        return max;
    }
}