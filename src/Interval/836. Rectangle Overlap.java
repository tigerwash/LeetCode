

/**
 * 836. Rectangle Overlap
 * **/

class Solution {
    // 变相看为 判断两组interval 是否 有overlap
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return overlap(new int[]{ rec1[0], rec1[2] }, new int[]{ rec2[0], rec2[2] })
                && overlap(new int[]{ rec1[1], rec1[3] }, new int[]{ rec2[1], rec2[3] }) ;
    }

    private boolean overlap(int[] a, int[] b) {
        if(a[0] >= b[1] || a[1] <= b[0]){
            return false;
        } else {
            return true;
        }
    }
}