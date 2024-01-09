class Solution {
    class Node {
        boolean isStart;
        int id;
        int time;
        Node(int id, boolean isStart, int time) {
            this.id = id;
            this.isStart = isStart;
            this.time = time;
        }
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        // stack 永远只存start, 一但碰到右括号，pop前面的左括号后 干两件事：
        // 1. 把当前 id 的时间加上去
        // 2. 从潜在nest 上一层的外层括号剪掉 现在的内部括号时间
        Stack<Node> stack = new Stack();
        // <id, count>
        int[] res = new int[n];
        for(String s : logs) {
            Node cur = getNode(s);
            if(cur.isStart){
                stack.add(cur);
            }else {
                Node start = stack.pop();
                res[cur.id] += cur.time - start.time + 1;
                if(!stack.isEmpty()){
                    Node pre = stack.peek();
                    res[pre.id] -= cur.time - start.time + 1;
                }
            }
        }
        return res;
    }

    private Node getNode(String str) {
        String[] cur = str.split(":");
        return new Node(Integer.valueOf(cur[0]),
                cur[1].equals("start"),
                Integer.valueOf(cur[2]));
    }
}