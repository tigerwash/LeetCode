package Array;

import java.util.PriorityQueue;

/**
 1405. Longest Happy String

 Input: a = 1, b = 1, c = 7
 Output: "ccaccbcc"

用pq， 把最多count的char append到 sb，如果到上限了的话
就暂时把这个先pop 出来，然后再继续循环
 * */
public class Longest_Happy_String {

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> q = new PriorityQueue<Pair>((m, n) -> n.count - m.count);
        if(a>0) q.offer(new Pair('a', a));
        if(b>0) q.offer(new Pair('b', b));
        if(c>0) q.offer(new Pair('c', c));

        StringBuilder sb = new StringBuilder();
        int ca = 0, cb = 0, cc = 0;
        Pair tmp = null;
        while(!q.isEmpty()){
            if(q.peek().c == 'a'){
                // 如果到达上限，就把它暂时挪出，方便其他char append
                if(ca == 2){
                    tmp = q.poll();
                    continue;
                }
                ca++;
                sb.append('a');
                cb = 0;
                cc = 0;
                Pair p = q.poll();
                if(p.count>1) q.offer( new Pair('a', p.count -1 ));
                // 放入新的 char 后吧tmp重置
                if(tmp != null){
                    q.offer(tmp);
                    tmp = null;
                }

            }else if ( q.peek().c == 'b'  ) {
                if(cb == 2){
                    tmp = q.poll();
                    continue;
                }
                cb++;
                sb.append('b');
                ca = 0;
                cc = 0;
                Pair p = q.poll();
                if(p.count>1) q.offer(new Pair('b', p.count -1));
                if(tmp != null){
                    q.offer(tmp);
                    tmp = null;
                }

            } else if( q.peek().c == 'c' ) {
                if(cc == 2){
                    tmp = q.poll();
                    continue;
                }
                cc++;
                sb.append('c');
                ca = 0;
                cb = 0;
                Pair p = q.poll();
                if(p.count>1) q.offer(new Pair('c', p.count -1));

                if(tmp != null){
                    q.offer(tmp);
                    tmp = null;
                }
            }else {
                break;
            }
        }
        return sb.toString();
    }

    class Pair{
        char c;
        int count;
        Pair(char c , int count){
            this.c = c;
            this.count = count;
        }
    }
}
