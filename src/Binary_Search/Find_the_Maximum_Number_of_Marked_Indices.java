package Binary_Search;

import java.util.Arrays;

/**
 * 2576. Find the Maximum Number of Marked Indices
 * https://leetcode.com/problems/find-the-maximum-number-of-marked-indices/
 * 先sort
 * 再 two pinter： 一个在0， 一个在(n+1)/2 处
 *
 * */
public class Find_the_Maximum_Number_of_Marked_Indices {
    public int maxNumOfMarkedIndices(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        if(nums.length<2) return 0;
        int l = 0;
        int r = (nums.length + 1)/2;
        while(r<nums.length){
            if(nums[l] <= nums[r]/2){
                l++;
                res++;
            }
            r++;
        }
        return res*2;
    }
}
