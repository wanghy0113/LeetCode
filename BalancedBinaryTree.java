public class Solution {
    public boolean isBalanced(TreeNode root) {
        return depth(root)!=-1;
    }
    
    public int depth(TreeNode root)
    {
        if(root==null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        if(left==-1||right==-1) return -1;
        if(Math.abs(left-right)>1) return -1;
        return (left>right?left:right)+1;
    }
}