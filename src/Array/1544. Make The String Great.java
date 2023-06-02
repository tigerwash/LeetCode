class Solution {
    // A + 32 == a
    public String makeGood(String s) {
        Stack<Character> stack = new Stack();
        for(char c : s.toCharArray()) {
            if(stack.isEmpty()){
                stack.push(c);
            }else {
                char pre = stack.peek();
                if(Math.abs((int)(pre - c)) == 32) {
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) sb.insert(0, stack.pop());
        return sb.toString();
    }
}