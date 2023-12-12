class Solution {
    // 对于他每个位置 我都记录他左边的最近的 ｜ 和右边最近的 ｜ 的位置
    // 然后也用一个 count 记录 [0, i] 上到底有多少个 ｜ 出现过，方便后面直接去除
    // 最后 就是 lastCandle - firstCandle - numOfCandle
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[][] candlePos = new int[s.length()][2];
        int left = -1;
        int right = -1;
        int[] count = new int[s.length()]; // c[i]: num of candles in [0, i]
        for(int i = 0; i<s.length(); i++) {
            int j = s.length() -1 - i;
            if(s.charAt(i)=='|'){
                left = i;
            }
            if(s.charAt(j) =='|'){
                right = j;
            }
            // get candle count
            if(s.charAt(i)=='|'){
                count[i] += i==0? 1 : count[i-1]+1;
            }else{
                count[i] = i==0? 0 : count[i-1];
            }
            candlePos[i][0] = left;
            candlePos[j][1] = right;
        }

        int[] res = new int[queries.length];
        for(int i = 0; i<queries.length; i++){
            int start = queries[i][0];
            int end = queries[i][1];
            int firstCandle = candlePos[start][1];
            int lastCandle = candlePos[end][0];
            if(firstCandle == -1 || lastCandle == -1 || firstCandle>=lastCandle){
                res[i] = 0;
            }else{
                int cnt = count[end] - (start>0? count[start-1] : 0);
                int len = lastCandle - firstCandle + 1;
                res[i] = len - cnt;
            }
        }
        return res;
    }
}