class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        // 以nums1 维护一个size min pq, 同时sort nums2 大到小，
        // 保证每次加进 集合里面的 n2 都是最小值
        int[][] pairs = new int[nums1.length][2];
        for(int i = 0; i< nums1.length; i++) {
            pairs[i] = new int[]{nums1[i], nums2[i]};
        }
        Arrays.sort(pairs, (a, b)-> b[1]-a[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a,b) -> a-b);
        long sum = 0;
        long max = 0;
        for(int i = 0; i<nums1.length; i++) {
            sum += pairs[i][0];
            int min = pairs[i][1];
            pq.offer(pairs[i][0]);
            if(pq.size() > k) {
                sum -= pq.poll();
            }
            if(pq.size() == k) max = Math.max(max, (long)min * (long)sum);
        }
        return max;
    }
}