/**
 * 1136. Parallel Courses
 *
 *
 * 找到最长的path
 * **/

class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        // dfs find longest root-leaf path
        Map<Integer, List<Integer> > map = new HashMap();
        // [pre, next]
        // map<pre, [child]>
        for(int[] e : relations) {
            if(!map.containsKey(e[0])) map.put(e[0], new ArrayList());
            map.get(e[0]).add(e[1]);
        }

        boolean[] visited = new boolean[n+1];
        int[] depth = new int[n+1];
        int max = 0;
        for(int i : map.keySet()) {
            int path = dfs(map, visited, i, depth);
            if(path == -1) return -1;
            max = Math.max(path, max);
        }
        return max;
    }

    private int dfs(Map<Integer, List<Integer>> map, boolean[] visited, int index, int[] depth) {
        if(visited[index]) return -1;
        int max = 0;
        if(depth[index] > 0 ) return depth[index];

        visited[index] = true;
        if(map.containsKey(index)) {
            for(int child : map.get(index)) {
                int curmax = dfs(map, visited, child, depth);
                if(curmax == -1) return -1;
                max = Math.max(curmax, max);
            }
        }
        depth[index] = max+1;
        visited[index] = false;
        return depth[index];
    }
}