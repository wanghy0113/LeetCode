public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head==null) return null;
        ListNode before1 = new ListNode(0);
        ListNode before2 = new ListNode(0);
        ListNode cur1 = before1;
        ListNode cur2 = before2;
        while(head!=null)
        {
            ListNode cur = head;
            head = head.next;
            if(cur.val<x)
            {
                cur1.next = cur;
                cur1 = cur1.next;
                cur1.next = null;
            }
            else
            {
                cur2.next = cur;
                cur2 = cur2.next;
                cur2.next = null;
            }
            
        }
        cur1.next = before2.next;
        return before1.next;
    }
}