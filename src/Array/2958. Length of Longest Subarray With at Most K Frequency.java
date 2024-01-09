
class Solution {
//    sliding window
    public int maxSubarrayLength(int[] nums, int k) {
        int right = 0;
        int left = 0;
        Map<Integer, Integer> map = new HashMap();
        int max = 0;
        while(right < nums.length) {
            int cur = nums[right];
            map.put(cur, map.getOrDefault(cur,0)+1);
            if(map.get(cur)==k+1) {
                while(map.get(cur) == k+1) {
                    map.put(nums[left], map.get(nums[left])-1);
                    left++;
                }
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
