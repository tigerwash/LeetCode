class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        /*** 遍历整个tasks， 用map 记载每种task最后执行的时间，
         res = Math.max(res, map.get(cur) + space) + 1;
         不断更新res */
        Map<Integer, Long> map = new HashMap(); // <key, last time of excute >
        long res = 0;
        for(int i = 0; i<tasks.length; i++) {
            int cur = tasks[i];
            if(map.containsKey(cur)) {
                res = Math.max(res, map.get(cur) + space) + 1;
                map.put(cur, res);
            } else {
                res++;
                map.put(cur, res);
            }
        }
        return res;
    }
}