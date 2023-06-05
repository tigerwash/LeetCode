

class Solution {
    /**  1314. Matrix Block Sum

     * dp[i,j] = sum [0..i][0..j]

             c1 c2
          1. 2. 3
     r1   4. 5. 6
     r2   7. 8. 9

     res[c1..c2, r1..r2]  = dp[r2,r1] - dp[r2,c1-1] - dp[r1-1,c2] + dp[r1-1,c1-1]
     **/
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m+1][n+1]; // dp[i,j] = sum [0..i][0..j]
        for(int i = 1; i<=m; i++){
            for(int j = 1; j<=n; j++){
                dp[i][j] = mat[i-1][j-1] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
            }
        }

        int[][] res = new int[m][n];
        for(int i = 0; i< m; i++){
            for(int j = 0; j< n; j++){
                int r1 = Math.max(0, i-k);
                int c1 = Math.max(0, j-k);
                int r2 = Math.min(m-1, i+k);
                int c2 = Math.min(n-1, j+k);
                r1++;
                c1++;
                r2++;
                c2++;
                res[i][j] = dp[r2][c2] - dp[r2][c1-1] - dp[r1-1][c2] + dp[r1-1][c1-1];
            }
        }
        return res;
    }
}