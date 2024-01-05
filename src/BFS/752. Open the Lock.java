class Solution {
    public int openLock(String[] deadends, String target) {
        /** 单向bfs  */
        // classic bfs, 主要优化方向在于 怎么样在string上直接 +-1
        // 这里用： sb.setCharAt(j, (c=='9' ? '0' : (char)(c + 1)));
        Queue<String> q = new ArrayDeque();
        Set<String> set = new HashSet();
        for(String s : deadends) set.add(s);
        if(set.contains("0000")) return -1;
        q.offer("0000");
        set.add("0000");
        int res = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i<size; i++){
                String cur = q.poll();
                if(cur.equals(target)) return res;

                for(int j = 0; j< 4; j++) {
                    StringBuilder sb = new StringBuilder(cur);
                    char c = cur.charAt(j);
                    sb.setCharAt(j, (c=='9' ? '0' : (char)(c + 1)));
                    String str1 = sb.toString();
                    sb.setCharAt(j, (c=='0' ? '9' : (char)(c - 1)));
                    String str2 = sb.toString();
                    if(!set.contains(str1)){
                        q.offer(str1);
                        set.add(str1);
                    }
                    if(!set.contains(str2) ){
                        q.offer(str2);
                        set.add(str2);
                    }
                }
            }
            res++;
        }
        return -1;
    }
}