class Solution {
    public int minOperations(int[] nums) {
        if(nums.length==1) return -1;
        Map<Integer, Integer> map = new HashMap();
        for(int n : nums) {
            map.put(n, map.getOrDefault(n,0)+1);
        }
        int res = 0;
        for(int k : map.keySet()) {
            if(map.get(k)==1) return -1;
            res += (map.get(k) + 2) / 3;
        }
        return res;
    }
}