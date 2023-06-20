/** 2537. Count the Number of Good Subarrays
 *
 * Sliding window, 保证 j....i 中间的有效pair大于 k，
 * 然后每次更新pair 的时候是 pair +- map.get(remove)
 * **/
class Solution {
    /** sliding window*/
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        int len = nums.length;
        int pairs = 0;
        long res = 0;
        int j = 0;
        for(int i = 0; i< nums.length; i++) {
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }else {
                pairs += map.get(nums[i]);
                map.put(nums[i], map.get(nums[i])+1);
            }

            while(j<i && pairs>=k){
                int remove = nums[j];
                if(map.get(remove) > 1) {
                    pairs -= map.get(remove)-1;
                    map.put(remove, map.get(remove)-1);
                }else {
                    map.remove(remove);
                }
                j++;
                res += len-i; // update reault
            }
        }
        return res;
    }

}