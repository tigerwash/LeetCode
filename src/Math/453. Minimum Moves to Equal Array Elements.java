class Solution {
    /***
     已知：数列nums，初始和s0，长度n，最小的数为m
     假设移动k步
     每移动一步，n-1个数会被＋1，则最终和s = s0 +(n-1) x k
     平均数为 s/n
     最小数每次移动都被+1，因此有：k =s/n -m
     即：（s0 +(n-1) x k）/n -m =k
     求得： k = s0 - m x n
     */
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        long sum = 0;
        for(int n : nums){
            sum += n;
            min = Math.min(min, n);
        }
        return (int)(sum - min * nums.length);
    }
}