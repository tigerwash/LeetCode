/**
 * 223. Rectangle Area
 * 求两个矩形合起来的面积  与 836 类似
 * **/

class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        // similar to interval
        if(ax1 > bx2 || ax2 < bx1 || ay1 > by2 || ay2 < by1)
            return (ax2 - ax1)*(ay2 - ay1) + (bx2 - bx1)*(by2 - by1);

        int left = Math.max(ax1, bx1);
        int right = Math.min(ax2, bx2);
        int up = Math.min(ay2, by2);
        int down = Math.max(ay1, by1)''

        int overlap = (right - left) * (up - down);

        return  (ax2 - ax1)*(ay2 - ay1) + (bx2 - bx1)*(by2 - by1) - overlap;
    }
}