class Solution {
    public int minimumTime(int[] jobs, int[] workers) {
        // greedy,
        Arrays.sort(jobs);
        Arrays.sort(workers);
        int res = 0;
        for(int i = 0; i< jobs.length; i++) {
            int cur = jobs[i]/workers[i] + (jobs[i]%workers[i]==0 ? 0 : 1);
            res = Math.max(cur, res);
        }
        return res;
    }
}