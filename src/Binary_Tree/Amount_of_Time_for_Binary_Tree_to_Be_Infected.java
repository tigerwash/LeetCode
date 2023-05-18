package Binary_Tree;

/**
 2385. Amount of Time for Binary Tree to Be Infected

 求 tree 中 某一个node start 到任何 leaf 的最长距离
 * */
public class Amount_of_Time_for_Binary_Tree_to_Be_Infected {

    int max = 0;
    public int amountOfTime(TreeNode root, int start) {
        helper(root, start);
        return max;
    }
    // return depth to 'leaf' if it's child not contains start
    // return -depth to 'start' if it's child has start
    private int helper(TreeNode root, int start) {
        if(root == null) return 0;
        int left = helper(root.left, start);
        int right = helper(root.right, start);
        // meet start
        if(root.val == start) {
            max = Math.max(left, right);
            return -1;
            // start not in child
        }else if(left >= 0 && right >= 0) {
            return Math.max(left, right) + 1;
        }else {  // one has leaf, one has start. return the -one
            max = Math.max(max, Math.abs(left - right));
            return Math.min(left, right) -1; // 找到小于0 的， 然后让他的绝对值 + 1，那就是 负数-1
        }
    }
}
