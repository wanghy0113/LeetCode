public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        
        ListNode before = new ListNode(0);  //here should use a dummy head
        before.next = head;
        ListNode slow = before;
        ListNode fast = before;
        while(fast.next!=null&&fast.next.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next.next;
        TreeNode root = new TreeNode(slow.next.val);
        slow.next = null;
        root.left = sortedListToBST(before.next);
        root.right = sortedListToBST(second);
        return root;
        
    }
}