class Solution {
/*
最主要hint 是Bob 到0 的时间和路线是唯一的，那么我们只要记录bob 到达0
的路径上每个点的 time， 然后让他跟Alice 达到这个点的时间相对比，一次来计算value
先dfs 算Bob 的路径和时间，存进 Bpath
再dfs 让Alice traverse 整个graph， 记录时间和value， 到达leaf的时候比较最大时间。
 */

    int max = Integer.MIN_VALUE;
    Map<Integer, Integer> Bpath = new HashMap();
    int Btime = 0;
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        Map<Integer, List<Integer>> map = new HashMap();
        for(int[] e : edges) {
            if(!map.containsKey(e[0])) map.put(e[0], new ArrayList());
            if(!map.containsKey(e[1])) map.put(e[1], new ArrayList());
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        Set<Integer> visited = new HashSet();
        Map<Integer, Integer> path = new HashMap();
        findBpath(map, bob, path, visited, 0);
        Btime = Bpath.size();

        System.out.print(Bpath);
        Set<Integer> set = new HashSet();
        dfs(map, Bpath, 0, set, 0, 0, amount);
        return max;
    }
    // Bob dfs 算出他的路径和相应时间
    private void findBpath(Map<Integer, List<Integer>> map, int cur, Map<Integer, Integer> path, Set<Integer> visited, int time) {

        if(cur == 0) {
            path.put(0, time);
            Bpath = new HashMap(path);
            return;
        }
        List<Integer> next = map.get(cur);
        visited.add(cur);
        path.put(cur, time);
        for(int n : next) {
            if(!visited.contains(n)) {
                findBpath(map, n, path, visited, time+1);
            }
        }
        path.remove(cur);
        return;
    }
    // 算 alice 的路径和value 以及时间
    private void dfs(Map<Integer, List<Integer>> map, Map<Integer, Integer> Bpath, int cur, Set<Integer> visited, int val, int time, int[] amount) {
        if(Bpath.containsKey(cur) ) {
            if(Bpath.get(cur) == time) {
                val += amount[cur] / 2;
            } else if(Bpath.get(cur) > time) {
                val += amount[cur];
            }
        }else {
            val += amount[cur];
        }

        if(map.get(cur).size()==1 && visited.contains(map.get(cur).get(0))) {
            max = Math.max(max, val);
            return;
        }
        visited.add(cur);
        List<Integer> next = map.get(cur);
        for(int n : next) {
            if(visited.contains(n)) continue;
            dfs(map, Bpath, n, visited, val, time+1, amount);
        }
        visited.remove(cur);
        return;
    }
}