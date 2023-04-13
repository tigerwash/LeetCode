package Binary_Search;

/**
 1533. Find the Index of the Large Integer

 **/

public class Find_the_Index_of_the_Large_Integer {

    public int getIndex(ArrayReader reader) {
        // l...r x...y
        int len = reader.length();
        int l = 0;
        int y = len -1;
        int compare = 0;
        while(l < y){
            int mid = (y-l)/2+l;
            // even 2,2
            if ((y-l)%2 == 1){
                // left : l -- mid ; right: mid+1 -- y
                compare = reader.compareSub(l, mid, mid+1, y);
                if(compare > 0){
                    y = mid;
                }else{
                    l = mid +1;
                }
                // odd 2, 1, 2
            }else {
                // left : l -- mid-1 ; right: mid+1 -- y
                compare = reader.compareSub(l, mid-1, mid+1, y);
                if(compare == 0) return mid;
                if(compare > 0){
                    y = mid-1;
                }else {
                    l = mid+1;
                }
            }
        }
        return l;
    }
}
