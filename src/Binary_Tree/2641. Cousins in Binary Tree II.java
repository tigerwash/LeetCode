package Binary_Tree;

/**
 2641. Cousins in Binary Tree II

 重点在于找到核心思路： 他表兄的值等于 当前层的总和 减去他和他的兄弟的值
 curval = level sum - (me + brother)
 这样其实只要用一个map 先找到每一层的总和，然后再dfs 一下就能算出来每个表兄的值
 * */
public class Cousins_in_Binary_Tree_II {
    // <level, sum>
    Map<Integer, Integer> map = new HashMap();
    public TreeNode replaceValueInTree(TreeNode root) {
        // curval = level sum - (me + brother)
        buildmap(root, 1);
        return changeval(root, 1, 0); // (cur, bro val)
    }

    private TreeNode changeval(TreeNode root, int level, int broval) {
        if(root == null) return null;
        int newval = map.get(level) - root.val - broval;
        TreeNode newroot = new TreeNode(newval);
        int rightval = root.right == null? 0 : root.right.val;
        int leftval = root.left == null? 0 : root.left.val;
        newroot.left = changeval(root.left, level+1, rightval);
        newroot.right = changeval(root.right, level+1, leftval);
        return newroot;
    }

    private void buildmap(TreeNode root, int level) {
        if(root == null) return;
        map.put(level, map.getOrDefault(level, 0) + root.val);
        buildmap(root.left, level+1);
        buildmap(root.right, level+1);
    }
}
