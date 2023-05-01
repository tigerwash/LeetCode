package DP;

/**
 2439. Minimize Maximum of Array

 将它理解为trapping water，但是水只能从右往左流。
 所以我们从左往右扫求他的 presum 除长度的平均值，取其最大值

 注意后面的结果因为是 ceil(double(sum) / (i + 1)) 写成算数就是 (presum + i) / (i+1)
 类似于在bianary search 里面求ceiling 会(l-r + 1)/2 * */
public class Minimize_Maximum_of_Array {

    public int minimizeArrayValue(int[] nums) {
        long res = 0;
        long presum = 0;
        for(int i = 0; i< nums.length;i++){
            presum += nums[i];
            // （presum + i） 的目的是为了得到除（i+1）后这个值的ceiling
            // (比如如果结果是2.3， 那我应该取 3)
            res = Math.max(res, (presum + i) / (i+1));
        }
        return (int)res;
    }}
