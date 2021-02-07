import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class 旋转链表 {
    public ListNode rotateRight(ListNode head, int k) {
        if(k <= 0) return head;
        ListNode cur = new ListNode(0); //0
        cur.next = head;    //0 1 2 3 4 5
        ListNode end = cur.next;    //end: 1,2,3,4,5
        while(k != 0){      //4 3  2 1
            if(end != null) end = end.next;     //end: 1 2 0 1
            else end = head;
            k--;
        }
        ListNode next = end.next;   //next: 4,5
        ListNode start = next;

        end.next = null;        //end: 1 2 3  next: 4 5
        while(next.next != null) next = next.next;
        next.next = head;

        return start;
    }
}
