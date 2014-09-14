/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root==null) return res;
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        Deque<List<Integer>> stack = new LinkedList<List<Integer>>();
        List<Integer> sol = new ArrayList<Integer>();
        int current = 1;
        int nextLevel = 0;
        while(!queue.isEmpty())
        {
            TreeNode node = queue.remove();
            sol.add(node.val);
            current--;
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
            if(current==0)
            {
                stack.push(sol);
                sol = new ArrayList<Integer>();
                current = nextLevel;
                nextLevel = 0;
            }
        }
        while(!stack.isEmpty())
        {
            res.add(stack.pop());
        }
        return res;
    }
}