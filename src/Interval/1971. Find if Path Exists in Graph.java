/**
 1971. Find if Path Exists in Graph

classic Union find
* ***/

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] map = new int[n];
        for(int i = 0; i<n; i++) map[i] = i;
        for(int[] e : edges) {
            int a = find(map, e[0]);
            int b = find(map, e[1]);
            if(a != b) {
                map[a] = b;
            }
        }
        return find(map, source) == find(map, destination);
    }

    private int find(int[] map, int i) {
        while(map[i] != i) i = map[i];
        return i;
    }

}