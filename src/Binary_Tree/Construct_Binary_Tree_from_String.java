package Binary_Tree;

/**
 536. Construct Binary Tree from String
看着简单其实不是很好写， 难点在于如何递归的将一层一层的括号分出 左右枝。
 本来想每次扫的时候再判定 左枝和右枝，用substring 来递归，结果写起来很麻烦也不优美。
 现在的方法是一次性撸过去， 每次碰到第一个左括号的时候开始递归进下一层，
 一层一层递归的过程中左枝全被放进了递归树里，那在这同一层里面再出现的 "（" 就
 必定是右枝， 然后再递归。
 整个递归的过程中维护一个 global 的 i 来记录递归的位置。
 * **/
public class Construct_Binary_Tree_from_String {
    int i = 0;
    public TreeNode str2tree(String s) {
        if(i == s.length()) return null;
        char cur = s.charAt(i);
        int sign = 1;
        int n = 40000;
        if(cur == '-'){
            sign = -1;
            i++;
            cur = s.charAt(i);
        }
        TreeNode root = null;
        // get current value
        while(i<s.length() && Character.isDigit(cur)){
            if(n==40000) n = 0;
            n = n *10 + cur-'0';
            i++;
            if(i<s.length()) cur = s.charAt(i);
        }
        // if no current value
        if(n != 40000) root = new TreeNode(n * sign);
        if(i< s.length() && cur == '('){
            i++;
            // left node
            root.left = str2tree(s);
            i++;
            if(i<s.length() && s.charAt(i) == '('){
                i++;
                // right node
                root.right = str2tree(s);
                i++;
            }
        }
        return root;
    }
}
