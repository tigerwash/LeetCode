/**
 * 1057. Campus Bikes
 * **/

class Solution {
    /**
     虽然看着像bfs，其实是一个简单的排序问题。因为各个点的坐标都是已知的
     建立一个pq， 依次以[dis, work, bike] 排序，
     然后穷举 把所有的可能性都放进pq 里面进行排序，然后依次pop（） ， filter 掉已经访问过的
     **/
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        // [dis, work, bike]
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                if(a[0] == b[0]) {
                    if(a[1] == b[1]){
                        return a[2] - b[2];
                    }else {
                        return a[1] - b[1];
                    }
                }else {
                    return a[0] - b[0];
                }
            }
        });

        for(int i = 0; i< workers.length; i++) {
            for(int j = 0; j<bikes.length; j++) {
                int dis = getDistance(workers[i], bikes[j]);
                pq.offer(new int[]{dis, i, j});
            }
        }

        Set<Integer> workerset = new HashSet();
        Set<Integer> bikeset = new HashSet();
        int[] res = new int[workers.length];
        int count = 0;
        while(count<workers.length) {
            int[] cur = pq.poll();
            if(workerset.contains(cur[1]) || bikeset.contains(cur[2])) continue;
            res[cur[1]] = cur[2];
            workerset.add(cur[1]);
            bikeset.add(cur[2]);
            count++;
        }
        return res;
    }

    private int getDistance(int[] a, int[] b) {
        return Math.abs(a[0]-b[0]) + Math.abs(a[1]-b[1]);
    }
}