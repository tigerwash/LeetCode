package DP;

/**
 1143. Longest Common Subsequence

     dp[i][j] = max(dp[i][j-1], d[i-1][j])  if a[i] != b[j]
                dp[i-1][j-1] + 1            if a[i] == b[j]
 * */

public class Longest_Common_Subsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1+1][len2+1];
        for(int i = 1; i<= len1; i++) {
            for(int j = 1; j<=len2; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }

            }
        }

        return dp[len1][len2];
    }
}
