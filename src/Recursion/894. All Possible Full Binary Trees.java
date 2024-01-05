/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> allPossibleFBT(int n) {
        // 好题， 深度考察recursion
        // Recursive: build all possible FBT of leftSubTree and rightSubTree with number n
        List<TreeNode> res = new ArrayList();

        if(n%2==0) return res;
        if(n==1){
            TreeNode root = new TreeNode(0);
            res.add(root);
            return res;
        }

        for(int i = 1; i< n; i+=2) {
            List<TreeNode> leftNodes = allPossibleFBT(i);
            List<TreeNode> rightNodes = allPossibleFBT(n-i -1);
            for(TreeNode l : leftNodes) {
                for(TreeNode r : rightNodes) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }
}