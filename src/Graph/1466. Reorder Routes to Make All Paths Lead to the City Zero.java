class Solution {
    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<Integer>> map = new HashMap();
        for(int[] c : connections) {
            if(!map.containsKey(c[0])) map.put(c[0], new ArrayList());
            if(!map.containsKey(c[1])) map.put(c[1], new ArrayList());
            map.get(c[0]).add(c[1]);
            map.get(c[1]).add(-c[0]);
        }
        int count = 0;
        Queue<Integer> q = new ArrayDeque();
        Set<Integer> set = new HashSet();
        set.add(0);
        q.offer(0);
        while(!q.isEmpty()) {
            int cur = q.poll();
            List<Integer> neighbors = map.get(cur);
            for(int nb : neighbors) {
                if(set.contains(Math.abs(nb))) continue;
                if(nb > 0) {
                    count++;
                    q.offer(nb);
                }else {
                    q.offer(-nb);
                }
                set.add(Math.abs(nb));
            }
        }
        return count;
    }

    /** DFS 写法  **/
    public int minReorderDFS(int n, int[][] connections) {
        Map<Integer, List<Integer>> map = new HashMap();
        for(int[] c : connections) {
            if(!map.containsKey(c[0])) map.put(c[0], new ArrayList());
            if(!map.containsKey(c[1])) map.put(c[1], new ArrayList());
            map.get(c[0]).add(c[1]);
            map.get(c[1]).add(-c[0]);
        }
        int[] count = new int[]{0};
        Set<Integer> set = new HashSet();
        dfs(map, 0, count, set);

        return count[0];
    }

    private void dfs(Map<Integer, List<Integer>> map, int index, int[] count, Set<Integer> set){

        List<Integer> neighbors = map.get(index);
        for(int nb : neighbors) {
            if(set.contains(Math.abs(nb))) continue;
            if(nb > 0) {
                count[0] = count[0]+1;
            }
            set.add(Math.abs(nb));
            dfs(map, Math.abs(nb), count, set);
        }
        return;
    }

}