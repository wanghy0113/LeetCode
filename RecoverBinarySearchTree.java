public class Solution {
    TreeNode node1;
    TreeNode node2;
    TreeNode pre;
    public void recoverTree(TreeNode root) {
           find(root);
           if(node1!=null&&node2!=null) 
           {
               int temp = node1.val;
               node1.val = node2.val;
               node2.val = temp; 
           }
    }
    
    public void find(TreeNode root)
    {
        if(root==null) return;
        find(root.left);
        if(pre!=null&&root.val<pre.val)
        {
            //the wrong node must be pre.
            //this is because pre should be smaller than root. If root is the wrong node, the other should be a node
            //in the right side of root whose value is greater than root. But that is impossible.
            node2 = root;
            if(node1==null) node1 = pre;
        }
        pre = root;
        find(root.right);
    }
}

