package Binary_Tree;

/**
 * 549. Binary Tree Longest Consecutive Sequence II
 * **/

class Solution {
    /**
     每次dfs 的时候往上返回两个信息：以当前root为起点往下撸的
     递减的长度， 递增的长度: [dis, inc]
     **/
    int max = 0;
    public int longestConsecutive(TreeNode root) {
        dfs(root);
        return max;
    }
    //
    private int[] dfs(TreeNode root) {
        if(root == null) return new int[]{0,0};
        int dis = 1;
        int inc = 1;
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        if(root.left != null) {
            if(root.val -1 == root.left.val){
                dis = left[0] + 1;
            }else if(root.val + 1 == root.left.val){
                inc = left[1] + 1;
            }
        }
        if(root.right != null) {
            if(root.val -1 == root.right.val){
                dis = Math.max(dis, right[0] + 1);
            }else if(root.val + 1 == root.right.val ){
                inc = Math.max(inc, right[1] + 1);
            }
        }
        max = Math.max(max, inc + dis -1);
        return new int[]{dis, inc};
    }
}