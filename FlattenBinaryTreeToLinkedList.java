public class Solution {
    public void flatten(TreeNode root) {
        flattenWithEnd(root);
    }
    
    public TreeNode flattenWithEnd(TreeNode root)
    {
        if(root==null) return null;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if(left==null&&right==null) return root;
        if(left==null) return flattenWithEnd(root.right);
        if(right==null)
        {
            root.right = root.left;
            root.left = null;
            return flattenWithEnd(root.right);
        }
        
        root.left= null;
        TreeNode leftEnd = flattenWithEnd(left);
        root.right = left;
        leftEnd.right = right;
        return flattenWithEnd(right);
    }
}