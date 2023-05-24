package Graph;

import java.util.*;

/**
 2642. Design Graph With Shortest Path Calculator

 standard Dijkstra question
 用一个priorityqueue 进行bfs
 * */
public class Design_Graph_With_Shortest_Path_Calculator {

    // <from, [[to, cost]] >
    Map<Integer, List<int[]>> map = new HashMap();
    public Graph(int n, int[][] edges) {
        map = new HashMap();
        for(int[] e : edges) {
            addEdge(e);
        }
    }
    // edge = [from, to, edgeCost]
    public void addEdge(int[] edge) {
        if(!map.containsKey(edge[0])) {
            map.put(edge[0], new ArrayList());
        }
        map.get(edge[0]).add(new int[]{edge[1], edge[2]});
    }

    // standard Dijkstra question
    public int shortestPath(int node1, int node2) {
        // [city, total cost]
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> a[1] - b[1]);
        pq.offer(new int[]{node1, 0});
        Set<Integer> set = new HashSet();
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[1];
            if(cur[0] == node2) return cost;
            set.add(cur[0]);
            if(!map.containsKey(cur[0])) continue;
            for(int[] nb : map.get(cur[0])) {
                if(set.contains(nb[0])) continue;
                pq.add(new int[]{nb[0], cost + nb[1]});

            }
        }
        return -1;
    }
}
