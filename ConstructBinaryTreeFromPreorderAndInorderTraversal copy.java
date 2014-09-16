public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    
    public TreeNode buildTree(int[] preorder, int s1, int e1, int[] inorder, int s2, int e2)
    {
        if(e1<s1) return null;
        int rootVal = preorder[s1];
        int index = 0;
        for(int i=s2;i<=e2;i++)
        {
            if(inorder[i]==rootVal)
            {
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(preorder, s1+1, s1+index-s2, inorder, s2, index-1);
        root.right = buildTree(preorder, s1+index-s2+1, e1,inorder, index+1, e2);
        return root;
    }
}