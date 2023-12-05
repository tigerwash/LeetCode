class Solution {
    /**
     * 看着像dp 其实是个数学题
     * 每次可以走i 步，要么往左要么往右，求走到终点target 一共要多少步
     其实这个题目已经预设你一定可以走到终点。 那么问题其实可以看
     如果求最小，那么先假设我们一直往右走，那么就有两种情况：
     1. 正好到达target， 比如 1+2+3=6
     2. 超过了但是超过了一个偶数的距离: 1+2+3+4+5 = 9(target) + 6
     那么这个6 只要把 前面那个 3 转成 -3 就可以刚好凑到9 ： 1+2-3+4+5 = 9
     换而言之，只要超过target 的是一个偶数差值n，那么在之前的steps里面总有 n/2 可以
     反转一个，去抵消这个差值， 凑到这个target值
     */
    public int reachNumber(int target) {
        target = Math.abs(target);
        int sum = 0;
        int step = 0;
        while(true) {
            step++;
            sum += step;
            if(sum == target){
                return step;
            }
            if(sum> target && (sum-target)%2 == 0) {
                return step;
            }
        }
    }
}