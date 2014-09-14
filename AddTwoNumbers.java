public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode before = new ListNode(0);
        ListNode cur = before;
        int carry = 0;
        while(l1!=null||l2!=null)
        {
            if(l1==null)
            {
                cur.next = new ListNode((l2.val+carry)%10);
                carry = (l2.val+carry)/10;
                l2 = l2.next;
                cur = cur.next;
                continue;
            }
            if(l2==null)
            {
                cur.next = new ListNode((l1.val+carry)%10);
                carry = (l1.val+carry)/10;
                l1 = l1.next;
                cur = cur.next;
                continue;
            }
            cur.next = new ListNode((l1.val+l2.val+carry)%10);
            carry = (l1.val+l2.val+carry)/10;
            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }
        //easy to ignore
        if(carry==1) cur.next = new ListNode(1);
        return before.next;
    }
}