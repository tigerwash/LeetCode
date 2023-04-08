package LinkedList;

/**
 * 237. Delete Node in a Linked List
 *
 * 这个题的脑洞非常清奇， 就是给你这个要删掉的这个node， 不给你nodehead， 要你将这个
 * node 从list 里面删掉
 *
 * 解决方法是吧当前的node val变成他的next，然后把真实的next 删掉，然后把当前的和隔一个后面
 * 的node 连起来，这样看起来就像是这个node 被删掉了，其实删的是他的next，他自己值变成了next
 * **/
public class Delete_Node_in_a_Linked_List {
    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = node.next.next;
    }
}
