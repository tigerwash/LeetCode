import java.util.*;
/**
 * 1546. Maximum Number of Non-Overlapping Subarrays With Sum Equals Target
 *
 * 求array 中有多少个不重叠的subarray , 且每个subarray 的和为target
 *
 *  Greedy , 每次碰到一个好的interval 就把prefix sum 清零， 重新开始
 *  同时 res++
 *
 *  note: 我曾经想过把每个interval 都算出来，然后求这个interval有多少个不重合的，结果其实很麻烦，只能用n^2 的dp， 会超时
 *  还是greedy 好
 * */

class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        // Greedy , 每次碰到一个好的interval 就把prefix sum 清零， 重新开始
        // 同时 res++
        Set<Integer> set = new HashSet();
        int res = 0;
        int prefix = 0;
        set.add(0);
        for(int i = 0; i<nums.length; i++){
            prefix += nums[i];
            if(set.contains(prefix - target)){
                res++;
                set = new HashSet();
            }
            set.add(prefix);
        }
        return res;
    }
}
