public class Solution {
    public boolean isValidBST(TreeNode root) {
       return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public boolean isValidBST(TreeNode root, int min, int max)
    {
        if(root==null) return true;
        return root.val<max&&root.val>min&&isValidBST(root.left, min, root.val)&&isValidBST(root.right, root.val, max);
    }
}