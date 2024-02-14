package MapPQ;

import java.util.*;

/**
 * 2593. Find Score of an Array After Marking All Elements
 * 每次选最小的值，加进 res， 同时把他旁边两个数标记上，标记了的位置不能再被访问
 * 求最后的和
 *
 * 方法就是件一个treemap<val, idx queue> 存sort 好的每个数以及他的idx
 * 一个一个的遍历， 然后用一个set<idx> 来进行标记，set 里面有的就说明还没访问到
 * 访问到的就remove
 *
 * */
public class Find_Score_of_an_Array_After_Marking_All_Elements {
    public long findScore(int[] nums) {
        long res = 0;
        TreeMap<Integer, Queue<Integer>> map = new TreeMap();
        Set<Integer> set = new HashSet();
        for(int i = 0; i< nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], new ArrayDeque());
            }
            map.get(nums[i]).add(i);
            set.add(i);
        }
        for(int val : map.keySet()){
            Queue curq = map.get(val);
            while(!curq.isEmpty()){
                int idx = (int)curq.poll();
                if(set.contains(idx)){
                    set.remove(idx);
                    res += val;
                    set.remove(idx+1);
                    set.remove(idx-1);
                }
            }
        }
        return res;
    }

}
