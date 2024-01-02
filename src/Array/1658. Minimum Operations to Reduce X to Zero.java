import java.util.*;
class Solution {
    public int minOperations(int[] nums, int x) {
        int len = nums.length;

        // left[i] + right[j] == x?  就像twosum，
        // map<presum, lst[index]>
        // 建一个map，放左边的prefix sum 以及第一个出现的index
        Map<Integer, Integer> map = new HashMap();
        int presum = 0;
        int res = Integer.MAX_VALUE;
        for(int i = 0; i<nums.length; i++) {
            presum += nums[i];
            if(presum == x) res = Math.min(i+1, res);  // 解决 左边边自己就可以组成 x 的情况
            if(!map.containsKey(presum)) map.put(presum, i);
        }
        int sufix = 0;

        map.put(0, -1); // 解决 右边自己就可以组成 x 的情况 , eg: [1,1,4,2,3], 5
        for(int j = len -1; j>=0; j--) {
            sufix += nums[j];
            if(map.containsKey(x-sufix)){
                int first = map.get(x-sufix);
                if(first < j) {
                    res = Math.min(first+1 + len - j, res);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}