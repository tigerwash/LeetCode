class Solution {
    public int longestOnes(int[] nums, int k) {
        int right = 0;
        int left = 0;
        int zero = 0;
        int max = 0;
        while(right < nums.length) {
            if(nums[right] == 0){
                zero++;
            }
            while(zero>k) {
                if(nums[left]==0) zero--;
                left++;
            }
            max = Math.max( right - left +1, max );
            right++;
        }
        return max;
    }
}