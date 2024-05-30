class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        // sliding window
        int[] diff = new int[s.length()];
        for(int i = 0; i< s.length(); i++) {
            diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int r = 0;
        int l = 0;
        int sum = 0;
        int max = 0;
        // [l, r)
        while(r < s.length()) {
            sum += diff[r++];
            if(sum <= maxCost) {
                max = Math.max(r-l, max);
            } else {
                while(sum> maxCost && l< r) {
                    sum -= diff[l++];
                }
            }
        }
        return max;
    }
}