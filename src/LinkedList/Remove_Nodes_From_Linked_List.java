package LinkedList;

import java.util.Stack;

public class Remove_Nodes_From_Linked_List {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    // 递归很简洁，就是直接读取后面一大串的头，判定递归后next 的值和当前值的大小，
    // 大的话直接返回到上一层，否则接上当前值一起返回到上面
    public ListNode removeNodesRecursion(ListNode head) {
        if(head == null) return null;
        ListNode next = removeNodes(head.next);
        if(next != null && next.val > head.val){
            return next;
        }else{
            head.next = next;
            return head;
        }
    }
    public ListNode removeNodes(ListNode head) {
        Stack<Integer> stack = new Stack();
        ListNode cur = head;
        while(cur != null){
            if(stack.isEmpty() || stack.peek() > cur.val){
                stack.push(cur.val);
                cur = cur.next;
            }else {
                while(!stack.isEmpty() && stack.peek() < cur.val){
                    stack.pop();
                }
                stack.push(cur.val);
                cur = cur.next;
            }
        }
        ListNode dummy = new ListNode(-1);
        while(!stack.isEmpty()){
            ListNode node = new ListNode(stack.pop());
            node.next = dummy.next;
            dummy.next = node;
        }
        return dummy.next;
    }
}

