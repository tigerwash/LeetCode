package LinkedList;

/**
 82. Remove Duplicates from Sorted List II

 * */
public class Remove_Duplicates_from_Sorted_List_II {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-101);
        ListNode cur = dummy;
        ListNode pre = null;
        while(head != null){
            if(head.val != cur.val){
                cur.next = new ListNode(head.val);
                pre = cur;
                cur = cur.next;
                head = head.next;
            }else {
                while(head != null && cur.val == head.val){
                    head = head.next;
                }
                if(head == null){
                    pre.next = null;
                    return dummy.next;
                }
                cur.val = head.val;
                head = head.next;
            }
        }
        return dummy.next;
    }
}
