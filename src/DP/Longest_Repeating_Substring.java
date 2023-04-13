package DP;

/**
 1062. Longest Repeating Substring

 Given a string s, return the length of the longest repeating substrings.
 If no repeating substring exists, return 0.

 Input: s = "aabcaabdaab"
 Output: 3

 **/

public class Longest_Repeating_Substring {

    /** **********      用 DP 写   *********** ***/
    public int longestRepeatingSubstring(String s) {
        int len = s.length();
        int[][] dp = new int[len+1][len+1];
        int res = 0;
        for(int i = 1; i<=len; i++){
            for(int j = i+1; j<=len; j++){
                if(s.charAt(i-1) == s.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;

                }
                res = Math.max(dp[i][j], res);
            }
        }
        return res;
    }



    /** **********      用 Tri 写   *********** ***/
    class TriNode {
        char val;
        TriNode[] neighbor;
        TriNode(char val){
            this.val = val;
            this.neighbor = new TriNode[26];
        }
    }

    public int longestRepeatingSubstring_TRI(String s) {
        int max = 0;
        TriNode tree = new TriNode('!');
        for(int i = 0; i< s.length(); i++){
            if(tree.neighbor[s.charAt(i) - 'a'] == null){
                tree.neighbor[s.charAt(i) - 'a'] = new TriNode(s.charAt(i) );
            }
            TriNode cur = tree.neighbor[s.charAt(i) - 'a'];
            int curlen = 0;
            for(int j = i; j<s.length(); j++){
                if(cur.neighbor[s.charAt(j)-'a'] != null){
                    curlen++;
                }else{
                    cur.neighbor[s.charAt(j)-'a'] = new TriNode(s.charAt(j));
                }
                cur = cur.neighbor[s.charAt(j)-'a'];
            }
            max = Math.max(curlen, max);
        }
        return max;
    }
}
