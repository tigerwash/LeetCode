package Binary_Tree;

// 513. Find Bottom Left Tree Value

public class Find_Bottom_Left_Tree_Value {
    // [val, level, hori_pos]
    int[] res;
    public int findBottomLeftValue(TreeNode root) {
        res = new int[]{root.val, 0,0};
        inorder(root, 0, 0);
        return res[0];
    }

    private void inorder(TreeNode root, int level, int pos){
        if(root == null) return;
        inorder(root.left, level+1, pos-1);
        if(level > res[1]){
            res = new int[]{root.val, level, pos};
        }else if(level == res[1] && pos < res[2]){
            res = new int[]{root.val, level, pos};
        }
        inorder(root.right, level+1, pos+1);
    }
}
