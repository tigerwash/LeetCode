package Stack;

import java.util.Stack;

/**
 856. Score of Parentheses

*
**/
public class Score_of_Parentheses {

    /**  李哥算法
     *
     * cur record the score at the current layer level.
        当碰到 ( 时， 将当前当cur 注入stack，意味着进入了下一个level，
            同时将 cur 归零
        当碰到 （ 时， cur 要么被double， 要么是1 （如果他之前是0）
            然后退出当前level， 通过stack.pop()
     *
     * */
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack();
        int cur = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(cur);
                cur = 0;
            }else { // c == )
                int pre = stack.pop();
                cur = pre + Math.max(cur*2, 1);
            }
        }
        return cur;
    }



    /**  笨办法， 按题目的逻辑一步一步  */
    /**
     自己建Node 放进stack ， 这个node 可以是 char 也可以是数字
     * */
    public int scoreOfParentheses2(String s) {
        Stack<Node> stack = new Stack();
        int res = 0;
        for(char c : s.toCharArray()){
            if(stack.isEmpty() || c== '('){
                stack.push(new Node(c, 0));
            }else { // ')'
                if(stack.peek().c == 'n') {
                    Node n = stack.pop();
                    n.val *= 2;
                    stack.pop(); // pop (  of "(n"
                    if(!stack.isEmpty() && stack.peek().c== 'n'){
                        n.val += stack.pop().val;
                    }
                    stack.push(n);
                }else { // peek ==  '('
                    Node n = new Node('n', 1);
                    stack.pop();
                    if(!stack.isEmpty() && stack.peek().c== 'n'){
                        n.val += stack.pop().val;
                    }
                    stack.push(n);
                }
            }
        }
        while(!stack.isEmpty()){
            res += stack.pop().val;
        }
        return res;
    }

    // node('n', 1)
    class Node {
        char c;
        int val;
        Node(char c, int n){
            this.c = c;
            this.val = n;
        }
    }
}
