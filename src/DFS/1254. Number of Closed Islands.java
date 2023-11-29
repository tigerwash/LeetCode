/**
 1254. Number of Closed Islands

 这个题的点在于撞到墙的时候不要立刻返回false， 还是需要继续dfs把剩下的陆地翻为1
 */
class Solution {
    int count = 0;
    public int closedIsland(int[][] grid) {
        for(int i = 0; i<grid.length; i++) {
            for(int j = 0; j<grid[0].length; j++) {
                if(grid[i][j] == 0){
                    if(dfs(grid, i, j)) count++;
                }
            }
        }
        return count;
    }

    int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    private boolean dfs(int[][] grid, int i, int j) {
        if(i<0 || j <0 || i>=grid.length || j>= grid[0].length) return false;
        if(grid[i][j] == 1 ) return true;
        boolean meetwall = false;
        if(grid[i][j] == 0 ) {
            grid[i][j] = 1;
            for(int[] d : dir) {
                int x = i+d[0];
                int y = j+d[1];
                if(!dfs(grid, x, y)){
                    meetwall = true;
                }
            }
        }
        return !meetwall;
    }
}