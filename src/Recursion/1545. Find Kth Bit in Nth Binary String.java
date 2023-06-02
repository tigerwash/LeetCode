/**
 * 1545. Find Kth Bit in Nth Binary String
 * */
class Solution {
    public char findKthBit(int n, int k) {
        if(n == 1) return '0';
        if(n == 2) return "011".charAt(k-1);
        if(k == (int)Math.pow(2,n-1)){
            return '1';
        } else if(k < (int)Math.pow(2,n-1)) {
            return findKthBit(n-1, k);
        } else {
            int diff = k - (int)Math.pow(2,n-1);
            diff = (int)Math.pow(2,n-1)-1 - diff +1;
            char pre = findKthBit(n-1, diff);
            return pre == '0' ? '1' : '0';
        }
    }
}