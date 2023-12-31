class Solution {
    // 先用 indegree 查一下有没有多个树，找到root，
    // 除了一个edgecase 就是既有环，且还有一个好树
    // 然后按root 进行dfs/bfs 找是否有环
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] indegree = new int[n];
        for(int i = 0; i< n; i++){
            int nextL = leftChild[i];
            int nextR = rig
            htChild[i];
            if(nextL != -1) {
                indegree[nextL]++;
                if(indegree[nextL]>1) return false;
            }
            if(nextR != -1) {
                indegree[nextR]++;
                if(indegree[nextR]>1) return false;
            }
        }
        Queue<Integer> q = new ArrayDeque();
        for(int i = 0; i<n; i++) {
            if(indegree[i]==0) q.offer(i);
        }
        if(q.size()!=1) return false;

        // 好有一种情况没有查到，就是一个环 + 一个树。
        Set<Integer> visited = new HashSet();
        visited.add(q.peek());
        return dfs(visited, q.poll(), leftChild, rightChild) && visited.size() == n;
        // return true;
    }

    private boolean dfs(Set<Integer> visited, int i, int[] leftChild, int[] rightChild) {
        if(leftChild[i]==-1 && rightChild[i]==-1) return true;
        boolean left = true;
        boolean right = true;
        if(leftChild[i]!=-1) {
            if(visited.contains(leftChild[i])){
                return false;
            }else {
                visited.add(leftChild[i]);
                left = dfs(visited, leftChild[i], leftChild, rightChild);
            }
        }
        if(rightChild[i]!=-1) {
            if(visited.contains(rightChild[i])){
                return false;
            }else {
                visited.add(rightChild[i]);
                right = dfs(visited, rightChild[i], leftChild, rightChild);
            }
        }
        return left && right;
    }
}