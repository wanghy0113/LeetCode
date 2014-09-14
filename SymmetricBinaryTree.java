public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetric(root.left, root.right);
    }
    
    public boolean isSymmetric(TreeNode r1, TreeNode r2)
    {
        if(r1==null&&r2==null) return true;
        if(r1==null||r2==null) return false;
        return r1.val==r2.val&&isSymmetric(r1.left,r2.right)&&isSymmetric(r1.right,r2.left);
    }
}