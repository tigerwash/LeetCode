class Solution {
    int name = 2;
    // <island name, count>
    Map<Integer, Integer> map = new HashMap();
    int max = 0;
    public int largestIsland(int[][] grid) {
        // 将每个岛屿编号，然后把面积 记载到 map里
        for(int i = 0; i<grid.length; i++) {
            for(int j = 0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    int[] count = new int[]{0};
                    dfs(grid, i, j, count);
                    map.put(name, count[0]);
                    name++;
                    max = Math.max(max, count[0]);
                }
            }
        }
        // 遍历每一个 0， 收集四周存在的岛屿以及面积 到一个新的 neighbor map 里面
        // 每一次都可以算一下它连接后最大面积能是多少
        for(int i = 0; i<grid.length; i++) {
            for(int j = 0; j<grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    Map<Integer, Integer> neighbor = new HashMap();
                    // left
                    if( (j-1)>=0 && grid[i][j-1]!=0 ) neighbor.put(grid[i][j-1], map.get(grid[i][j-1]));
                    // right
                    if( (j+1)<grid[0].length && grid[i][j+1]!=0 ) neighbor.put(grid[i][j+1], map.get(grid[i][j+1]));
                    // up
                    if( (i-1)>=0 && grid[i-1][j]!=0 ) neighbor.put(grid[i-1][j], map.get(grid[i-1][j]));
                    // down
                    if( (i+1)<grid.length && grid[i+1][j]!=0 ) neighbor.put(grid[i+1][j], map.get(grid[i+1][j]));

                    int cur = 0;
                    for(int k : neighbor.keySet()) cur += neighbor.get(k);
                    max = Math.max(max, cur+1);
                }
            }
        }
        return max;
    }

    int[][] dir = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    private void dfs(int[][] grid, int i, int j, int[] count){
        grid[i][j] = name;
        count[0]++;
        for(int[] d : dir) {
            int x = i+d[0];
            int y = j+d[1];
            if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || grid[x][y]!=1) continue;

            dfs(grid, x, y, count);
        }
    }
}