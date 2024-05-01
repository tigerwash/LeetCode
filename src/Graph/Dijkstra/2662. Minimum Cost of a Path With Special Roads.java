
/**
 平面上给一堆坐标还有

 **/
class Solution {
    /**
     Time complexity: O(n^2*log(n^2)) where n is the number of special roads
     Space complexity: O(n^2)
     )
     */
    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        PriorityQueue<int[]> q = new PriorityQueue<int[]>((a,b) -> a[2] - b[2]);
        Set<Pair> visited = new HashSet();
        q.offer(new int[]{start[0], start[1], 0});
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if(visited.contains(new Pair(cur[0], cur[1]))) continue;
            visited.add(new Pair(start[0], start[1]));

            if(cur[0]==target[0] && cur[1]==target[1]) {
                return cur[2];
            }

            q.offer(new int[]{target[0], target[1], cur[2]+
                    Math.abs(target[0] - cur[0]) + Math.abs(target[1] - cur[1])});

            for(int[] r : specialRoads) {
                if(!visited.contains(new Pair(r[2], r[3]))) {
                    q.offer(new int[]{r[2], r[3],
                            r[4] + cur[2] + Math.abs(r[0]-cur[0])+ Math.abs(r[1]-cur[1])} );
                }
            }
        }
        return -1;
    }

}