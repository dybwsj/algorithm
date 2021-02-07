import java.util.LinkedList;

public class 合并两个有序列表 {
}

class ListNode1 {
    int val;
    ListNode1 next;
    ListNode1() {}
    ListNode1(int val) { this.val = val; }
    ListNode1(int val, ListNode1 next) { this.val = val; this.next = next; }
    }

class Solution13 {
    public ListNode1 mergeTwoLists(ListNode1 l1, ListNode1 l2) {
        ListNode1 head = new ListNode1(0);
        ListNode1 ln = head;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                ln.next = l2;
                l2 = l2.next;
            } else {
                ln.next = l1;
                l1 = l1.next;
            }
            ln = ln.next;
        }
        if (l1 == null) {
            ln.next = l2;
        } else {
            ln.next = l1;
        }

        return head.next;
    }
}