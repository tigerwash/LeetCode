class Solution {
    public int findMaxLength(int[] nums) {
        //求最长的substring 其中01个数相等，
        // 可以转化成 sub arry sum， 把 0 换成 -1
        // 即求最长的 sub array 其sum 为 0
        // <presum, index>

        for(int i = 0; i<nums.length; i++){
            if(nums[i]==0) nums[i] = -1;
        }
        Map<Integer, Integer> map = new HashMap();
        map.put(0, -1);
        int sum = 0;
        int max = 0;
        for(int i = 0; i<nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum)) {
                max = Math.max(max, i - map.get(sum));
            }else {
                map.put(sum, i);
            }
        }
        return max;
    }
}