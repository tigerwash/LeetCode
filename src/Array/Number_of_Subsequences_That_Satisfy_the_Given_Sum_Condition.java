package Array;
/**
 1498. Number of Subsequences That Satisfy the Given Sum Condition

 其实是一个变相的two sum， 用两个pointer i,j 相向而行，找到比他小的sum， 然后这两个pointer
 区间 [i, j] 内 所有的组合（一定包括j）2^(j-i) 种都可以算进去。

 注意 2^n 数字太大了，需要用pow[i] % mod  来表示
 *
 * */
public class Number_of_Subsequences_That_Satisfy_the_Given_Sum_Condition {

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int mod = (int)1e9+7;
        int l = 0;
        int r = nums.length-1;
        int res = 0;
        // 一定要用pow[]， 不然会超界
        int[] pow = new int[nums.length];
        pow[0] = 1;
        for(int i = 1; i<nums.length; i++)
            pow[i] = pow[i-1]*2%mod;

        // 定住 r， [l, r] 之间有2^(r-l) 种可能性
        while(l <= r){
            if(nums[l] + nums[r] > target) {
                r--;
            }else {
                res += pow[r-l] ;
                res %= mod;
                l++;
            }
        }
        return res;
    }
}
