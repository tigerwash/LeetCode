package MapPQ;

import java.util.TreeMap;

/**
 729. My Calendar I

 TreeMap 用法
 https://docs.oracle.com/javase/7/docs/api/java/util/TreeMap.html
  用 ceilingKey floor key

 用treemap 存 <start, end>
 注意得在 map 头和尾 放上dummy node。 MAX和MIN 方便计算
 */
public class My_Calendar_I {

    // <start, end>
    TreeMap<Integer, Integer> map;

    public MyCalendar() {
        map = new TreeMap();
        map.put(Integer.MIN_VALUE, Integer.MIN_VALUE);
        map.put(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    public boolean book(int start, int end) {

        if(map.containsKey(start)) return false;
        Integer next = map.ceilingKey(start);
        Integer pre = map.floorKey(start);
        if(map.get(pre) <= start && next >= end){
            map.put(start, end);
            return true;
        }
        return false;
    }
}
