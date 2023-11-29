/**
 * 934. Shortest Bridge
 *
 * 两个岛， 求链接两个岛岛最短距离。
 * 先找个一个岛，然后dfs将其所有的1 翻为2，同时将坐标加到 queue 里面
 * 再bfs 这个queue， 找到最近的1
 * **/

class Solution {
    int[][] dir = new int[][]{{0,1}, {0,-1}, {1,0}, {-1, 0}};
    public int shortestBridge(int[][] grid) {
        Queue<int[]> q = new ArrayDeque();
        int m = grid.length;
        int n = grid[0].length;
        boolean found = false;
        for(int i = 0; i<m; i++) {
            if(found) break;
            for(int j = 0; j<n; j++ ) {
                if(grid[i][j] == 1) {
                    dfs(grid, new int[]{i, j}, q);
                    found= true;
                    break;
                }
            }
        }
        int count = 0;
        // boolean[][] visited =
        // new boolean[grid.length][grid[0].length];
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i<size; i++){
                int[] cur = q.poll();
                for(int[] d : dir) {
                    int x = cur[0] + d[0];
                    int y = cur[1] + d[1];
                    if(x <0 || y<0 || x>=grid.length
                            || y>=grid[0].length ||
                            grid[x][y] == 2 ) continue;

                    if(grid[x][y] == 1) return count;
                    q.offer(new int[]{x,y});
                    grid[x][y] = 2;
                }
            }
            count++;
        }
        return count;
    }

    private void dfs(int[][] grid, int[] pos, Queue<int[]> out) {
        if(pos[0]<0 || pos[0]>=grid.length
                || pos[1]<0 || pos[1]>=grid[0].length
                || grid[pos[0]][pos[1]] == 0
                || grid[pos[0]][pos[1]] ==2) {
            return ;
        }

        out.add(pos);
        grid[pos[0]][pos[1]] = 2;
        out.offer(pos);
        for(int[] d : dir) {
            int x = pos[0] + d[0];
            int y = pos[1] + d[1];
            dfs(grid, new int[]{x, y}, out);
        }
    }

}