import LinkedList.ListNode;

/**
 * 86. Partition List
 * 扫两遍，一遍append 小的，一遍append 大的
 * **/

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(-1);
        ListNode small = dummy;
        ListNode cur = head;
        while(cur != null){
            if(cur.val<x){
                small.next = new ListNode(cur.val);
                small = small.next;
            }
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            if(cur.val>=x){
                small.next = new ListNode(cur.val);
                small = small.next;
            }
            cur = cur.next;
        }
        return dummy.next;

    }
}