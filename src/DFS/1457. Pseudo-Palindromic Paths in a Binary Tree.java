class Solution {
    int count = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        // <int, count>
        Map<Integer, Integer> map = new HashMap();
        dfs(root, map);
        return count;
    }

    private void dfs(TreeNode root, Map<Integer, Integer> map ) {
        if(root == null) return;
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);

        if(root.left == null && root.right == null) {
            int odd = 0;
            for(int key : map.keySet()) {
                if(map.get(key)%2 != 0) odd++;
            }
            if(odd <= 1) count++;
        }
        dfs(root.left, map);
        dfs(root.right, map);
        if(map.get(root.val) == 1) {
            map.remove(root.val);
        }else{
            map.put(root.val, map.get(root.val)-1);
        }

    }
}