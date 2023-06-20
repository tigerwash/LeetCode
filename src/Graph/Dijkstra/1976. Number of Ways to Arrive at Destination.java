

class Solution {
    /**  1976. Number of Ways to Arrive at Destination

     *
     *
     dijkstra 经典， 求到达终点的最短路径一共有几条。
     需要有一个dis[] 记录原点到i 的最短具体，不断更新
     还要有 ways[] 记录到这个点有多少条最短的路径
     */
    public int countPaths(int n, int[][] roads) {
        PriorityQueue<int[]> q = new PriorityQueue<int[]>( (a,b) -> a[1] - b[1] ); // [node, dis]
        int[] dis = new int[n]; // store min dis from i to 0
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;
        int mod = (int)(1e9+7);
        int[] ways = new int[n]; // ways from i to 0 wiht min dis
        ways[0] = 1;
        Map<Integer, List<int[]>> map = new HashMap(); // <star, [neight, cost]>
        for(int[] e : roads) {
            if(!map.containsKey(e[0])) map.put(e[0], new ArrayList());
            map.get(e[0]).add(new int[]{e[1], e[2]});
            if(!map.containsKey(e[1])) map.put(e[1], new ArrayList());
            map.get(e[1]).add(new int[]{e[0], e[2]});
        }

        q.offer(new int[]{0, 0});
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            // visited.add(cur[0]); // dijkstra 不需要visited，因为算距离直接吧重复的路径去掉了
            if(!map.containsKey(cur[0])) continue;
            for(int[] nb : map.get(cur[0])) {
                int curdis = cur[1] + nb[1];
                if(dis[nb[0]] < curdis) continue;
                if(dis[nb[0]] > curdis) {
                    dis[nb[0]] = curdis;
                    ways[nb[0]] = ways[cur[0]];
                    q.offer(new int[]{nb[0], curdis}); // 只有当发现更短的路径的时候才把这个node 放进去，
                    // 同距离的路径不需要放进去，否则会重复计算
                } else if(dis[nb[0]] == curdis) {
                    ways[nb[0]] = (ways[nb[0]] + ways[cur[0]])%mod;
                }
                // q.offer(new int[]{nb[0], curdis});
            }
        }
        return ways[n-1];
    }

}