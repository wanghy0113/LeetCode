public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;
        while(!stack.isEmpty()||node!=null)
        {
            if(node!=null)
            {
                res.add(node.val);
                if(node.right!=null) stack.push(node.right);
                node = node.left;
            }
            else
            {
                node = stack.pop();
            }
        }
        return res;
    }
}