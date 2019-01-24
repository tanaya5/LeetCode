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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        ArrayList<TreeNode> pre = new ArrayList<TreeNode>();
        inOrderTraversal(root,pre);
        TreeNode inOrderS = null;
        for( int i = 0; i< pre.size()  ; i ++)
        {
            if(pre.get(i).val == p.val)
            {
                if( i == pre.size()-1)
                    inOrderS = null;
                else
                    inOrderS = pre.get(i+1);
                
                break;
            }
        }
        return inOrderS;
    }
    
   public void inOrderTraversal(TreeNode root, ArrayList<TreeNode> pre)
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
            inOrderTraversal(root.left , pre);
        }
        
        pre.add(root);
        
        if(root.right != null)
        {
            inOrderTraversal(root.right , pre);
        }    
            
    }
    
}
