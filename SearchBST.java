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
    public TreeNode searchBST(TreeNode root, int val) {
        // if tree is empty
        if(root == null )
            return null;
        
        // if root is the only node
        if(root.left == null && root.right == null)
        {
            if(root.val == val)
                return root;
            else return null;
        }
        
        
        // if value is equal to the root
        if (val == root.val)
            return root;
        
        // if the val is less than root
        else if(val < root.val)
            return searchBST(root.left, val);
        
        // else if val is more than root
        else if (val > root.val)
            return searchBST( root.right , val);
        
       return null; 
    }
}
