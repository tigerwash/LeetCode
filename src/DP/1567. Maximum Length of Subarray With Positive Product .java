class Solution {
    public int getMaxLen(int[] nums) {
        // DP
        // neg[i]: longest consecutive neg length ending with i
        // pos[i]: longest consecutive postive length ending with i
        int[] neg = new int[nums.length];
        int[] pos = new int[nums.length];
        pos[0] = nums[0]>0 ? 1 : 0;
        neg[0] = nums[0]<0 ? 1 : 0;
        int max = pos[0];
        for(int i = 1; i< nums.length; i++) {
            if(nums[i] > 0) {
                pos[i] = 1 + pos[i-1];
                neg[i] =
                        neg[i-1]>0 ? neg[i-1]+1 : 0;
            } else if(nums[i]<0) {
                pos[i] =
                        neg[i-1]>0 ? neg[i-1]+1 : 0;
                neg[i] = 1 + pos[i-1];
            }
            max = Math.max(max, pos[i]);
        }
        return max;
    }
}