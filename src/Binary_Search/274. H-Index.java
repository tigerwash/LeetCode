class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        // int res = 0;
        // for(int i = citations.length-1;  i>=0; i--) {
        //     int n = citations.length - i;
        //     if(citations[i] >= n){
        //         res = n;
        //     }else{
        //         break;
        //     }
        // }
        int l = 0;
        int r = citations.length-1;
        while(l<r) {
            int mid = (r-l)/2+l;
            int n = citations.length-mid;
            if(citations[mid] >= n) {
                r = mid;
            }else {
                l = mid+1;
            }
        }
        if(citations[l] >= citations.length-l) {
            return citations.length-l;
        }else {
            return citations.length-l -1;
        }
    }
}