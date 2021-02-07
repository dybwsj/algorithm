public class 两两交换链表节点 {
    public ListNode swapPairs(ListNode head) {
        //迭代法
//        ListNode L = new ListNode(0);
//        L.next = head;
//        ListNode pre = L;
//        while(head != null && head.next != null){
//            ListNode first = head;
//            ListNode second = head.next;
//            pre.next = second;
//            first.next = second.next;
//            second.next = first;
//
//            pre = first;
//            head = pre.next;
//        }
//        return L.next;

        //递归法
        if(head == null || head.next == null) return head;
        ListNode first = head;
        ListNode second = head.next;

        first.next = swapPairs(second.next);

        second.next = first;

        return second;
    }
}
