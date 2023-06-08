

/**
 * 1055. Shortest Way to Form String
**/

class Solution {
    /**
     Two Pointer 法：
     source 和target 各有一个pointer s,t。 对于每个新的字段t，
     我们都需要用s去扫一遍source, 只要发现相同的了就 t++;
     发现t 在这个轮次没挪动 那就说明这个字母不存在，return -1
     **/
    public int shortestWay(String source, String target) {
        int t = 0;
        int res = 0;
        while(t<target.length()) {
            int orgt = t;
            for(int s = 0; s<source.length(); s++) {
                if(t< target.length() && source.charAt(s) == target.charAt(t)){
                    t++;
                }
            }
            // if target[t] not in source
            if(orgt == t) return -1;
            res++;
        }
        return res;
    }
}