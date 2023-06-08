/**
 1372. Longest ZigZag Path in a Binary Tree
* **/

class Solution {
    int max = 0;
    public int longestZigZag(TreeNode root) {
        if(root == null) return 0;
        helper(root.left, true, 1);
        helper(root.right, false, 1);
        return max;
    }

    // parent : true: left,  false: right
    private void helper(TreeNode root, boolean dir, int depth) {
        if(root == null) return;
        max = Math.max(max, depth);
        if(dir) {
            helper(root.right, false, depth+1) ;
            helper(root.left, true, 1) ;  // restart orgion
        }else {
            helper(root.left, true, depth + 1);
            helper(root.right, false, 1) ;  // restart orgion
        }
    }
}