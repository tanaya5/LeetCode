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
    public boolean isValidBST(TreeNode root) {
        
        ArrayList<TreeNode> pre = new ArrayList<TreeNode>();
        preOrderTraversal(root ,pre);
        boolean flag = true;
        for(int i = 0; i < pre.size() -1 ; i++)
        {
            if(pre.get(i).val >= pre.get(i+1).val)
            {
                flag = false;
                break;
            }
        }
        return flag;
    }
    
    public void preOrderTraversal(TreeNode root, ArrayList<TreeNode> pre)
    {
        // if root is null
        if(root == null)
            return;
        
        // if root has no child
        if(root.left == null  && root.right == null)
        {
            pre.add(root);
            return;
        }
        
        if(root.left != null)
        {
            preOrderTraversal(root.left , pre);
        }
        
        pre.add(root);
        
        if(root.right != null)
        {
            preOrderTraversal(root.right , pre);
        }    
            
    }

}
