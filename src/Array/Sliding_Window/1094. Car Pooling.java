class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // similar to max meeting rooms needed 253. Meeting Rooms II. 对开头和结尾建立node 进行sort
        // start node 遇到时++ 人数， end node 遇到时 --。
        // [num, time, start/end] -- start:0, end: 1
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
                (a,b) -> a[1]==b[1]? b[2]-a[2] : a[1] - b[1]
        ); // 当时间相同时，end node 排在前面先出来
        for(int[] t : trips) {
            pq.offer(new int[]{t[0], t[1], 0});
            pq.offer(new int[]{-t[0], t[2], 1});
        }

        int used = 0;
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            used += cur[0];
            if(used<0 || used > capacity) return false;
        }
        return true;
    }
}