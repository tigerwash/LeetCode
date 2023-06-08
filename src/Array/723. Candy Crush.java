
/**  723. Candy Crush
 **/
class Solution {
    /***
     消消乐的游戏，要求横竖大于2个相连的就消掉
     每次扫的时候查找右边和下面两个方向是否满足条件即可， 把需要消除的设为 -n
     这么做的一个坑点在于被mark 后的值依旧需要在后面的遍历中进行比较，所以一直要用 ｜val｜
     然后用two pointer 方法一列一列地crush
     **/

    int[][] dir = new int[][]{{0,1}, {0,-1},{1,0},{-1,0}};
    public int[][] candyCrush(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean needcrush = true;
        while(needcrush) {
            needcrush = false;
            for(int i = 0; i<m; i++) {
                for(int j = 0; j<n; j++) {
                    int val = Math.abs(board[i][j]);
                    if(val == 0) continue;
                    // check right, mark crush val to -val
                    if(j<n-2 && Math.abs(board[i][j+1])==val && Math.abs(board[i][j+2])==val) {
                        needcrush = true;
                        int idx = j;
                        while(idx<n && Math.abs(board[i][idx]) == val) {
                            board[i][idx++] = -val;
                        }
                    }
                    //check bottom, mark crush val to -val
                    if(i<m-2 && Math.abs(board[i+1][j])==val && Math.abs(board[i+2][j]) == val) {
                        needcrush = true;
                        int idx = i;
                        while(idx<m && Math.abs(board[idx][j]) == val) {
                            board[idx++][j] = -val;
                        }
                    }
                }
            }
            //cursh, using two pointer
            for(int j = 0; j<n; j++) {
                int idx = m-1;
                for(int i = m-1; i>=0; i--) {
                    if(board[i][j] > 0) {
                        board[idx--][j] = board[i][j];
                    }
                }
                // fill 0
                while(idx>=0) board[idx--][j] = 0;
            }
        }
        return board;
    }
}