import java.util.HashMap;

public class 合并k个有序链表 {
    public static void main(String[] args){
    }
}

class ListNode2 {
    int val;
    ListNode2 next;
    ListNode2(int x) { val = x; }
 }

class Solution18 {
    public ListNode2 mergeKLists(ListNode2[] lists) {
        ListNode2 head = null;
        for (int i = 0; i < lists.length; i++){
            head = hebing(head,lists[i]);
        }
        return head;
    }

    private ListNode2 hebing(ListNode2 ln, ListNode2 list) {
        ListNode2 dummyHead = new ListNode2(0);
        ListNode2 tail = dummyHead;

        while (ln != null && list != null) {
            if (ln.val > list.val) {
                tail.next = list;
                list = list.next;
            } else {
                tail.next = ln;
                ln = ln.next;
            }
            tail = tail.next;
        }
        if (ln == null) {
            tail.next = list;
        } else {
            tail.next = ln;
        }

        return dummyHead.next;
    }
}