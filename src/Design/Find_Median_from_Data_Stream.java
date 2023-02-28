package Design;

import java.util.PriorityQueue;

/**

 维护两个heap， 一个maxheap 存小与median的值, 一个 minheap 存大于median 的值。
 每次有新值加入的时候，两边的heap balance 一下，（balance 的方法得背）
 永远保证，small 不小于 large。
 最后只要通过输入的个数是单数还是双数来判断是取两侧平均值还是取small 的peek

 **/
public class Find_Median_from_Data_Stream {
    PriorityQueue<Integer> larger;
    PriorityQueue<Integer> smaller;
    public void MedianFinder() {
        larger = new PriorityQueue<Integer>((a,b) -> a -b);
        smaller = new PriorityQueue<Integer>((a,b) -> b-a);
    }

    public void addNum(int num) {
        smaller.offer(num);
        larger.offer(smaller.poll());

        if(larger.size() > smaller.size()){
            smaller.offer(larger.poll());
        }
    }

    public double findMedian() {
        if(larger.size()<smaller.size()){
            return smaller.peek();
        }else{
            return (double)(larger.peek() + smaller.peek())/2;
        }
    }
}
