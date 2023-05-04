package Recursion;

/**
 339. Nested List Weight Sum

 递归法： 新建一个helper 函数，每次碰到int 就乘以level，否则level++进入下一个递归
 bfs:  对于每个node，如果是int 就乘以level 加进res，否则就得到list 放进 queue里，
       每层bfs level++

 */

public class Nested_List_Weight_Sum {

  /** 方法1： recrusion:  */
    public int depthSum(List<NestedInteger> nestedList) {
        int res = 0;
        for(NestedInteger n : nestedList){
            res += getval(n,1);
        }
        return res;
    }

    private int getval(NestedInteger ni, int level){
        if(ni.isInteger()) return ni.getInteger()*level;
        int res = 0;
        for(NestedInteger n : ni.getList()){
            res += getval(n, level+1);
        }
        return res;
    }

    /**  方法2：   BFS    */
    public int depthSum(List<NestedInteger> nestedList) {
        Queue<NestedInteger> q = new ArrayDeque();
        for(NestedInteger n : nestedList) q.offer(n);
        int res = 0;
        int level = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                NestedInteger cur = q.poll();
                if(cur.isInteger()){
                    res += cur.getInteger()*level;
                }else{
                    List<NestedInteger> newlist = cur.getList();
                    for(NestedInteger n : newlist) q.offer(n);
                }
            }
            level++;
        }
        return res;
    }
}

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */