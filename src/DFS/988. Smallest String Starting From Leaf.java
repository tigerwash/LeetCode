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

/**
 * 求char树 从叶子到根的 字典序最小，只能前序dfs，到 leaf 的时候把整个path
 * reverse 一遍，然后比大小。 注意这个sb一定要deep copy 这个path。
 * */

class Solution {
    String res = null;
    public String smallestFromLeaf(TreeNode root) {
        StringBuilder path = new StringBuilder();
        dfs(root, path);
        return res;
    }

    private void dfs(TreeNode root, StringBuilder sb) {
        if(root == null) return;
        char c = (char)('a' + root.val);
        sb.append(c);
        int len = sb.length();
        if(root.left==null && root.right == null) {
            StringBuilder reverse = new StringBuilder(sb);
            String path = reverse.reverse().toString();
            if(res == null || res.compareTo(path)>0) {
                res = path;
            }
            return;
        }
        dfs(root.left, sb);
        sb.setLength(len);

        dfs(root.right, sb);
        sb.setLength(len);
    }
}