public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        return sortedArrayToBST(num, 0, num.length-1);
    }
    
    public TreeNode sortedArrayToBST(int[] num, int p, int q)
    {
        if(q<p) return null;
        int mid = (p+q)/2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = sortedArrayToBST(num, p, mid-1);
        root.right = sortedArrayToBST(num, mid+1, q);
        return root;
    }
}