public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    
    public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd)
    {
        if(inEnd<inStart) return null;
        int length = inEnd-inStart+1;
        int rootVal = postorder[postEnd];
        int index = 0;
        for(int i=inStart;i<=inEnd;i++)
        {
            if(inorder[i]==rootVal)
            {
                index = i;
                break;
            }
        }
        
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(inorder, inStart, index-1, postorder, postStart, postStart+index-inStart-1);
        root.right = buildTree(inorder, index+1, inEnd, postorder, postStart+index-inStart, postEnd-1);
        return root;
    }
}