class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0;
        int right = 0;
        int max = 0;
        int zero = 0;
        while(right < nums.length) {
            if(nums[right] == 0){
                zero++;
            }
            while(zero>1) {
                if(nums[left]==0) zero--;
                left++;
            }
            max = Math.max( right - left +1, max );
            right++;
        }
        return max;
    }
}