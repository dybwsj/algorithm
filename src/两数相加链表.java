import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

public class 两数相加链表 {
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode L = new ListNode(0);

        ListNode M = L;
        int carry = 0;
        while (l1!=null || l2!=null){
            int x = l1==null ? 0:l1.val;
            int y = l2==null ? 0:l2.val;
            int sum = (carry+x+y)%10;
            carry = (carry + x + y)/10;
            L.next = new ListNode(sum);
            L=L.next;
            if(l1!=null) l1 = l1.next;
            if(l2!=null) l2 = l2.next;
        }
        if (carry!=0){
            L.next = new ListNode(carry);
        }
        return M.next;
    }
}