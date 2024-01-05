class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList();
        for(int i = 1; i<=n; i++) list.add(i);
        int cur = 0;

        while(list.size()>1) {
            int len = list.size();
            // int remove = list.get((cur+k-1)%len);
            list.remove( (cur+k-1)%len );
            cur = (cur + k -1)%len;
            cur %= list.size();
        }
        return list.get(0);
    }

    /***
     public int findTheWinner(int n, int k) {
     return helper(n,k)+1;
     }
     public int helper(int n,int k){
     if(n==1)
     return 0;
     else
     return (helper(n-1,k)+k)%n;
     }

     */
}