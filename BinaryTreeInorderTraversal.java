public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        TreeNode node = root;
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        while(node!=null||!stack.isEmpty())
        {
            if(node!=null)
            {
                stack.push(node);
                node=node.left;
            }
            else
            {
                node = stack.pop();
                res.add(node.val);
                node = node.right; //node should always be equal to node.right despit node.right is null
            }
        }
        return res;
    }
}