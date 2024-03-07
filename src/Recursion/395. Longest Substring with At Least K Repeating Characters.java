class Solution {
    public int longestSubstring(String s, int k) {
        // divide and conquer , 把str通过频数小于k的char split， 然后对每一个substring
        // 再进行recursion call longestSubstring()
        if(s==null || s.length()==0) return 0;
        // store each count
        int[] map = new int[26];
        for(char c : s.toCharArray()) map[c-'a']++;
        boolean goodString = true; // check is orign s is good str
        for(int n : map) {
            if(n>0 && n<k) {
                goodString = false;
                break;
            }
        }
        if(goodString) return s.length();
        // if not good string, split it
        int res = 0;
        int l = 0;
        int r = 0;
        while(r < s.length()) {
            if(map[s.charAt(r)-'a']>0 && map[s.charAt(r)-'a']<k) {
                String subStr = s.substring(l, r);
                res = Math.max(res, longestSubstring(subStr, k));
                l = r+1;
            }
            r++;
        }
        // 再算一下到终点的，以防漏了edgecase
        res = Math.max(res, longestSubstring(s.substring(l), k));
        return res;

    }
}