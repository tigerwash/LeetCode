class Solution {
    public int largestCombination(int[] candidates) {
        int[] all = new int[32];
        int max = 0;
        for(int n : candidates){
            int index = 0;
            while(n>0) {
                int cur = n&1;
                all[index] += cur;
                max = Math.max(all[index], max);
                n = n>>1;
                index++;
            }
        }
        return max;
    }
}