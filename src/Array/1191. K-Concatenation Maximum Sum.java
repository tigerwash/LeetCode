class Solution {
    // largest subarray sum, 如果 presum < 0 则 cur = 0
    public int kConcatenationMaxSum(int[] arr, int k) {
        long max = Integer.MIN_VALUE;
        long cur = 0;
        long all = 0;
        for(int i = 0; i<arr.length*(k>=2? 2 : 1); i++) {
            cur += arr[i%arr.length];
            if(cur <0) cur = 0;
            max = Math.max(cur, max);
            max %= 1e9+7;
            if(i<arr.length) all += arr[i];
        }

        long midpart = 0;
        if(all > 0 && k > 2){
            midpart = all * (k-2);
        }

        if(k>1){
            return (int)max + (int)(midpart%(1e9+7));
        }else {
            return (int)max;
        }

    }
}