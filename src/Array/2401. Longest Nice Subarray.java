package Array;
/**
 *
 2401. Longest Nice Subarray

Sliding window、
 ......l ..... r...
 l - r 之间是nice

 *
 * */
public class Longest_Nice_Subarray {

    /***   直接用java 自带的 bit 操作 **/
    public int longestNiceSubarray(int[] nums) {
        int window = 0;
        int l = 0;
        int r = 0;
        int res = 0;
        while(r < nums.length) {
            while(l<r && (nums[r] & window) != 0) {
                window = window ^ nums[l++];
            }
            window |= nums[r++];
            res = Math.max(res, r-l);
        }
        return res;
    }


    /*** 我的 笨办法， bit 操作都用 boolean[] 来表示 **/
    public int longestNiceSubarray1(int[] nums) {
        boolean[] map = new boolean[32];
        int res = 0;
        int f = 0;
        int s = 0;
        // sliding window
        //  s->  f->
        while(f < nums.length) {
            int cur = nums[f];
            // get binary array of cur
            boolean[] curmap = getbinary(cur);
            // check if it is nice
            boolean nice = isnice(map, curmap);

            // if not nice, then s ++, and remove it from map
            while(s < f && !nice) {
                boolean[] toremove = getbinary(nums[s]);
                // remove n[s]
                for(int j = 0; j<32; j++) {
                    if(map[j] && toremove[j])
                        map[j] = false;
                }
                nice = isnice(map, curmap);
                s++;
            }

            // if it is nice, then update map
            for(int j = 0; j<32; j++) {
                map[j] = map[j] || curmap[j];
            }

            f++;
            res = Math.max(res, f-s );
        }
        return res;
    }

    private boolean[] getbinary(int cur) {
        boolean[] curmap = new boolean[32];
        int i = 0;
        while(i<32 && cur >0) {
            curmap[i] = (cur & 1) == 1;
            cur = cur>>1;
            i++;
        }
        return curmap;
    }

    private boolean isnice(boolean[] map, boolean[] curmap) {
        for(int j = 0; j<32; j++){
            if(curmap[j] && map[j]) {
                return false;
            }
        }
        return true;
    }
}
