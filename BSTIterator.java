/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {

    private Stack<TreeNode> stk = new Stack<TreeNode>();
    private TreeNode curr = null;
    
    public BSTIterator(TreeNode root) {
        if(root != null)
        {
            stk.push(root);
            while(root.left != null)
            {
                stk.push(root.left);
                root = root.left;
            }
        }
            
        
    }
    
    /** @return the next smallest number */
    public int next() {
        curr = stk.pop();
        if(curr.right != null)
        {
            TreeNode pre = curr;
            stk.push(pre.right);
            pre = pre.right;
            while(pre.left != null)
            {
                stk.push(pre.left);
                pre= pre.left;
            }
        }
        return curr.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stk.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
