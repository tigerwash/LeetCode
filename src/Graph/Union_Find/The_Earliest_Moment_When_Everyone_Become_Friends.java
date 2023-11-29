package Graph.Union_Find;

import java.util.Arrays;

/**
 1101. The Earliest Moment When Everyone Become Friends

 给一堆log【time, a, b】来表示 a 和b 成为好友的时间，求所有人都再这个graph 里面的最小时间
 其实就是先 按时间 sort 一下 log， 然后求出练了 n - 1 个edge 时的那个时间
 **/
public class The_Earliest_Moment_When_Everyone_Become_Friends {

    public int earliestAcq(int[][] logs, int n) {
        int[] map = new int[n];
        for(int i = 0; i< n; i++) map[i] = i;
        Arrays.sort(logs, (a, b) -> a[0] - b[0]);
        int[][] test = logs;
        int count = 0;
        for(int[] log: logs){
            int a = log[1];
            int b = log[2];
            int time = log[0];
            int roota = find(map, a);
            int rootb = find(map, b);
            if(roota != rootb){
                map[roota] = rootb;
                count++;
                if(count == n-1) return time;
            }
        }
        return -1;
    }

    private int find(int[] map, int a){
        while(map[a] != a){
            a = map[a];
        }
        return a;
    }
}
