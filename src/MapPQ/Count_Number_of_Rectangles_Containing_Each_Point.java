package MapPQ;

import java.util.*;

/**
 2250. Count Number of Rectangles Containing Each Point
contest 290

 给一堆坐标，每个坐标代表他和原点左组成的矩形， 再给一堆点堆坐标， 求这对点在矩形里面各定住了几个矩形

 基本思路从题干堆取值范围找到： x <-[0,10^9], y<-[0, 100]
 由此可想到可以用y 值为key 构建 x list 的 map，
 map<y, list of x in sorted order>
 对于每一个point， 我们便利所有比他大的 y， 然后bianryseach  找到每个y里面比他大的x
 求和。
 * **/


public class Count_Number_of_Rectangles_Containing_Each_Point{

    // bianry search 比 treeset 快5倍左右
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        // map 存 <出现过的 y 坐标， 这个y坐标上所有的x>， 根据题干范围可知 　key size <= 100
        Map<Integer, List<Integer>> map = new HashMap();
        // buid map
        for(int[] p : rectangles){
            if(!map.containsKey(p[1])){
                map.put(p[1], new ArrayList<Integer>());
            }
            map.get(p[1]).add(p[0]);
        }
        // keylist 存y轴上出过的所有坐标，为key
        List<Integer> keylist = new ArrayList();

        // sort x val for each x
        for(int k : map.keySet()){
            Collections.sort(map.get(k));
            keylist.add(k);
        }
        // sort key list
        Collections.sort(keylist);

        int[] res = new int[points.length];
        for(int i = 0; i< points.length; i++){
            int[] p = points[i];
            // 从大到小遍历每一个比她大的纵坐标，对于每一个纵坐标对应的 x list， 二分查找目标x坐标的 ceiling
            // 那么 大等于ceiling的所有数都是满足条件的
            for(int j = keylist.size()-1; j>= 0 && keylist.get(j) >= p[1]; j--){
                int ceilingindex = binarysearch(map.get(keylist.get(j)), p[0]);

                if(ceilingindex != -1){
                    res[i] += map.get(keylist.get(j)).size() - ceilingindex ;
                }
            }
        }
        return res;
    }

    // find ceiling . which is the smaller larger or equal
    private int binarysearch(List<Integer> list, int target){
        int l = 0;
        int r = list.size()-1;
        while(l<r){
            int mid = (r-l)/2+l;
            if(list.get(mid) < target){
                l = mid+1;
            }else{ // >= target
                r = mid;
            }
        }
        if(list.get(l) < target) return -1;
        return l;
    }

    /**  TreeSet 解法 TTL  **/
    public int[] countRectangles_TreeSet_Solution(int[][] rectangles, int[][] points) {
        TreeSet<Integer> keyset = new TreeSet();
        Map<Integer, TreeSet<Integer>> map = new HashMap();
        for(int[] p : rectangles){
            if(!map.containsKey(p[1])){
                map.put(p[1], new TreeSet<Integer>());
                keyset.add(p[1]);
            }
            map.get(p[1]).add(p[0]);
        }
        List<Integer> keylist = new ArrayList<Integer>(keyset);
        int[] res = new int[points.length];
        for(int i = 0; i< points.length; i++){
            int[] p = points[i];
            for(int j = keylist.size()-1; j>= 0 && keylist.get(j) >= p[1]; j--){
                TreeSet l_list = map.get(keylist.get(j));
                int size = l_list.size();
                Integer ceiling = (Integer)l_list.ceiling(p[0]);

                if( ceiling != null){
                    int curindex = indexOf(l_list, ceiling);
                    res[i] += size - curindex ;
                }
            }
        }
        return res;
    }

    private int indexOf(TreeSet<Integer> set, Integer i){
        List<Integer> list = new ArrayList<Integer>(set);
        return list.indexOf(i);
    }

}
