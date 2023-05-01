package Array;

import java.util.Arrays;

/**
 2405. Optimal Partition of String
 题目要求将一个string 切成尽可能少的段，每一段各个char 都是不重复的

 思路是用一个map 记录每个char 最后出现的位置，每次发现一个重复的char
 就说明需要切出来一个新的字段，那么把之前记录的所有char 都归位初始值 -1
 同时 res++
 *
 * **/
public class Optimal_Partition_of_String {
    public int partitionString(String s) {
        // map[idx] the last apprance index
        int[] map = new int[26];
        Arrays.fill(map, -1);
        int res = 0;
        for(int i = 0; i< s.length(); i++){
            char cur = s.charAt(i);
            if(map[cur-'a'] != -1){
                res++;
                // upldate all char
                Arrays.fill(map, -1);
            }
            map[cur-'a'] = i;
        }
        return res+1;
    }
}
