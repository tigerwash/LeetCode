class Solution {
    public int countOrders(int n) {
        // nums of ways to put Dn, Pn ==> C 2  2n
        // =>   2n * (2n-1) / 2 => n*(2n-1)
        long res = 1;
        for(int i = 2; i<=n; i++) {
            long curway = i*(2*i-1);
            res *= curway;
            res %= (long)(1e9+7);
        }
        return (int)res;
    }
}