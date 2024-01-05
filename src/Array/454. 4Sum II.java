class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // O(n^2)
        // <n1[i]+n2[j], count>
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i< nums1.length; i++) {
            for(int j = 0; j<nums2.length; j++) {
                map.put(nums1[i] + nums2[j], map.getOrDefault(nums1[i]+nums2[j], 0) + 1);
            }
        }
        int res = 0;
        for(int m = 0; m<nums3.length; m++) {
            for(int n = 0; n<nums4.length; n++) {
                if(map.containsKey(-nums3[m]-nums4[n])) {
                    res += map.get(-nums3[m]-nums4[n]);
                }
            }
        }
        return res;
    }
}