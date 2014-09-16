public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null) return;
        Deque<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.add(root);
        int current = 1;
        int nextLevel = 0;
        TreeLinkNode last = new TreeLinkNode(0);
        
        while(!queue.isEmpty())
        {
            TreeLinkNode node = queue.remove();
            last.next = node;
            last = node;
            current--;
            if(node.left!=null) {queue.add(node.left);nextLevel++;}
            if(node.right!=null) {queue.add(node.right);nextLevel++;}
            if(current==0)
            {
                last = new TreeLinkNode(0);
                current = nextLevel;
                nextLevel = 0;
            }
            
        }
    }
}