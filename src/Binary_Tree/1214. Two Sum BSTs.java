/**
 * 1214. Two Sum BSTs
 * 判断两个树 里面是否各有一个数字使其 之和 等于target
 * 因为是bs tree， 所以每个数字都是不一样的
 * **/

class Solution {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if(root1 == null) return false;
        boolean o = findN(root2, target - root1.val);
        boolean l = twoSumBSTs(root1.left, root2, target);
        boolean r = twoSumBSTs(root1.right, root2, target);
        return o || l || r;

    }

    private boolean findN(TreeNode root, int target) {
        if(root == null) return false;
        if(root.val == target) return true;
        if(root.val > target){
            return findN(root.left, target);
        }else {
            return findN(root.right, target);
        }
    }
}