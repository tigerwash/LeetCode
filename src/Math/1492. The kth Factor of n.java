class Solution {
    public int kthFactor(int n, int k) {
        /*** O(n) */
        // int i = 1;
        // while(i<=n ) {
        //     if(n%i==0){
        //         k--;
        //     }
        //     if(k == 0) return i;
        //     i++;
        // }

        /*** O(sqrt N) */
        // 两个list，一边存小于root， 一边存大于root
        List<Integer> small = new ArrayList();
        List<Integer> large = new ArrayList();
        int cnt = k;
        for(int i = 1; i<= Math.sqrt(n); i++) {
            if(n%i==0) {
                small.add(i);
                if(i!=Math.sqrt(n))
                    large.add(n/i);
                cnt--;
                if(cnt==0) return i;
            }
        }
        if(small.size() + large.size() <k) return -1;
        // large 是从大到小排的，所以就取倒数第cnt个
        return large.get(large.size() - cnt);
    }
}