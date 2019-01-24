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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)
        {
            root = new TreeNode(val);
            return root;
        }
        
        TreeNode curr = root;
        TreeNode prev = root;
        while(curr != null)
        {
            if(curr.val > val)
            {
                prev = curr;
                curr = curr.left;
            }
            else
            {
                prev = curr;
                curr = curr.right;
            }
        }
        
        if(val > prev.val)
                prev.right = new TreeNode(val);
            else
                prev.left = new TreeNode(val);
        
        return root;
    }
}
