public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res= new ArrayList<Integer>();
        TreeNode node = root;
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode lastVisit = null;
        while(node!=null||!stack.isEmpty())
        {
            if(node!=null)
            {
                stack.push(node);
                node = node.left;
            }
            else
            {
                TreeNode top = stack.peek();
                if(top.right==null||lastVisit==top.right)
                {
                    res.add(top.val);
                    lastVisit = top;
                    stack.pop();
                    //node = null; no need to write this line because node must be null here
                }
                else
                {
                    node = top.right;
                }
            }
        }
        return res;
    }
}