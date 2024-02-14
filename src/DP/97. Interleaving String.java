class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        //classic dp
        // dp[i][j] = true  if s1[i] == s3[i+j] && dp[i-1][j]
        //                  || s2[j] == s3[i+j] && dp[i][j-1]

        if(s1.length() + s2.length() != s3.length()) return false; // 这个case 有58个test
        // 加dummy head
        s1 = "#" + s1;
        s2 = "#" + s2;
        s3 = "#" + s3;
        boolean[][] dp = new boolean[s1.length()][s2.length()];
        dp[0][0] = true;
        int i =1, j = 1;
        while(i<s1.length() && s1.charAt(i)==s3.charAt(i)){
            dp[i][0]= true;
            i++;
        }
        while(j<s2.length() && s2.charAt(j)==s3.charAt(j)){
            dp[0][j]= true;
            j++;
        }

        for(i = 1; i<s1.length(); i++) {
            for(j = 1; j<s2.length(); j++) {
                if(s1.charAt(i) == s3.charAt(i+j) && dp[i-1][j]) dp[i][j] = true;
                if(s2.charAt(j) == s3.charAt(i+j) && dp[i][j-1]) dp[i][j] = true;
            }
        }
        return dp[s1.length()-1][s2.length()-1];
    }
}