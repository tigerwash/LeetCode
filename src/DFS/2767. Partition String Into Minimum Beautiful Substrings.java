class Solution {
    int min = 20;
    public int minimumBeautifulSubstrings(String s) {
        dfs(s, 0, 0);
        return min==20? -1 : min;
    }

    private void dfs(String s, int index, int count) {
        if(index==s.length()) {
            min = Math.min(min, count);
            return;
        }
        if(s.charAt(index) == '0') return;
        for(int i = index+1; i<= s.length(); i++) {
            String substr = s.substring(index, i);
            if(isPowFive(substr)){
                dfs(s, i, count+1);
            }
        }
    }

    private boolean isPowFive(String str) {
        int nums = Integer.parseInt(str, 2);
        while(nums%5==0) {
            nums = nums/5;
        }
        // System.out.println(str);
        // System.out.println(nums==1);
        return nums==1;
    }
}