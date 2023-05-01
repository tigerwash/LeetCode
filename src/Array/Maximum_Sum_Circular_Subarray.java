package Array;

/**
 918. Maximum Sum Circular Subarray

 * **/
public class Maximum_Sum_Circular_Subarray {
    public int maxSubarraySumCircular(int[] nums) {
        // max(the max subarray sum, the total sum - the min subarray sum)
        int maxsum = nums[0];
        int minsum = nums[0];
        int curmin = 0;
        int curmax = 0;
        int total = 0;
        for(int n : nums){
            total += n;
            curmax = curmax >0? curmax+n : n;
            maxsum = Math.max(curmax, maxsum);
            curmin = curmin <0? curmin+n : n;
            minsum = Math.min(curmin, minsum);
        }
        // final check, check the corner case that all cursum < 0
        return maxsum > 0 ? Math.max(maxsum, total - minsum) : maxsum;
    }
}
