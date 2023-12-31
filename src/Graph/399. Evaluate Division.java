class Solution {
    /***
     给你 a / b = ? 等一堆等式的结果， 叫你求 a/k =？
     其实就是一个graph 题， 看能不能找到路径从start一直搭到target，
     可以用dfs 也可以用bfs，就是bfs 的时候有点像是买机票，需要一直维护到当前节点的计算结果，
     所以node 是一个 <string, val> pair

     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap();
        for(int i = 0; i<equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            if(!map.containsKey(a)) {
                map.put(a, new HashMap<String, Double>());
                map.get(a).put(a, 1.0);
            }
            if(!map.containsKey(b)) {
                map.put(b, new HashMap<String, Double>());
                map.get(b).put(b, 1.0);
            }
            Map<String, Double> childA = map.get(a);
            Map<String, Double> childB = map.get(b);
            childA.put(b, values[i]);
            childB.put(a, 1/values[i]);
            map.put(a, childA);
            map.put(b, childB);
        }

        double[] res = new double[queries.size()];
        for(int i = 0; i<queries.size(); i++) {
            List<String> query = queries.get(i);
            // res[i] = computeBFS(map, query);
            res[i] = computeDFS(map, query);
        }
        return res;
    }

    /*** BFS 写法 */
    class Pair {
        String key;
        double val;
        Pair(String key, double val ){
            this.key = key;
            this.val = val;
        }
    }

    private double computeBFS(Map<String, Map<String, Double>> map, List<String> query) {
        String start = query.get(0);
        String end = query.get(1);
        Set<String> set = new HashSet();
        if(!map.containsKey(start) || !map.containsKey(end)) return -1.0;
        Queue<Pair> q = new ArrayDeque();
        q.offer(new Pair(start, 1.0));
        while(!q.isEmpty()) {
            Pair cur = q.poll();
            set.add(cur.key);
            Map<String, Double> children = map.get(cur.key);
            for(String child : children.keySet()) {
                if(child.equals(end)){
                    return cur.val * children.get(child);
                }
                if(set.contains(child)) continue;
                q.offer(new Pair(child, cur.val * children.get(child)));
            }
        }
        return -1.0;
    }

    /****。DFS 写法 */
    private double computeDFS(Map<String, Map<String, Double>> map, List<String> query){
        String start = query.get(0);
        String end = query.get(1);
        Set<String> set = new HashSet();
        if(!map.containsKey(start) || !map.containsKey(end)) return -1.0;
        return dfs(map, start, end, set, 1.0);
    }

    private double dfs(Map<String, Map<String, Double>> map,
                       String cur, String target, Set<String> set, double curval){
        if(target.equals(cur)) return curval;
        Map<String, Double> children = map.get(cur);
        set.add(cur);
        for(String child : children.keySet()) {
            if(set.contains(child)) continue;
            double val = dfs(map, child, target, set, curval * children.get(child));
            if(val != -1.0) return val;
        }
        return -1.0;
    }
}