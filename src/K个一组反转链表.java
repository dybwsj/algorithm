public class K个一组反转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode L = new ListNode(0);
        L.next = head;
        ListNode curr = L;
        ListNode end = L;
        while(end.next != null){
            for(int i = 0; i < k && end != null; i++) end = end.next;
            if(end == null) break;
            ListNode start = curr.next;
            ListNode next = end.next;
            end.next = null;
            curr.next = reverse(start);
            start.next = next;
            curr = start;
            end = curr;
        }

        return L.next;


    }
    private ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
