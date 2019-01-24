/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    
    public TreeNode deleteNode(TreeNode root , int key)
    {
        if(root == null)
            return root;
        
        if(root.val == key)
        {
            if(root.right == null && root.left == null)
                root= root.right;
            else if (root.right == null)
                root = root.left;
            else if (root. left == null)
                root = root.right;
            else
            {
                TreeNode temp = findSuccessor(root);
                root.val = temp.val;
                root.right = deleteNode(root.right, temp.val);
            }
            return root;
            
        }
        
        if(root.val > key )
            root.left = deleteNode(root.left , key);
        else 
            root.right = deleteNode(root.right , key);
        
        return root;
    }
    private TreeNode findSuccessor(TreeNode root) {
        TreeNode cur = root.right;
        while (cur != null && cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }
}
