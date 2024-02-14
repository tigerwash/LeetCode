package MapPQ;
import java.util.*;

/**
 2370. Longest Ideal Subsequence

 用一个map 存 以这个char 为终点的最长subsequence 距离， 然后撸一遍s
 对于每一个 c (s[i])， 遍历可能作为他前一个元素的char， 即在范围[c-k, c+k] 里面
 查找最长距离，然后更新map(c, max+1);
 * */

public class Longest_Ideal_Subsequence {
    public int longestIdealString(String s, int k) {
        // <char, longest end in char>
        Map<Character, Integer> map = new HashMap();
        int res = 0;
        for(int i = 0; i<s.length(); i++){
            char cur = s.charAt(i);
            int max = 0;
            for(int j = -k; j<=k; j++){
                if( (char)(cur+j) < 'a' || (char)(cur+j)>'z') continue;
                char prechar = (char)(cur+j);
                // System.out.println("cur: "+cur + ", prechar: "+ prechar);
                if(!map.containsKey(prechar)) continue;
                max = Math.max(max, map.get(prechar));
            }
            map.put(cur, max+1);
            res = Math.max(map.get(cur), res);
        }
        return res;
    }

}
