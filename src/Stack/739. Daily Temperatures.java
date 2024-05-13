class Solution {
    public int[] dailyTemperatures(int[] T) {
        // monostack [idx] desc
        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack();
        for(int i = 0; i<T.length; i++) {
            while(!stack.isEmpty() && T[stack.peek()]<T[i]) {
                int pre = stack.pop();
                res[pre] = i-pre;
            }
            stack.push(i);
        }
        return res;
    }
}