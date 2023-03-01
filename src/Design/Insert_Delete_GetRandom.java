package Design;

import java.util.*;

/**
 较简单的设计题： 同时使用一个hashmap和list；
 list 用于储存所有的value，用于和rand.nextInt(size) 结合输出随机数。
 map用于储存(val， index) 便于确认是否存在这个数，然后必要时通过他的index 去list中删除。
 此题唯一有点麻烦的是当删除中间某个值的时候，为了保持所有后面的值index(存map里了)保持不变，
 可将最后一个数放到被删的地方上，然后删除末尾，最后更新map中这个值就好。

 知识点： 注意使用rand.nextInt(size)  输出随机
 **/

public class RandomizedSet {
    /** Initialize your data structure here. */
    int size = 0;
    Map<Integer, Integer> map;
    Random rand = new Random();
    List<Integer> list;
    public RandomizedSet() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        } else{ //add the new node at the end
            map.put(val, size);
            list.add(val);
            size++;
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)){
            //move the target value, and move the last element in the list to fill the gap
            //thus the rest elements keep the original order
            list.set(map.get(val), list.get(size-1));
            map.put(list.get(size-1), map.get(val));//update the new removed gap
            list.remove(size-1);
            size--;
            map.remove(val); //remove the val 注意这一步只能放在最后
            return true;
        }else{
            return false;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(size));
    }
}
