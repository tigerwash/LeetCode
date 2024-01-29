class Solution {
    /*** 遍历grid2，dfs 每一个1， 如果有一个1在grid1 中是0， 那么它就不是完全包裹 */
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        int res = 0;
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(grid2[i][j] == 1) {
                    boolean[] inside = new boolean[]{grid1[i][j] == 1};
                    dfs(grid1, grid2, i, j, inside);
                    if(inside[0]) res++;
                }
            }
        }
        return res;
    }

    int[][] dir = new int[][]{{0,1},{0,-1}, {-1,0}, {1,0}};
    private void dfs(int[][] grid1, int[][] grid2, int i, int j, boolean[] inside) {
        grid2[i][j] = -1;
        for(int[] d : dir) {
            int x = i+d[0];
            int y = j+d[1];
            if(x<0 || y<0 || x>= grid2.length || y>= grid2[0].length || grid2[x][y] != 1) continue;
            if(grid1[x][y] == 0) inside[0] = false;
            grid2[x][y] = -1;
            dfs(grid1, grid2, x, y, inside);
        }
    }
}