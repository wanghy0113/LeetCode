public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root==null) return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> sol = new ArrayList<Integer>();
        queue.add(root);
        int cur = 1;
        int nextLevel = 0;
        while(!queue.isEmpty())
        {
            TreeNode node = queue.remove();
            sol.add(node.val);
            cur--;
            if(node.left!=null) 
            {
                queue.add(node.left);
                nextLevel++;
            }
            if(node.right!=null)
            {
                queue.add(node.right);
                nextLevel++;
            }
            if(cur==0)
            {
                res.add(sol);
                sol = new ArrayList<Integer>();
                cur = nextLevel;
                nextLevel = 0;
            }
            
        }
        return res;
    }
}