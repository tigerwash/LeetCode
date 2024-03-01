class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        // 找到最小的满足 canComplete（） 的time
        long l = 0;
        long r = (long)(1e14);
        while(l<r) {
            long mid = (r-l)/2+l;
            if(canComplete(time, mid, (long)totalTrips)){
                r = mid ;
            }else {
                l = mid+1;
            }
        }
        return l;
    }

    private boolean canComplete(int[] time, long mid, long total) {
        for(int i = 0; i<time.length; i++) {
            total -= mid/time[i];
            if(total <=0) return true;
        }
        return false;
    }
}