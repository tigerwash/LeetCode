/**
 * 487. Max Consecutive Ones II
 * **/

class Solution {
    /**
     用一个pre 记录他前面一个位置的连续1 的个数，如果中间隔了两个0，那么他就是0
     **/
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 1;
        int pre = -1; // consecutive 1 before
        int i = 0;
        if(nums.length ==1 ) return 1;
        while(i<nums.length) {
            if(nums[i] == 1) {
                int count = 0;
                while(i<nums.length && nums[i] == 1) {
                    count++;
                    i++;
                }
                if(pre > 0) max = Math.max(max, pre + 1 + count);
                if(i < nums.length || pre ==0) max = Math.max(max, count+1);  // cover [1, 0], [0, 1]
                max = Math.max(max, count);
                pre = count;
            }else {
                if((i>0 && nums[i-1] == 0) || pre == -1) pre = 0;
                i++;
            }
        }
        return max;
    }
}