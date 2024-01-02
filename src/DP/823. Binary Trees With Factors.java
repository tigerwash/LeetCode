import java.util.*;

class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        /***
         DP equation:
         dp[i] = sum(dp[j] * dp[i / j])
         res = sum(dp[i])
         with i, j, i / j in the list L

         dp[i] ==> ways of arr[i] as root
         */

        Arrays.sort(arr);
        Set<Integer> set = new HashSet();
        Map<Integer, Integer> map = new HashMap();
        long[] dp = new long[arr.length];
        Arrays.fill(dp, 1);
        long res = 0;
        for(int i = 0; i<arr.length; i++) {
            map.put(arr[i], i);
            for(int j=0; j<= i; j++ ) {
                if(arr[i] % arr[j]==0 && map.containsKey(arr[i]/arr[j])) {
                    dp[i] += dp[j] * dp[map.get(arr[i]/arr[j])];
                }
            }
            res += dp[i];
            res %= (long)1e9 + 7;
        }
        return (int)res;
    }
}