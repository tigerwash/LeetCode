class Solution {
    int res = 0;
    public int totalNQueens(int n) {
        int[][] matrix = new int[n][n];
        dfs(matrix, 0, n);
        return res;
    }

    private void dfs(int[][] matrix, int index, int n) {
        if(index == n){
            res++;
            return;
        }
        for(int i = 0; i< n; i++){
            if(valid(matrix, i, index)){
                matrix[i][index] = 1;
                dfs(matrix, index+1, n);
                matrix[i][index] = 0;
            }
        }
    }

    private boolean valid(int[][] matrix, int n, int m){
        // top -> down
        for(int i = 0; i<n; i++) {
            if(matrix[i][m]==1) return false;
        }
        // left -> right
        for(int i = 0; i<m; i++) {
            if(matrix[n][i]==1) return false;
        }
        // leftup -> rightdown
        int k = 0;
        while(n-k>=0 && m-k>=0) {
            if(matrix[n-k][m-k]==1) return false;
            k++;
        }

        // leftdown -> rightup
        int p = 0;
        while(n+p<matrix.length && m-p>=0){
            if(matrix[n+p][m-p]==1) return false;
            p++;
        }

        return true;
    }
}