import java.util.*;

/**
 * 895. Maximum Frequency Stack
 * */
class FreqStack {
    Map<Integer, Integer> map; // count
    Map<Integer, Stack<Integer>> freq; // num in same frequence, stroed in stack
    int max;
    public FreqStack() {
        map = new HashMap();
        max = 0;
        freq = new HashMap();
    }

    public void push(int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
        int count = map.get(val);
        max = Math.max(max, count);
        if(!freq.containsKey(count))
            freq.put(count, new Stack<Integer>());

        freq.get(count).push(val);
    }

    public int pop() {
        int val = freq.get(max).pop();
        map.put(val, map.get(val)-1);
        if(map.get(val)==0) map.remove(val);
        if(freq.get(max).size() == 0) {
            freq.remove(max);
            max--;
        }
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */