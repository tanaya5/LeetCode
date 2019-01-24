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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return searchLCA( root ,  p,  q);
    }
    private TreeNode searchLCA(TreeNode root , TreeNode p, TreeNode q)
    {
        TreeNode found = root;
        if(p.val < root.val && q.val < root.val)
        {
            return searchLCA(root.left, p ,q);
        }
        else if(p.val > root.val && q.val > root.val)
        {
            return searchLCA(root.right , p,q);
        }
        else
            return found;
    }
}
