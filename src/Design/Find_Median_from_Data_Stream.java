package Design;

import java.util.PriorityQueue;

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
