class Solution {
    public int minCost(String s, int[] cost) {
        int res = 0;
        for(int i = 0; i< cost.length; i++) {
            int j = i;
            int cursum = 0;
            int curmax = 0;
            while(j < cost.length && s.charAt(i) == s.charAt(j)) {
                curmax = Math.max(curmax, cost[j]);
                cursum += cost[j];
                j++;
            }
            if(i != j-1) {
                res += cursum - curmax;
                i = j-1;
            }
        }
        return res;
    }
}