public class Solution {
    public List<TreeNode> generateTrees(int n) {
        
        return generateTrees(1, n);
    }
    
    public List<TreeNode> generateTrees(int p, int q)
    {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if(q<p) 
        {
            res.add(null);
            return res;
        }
        for(int i=p;i<=q;i++)
        {
            List<TreeNode> lefts = generateTrees(p,i-1);
            List<TreeNode> rights = generateTrees(i+1, q);
            for(TreeNode left:lefts)
            {
                for(TreeNode right:rights)
                {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}