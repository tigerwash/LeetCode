/**
 * 1530. Number of Good Leaf Nodes Pairs
 * **/

/*** dfs 每次往上返回dis[] 每一层有多少个 leaves
 dis[i]= num of leaves in dis i */
class Solution {
    int res = 0;
    int dis;
    public int countPairs(TreeNode root, int distance) {
        this.dis = distance;
        dfs(root);
        return res;
    }

    //  dis[i]= num of leaves in dis i
    public int[] dfs(TreeNode root) {
        int[] out = new int[10];
        if(root == null) return out;
        if(root.left == null && root.right == null) {
            out[0] = 1;
            return out;
        }
        int[] disleft = dfs(root.left);
        int[] disright = dfs(root.right);
        int cur = 0;
        for(int i = 0; i< dis-1; i++) {
            for(int j = 0; j<dis-1-i; j++){
                res += disleft[i] * disright[j];
            }
        }

        for(int i = 0; i<9; i++) {
            if(disleft[i]>0) out[i+1] = disleft[i];
            if(disright[i]>0) out[i+1] += disright[i];
        }

        return out;
    }
}