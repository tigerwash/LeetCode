package BFS;
/**
 * 130. Surrounded Regions
 *
 * 把不挨着边的岛屿都删除掉
 *
 * 我的方法是建一个新的地图，把挨着边的岛屿都标记出来，然后最后
 * 全图扫一遍把没标记的岛屿全删除了
 *
 * **/
public class Surrounded_Regions {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        // map[ i, j] = true when [i,j] is good 'O'
        boolean[][] map = new boolean[m][n];
        // 上
        for(int i = 0; i< n; i++){
            if(board[0][i] == 'O' && !map[0][i]){
                // marke all good "o" as true
                dfs(board, map, 0, i);
            }
        }
        // 下
        for(int i = 0; i< n; i++){
            if(board[m-1][i] == 'O' && !map[m-1][i]){
                // marke all good "o" as true
                dfs(board, map, m-1, i);
            }
        }
        // 左
        for(int i = 1; i< m-1; i++){
            if(board[i][0] == 'O' && !map[i][0]){
                // marke all good "o" as true
                dfs(board, map, i, 0);
            }
        }
        // 右
        for(int i = 1; i< m-1; i++){
            if(board[i][n-1] == 'O' && !map[i][n-1]){
                // marke all good "o" as true
                dfs(board, map, i, n-1);
            }
        }

        for(int i = 0; i< m; i++){
            for(int j = 0; j<n; j++){
                if(board[i][j] == 'O' && !map[i][j]) board[i][j] = 'X';
            }
        }

    }

    int[][] dir = new int[][]{{0,1}, {0, -1}, {1,0}, {-1, 0}};
    private void dfs(char[][] board, boolean[][] map, int i, int j){
        if(i< 0 || j < 0 || i >=board.length || j >= board[0].length || board[i][j] == 'X') return;
        if(board[i][j] == 'O' && !map[i][j]){
            map[i][j] = true;
            for(int[] d : dir){
                int x = i+d[0];
                int y = j+d[1];
                dfs(board, map, x, y);
            }
        }

    }
}
