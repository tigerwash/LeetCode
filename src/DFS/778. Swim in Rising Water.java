class Solution {
    public int swimInWater(int[][] grid) {
        // 可以优化成binary search
        for(int i = 0; i< grid.length*grid.length; i++){
            if(i<grid[0][0]) continue;
            boolean[][] M = new boolean[grid.length][grid.length];
            if(canReach(grid, M, 0, 0, i)) return i;
        }
        return 0;
    }


    int[][] dir = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    public boolean canReach(int[][] grid, boolean[][] M, int i, int j, int h) {
        M[i][j] = true; // visited
        for(int[] d : dir) {
            int x = d[0] + i;
            int y = d[1] + j;
            if(x<0 || y<0 || x>=M.length || y>=M[0].length || M[x][y] || grid[x][y]>h) continue;
            if(x== grid.length-1 && y == grid.length-1) return true;
            boolean reach = canReach(grid, M, x, y, h);
            if(reach) return true;
        }
        return false;
    }
}