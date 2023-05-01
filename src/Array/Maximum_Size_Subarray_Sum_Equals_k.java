package Array;

/**
 * 325. Maximum Size Subarray Sum Equals k

    建一个map 存第一次出现的prefixsum 的index  <prefix sum, index >
    如果 cursum - k == prefix sum ， 则通过index判断长度
 */
public class Maximum_Size_Subarray_Sum_Equals_k {

    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        int res = 0;
        int sum = 0;
        map.put(0,-1);
        for(int i = 0; i< nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum - k)){
                res = Math.max(i-map.get(sum-k), res);
            }
            if(!map.containsKey(sum)) map.put(sum, i);
        }
        return res;
    }
}
