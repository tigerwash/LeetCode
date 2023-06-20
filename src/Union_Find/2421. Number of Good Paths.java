import java.util.*;

/** 2421. Number of Good Paths
 * **/

class UnionFind {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {}

}


/** 用hashmap + bfs 结果 123 / 134 testcases passed
 剩下的test 超时   O(n^2)
 **/
class HashMapBFS {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        Map<Integer, List<Integer>> map = new HashMap();
        for(int[] e : edges) {
            if(!map.containsKey(e[0])) map.put(e[0], new ArrayList());
            if(!map.containsKey(e[1])) map.put(e[1], new ArrayList());
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }

        // <val, set[node]>
        Map<Integer, Set<Integer>> valmap = new HashMap();
        for(int i = 0; i<n; i++) {
            if(!valmap.containsKey(vals[i])) {
                valmap.put(vals[i], new HashSet());
            }
            valmap.get(vals[i]).add(i);
        }

        int res = 0;
        for(int val : valmap.keySet()) {
            if(valmap.get(val).size() > 1) {
                int cur = findPairs(map, valmap.get(val), val, vals);
                res += cur;
            }
        }
        return res + n;
    }

    // find pairs that forms a good path within nodes with same val.
    private int findPairs(Map<Integer, List<Integer>> map, Set<Integer> nodes, int maxval, int[] vals) {
        int res = 0;
        Set<Integer> formed = new HashSet(); // store the node alread formed
        // set every node as start and then bfs
        for(int start : nodes) {
            formed.add(start);
            int pair = bfs(map, start, nodes, vals, formed);
            res += pair;
        }
        return res;
    }

    private int bfs(Map<Integer, List<Integer>> map, int start, Set<Integer> nodes, int[] vals, Set<Integer> formed) {
        Queue<Integer> q = new ArrayDeque();
        Set<Integer> visited = new HashSet();
        q.offer(start);
        int maxval = vals[start];
        int count = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            visited.add(cur);
            List<Integer> children = map.get(cur);
            for(int child : children) {
                if(!visited.contains(child) && vals[child] <= maxval){
                    if(nodes.contains(child) && !formed.contains(child)) count++;
                    q.offer(child);
                }
            }
        }
        return count;
    }
}