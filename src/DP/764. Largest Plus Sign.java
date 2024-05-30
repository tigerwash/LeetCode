class Solution {
    // dp,  建几个int[] 算各个方向到0 的最大值，
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] hor = new int[n][n];
        int[][] ver = new int[n][n];
        int[][] matrix = new int[n][n];
        for(int[] a : matrix)
            Arrays.fill(a, 1);
        for(int[] c : mines){
            matrix[c[0]][c[1]] = 0;
        }

        for(int i = 0; i<n; i++) {
            int max = 0;
            for(int j = 0; j<n; j++) {
                max = matrix[i][j]==1 ? max+1 : 0;
                hor[i][j] = max;
            }
            max = 0;
            for(int j = n-1; j>=0; j--) {
                max = matrix[i][j]==1 ? max+1 : 0;
                hor[i][j] = Math.min(max, hor[i][j]);
            }
        }
        int res = 0;
        for(int j = 0; j<n; j++) {
            int max = 0;
            for(int i = 0; i<n; i++) {
                max = matrix[i][j]==1 ? max+1 : 0;
                ver[i][j] = max;
            }
            max = 0;
            for(int i = n-1; i>=0; i--) {
                max = matrix[i][j]==1 ? max+1 : 0;
                ver[i][j] = Math.min(max, ver[i][j]);

                int cur = Math.min(ver[i][j], hor[i][j]);
                res = Math.max(res, cur);
            }

        }
        return res;
    }
}