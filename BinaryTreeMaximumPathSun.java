public class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxAtVertex(root);
        return max;
    }
    
    public int  maxAtVertex(TreeNode root)
    {
        if(root==null) return 0;
        int left = Math.max(maxAtVertex(root.left),0);
        int right = Math.max(maxAtVertex(root.right),0);
        max = Math.max(max, root.val+left+right);
        return Math.max(left,right)+root.val;
    }
}